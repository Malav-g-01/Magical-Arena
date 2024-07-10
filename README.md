# Magical-Arena

Magical Arena is a Java-based simulation game where two players battle in a magical arena. Each player has attributes such as health, strength, and attack. Players take turns attacking and defending using dice rolls to determine the outcome of each turn.

## Getting Started

### Prerequisites

Ensure you have the following installed:

+ Java Development Kit (JDK)
+ Maven

### Installation

1. Clone the repository:
   ```
   git clone [https://github.com/your-repo/magical-arena.git](https://github.com/Malav-g-01/Magical-Arena.git)
   cd magical-arena
   ```
2. Build the project:
   ```
   mvn clean install
   ```
### Running the Application

To run the application, execute the following command:

```
mvn exec:java -Dexec.mainClass="com.magicalarena.MagicalArena"
```

### Running Tests

To run the unit tests, use the following command:

```
mvn test
```

Test results will be displayed in the terminal and detailed reports can be found in target/surefire-reports.

## Classes

### MagicalArena

`MagicalArena` class is the main entry point of the application. It orchestrates the game flow and determines the winner.

### Player

`Player` class represents a player in the arena. Each player has health, strength, and attack attributes, and methods to calculate damage and defense.

### Dice

`Dice` class simulates a six-sided dice roll, which is used to determine the outcome of attacks and defenses.

## Tests

### MagicalArenaTest

`MagicalArenaTest` class contains unit tests for the MagicalArena class. It uses JUnit 5 for testing. The tests validate the game logic and ensure correct behavior.

### Writing Tests
To add new tests, place your test classes in the `src/test/java/com/MegicalArena/` directory. Ensure that your test classes follow the naming convention *Test.java.

## Acknowledgments

+ Thanks to all contributors and testers for their valuable feedback and support.
