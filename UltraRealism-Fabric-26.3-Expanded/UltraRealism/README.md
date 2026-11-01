# Ultra Realism — Minecraft Java 26.3 / Fabric

**Status: expanded development foundation, not a finished game-ready mod.**

This project is structured for a large realism mod and contains reusable simulation logic, feature specifications, data catalogs, a Fabric entrypoint, and a build/test setup. It does **not** yet implement every listed system as in-game content. In particular, custom animal entity registration, models, renderers, spawn rules, complete block/item registration, GUIs, and world integration still require implementation and in-game verification.

## Included in this version
- Fabric 26.3 project metadata and current version pins
- Modular Java package layout
- Pure Java simulation modules for food freshness, crops, material wear, animal needs, and simple power allocation
- Unit tests for simulation logic
- JSON content catalog for planned foods, animals, materials, machines, and vehicles
- Feature roadmap and acceptance criteria
- GitHub Actions build workflow

## Target toolchain
Use the versions currently recommended by Fabric for Minecraft 26.3:
- Minecraft: `26.3`
- Java: `25`
- Fabric Loader: `0.19.5`
- Fabric API: `0.165.0+26.3`
- Fabric Loom: `1.19-SNAPSHOT`
- Gradle: `9.7.1` or a compatible newer version

Always verify the current recommended versions at https://fabricmc.net/develop/ before building.

## Build
In a Java 25 + Gradle 9.7.1 cloud environment:
```bash
gradle test
gradle build
```
If using the Gradle wrapper after adding the wrapper files:
```bash
./gradlew test
./gradlew build
```
The resulting mod JAR should appear in `build/libs/` if the build succeeds.

## Honest verification status
This ZIP was assembled as source files. A Minecraft Gradle build and in-game launch were **not run in the file-generation environment**. The CI workflow is included so the project can be built in GitHub Actions. A successful Java build does not by itself prove all mechanics work in-game.

## First playable milestone
The first target is not “thousands of items”; it is one small vertical slice:
1. mod starts on 26.3;
2. one registered custom food item exists;
3. one recipe works;
4. one custom animal spawns, renders, moves, eats, and persists;
5. automated tests and an in-game checklist pass.

Then expand each subsystem in small, tested increments.
