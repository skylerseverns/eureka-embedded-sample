# eureka-embedded-sample

This is a sample project for running eureka as a spring-boot application with limited extras.

# Prerequisites
- Java 8
- IntelliJ

## Building
This is a standard maven project, use intelliJ and package.

## Running
Also very straightforward (except for setting up Eureka). The project is an executable jar and all settings have been externalized through properties. 
In the `scripts` directory you will find a powershell file setting every configurable variable.

*Setting Up Eureka*

1. Download the [eureka server war](http://search.maven.org/#search%7Cga%7C1%7Ceureka-server).
1. Put the WAR somewhere nice (e.g. c:\opt\netflix\eureka\)
1. Change the WAR extension to ZIP
1. Extract
1. Update the files found in `config` then copy them into {extracted-directory}\WEB-INF\classes. Overwritting the files already there.
1. Update the start.ps1 to have the settings you want

*Running as a Service*
1. Setup Eureka (see above)
1. Copy the spring-boot jar, `deploy\eureka-service.exe`, `deploy\eureka-service.xml` to desired folder.
1. Run eureka-service.exe install


## Potential Issues
- The executable jar needs to be in the same directory as the start.ps1 script by default.
- The application will write to disk, check permissions on the tomcat base directory.