# Cron Parser Utility

### Current CI status: [![Build Status](https://travis-ci.org/ciprianivanov/guardian-open-platform-api-test.svg?branch=master)](https://travis-ci.org/ciprianivanov/guardian-open-platform-api-test)

This repository contains a Cron parser utility

## Current capabilities

Basic Cron parser capable of interpreting a valid standard Cron expression and outputting the expected execution times.

*Currently does not offer Cron expression validation capabilities. Assumes that the Cron expression provided is valid.*

### Supported Cron format:

```
* * * * *
| | | | | 
| | | | +---- Day of the Week   (range: 1-7, 1 standing for Monday)
| | | +------ Month of the Year (range: 1-12)
| | +-------- Day of the Month  (range: 1-31)
| +---------- Hour              (range: 0-23)
+------------ Minute            (range: 0-59)
```

### Supported symbols (field types):

* \* - (“all values”) - used to select all values within a field. For example, “*” in the minute field means “every minute”.
* *?* - (“no specific value”) - useful when you need to specify something in one of the two fields in which the character is allowed, but not the other. For example, if I want my trigger to fire on a particular day of the month (say, the 10th), but don’t care what day of the week that happens to be, I would put “10” in the day-of-month field, and “?” in the day-of-week field. See the examples below for clarification.
* *-* - used to specify ranges. For example, “10-12” in the hour field means “the hours 10, 11 and 12”.
* *,* - used to specify additional values. For example, “MON,WED,FRI” in the day-of-week field means “the days Monday, Wednesday, and Friday”.
* */* - used to specify increments. For example, “0/15” in the seconds field means “the seconds 0, 15, 30, and 45”. And “5/15” in the seconds field means “the seconds 5, 20, 35, and 50”. You can also specify ‘/’ after the ‘’ character - in this case ‘’ is equivalent to having ‘0’ before the ‘/’. ‘1/3’ in the day-of-month field means “fire every 3 days starting on the first day of the month”.

(c) - [explanation source](https://travis-ci.org/ciprianivanov/guardian-open-platform-api-test)

### Does not support: 

* L, W and # symbols

## Languages, frameworks and libraries used

* *Java 8:* programming language of choice
* *Maven:* dependency management and build tool
* *JUnit:* used for purposes of unit testing

## Project structure

The cron-parser core has the following package structure:
src\main\java\com\cron\parser
```
src
└─main
 │  └─java
 │    └─com
 │       └─cron
 │          └─parser
 │             └─cli          - containg the command line interface, entry point
 │             └─impl         - cron parser implementation
 │             └─interpreter  - currently available interpreters
 │             └─model        - cron expression related models
 │             └─util         - utility classes
 │
 └─test
    └─java
      └─com
         └─cron
            └─parser          - unit/acceptance tests
```
*.travis.yml* - the manages the Travis CI plugin and the jobs triggered
*pom.xml* - handles all the dependencies and information about the build process


## Prerequisites

Not much in the way of setting up the project.

The only requirement is to have Maven and Git installed and configured properly. 
See: https://maven.apache.org/install.html for Maven and for Git https://git-scm.com/book/en/v2/Getting-Started-Installing-Git

## Setup

#### Steps:

1. Clone the repository
2. Run *mvn clean install* in the root directory of the application (where pom.xml file is)
3. From root repository folder navigate to *target* folder

After the steps there should find a cron-parser-1.0-SNAPSHOT.jar in the folder. Opening a command line in the folder and running the 
examples will yield the interpretation output.

## CLI usage examples

The basic call should follow the template: java -jar %jar_file_name%.jar "%cron_expression%"

```
java -jar cron-parser-1.0-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find

java -jar cron-parser-1.0-SNAPSHOT.jar "0 0 * * * find $HOME -name core 2>/dev/null | xargs rm -f"
minute        0
hour          0
day of month  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5 6 7
command       find $HOME -name core 2>/dev/null | xargs rm -f


java -jar cron-parser-1.0-SNAPSHOT.jar "1,2,3,5,20-25,30-35,59 23 31 12 *"
minute        1 2 3 5 20 21 22 23 24 25 30 31 32 33 34 35 59
hour          23
day of month  31
month         12
day of week   1 2 3 4 5 6 7
command       <no command>
```

## Java code usage examples

The parser capabilities can be reused when needed in any other Java application as follows:

```java
Parser parser = new CronParser(); // create the CronParser instance

parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find"); // parsing call
parser.parse("0 0 * * * find $HOME -name core 2>/dev/null | xargs rm -f"); // parsing call
parser.parse("1,2,3,5,20-25,30-35,59 23 31 12 *"); // parsing call

// will produce the same exact output as the CLI interface above
```

## TODO's

* Custom per-field validation capabilities which will provide a safety net before starting the parsing effort