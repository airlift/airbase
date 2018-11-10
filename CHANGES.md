Airbase 88

* Replace dependency-versions-check with Enforcer requireUpperBoundDeps

Airbase 87

* Generate parameters names also when compiling in IntelliJ

Airbase 86

* Checkstyle updates:
  - Do not enforce whitespace before array initializers

Airbase 85

* Do not allow duplicate dependencies in POMs

Airbase 84

* Do not trim stack traces for Surefire test failures
* Prevent JVM from omitting stack traces for Surefire
* Checkstyle updates:
  - Forbid static import of Optional's members
  - Enforce whitespace around additional tokens

Airbase 83

* Dependency updates:
  - SpotBugs annotations 3.1.6 (from 3.1.2)
* Plugin updates:
  - SpotBugs 3.1.6 (from 3.1.3)
  - PMD 3.10.0 (from 3.7)
  - JaCoCo 0.8.1 (from 0.7.9)
* Checkstyle updates:
  - Require simplified usages of annotations

Airbase 82

* Plugin updates:
  - Surefire 2.22.0 (from 2.20.1)
  - Enforcer 3.0.0-M2 (from 3.0.0-M1)

Airbase 81

* Guarantee termination of JVM on OOM when running Surefire
* Dependency updates:
  - Slice 0.34 (from 0.10)

Airbase 80

* Add milliseconds and time zone to log format for tests
* Dependency updates:
  - Guava 24.1 (from 21.0)
  - Guice 4.2 (from 4.0)
  - JMH 1.20 (from 1.15)
  - packaging 0.163 (from 0.91)
  - SpotBugs annotations 3.1.2 (from 3.1.0)
* Plugin updates:
  - compiler 3.7.0 (from 3.6.2)
  - Eclipse compiler 2.8.3 (from 2.8.2)
  - Error Prone compiler 2.8.3 (from 2.8.2)
  - SpotBugs 3.1.3 (from 3.1.0-RC8)
* Checkstyle updates:
  - Forbid import of format methods other than String.format

Airbase 79

* Use Apache license header from policy JAR
* Add Checkstyle as an extended checker

Airbase 78

* Prevent Surefire from adding java.se.ee module on Java 9
* Remove Eclipse m2e settings
* Dependency updates:
  - javax.annotation-api 1.3.1 (from 1.2)

Airbase 77

* Fix air.javadoc.lint property for Javadoc 3.0.0 plugin

Airbase 76

* Exclude Java 9 module-info.class from duplicate finder
* Dependency updates:
  - SpotBugs annotations 3.1.0 (from 3.1.0-RC5)
  - cglib 3.2.5 (from 2.2.2)
* Plugin updates:
  - SpotBugs 3.1.0-RC8 (from 3.1.0-RC4)
  - Javadoc 3.0.0 (from 2.9)
  - duplicate-finder 1.2.1 (from 1.0.6)

Airbase 75

* Enable compiled metadata for reflection on method parameters

Airbase 74

* Dependency updates:
  - Logback 1.2.3 (from 1.0.13)

Airbase 73

* Remove support for JUnit 5

Airbase 72

* Revert using Nexus Staging plugin

Airbase 71

* Use Nexus Staging plugin instead maven-deploy-plugin
* Dependency updates:
  - javax.ws.rs-api 2.1 (from 2.0.1)

Airbase 70

* Plugin updates:
  - maven-deploy-plugin 2.8.2 (from 2.7)
  - maven-clean-plugin 3.0.0 (from 2.5)
  - maven-install-plugin 2.5.2 (from 2.4)

Airbase 69

* Plugin updates:
  - Surefire 2.20.1 (from 2.20)
  - JUnit Jupiter Engine 5.0.0 (from 5.0.0-RC2)
  - JUnit Platform Surefire Provider (from 1.0.0-RC2)

Airbase 68

* Add support for JUnit 5
* Add dependency-scope as a basic checker
* Dependency updates:
  - SLF4J 1.7.25 (from 1.7.12)
* Plugin updates:
  - Surefire 2.20 (from 2.19.1)

Airbase 67

* Ban `com.google.code.findbugs:annotations` dependency
* Add dependencies:
  - FindBugs / SpotBugs annotations 3.1.0-RC5
  - JSR-305 annotations 3.0.2

Airbase 66

* Remove deprecated oss-parent POM
* Use `ossrh` as the ID for both deployment repositories
* Migrate from FindBugs to SpotBugs
* Plugin updates:
  - Enforcer 3.0.0-M1 (from 1.2)

Airbase 65

* Add `eclipse-compiler` profile for building with Eclipse compiler
* Add `errorprone-compiler` profile for building with Error Prone compiler
* Plugin updates:
  - compiler 3.6.2 (from 3.0)

Airbase 64

* Dependency updates:
  - Joda-Time 2.9.9 (from 2.8.2)

Airbase 63

* Plugin updates:
  - FindBugs 3.0.4 (from 2.5.2)
  - PMD 3.7 (from 3.0.1)
  - JaCoCo 0.7.9 (from 0.7.5.201505241946)

Airbase 62

* Dependency updates:
  - Guava 21.0 (from 20.0)

Airbase 61

* Add Modernizer as an extended checker

Airbase 60

* Add dependencies:
  - AssertJ Core 3.5.2
  - AssertJ Guava 3.1.0
  - AssertJ Joda-Time 2.0.0
  - AssertJ DB 1.1.1
* Dependency updates:
  - Guava 20.0 (from 18.0)

Airbase 59

* Remove air.test.fork-mode property
* Dependency updates:
  - JMH 1.15 (from 1.13)
* Plugin updates:
  - Surefire 2.19.1 (from 2.14)

Airbase 58

* Plugin updates:
  - dependency-versions-check 2.0.4 (from 2.0.2)

Airbase 57

* Remove dependency for jackson-datatype-jdk7
* Dependency updates:
  - Jackson 2.8.1 (from 2.4.4)

Airbase 56

* Dependency updates:
  - JMH 1.13 (from 1.9.3)
  - BVal 1.1.1 (from 0.5)

Airbase 55

* Remove Jetty dependencies
* Remove Jersey dependencies

Airbase 54

* Dependency updates:
  - Jetty 9.3.9.M1 (from 9.3.9.M0)

Airbase 53

* Add Jetty http2-server dependency

Airbase 52

* Add dependencies:
  - Jetty http2-client
  - Jetty http2-http-client-transport
* Dependency updates:
  - Jetty 9.3.9.M0 (from 9.3.8.v20160314)

Airbase 51

* Add jersey-container-servlet dependency
* Dependency updates:
  - Jersey 2.22.2 (from 2.12)

Airbase 50

* Dependency updates:
  - Jetty 9.3.8.v20160314 (from 9.3.8.RC0)

Airbase 49

* Dependency updates:
  - Jetty 9.3.8.RC0 (from 9.3.7.RC0)

Airbase 48

* Dependency updates:
  - jmxutils 1.19 (from 1.18)

Airbase 47

* Dependency updates:
  - Jetty 9.3.7.RC0 (from Jetty 9.2.11.v20150529)

Airbase 46

* Dependency updates:
    - TestNG, exclude transitive guice dependency

Airbase 45

* Dependency updates:
    - Jacoco 0.7.5.201505241946 (from 0.6.2.201302030002). Fixes a compatibility issue with Java 8

Airbase 44

* Dependency updates:
    - TestNG 6.9.6 (from 6.8.7)
    - Guice 4.0 (from 4.0-beta5)

Airbase 43

* Dependency updates:
    - Joda 2.8.2 (from 2.8). Fixes a compatibility issue with Java 8u60

Airbase 42

* Allow configuring minimum Java version with air.java.version

Airbase 41

* Add dependency for jackson-datatype-jdk7
* Dependency updates:
 - slf4j 1.7.12 (from 1.7.5)

Airbase 40

* Dependency updates:
  - Jetty 9.2.11.v20150529 (from Jetty 9.2.11.M0)
* Add jmh 1.9.3 dependency

Airbase 39

* Dependency updates:
  - Joda 2.8 (from 2.4)

Airbase 38

* JVM size can be configured running tests.
* Configure lint mode for Javadoc.
* Add CI profile that builds Javadoc.

Airbase 37

* Capture Git versioning information in jar manifest.
* Time zone, parallel and thread count can be configured for Surefire.
* Improve JDK logging format used when running tests.

Airbase 36

* Dependency updates:
  - Jetty 9.2.11.M0 (from 9.2.10.v20150310)

Airbase 35

* Dependency updates:
  - Jetty 9.2.10.v20150310 (from 9.2.8.v20150217)

Airbase 34

* Dependency updates:
  - Guice 4.0-beta5 (from 3.0)

Airbase 33

* Dependency updates:
  - Jetty 9.2.8.v20150217 (from 9.2.2.v20140723)

Airbase 32

* Dependency updates:
  - Slice 0.10 (from 0.6)
  - maven-dependency-plugin 2.10 (from 2.9).

Airbase 31

* Fix dependency jackson-module-parameter-names
* Add ANTLR files to license checker

Airbase 30

* Use Java 8 by default
* Add dependencies:
  - jackson-datatype-jdk8
  - jackson-datatype-jsr310
  - jackson-module-parameter-names
* Dependency updates:
  - Jackson 2.4.4 (from 2.4.2)

Airbase 29

* Dependency updates:
  - maven-dependency-plugin 2.9 (from 2.8). This version is compatible with Java 8

Airbase 28

* Dependency updates:
  - Guava 18.0 (from 16.0.1)

Airbase 27

* Set minimum Maven version to 3.2.3
* Exclude .sql files from license checker

Airbase 26

* Dependency updates:
  - Jetty 9.2.2.v20140723 (from 9.1.4.v20140401)
  - Jersey 2.12 (from 2.9.1)
  - Jackson 2.4.2 (from 2.1.4 and 2.1.2)

Airbase 25

* Dependency updates:
  - joda-time 2.4 (from 2.1)

Airbase 24

* Add dependencies for javax.annotation-api and javax.ws.rs-api
* Dependency updates:
  - Jersey 2.9.1 (from 1.17.1)

Airbase 23

* Dependency updates:
  - findbugs-annotations 2.0.3 (from 2.0.2)

Airbase 22

* Dependency updates:
  - jmxutils 1.18 (from 1.16)
  - slice 0.6 (from 0.5)
  - packaging 0.91 (from 0.82)

Airbase 21

* Ignore conflicting THIRD-PARTY in resources

Airbase 20

* Add dependencies for jetty-client and jetty-io

Airbase 19

* Dependency updates:
  - Jetty 9.1.4.v20140401 (from Jetty 9.1.3.v20140225)

Airbase 18

* Add dependency for io.airlift:slice:0.5
* Dependency updates:
  - jmxutils 1.16 (from 1.14)
  - Jetty 9.1.3.v20140225 (from 9.1.2.v20140210)

Airbase 17

* Update release plugin to 2.5

Airbase 16

* Fix dependency checker for Airlift HTTP libraries
* Add OSS snapshots as a plugin repository
* Update OSS base POM to 9
* Dependency updates:
 - javax.servlet 3.1.0 (from 3.0.1)
 - Jetty 9.1.2.v20140210 (from 8.1.9.v20130131)
* Plugin updates:
 - dependency 2.8 (from 2.7)
 - duplicate-finder 1.0.6 (from 1.0.4)

Airbase 15

* Set minimum Maven version to 3.1.1

Airbase 14

* Set memory size for compiler by enabling fork mode
* Remove dependency ban for junit 4.11+
* Dependency updates:
 - findbugs-annotations 2.0.2 (from 2.0.1)
 - jmxutils 1.14 (from 1.13)
 - testng 6.8.7 (from 6.8)
 - guava 16.0.1 (from 15.0)

Airbase 13

* Update airlift version to 0.82 to avoid launcher bug
* Remove parameters from SCM configuration
* Dependency updates:
 - Guava 15.0 (from 14.0.1)
 - slf4j 1.7.5 (from 1.7.2)
 - logback 1.0.13 (from 1.0.8)
 - validation-api 1.1.0.Final (from 1.0.0.GA)

Airbase 12

* Fix building in Eclipse

Airbase 11

* Run checks in the earliest possible phase

Airbase 10

* Update license plugin to 2.3

Airbase 9

* Update airlift version to 0.80 to avoid launcher bug

Airbase 8

* Update build-airlift for launcher rewrite

Airbase 7

* Remove erroneous git commit info from jar versions
* Remove mavanagaiata plugin

Airbase 6

* Dependency updates:
 - Guava 14.0.1 (from 14.0)
* Ban former experimental airlift modules
* Updated release plugin from 2.2.2 to 2.3.2
* Updated surefire plugin from 2.13 to 2.14
* set goal and arguments for release plugin

Airbase 5

* Updated pmd plugin to 3.0.1 from 3.0
* Updated dependency plugin to 2.7 from 2.6
* Added rule to enforce main class property being present when building airlift package.
* Added slf4j-jdk14 to the list of managed dependencies.

Airbase 4

* [BUGFIX] build-airlift profile puts main class and classpath into the main jar.

Airbase 3

* Fork mode can be configured with air.test.fork-mode.
* Re-enable mavanagaiata plugin to add git information to built jars
* Add profile to build a tarball using airlift packaging.

* Dependency updates:
 - Jersey 1.17.1 (from 1.17)
 - Guava 14.0 (from 13.0.1)
 - Jackson core, databind, dataformat-smile 2.1.4 (from 2.1.3)
 - Jackson annotations 2.1.4 (from 2.1.2)

* Plugin updates:
 - dependency plugin 2.7 (from 2.6)

Airbase 2

* Bug fix: air.check.skip-jacoco did not work

Airbase 1

* Initial release

