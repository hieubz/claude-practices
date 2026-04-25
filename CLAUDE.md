# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run

```bash
mvn compile          # compile sources
mvn package          # build JAR to target/
mvn test             # run tests
mvn clean            # remove target/
```

Run the main class after compiling:
```bash
mvn exec:java -Dexec.mainClass="com.hieupd.Main"
```

## Project Structure

- **Language:** Java 17
- **Build:** Maven (`pom.xml`), group `com.hieupd`, artifact `claude-practices`
- **Entry point:** `src/main/java/com/hieupd/Main.java`
- **Tests:** `src/test/java/com/hieupd/` (currently empty — no test framework added yet)
- **Resources:** `src/main/resources/` (empty)

## Notes

No test dependencies are configured in `pom.xml` yet. To add JUnit 5, add the `junit-jupiter` dependency and the `maven-surefire-plugin` before writing tests.
