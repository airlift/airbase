Airbase 2

* Bug fixes

* Create tarballs (with launcher) from a module

When a '.build-tarball' file is present in a maven module (or
submodule), automatically create and attach a tarball from this module
and all its dependencies.

The tarball will use airlift packaging and launcher. The version for
those is controlled by the 'dep.packaging.version' property.

Default is 0.70 (latest release).


Airbase 1

* Initial release
