Airbase 7

* Disable mavanagaiata plugin

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
