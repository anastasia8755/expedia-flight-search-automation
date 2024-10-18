# expedia-flight-search-automation
<h3>Automation Project for Automation Testing Manage - Expedia

<h3>Project Covers:

- UI

[![Java8](https://img.shields.io/badge/java-8-orange)](https://www.openlogic.com/openjdk-downloads)
[![Maven](https://img.shields.io/badge/-maven-purple)](https://maven.apache.org/)
[![TestNG](https://img.shields.io/badge/-TestNG-red)](https://testng.org/doc/download.html)
[![Selenium](https://img.shields.io/badge/selenium-green)](https://www.selenium.dev/documentation/webdriver/)

##Short description
**This automation framework is designed to test the flights information and booking functionality of a travel website Expedia. It verifies core features such as flight search, flight filters, choosing the best fly option.**

**The framework utilizes Selenium for browser automation, is written in Java 8, and is built on the Page Object and Page Factory design patterns for ease and efficiency in testing.**

## 1. Set up
Prerequisite:
- Java: download and install Java in the system as per the system configuration and set the path in the environment variables.

- Maven: download and install Maven in the system as per the system configuration and set the path in the environment variables.

- IDE: download and install either IntelliJ community or eclipse version as per the system configuration.

- Git: Download and install Git as per the system configuration.

Before cloning the project make sure that you have SSH Key in GitHub. If you don't have one, create and add an SSH key, follow the instructions:

[![Generate](https://img.shields.io/badge/-How%20to%20generate%20SSH%20Key-lightgrey)](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)
[![Add](https://img.shields.io/badge/-How%20to%20add%20SSH%20Key%20to%20account-lightgrey)](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account)

After that you can clone project with command:
```
git@github.com:anastasia8755/expedia-flight-search-automation.git
```
##or

Clone project without SSH:
```
git clone https://github.com/anastasia8755/expedia-flight-search-automation.git
```
## 2. Test execution
Run tests with TestNG

To run tests with TestNG run tests from IDE: click on the module (project) name>>Run>>All Tests.

### 2.1 Run for different browsers
If you run tests on Windows you can choose between Chrome and Firefox browser.
If you run tests on macOS you should choose Safari.

For choosing appropriate browser click: 
module(project)name>>src>>main>>resources>>WebDriverConfig.properties

And set appropriate ```browser= ```

### 2.2 Difficulties with captcha
If you run test _lightBookingFlowTest_ several times you may see captcha after click ```Search``` button.
In this case go to 

module(project)name >> src >> main >> java >> com >> expedia >> pages >> components >> SearchPanelComponent

and put breakpoint at line 94.

After that run test in _Debug_ mode. When test stops at breakpoint manually resolve captcha puzzle and continue running test.

_**Note:**_ all test data already have been filled in test in order to task. 