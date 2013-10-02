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

