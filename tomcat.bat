@echo off
D:
SET PROJECT_HOME=%cd%
ECHO Project HOME:"%PROJECT_HOME%"

SET ANTX_PROPERTY=%PROJECT_HOME%\antx.properties
set MAVEN_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -DuserProp=%ANTX_PROPERTY% -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n

call mvn -X  package

@pause