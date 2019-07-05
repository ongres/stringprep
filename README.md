# StringPrep and SaslPrep implementation

## Overview

StringPrep is the preparation of internationalized strings 
([stringprep, RFC 3454](https://tools.ietf.org/html/rfc3454)).
SaslPrep is a profile of stringprep for user names and passwords 
([saslprep, RFC 4013](https://tools.ietf.org/html/rfc4013)).

## Goals

This project aims to provide a implementation of these algorithms.
It is written in Java and provided in a modular, re-usable way, independent of
other software or programs.

Current functionality includes:

* Parsers with the different steps for preparing string. The data is obtained from a file with the rules of the RFC.
* StringPrep dynamic class with the different types of: map, normalize, prohibit and check bidi possibles.
* SaslPrep with the specific steps of StringPrep.
* Tests with the RFC example and several tests of each steps.

## Saslprep

'saslprep' is the module that contains the saslprep profile of StringPrep.
Import maven dependency:

    <dependency>
        <groupId>com.ongres.stringprep</groupId>
        <artifactId>saslprep</artifactId>
    </dependency>
    

## Contributing

Please submit [Merge Requests](https://gitlab.com/ongresinc/stringprep) for code contributions.
Make sure to compile with `mvn compile -P safer` before submitting a MR.

Releases (on the master branch only) must be verified with:

    mvn -P safer -Pmaster-branch