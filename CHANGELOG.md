# Changelog
All notable changes to this project will be documented in this file.

## [Unreleased]

## [2.2] - Unreleased
### :building_construction: Improvements
- Ensure the LICENSE file is included in the Jar file.
- Fix reproducible build.

### :ghost: Maintenance
- Migrate the main repo back to GitHub.
- Updated dependencies and maven plugins.

## [2.1] - 2024-04-01
### :bug: Bug Fixes
- `Stringprep::getProvider` was not working on the module path.

### :sparkles: New features
- The Profile interface now has overloaded methods with `char[]` versions.

### :building_construction: Improvements
- The Java modules profiles `com.ongres.saslprep` and `com.ongres.nameprep` have implied readability with `com.ongres.stringprep`.
- Exports the packages of the profiles in the module declaration to allow creating instances without the ServiceLoader lookup.
- Introduce the annotation `@ProfileName` to declare the name of the profile used for ServiceLoader lookup.
- Now the released jars are reproducible.
- Publish CycloneDX SBOM.

## [2.0] - 2021-02-01
### :boom: Breaking changes
- Full rewrite of the `stringprep` implementation, this release is compatible with Java 8+.

### :sparkles: New features
- The stringprep profiles can be created by implementing the `Profile` interface.
- New module `nameprep` implementing the stringprep `Profile`.
- Create Multi-release Modular JARs, the modules names are:
  - `com.ongres.stringprep`
  - `com.ongres.saslprep`
  - `com.ongres.nameprep`

### :building_construction: Improvements
- Refactor of the `stringprep` implementation to make it extensible and modular, now this implemenation is considered feature-complete.
- Change the module `saslprep` to implement the stringprep `Profile` interface.

[2.0]: https://github.com/ongres/stringprep/compare/1.1...2.0
[2.1]: https://github.com/ongres/stringprep/compare/2.0...2.1
[Unreleased]: https://github.com/ongres/stringprep/compare/2.1...main
