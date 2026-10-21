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
import org.apache.maven.enforcer.rule.api.AbstractEnforcerRule;
import org.apache.maven.enforcer.rule.api.EnforcerRuleException;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.Set;

import static java.util.Objects.requireNonNull;

@Named("requireJunitExtensions")
public class RequireJunitExtensions
        extends AbstractEnforcerRule
{
    private final MavenProject project;

    @Inject
    public RequireJunitExtensions(MavenProject project)
    {
        this.project = requireNonNull(project, "project is null");
    }

    @Override
    public void execute()
            throws EnforcerRuleException
    {
        Set<Artifact> artifacts = project.getArtifacts();
        boolean usesJupiter = artifacts.stream()
                .anyMatch(artifact -> artifact.getGroupId().equals("org.junit.jupiter"));
        boolean hasJunitExtensions = artifacts.stream()
                .anyMatch(artifact -> artifact.getGroupId().equals("io.airlift") && artifact.getArtifactId().equals("junit-extensions"));
        if (!usesJupiter) {
            return;
        }
        if (!hasJunitExtensions) {
            throw new EnforcerRuleException("Projects that depend on org.junit.jupiter must also depend on io.airlift:junit-extensions");
        }
        if (!isAutodetectionEnabled()) {
            throw new EnforcerRuleException("Projects that depend on org.junit.jupiter must set junit.jupiter.extensions.autodetection.enabled to true in maven-surefire-plugin systemPropertyVariables");
        }
    }

    private boolean isAutodetectionEnabled()
    {
        Plugin surefire = project.getPlugin("org.apache.maven.plugins:maven-surefire-plugin");
        if (surefire == null || !(surefire.getConfiguration() instanceof Xpp3Dom configuration)) {
            return false;
        }
        Xpp3Dom properties = configuration.getChild("systemPropertyVariables");
        if (properties == null) {
            return false;
        }
        Xpp3Dom autodetection = properties.getChild("junit.jupiter.extensions.autodetection.enabled");
        return autodetection != null && "true".equals(autodetection.getValue());
    }

    @Override
    public String toString()
    {
        return "RequireJunitExtensions";
    }
}
