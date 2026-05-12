# Changelog

All notable changes to this project will be documented in this file.

## [Unreleased]

## [2.3] - 2026-05-12

### :bug: Bug Fixes

- Fixed an `ArrayIndexOutOfBoundsException` that occurred when mapping characters to an empty output.
- Optimized throughput and reduced heap churn by utilizing `Normalizer.isNormalized()` to avoid unnecessary processing.

### :lock: Security

- Introduced `SecureStringBuilder` to safely handle sensitive data and allow for immediate memory clearing during stringprep operations.

### :building_construction: Infrastructure & Build

- Updated build environment to Java 25.
- Upgraded Maven wrapper/requirement to 3.9.15.

### :ghost: Maintenance

- Updated project dependencies and Maven plugins to their latest stable versions.
- Refactored Stringprep internal logic to store the EnumSet directly, replacing 18 individual boolean flags for better maintainability and reduced memory footprint.

## [2.2] - 2024-06-25

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
[2.2]: https://github.com/ongres/stringprep/compare/2.1...2.2
[2.3]: https://github.com/ongres/stringprep/compare/2.2...2.3
[Unreleased]: https://github.com/ongres/stringprep/compare/2.3...main
