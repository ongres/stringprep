# Changelog
All notable changes to this project will be documented in this file.

## [Unreleased]
### :bug: Bug Fixes
- `Stringprep.getProvider` was not working in the module path.

## [2.0] - 2021-02-01
### :boom: Breaking changes
- Full rewrite of the `stringprep` implementation, this release is compatible with Java 8+.

### :sparkles: New features and improvements
- Refactor of the `stringprep` implementation to make it extensible and modular, now this implemenation is considered feature-complete.
- The stringprep profiles can be created by implementing the `Profile` interface.
- Change module `saslprep` to implement the stringprep `Profile` interface.
- New module `nodeprep` implementing the stringprep `Profile` interface.
- Create Multi-release Modular JARs, the modules names are:
  - `com.ongres.stringprep`
  - `com.ongres.saslprep`
  - `com.ongres.nodeprep`

[Unreleased]: https://gitlab.com/ongresinc/stringprep/-/compare/2.0...main
[2.0]: https://gitlab.com/ongresinc/stringprep/-/compare/1.1...2.0
