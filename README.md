# Geo Weather Project

Source code: https://github.com/anatoly-antonov/geo-weather

1. Run Application class;
2. Open http://localhost:8080;
3. Enjoy.

 #### Usages ####
 * Ehcache as a cache;
 * H2 as in-memory database;
 * JaCoCo for test coverage report.
 
 #### Test Coverage Report ####
 1. Execute "mvn clean test" command;
 2. Execute "mvn jacoco:report";
 3. Open target\site\jacoco\index.html to see the report.

 #### H2 Console ####
 1. Open http://localhost:8080/h2/
 2. Use JDBC url "jdbc:h2:mem:geoweather" with user "user" and no password
 
 #### IDE Requirements ####
 * Lombok plugin.
 
 #### Environment Requirements ####
 * JDK;
 * Maven. 