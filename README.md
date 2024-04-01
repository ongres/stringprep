# Stringprep (RFC 3454) Java implementation

> Preparation of Internationalized Strings ("stringprep")

## Overview

This project implements the [RFC 3454](https://tools.ietf.org/html/rfc3454) Preparation of Internationalized Strings ("stringprep") in pure Java.

[![Maven Central](https://img.shields.io/badge/maven--central-stringprep-informational?style=for-the-badge&logo=apache-maven&logoColor=red)](https://maven-badges.herokuapp.com/maven-central/com.ongres.stringprep/stringprep)

The stringprep protocol does not stand on its own; it has to be used by other protocols at precisely-defined places in those other protocols.

## Profiles

### SASLprep (RFC 4013)

`SASLprep` is a profile of stringprep for user names and passwords ([RFC 4013](https://tools.ietf.org/html/rfc4013)).

Import Maven dependency:

[![Maven Central](https://img.shields.io/badge/maven--central-saslprep-informational?style=for-the-badge&logo=apache-maven&logoColor=red)](https://maven-badges.herokuapp.com/maven-central/com.ongres.stringprep/saslprep)

```xml
<dependency>
  <groupId>com.ongres.stringprep</groupId>
  <artifactId>saslprep</artifactId>
  <version>2.1</version>
</dependency>
```

### Nameprep (RFC 3491)

`Nameprep` is a Stringprep Profile for Internationalized Domain Names (IDN) ([RFC 3491](https://tools.ietf.org/html/rfc3491)).

Import Maven dependency:

[![Maven Central](https://img.shields.io/badge/maven--central-nameprep-informational?style=for-the-badge&logo=apache-maven&logoColor=red)](https://maven-badges.herokuapp.com/maven-central/com.ongres.stringprep/nameprep)

```xml
<dependency>
  <groupId>com.ongres.stringprep</groupId>
  <artifactId>nameprep</artifactId>
  <version>2.1</version>
</dependency>
```

## Usage

The normal usage is to import the dependency of the Stringprep profile to use, and lookup the provider service that contains the profile.

### Example:
Import the `SASLprep` dependency, this transitively imports the `Stringprep` dependency.
```xml
<dependency>
  <groupId>com.ongres.stringprep</groupId>
  <artifactId>saslprep</artifactId>
  <version>2.1</version>
</dependency>
```

Get the `SASLprep` provider service:
```java
Profile saslPrep = Stringprep.getProvider("SASLprep");
String prepared = saslPrep.prepareStored("I\u00ADX \u2168");
prepared.equals("IX IX"); // true
```

You could also (only) use the stringprep dependency to create your own profiles by implementing the `Profile` interface, just override the `profile()` method with the set of options.

Anonymous on-the-fly profile usage:
```java
Profile saslPrep = () -> EnumSet.of(Option.NORMALIZE_KC, Option.MAP_TO_NOTHING);
String prepared = saslPrep.prepareStored("I\u00ADX ⑳");
prepared.equals("IX 20"); // true
```

> Please note that when two protocols that use different profiles of stringprep interoperate, there may be conflict about what characters are and are not allowed in the final string.  Thus, protocol developers should strongly consider re-using existing profiles of stringprep.

### Java Modules (JPMS):
The Stringprep and profiles implementation are explicit Java modules with the names:

* `com.ongres.stringprep`
* `com.ongres.saslprep`
* `com.ongres.nameprep`

If you depend on a specific profile (`saslprep` or `nameprep`) there is an implied readability on `stringprep`, so you will only need to declare in your `module-info.java` the profile module and get the service from the provider.

Example `module-info.java`:
```java
module test.app {
  requires com.ongres.saslprep;
}
```

## Goals

This project aims to provide a implementation of these algorithms.
It is written in Java and provided in a modular, re-usable way, independent of other software or programs.

Current functionality includes:

* Parsers with the different steps for preparing string. The data is obtained from files with the rules of the RFC.
* Provide a `Profile` interface working as the base for implementing different profiles of Stringprep.
* Include the preparation of two types of strings "stored strings" and "queries".
* `SASLprep` profile with the specific options of Stringprep.
* `Nameprep` profile with the specific options of Stringprep.
* Tests with the RFC example and several tests of each steps.
* Multi-release Modular JARs, compatible with Java 8+.
* Zero-depdency, each profile depends only on the Stringprep module.
* New Stringprep profiles could be implemented easily and even "on-the-fly".
