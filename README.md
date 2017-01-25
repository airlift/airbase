# Airbase
[![Maven Central](https://img.shields.io/maven-central/v/io.airlift/airbase.svg?label=Maven%20Central)](https://search.maven.org/#search%7Cga%7C1%7Cg%3A%22io.airlift%22%20AND%20a%3A%22airbase%22)
[![Build Status](https://travis-ci.org/airlift/airbase.svg?branch=master)](https://travis-ci.org/airlift/airbase)

## Usage

Add Airbase as the parent to a project:

```xml
<parent>
  <groupId>io.airlift</groupId>
  <artifactId>airbase</artifactId>
  <version> ... current pom release version ...</version>
</parent>
```

## Project pom structure

The following elements should be present in a pom using Airbase as parent:

* `groupId`, `artifactId`, `version`, `packaging`, `name`, `description` and `inceptionYear`

  Define the new project. These elements should always be present. If any of those fields are missing from the project,
the values from Airbase are picked up instead.

* `scm`

  Defines the SCM location and URL for the project. This is required to use the `release:prepare` and `release:perform` targets
  to deploy artifacts to Maven Central.

* `organization`, `developers`, `distributionManagement`

  Empty elements override the values inherited from Airbase.

This is a sample skeleton pom using Airbase:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

  <modelVersion>4.0.0</modelVersion>

  <parent>
    <groupId>io.airlift</groupId>
    <artifactId>airbase</artifactId>
    <version> ... current version ...</version>
  </parent>

  <groupId> ... group id of the new project ... </groupId>
  <artifactId> ... artifact id of the new project ... </artifactId>
  <version> ... version of the new project ... </version>
  <packaging> ... jar|pom ... </packaging>
  <description> ... description of the new project ...  </description>
  <name>${project.artifactId}</name>
  <inceptionYear>2013</inceptionYear>

  <scm>
    <connection> ... scm read only connection ... </connection>
    <developerConnection>... scm read write connection ... </developerConnection>
    <url> ... project url ... </url>
  </scm>

  <distributionManagement/>
  <developers/>
  <organization/>
  ...
</project>
```

## Project POM conventions

In large maven projects, especially with multi-module builds, the pom files can become quite large. In many places, properties defined in the `<properties>` section of the pom are used.

To avoid confusion with properties, the following conventions are used in Airbase:

* Properties defined in the POM that influence the build configuration are prefixed with `air`.
* Properties that factor out plugin versions (because the plugin is used in multiple places in the POM and the versions should be uniform) start with `dep.plugin` and end with `version`.
* Properties that factor out dependency versions (to enforce uniform dependency versions across multiple, related dependencies) start with `dep` and end with `version`.

Examples:

```xml
<properties>
  <!-- Sets the minimum maven version to build (influences build) -->
  <air.maven.version>3.0.4</air.maven.version>

  <!-- The surefire plugin version -->
  <dep.plugin.surefire.version>2.13</dep.plugin.surefire.version>

  <!-- The version for all guice related dependencies -->
  <dep.guice.version>3.0</dep.guice.version>
<properties>
```


## Deploy to Maven Central (oss.sonatype.org)

Airbase is intended for open source projects that should be deployed to Maven Central.

It inherits from the oss-parent POM and supports the OSS deployment process as outlined at https://docs.sonatype.org/display/Repository/Sonatype+OSS+Maven+Repository+Usage+Guide.

As described on https://docs.sonatype.org/display/Repository/Sonatype+OSS+Maven+Repository+Usage+Guide, the `sonatype-nexus-staging` and `sonatype-nexus-snapshots` repositories must be configured:

```xml
<servers>
  ...
  <server>
    <id>sonatype-nexus-snapshots</id>
    <username>user</username>
    <password>password</password>
  </server>
  <server>
    <id>sonatype-nexus-staging</id>
    <username>user</username>
    <password>password</password>
  </server>
  ...
</servers>
```


## Project Build and Checkers

Airbase hooks various checkers into the build lifecycle and executes them on each build.

Generally speaking, running a set of checks at each build is a good way to catch problems early and any problem reported by a checker should be treated as something that needs to be fixed before releasing.

Checkers are organized in two groups, basic and extended.

### Basic checkers
* Maven Enforcer                  (http://maven.apache.org/enforcer/maven-enforcer-plugin/)
* Maven Dependencies              (http://maven.apache.org/plugins/maven-dependency-plugin/)
* Maven Dependency version check  (https://github.com/ning/maven-dependency-versions-check-plugin)
* Maven Duplicate finder          (https://github.com/ning/maven-duplicate-finder-plugin)

### Extended checkers
* Findbugs                        (http://mojo.codehaus.org/findbugs-maven-plugin/)
* PMD                             (http://maven.apache.org/plugins/maven-pmd-plugin/)
* License check                   (http://code.google.com/p/maven-license-plugin/)
* Code coverage                   (http://www.eclemma.org/jacoco/trunk/doc/maven.html)
* Modernizer                      (https://github.com/andrewgaul/modernizer-maven-plugin)


All checkers are enabled by default, but the checkers will *NOT* fail the build if a problem is encountered.

Each checker has a switch to turn it on or off and also whether a problem will be a warning or fatal to the build.

```xml
...
<properties>
  <!-- Do not run the duplicate finder --->
  <air.check.skip-duplicate-finder>true</air.check.skip-duplicate-finder>
</properties>
...
```

The following switches exist:

<table>
  <tr>
    <th>Group</th>
    <th>Check</th>
    <th>Skip check (Setting to <tt>true</tt> skips the check)</th>
    <th>Fail build (Setting to <tt>false</tt> only reports a warning)</th>
  </tr>
  <tr>
    <td>Basic</td>
    <td>Maven Enforcer</td>
    <td><tt>air.check.skip-enforcer</tt></td>
    <td><tt>air.check.fail-enforcer</tt></td>
  </tr>
  <tr>
    <td>Basic</td>
    <td>Maven Dependencies</td>
    <td><tt>air.check.skip-dependency</tt></td>
    <td><tt>air.check.fail-dependency</tt></td>
  </tr>
  <tr>
    <td>Basic</td>
    <td>Maven Dependency version check</td>
    <td><tt>air.check.skip-dependency-version-check</tt></td>
    <td><tt>air.check.fail-dependency-version-check</tt></td>
  </tr>
  <tr>
    <td>Basic</td>
    <td>Maven Duplicate finder</td>
    <td><tt>air.check.skip-duplicate-finder</tt></td>
    <td><tt>air.check.fail-duplicate-finder</tt></td>
  </tr>
  <tr>
    <td>Extended</td>
    <td>Findbugs</td>
    <td><tt>air.check.skip-findbugs</tt></td>
    <td><tt>air.check.fail-findbugs</tt></td>
  </tr>
  <tr>
    <td>Extended</td>
    <td>PMD</td>
    <td><tt>air.check.skip-pmd</tt></td>
    <td><tt>air.check.fail-pmd</tt></td>
  </tr>
  <tr>
    <td>Extended</td>
    <td>License check</td>
    <td><tt>air.check.skip-license</tt></td>
    <td><tt>air.check.fail-license</tt></td>
  </tr>
  <tr>
    <td>Extended</td>
    <td>Code coverage</td>
    <td><tt>air.check.skip-jacoco</tt></td>
    <td><tt>air.check.fail-jacoco</tt></td>
  </tr>
  <tr>
    <td>Extended</td>
    <td>Modernizer</td>
    <td><tt>air.check.skip-modernizer</tt></td>
    <td><tt>air.check.fail-modernizer</tt></td>
  </tr>
</table>

Checks can be turned on and off in groups:

<table>
  <tr>
    <th>Group</th>
    <th>Skip checks</th>
    <th>Fail build</th>
  </tr>
  <tr>
    <td>All Checks</td>
    <td><tt>air.check.skip-all</tt></td>
    <td><tt>air.check.fail-all</tt></td>
  </tr>
  <tr>
    <td>All Basic checks</td>
    <td><tt>air.check.skip-basic</tt></td>
    <td><tt>air.check.fail-basic</tt></td>
  </tr>
  <tr>
    <td>All Extended Checks</td>
    <td><tt>air.check.skip-extended</tt></td>
    <td><tt>air.check.fail-extended</tt></td>
  </tr>
</table>

A more specific setting (checker specific, then group, then all) overrides a more general setting:

```xml
...
<properties>
  <air.check.skip-all>true</air.check.skip-all>
  <air.check.skip-duplicate-finder>false</air.check.skip-duplicate-finder>
</properties>
...
```
will skip *all* checks except the duplicate finder.


### Checker notes

#### License checker

To ensure that a project has an uniform license header in all source files, the Maven license plugin can be used to check and format license headers.

The plugin expects the license header file as `src/license/LICENSE-HEADER.txt` in the root folder of a project.

For a multi-module project, this file should exist only once, in the root pom of the project. In all other sub-modules, add

```xml
<properties>
  <air.main.basedir>${project.parent.basedir}</air.main.basedir>
</properties>
```

to each pom. This is a limitation of the Maven multi-module build process (see http://stackoverflow.com/questions/1012402/maven2-property-that-indicates-the-parent-directory for details).

#### Enforcer checker

The Enforcer plugin outlaws a number of dependencies that project might use for various reasons:

<table>
  <tr>
    <th>Outlawed dependency</th>
    <th>Rationale</th>
    <th>What to use</th>
  </tr>
  <tr>
    <td><tt>commons-logging:commons-logging-api</tt></td>
    <td>Ill-fated attempt to split commons-logging implementation and commons-logging API.</td>
    <td><tt>commons-logging:commons-logging</tt></td>
  </tr>
  <tr>
    <td><tt>cglib:cglib</tt></td>
    <td>Has all its dependencies packed inside, therefore leads to duplicate classes.</td>
    <td><tt>cglib:cglib-nodep</tt></td>
  </tr>
  <tr>
    <td><tt>junit:junit</tt></td>
    <td>Has all its dependencies packed inside, therefore leads to duplicate classes.</td>
    <td><tt>junit:junit-dep</tt></td>
  </tr>
  <tr>
    <td><tt>com.google.collections:google-collections</tt></td>
    <td>Superseded by Guava, duplicate classes with Guava.</td>
    <td><tt>com.google.guava:guava</tt></td>
  </tr>
  <tr>
    <td><tt>com.google.code.findbugs:jsr305</tt></td>
    <td>Subset of the full findbugs annotations, contains only the JSR-305 annotations.</td>
    <td><tt>com.google.code.findbugs:annotations</tt></td>
  </tr>
  <tr>
    <td><tt>org.eclipse.jetty.orbit:javax.servlet</tt></td>
    <td>Jetty variant of the 3.x servlet API jar.</td>
    <td><tt>javax.servlet:javax.servlet-api</tt></td>
  </tr>
</table>


## Well known dependencies

Airbase provides a number of dependencies to projects. These dependencies are considered "well known and stable". When a project wants to use any of these dependencies, it can declare them in the project `<dependencies>` section without a version and automatically pick it up from Airbase.

Airbase provides versions for the following well-known dependencies:

<table>
  <tr><th>Dependency name</th><th>Group/Artifact Ids</th></tr>
  <tr>
   <td>Google Guice</td>
   <td><tt>com.google.inject:guice</tt><p/><tt>com.google.inject.extensions:guice-servlet</tt><p/><tt>com.google.inject.extensions:guice-assistedinject</tt><p/><tt>com.google.inject.extensions:guice-multibindings</tt><p/><tt>com.google.inject.extensions:guice-throwingproviders</tt></td>
  </tr>
  <tr>
   <td>Google Guava</td>
   <td><tt>com.google.guava:guava</tt></td>
  </tr>
  <tr>
    <td>Joda Time</td>
    <td><tt>joda-time:joda-time</tt></td>
  </tr>
  <tr>
    <td>Java Inject API</td>
    <td><tt>javax.inject:javax.inject</tt></td>
  </tr>
  <tr>
    <td>Java Servlet API</td>
    <td><tt>javax.servlet:javax.servlet-api</tt></td>
  </tr>
  <tr>
    <td>Java Validation API</td>
    <td><tt>javax.validation:validation-api</tt></td>
  </tr>
  <tr>
    <td>slf4j (Simple Logging Facade for Java)</td>
    <td><tt>org.slf4j:slf4j-api</tt><p/><tt>org.slf4j:slf4j-nop</tt><p/><tt>org.slf4j:slf4j-simple</tt><p/><tt>org.slf4j:slf4j-ext</tt><p/><tt>org.slf4j:jcl-over-slf4j</tt><p/><tt>org.slf4j:jul-to-slf4j</tt><p/><tt>org.slf4j:log4j-over-slf4j</tt><p/><tt>org.slf4j:slf4j-jdk14</tt></td>
  </tr>
  <tr>
    <td>Logback</td>
    <td><tt>ch.qos.logback:logback-core</tt><p/><tt>ch.qos.logback:logback-classic</tt></td>
  </tr>
  <tr>
    <td>Jackson</td>
    <td><tt>com.fasterxml.jackson.core:jackson-annotations</tt><p/><tt>com.fasterxml.jackson.core:jackson-core</tt><p/><tt>com.fasterxml.jackson.core:jackson-databind</tt><p/><tt>com.fasterxml.jackson.datatype:jackson-datatype-guava</tt><p/><tt>com.fasterxml.jackson.datatype:jackson-datatype-joda</tt><p/><tt>com.fasterxml.jackson.dataformat:jackson-dataformat-smile</tt></td>
  </tr>
  <tr>
    <td>Bean Validation Framework</td>
    <td><tt>org.apache.bval:bval-jsr</tt></td>
  </tr>
  <tr>
    <td>JmxUtils</td>
    <td><tt>org.weakref:jmxutils</tt></td>
  </tr>
  <tr>
    <td>Joda Time</td>
    <td><tt>joda-time:joda-time</tt></td>
  </tr>
  <tr>
    <td>CGLib</td>
    <td><tt>cglib:cglib-nodep</tt></td>
  </tr>
  <tr>
    <td>Findbugs Annotations</td>
    <td><tt>com.google.code.findbugs:annotations</tt></td>
  </tr>
  <tr>
    <td>TestNG testing</td>
    <td><tt>org.testng:testng</tt></td>
  </tr>
  <tr>
    <td>AssertJ</td>
    <td><tt>org.assertj:assertj-core</tt><p/><tt>org.assertj:assertj-guava</tt><p/><tt>org.assertj:assertj-joda-time</tt><p/><tt>org.assertj:assertj-db</tt></td>
  </tr>
  <tr>
    <td>Mockito</td>
    <td><tt>org.mockito:mockito-core</tt></td>
  </tr>
  <tr>
    <td>Hamcrest matchers</td>
    <td><tt>org.hamcrest:hamcrest-core</tt><p/><tt>org.hamcrest:hamcrest-library</tt><p/><tt>org.objenesis:objenesis</tt></td>
  </tr>
  <tr>
    <td>Airlift Slice</td>
    <td><tt>io.airlift:slice</tt></td>
  </tr>
</table>



## Other properties

These are default properties that affect some aspects of the build. All of them can be overriden in the `<properties>` section of the project pom.

## project.build.targetJdk

By default, Airbase enforces JDK 1.8. To use another version, add

```xml
<properties>
  <project.build.targetJdk>1.6</project.build.targetJdk>
  ...
</properties>
```


### air.build.jvmsize

Sets the default heap size for the compiler, javadoc generation and other plugins. Default is 1024M.

### air.release.push-changes

When a project creates a release using the maven-release-plugin and `mvn release:prepare`, this switch controls whether the generated tags, modified POM files etc. are pushed automatically to the upstream repository or not. Default is `false` (do not push the changes).

### air.maven.version

The minimum version of Maven to build a project. Default is "3.0".

### air.main.basedir

The 'root' directory of a project. For a simple project, this is identical to `project.basedir`. In a multi-module build, it should point at the root project.

For a multi-module project, all other sub-modules must have this explicitly set to the root directory and therefore the following code

```xml
<properties>
  <air.main.basedir>${project.parent.basedir}</air.main.basedir>
</properties>
```

must be added to each pom. This is a limitation of the Maven multi-module build process (see http://stackoverflow.com/questions/1012402/maven2-property-that-indicates-the-parent-directory for details).



## Deploy profiles

### airlift packaging build

A module or sub-module can produce a tarball using the airlift packaging. This profile is activated by creating a file `.build-airlift` in the root of the module or submodule. This file
can be empty. The tarball is attached as an additional artifact.

The necessary launchers from the airlift launcher package are included. The version of the launcher included is controlled by the `dep.packaging.version` property.


