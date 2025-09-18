# Java Utils Library

Eine umfassende Java Utility Library mit wiederverwendbaren Komponenten für häufige Programmieraufgaben.

## 📋 Inhaltsverzeichnis

- [Überblick](#überblick)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [API Dokumentation](#api-dokumentation)
- [Development](#development)
- [Publishing](#publishing)
- [Contributing](#contributing)

## 🎯 Überblick

Die Java Utils Library bietet eine Sammlung von Utility-Klassen für:

- **String-Operationen** (StringUtils)
- **Datum/Zeit-Verarbeitung** (DateUtils)
- **Validierung** (ValidationUtils)
- **Mathematische Berechnungen** (Calculator)

Alle Klassen sind vollständig getestet, dokumentiert und Thread-Safe.

## ✨ Features

### StringUtils

- Null-Safe String-Operationen
- Text-Transformation (Kapitalisierung, CamelCase, etc.)
- String-Validierung und -Analyse
- Join/Split-Operationen

### DateUtils

- Datum/Zeit-Formatierung und -Parsing
- Datum-Arithmetik
- Zeitperioden-Berechnungen
- Datum-Validierung

### ValidationUtils

- Email, Phone, URL Validierung
- Numerische Validierung
- Text-Pattern Validierung
- Range-Validierung

### Calculator

- Grundrechenarten
- Erweiterte mathematische Funktionen
- Array-Operationen (Min, Max, Average, Sum)
- Zahlen-Eigenschaften (Primzahl, Gerade/Ungerade)
- GCD/LCM Berechnungen

## 🚀 Installation

### Via GitHub Packages (Empfohlen)

1. Fügen Sie das GitHub Packages Repository zu Ihrer `pom.xml` hinzu:

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/berkeposlu/java-utils-library</url>
    </repository>
</repositories>
```

2. Fügen Sie die Dependency hinzu:

```xml
<dependency>
    <groupId>com.berkeposlu</groupId>
    <artifactId>java-utils-library</artifactId>
    <version>1.0.0</version>
</dependency>
```

3. Konfigurieren Sie die GitHub Packages Authentifizierung in `~/.m2/settings.xml`:

```xml
<settings>
    <servers>
        <server>
            <id>github</id>
            <username>YOUR_GITHUB_USERNAME</username>
            <password>YOUR_GITHUB_TOKEN</password>
        </server>
    </servers>
</settings>
```

### Lokale Installation

```bash
# Clone das Repository
git clone https://github.com/berkeposlu/java-utils-library.git
cd java-utils-library

# Build und installiere lokal
mvn clean install
```

## 📖 Usage

### StringUtils Beispiele

```java
import com.berkeposlu.javautils.StringUtils;

// Basic operations
StringUtils.isEmpty(""); // true
StringUtils.isNotBlank("hello"); // true
StringUtils.capitalize("hello world"); // "Hello world"
StringUtils.reverse("hello"); // "olleh"

// Text transformation
StringUtils.toCamelCase("hello_world_test"); // "helloWorldTest"
StringUtils.join(", ", "apple", "banana", "cherry"); // "apple, banana, cherry"
StringUtils.truncate("Very long text", 10); // "Very lo..."

// Analysis
StringUtils.countOccurrences("hello world", "l"); // 3
```

### DateUtils Beispiele

```java
import com.berkeposlu.javautils.DateUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;

// Formatting
LocalDate date = LocalDate.now();
DateUtils.formatDate(date, "yyyy-MM-dd"); // "2023-12-25"
DateUtils.formatDate(date, "dd.MM.yyyy"); // "25.12.2023"

// Parsing
LocalDate parsed = DateUtils.parseDate("2023-12-25", "yyyy-MM-dd");

// Date arithmetic
DateUtils.addDays(date, 10); // Add 10 days
DateUtils.daysBetween(startDate, endDate); // Days difference

// Validation
DateUtils.isToday(date); // true/false
DateUtils.isInFuture(tomorrow); // true
```

### ValidationUtils Beispiele

```java
import com.berkeposlu.javautils.ValidationUtils;

// Email validation
ValidationUtils.isValidEmail("test@example.com"); // true
ValidationUtils.isValidEmail("invalid-email"); // false

// Phone validation
ValidationUtils.isValidPhone("+1234567890"); // true
ValidationUtils.isValidPhone("123-456-7890"); // true

// URL validation
ValidationUtils.isValidUrl("https://www.example.com"); // true

// Text validation
ValidationUtils.isNumeric("123.45"); // true
ValidationUtils.isAlphabetic("hello"); // true
ValidationUtils.isAlphanumeric("hello123"); // true

// Length validation
ValidationUtils.hasMinLength("hello", 5); // true
ValidationUtils.isLengthInRange("hello", 3, 10); // true

// Range validation
ValidationUtils.isInRange(5, 1, 10); // true
ValidationUtils.areAllNotNull("a", "b", "c"); // true
```

### Calculator Beispiele

```java
import com.berkeposlu.javautils.Calculator;

// Basic arithmetic
Calculator.add(10, 5); // 15.0
Calculator.divide(10, 3); // 3.333...
Calculator.power(2, 3); // 8.0
Calculator.sqrt(16); // 4.0

// Advanced operations
Calculator.factorial(5); // 120
Calculator.percentageOf(200, 50); // 100.0 (50% of 200)
Calculator.round(3.14159, 2); // 3.14

// Array operations
double[] values = {1.0, 2.0, 3.0, 4.0, 5.0};
Calculator.min(values); // 1.0
Calculator.max(values); // 5.0
Calculator.average(values); // 3.0
Calculator.sum(values); // 15.0

// Number properties
Calculator.isEven(4); // true
Calculator.isPrime(7); // true
Calculator.gcd(12, 18); // 6
Calculator.lcm(12, 18); // 36
```

## 📚 API Dokumentation

Die vollständige JavaDoc Dokumentation wird automatisch generiert und ist verfügbar:

- **Online**: GitHub Pages (nach dem Build)
- **Lokal**: `mvn javadoc:javadoc` → `target/site/apidocs/index.html`

### Wichtige Klassen

| Klasse            | Beschreibung              | Wichtige Methoden                              |
| ----------------- | ------------------------- | ---------------------------------------------- |
| `StringUtils`     | String-Operationen        | `isEmpty()`, `capitalize()`, `toCamelCase()`   |
| `DateUtils`       | Datum/Zeit-Verarbeitung   | `formatDate()`, `parseDate()`, `daysBetween()` |
| `ValidationUtils` | Validierung               | `isValidEmail()`, `isNumeric()`, `isInRange()` |
| `Calculator`      | Mathematische Operationen | `add()`, `factorial()`, `isPrime()`            |

## 🛠 Development

### Voraussetzungen

- Java 17+
- Maven 3.8+
- Git

### Setup

```bash
# Repository clonen
git clone https://github.com/berkeposlu/java-utils-library.git
cd java-utils-library

# Dependencies installieren und Tests ausführen
mvn clean install

# Tests ausführen
mvn test

# JavaDoc generieren
mvn javadoc:javadoc
```

### Projektstruktur

```
java-utils-library/
├── src/
│   ├── main/java/com/berkeposlu/javautils/
│   │   ├── StringUtils.java
│   │   ├── DateUtils.java
│   │   ├── ValidationUtils.java
│   │   └── Calculator.java
│   └── test/java/com/berkeposlu/javautils/
│       ├── StringUtilsTest.java
│       ├── DateUtilsTest.java
│       ├── ValidationUtilsTest.java
│       └── CalculatorTest.java
├── .github/workflows/
│   ├── ci.yml
│   └── publish.yml
├── pom.xml
└── README.md
```

### Tests ausführen

```bash
# Alle Tests
mvn test

# Spezifische Test-Klasse
mvn test -Dtest=StringUtilsTest

# Test Coverage Report
mvn test jacoco:report
```

## 📦 Publishing

### Automatisches Publishing via GitHub Actions

Das Projekt ist so konfiguriert, dass es automatisch auf GitHub Packages veröffentlicht wird:

1. **Bei Tag-Push**: `git tag v1.0.1 && git push origin v1.0.1`
2. **Bei Release**: Erstellen Sie ein Release über GitHub UI
3. **Manuell**: Über GitHub Actions Workflow Dispatch

### Manuelles Publishing

```bash
# Version in pom.xml aktualisieren
mvn versions:set -DnewVersion=1.0.1
mvn versions:commit

# Build und Deploy
mvn clean compile test package source:jar javadoc:jar deploy
```

### Versionierung

Das Projekt folgt [Semantic Versioning](https://semver.org/):

- **MAJOR**: Breaking Changes
- **MINOR**: Neue Features (backwards compatible)
- **PATCH**: Bug Fixes

## 🤝 Contributing

Beiträge sind willkommen! Bitte beachten Sie:

1. Fork das Repository
2. Erstellen Sie einen Feature Branch (`git checkout -b feature/amazing-feature`)
3. Committen Sie Ihre Änderungen (`git commit -m 'Add amazing feature'`)
4. Pushen Sie den Branch (`git push origin feature/amazing-feature`)
5. Öffnen Sie eine Pull Request

### Code Style

- Verwenden Sie JavaDoc für alle öffentlichen Methoden
- Schreiben Sie Tests für neue Features
- Befolgen Sie Java Code Conventions
- Halten Sie Methoden klein und fokussiert

### Reporting Issues

Nutzen Sie GitHub Issues für:

- Bug Reports
- Feature Requests
- Fragen zur Verwendung

## 📄 License

Dieses Projekt steht unter der MIT License. Siehe [LICENSE](LICENSE) für Details.

## 🙏 Acknowledgments

- Inspiriert von Apache Commons Lang
- Dank an die Java Community
- JUnit Team für das Testing Framework

---

**Erstellt mit ❤️ von Berke Poslu**
