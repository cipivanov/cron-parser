# Cron Parser Utility

### Current CI status: [![Build Status](https://travis-ci.org/ciprianivanov/guardian-open-platform-api-test.svg?branch=master)](https://travis-ci.org/ciprianivanov/guardian-open-platform-api-test)

This repository contains a Cron parser utility

## Languages, frameworks and libraries used

* *Java:* programming language of choice
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

## Setup

Not much in the way of setting up the project.

The only requirement is to have Maven installed and configured properly. See: https://maven.apache.org/install.html
Then Maven should handle all the dependencies by itself.

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

## TODO's

* Custom per-field validation capabilities which will provide a safety net before starting the parsing effort