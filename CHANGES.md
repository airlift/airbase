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

