Java Commons
============

[![CI](https://github.com/torand/java-commons/actions/workflows/continuous-integration.yml/badge.svg)](https://github.com/torand/java-commons/actions/workflows/continuous-integration.yml)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.torand/java-commons.svg?label=maven%20central)](https://central.sonatype.com/artifact/io.github.torand/java-commons)
[![Javadoc](https://img.shields.io/badge/javadoc-online-green)](https://torand.github.io/java-commons/apidocs/)
[![Coverage](https://coveralls.io/repos/github/torand/java-commons/badge.svg?branch=main)](https://coveralls.io/github/torand/java-commons?branch=main)
[![Apache 2.0 License](https://img.shields.io/badge/license-Apache%202.0-orange)](LICENSE)

Java library with general purpose utility classes.

## Table of Contents

- [Overview](#overview)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Overview

A collection of Java classes not related to any domain or application, providing useful tools currently missing from the JDK "toolbox".

The library can be used in any Java project running on JVM 17 or later. It has no run-time dependencies besides existing classes and interfaces in JDK 17.

## Usage

The package is available from the [Maven Central Repository](https://central.sonatype.com/artifact/io.github.torand/java-commons).

### Maven

Include in a ```pom.xml``` file like this:

```xml
<dependencies>
  <dependency>
    <groupId>io.github.torand</groupId>
    <artifactId>java-commons</artifactId>
    <version>1.1.0</version>
  </dependency>
</dependencies>
```

### Gradle

Include in a ```build.gradle``` file like this:

```groovy
dependencies {
    implementation 'io.github.torand:java-commons:1.1.0'
}
```

## Contributing

1. Fork it (https://github.com/torand/java-commons/fork)
2. Create your feature branch (git checkout -b feature/fooBar)
3. Commit your changes (git commit -am 'Add some fooBar')
4. Push to the branch (git push origin feature/fooBar)
5. Create a new Pull Request

## License

This project is licensed under the [Apache-2.0 License](LICENSE).
