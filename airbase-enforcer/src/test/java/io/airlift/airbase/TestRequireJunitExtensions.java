/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.airlift.airbase;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.handler.DefaultArtifactHandler;
import org.apache.maven.enforcer.rule.api.EnforcerRuleException;
import org.apache.maven.model.Build;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestRequireJunitExtensions
{
    private static final Artifact JUPITER_API = artifact("org.junit.jupiter", "junit-jupiter-api");
    private static final Artifact JUNIT_EXTENSIONS = artifact("io.airlift", "junit-extensions");

    @Test
    public void testNoDependencies()
    {
        assertThatCode(() -> rule(null).execute()).doesNotThrowAnyException();
    }

    @Test
    public void testJupiterWithJunitExtensions()
    {
        assertThatCode(() -> rule("true", JUPITER_API, JUNIT_EXTENSIONS).execute())
                .doesNotThrowAnyException();
    }

    @Test
    public void testJupiterWithoutJunitExtensions()
    {
        assertThatThrownBy(() -> rule("true", JUPITER_API).execute())
                .isInstanceOf(EnforcerRuleException.class)
                .hasMessage("Projects that depend on org.junit.jupiter must also depend on io.airlift:junit-extensions");
        assertThatThrownBy(() -> rule("true", artifact("org.junit.jupiter", "junit-jupiter")).execute())
                .isInstanceOf(EnforcerRuleException.class)
                .hasMessage("Projects that depend on org.junit.jupiter must also depend on io.airlift:junit-extensions");
    }

    @Test
    public void testJupiterWithoutAutodetection()
    {
        assertThatThrownBy(() -> rule(null, JUPITER_API, JUNIT_EXTENSIONS).execute())
                .isInstanceOf(EnforcerRuleException.class)
                .hasMessage("Projects that depend on org.junit.jupiter must set junit.jupiter.extensions.autodetection.enabled to true in maven-surefire-plugin systemPropertyVariables");
        assertThatThrownBy(() -> rule("false", JUPITER_API, JUNIT_EXTENSIONS).execute())
                .isInstanceOf(EnforcerRuleException.class)
                .hasMessage("Projects that depend on org.junit.jupiter must set junit.jupiter.extensions.autodetection.enabled to true in maven-surefire-plugin systemPropertyVariables");
    }

    @Test
    public void testAutodetectionWithoutJupiter()
    {
        assertThatCode(() -> rule("true").execute()).doesNotThrowAnyException();
    }

    private static RequireJunitExtensions rule(String autodetection, Artifact... artifacts)
    {
        Xpp3Dom properties = new Xpp3Dom("systemPropertyVariables");
        if (autodetection != null) {
            Xpp3Dom property = new Xpp3Dom("junit.jupiter.extensions.autodetection.enabled");
            property.setValue(autodetection);
            properties.addChild(property);
        }
        Xpp3Dom configuration = new Xpp3Dom("configuration");
        configuration.addChild(properties);

        Plugin surefire = new Plugin();
        surefire.setGroupId("org.apache.maven.plugins");
        surefire.setArtifactId("maven-surefire-plugin");
        surefire.setConfiguration(configuration);
        Build build = new Build();
        build.addPlugin(surefire);
        Model model = new Model();
        model.setBuild(build);

        MavenProject project = new MavenProject(model);
        project.setArtifacts(Set.of(artifacts));
        return new RequireJunitExtensions(project);
    }

    private static Artifact artifact(String groupId, String artifactId)
    {
        return new DefaultArtifact(groupId, artifactId, "1", "test", "jar", null, new DefaultArtifactHandler("jar"));
    }
}
