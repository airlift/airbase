Airbase 15

* Maven version 3.1.1 is now required

Airbase 14

* Maintenance release

Airbase 13

* Update airlift packaging version to avoid launcher bug

Airbase 12

* Fix building in Eclipse

Airbase 11

* Run checks in the earliest possible phase

Airbase 10

* The license header checker is now configurable via properties

Airbase 9

* Update airlift version to avoid launcher bug. If you are using
  airbase 8 and the default version of airlift packaging, then you
  should upgrade to this version.

Airbase 8

* Update build-airlift for launcher rewrite. This requires
  dep.packaging.version to be at least 0.79.

Airbase 7

* Remove mavanagaiata plugin

Airbase 6

* Ban all old 'experimental' modules, so this release will no longer
  work with any airlift versions before 0.74

Airbase 5

* Maintenance release

Airbase 4

* Bug fix release (fixes a problem with the airlift packaging build)

Airbase 3

* Test fork mode is configurable

* Create a tarball using airlift packaging

When a '.build-airlift file is present in a maven module (or
submodule), automatically create and attach a tarball from this module
and all its dependencies.

The tarball will use airlift packaging and launcher. The version for
those is controlled by the 'dep.packaging.version' property.

Default is 0.70 (latest release).

Airbase 2

* Bug fixes

Airbase 1

* Initial release
