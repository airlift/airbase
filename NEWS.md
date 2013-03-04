Airbase 3

* Test fork mode is configurable

* Create airship compatible tarball with launcher from a module

When a '.build-airship' file is present in a maven module (or
submodule), automatically create and attach a tarball from this module
and all its dependencies.

The tarball will use airlift packaging and launcher. The version for
those is controlled by the 'dep.packaging.version' property.

Default is 0.70 (latest release).

Airbase 2

* Bug fixes

Airbase 1

* Initial release
