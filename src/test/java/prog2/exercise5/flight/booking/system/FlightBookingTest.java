<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>prog2.exercise5.flight.booking.system</groupId>
  <artifactId>flight_booking_system</artifactId>
  <version>1.0</version>

  <name>flight_booking_system</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
        <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.7.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>
 13  
src/main/java/prog2/exercise5/flight/booking/system/App.java
Comment on this file
@@ -0,0 +1,13 @@
package prog2.exercise5.flight.booking.system;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
 96  
src/test/java/prog2/exercise5/flight/booking/system/FlightBookingTest.java
Comment on this file
@@ -0,0 +1,96 @@
package prog2.exercise5.flight.booking.system;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;

import org.junit.Test;


public class FlightBookingTest 
{  
    @Test
    public void testing_Constructor_Accepting_Arrays(){
        int size = 3;
        FlightBooking fb = new FlightBooking(size);

        String [] fullName = {"Matt Jive", "Sally Fields", "Posh Quattro"};
        String [] gender = {"Male", "Female", "Other"};
        int [] age = {43, 32, 21};

        for(int i=0; i<size; ++i){
            fb.setPassengerFullName(i, fullName[i]);
            fb.setPassengerGender(i, gender[i]);
            fb.setPassengerAge(i, age[i]);
        }

        for(int j=0; j<size; ++j){
            if((fb.getPassengerFullName(j) == fullName[j]) && (fb.getPassengerGender(j) == gender[j]) 
            && fb.getPassengerAge(j) == age[j]){
                assertEquals(1, 1);
            }
            else {
                assertEquals(1, 2);
            }
        }   
    }

    @Test
    public void testing_Ticket_Reservation_Method(){
        int size = 3;
        FlightBooking fb = new FlightBooking(size);

        String [] fullName = {"Matt Jive", "Sally Fields", "Posh Quattro"};
        String [] gender = {"Male", "Female", "Other"};
        int [] age = {43, 32, 21};

        for(int i=0; i<size; ++i){
            fb.setPassengerFullName(i, fullName[i]);
            fb.setPassengerGender(i, gender[i]);
            fb.setPassengerAge(i, age[i]);
        }

        fb.setTripSource("1");
        fb.setSourceAirport("1");

        fb.setTripDestination("1", "3");
        fb.setDestinationAirport("1", "3");

        fb.setTripType("2");

        fb.setBookingClass("1");

        String sdepart = "2023-04-12";
        LocalDate departingOn = LocalDate.parse(sdepart);

        String returnD = "2023-05-12";
        LocalDate returningOn = LocalDate.parse(returnD);

        fb.setDepartureDate(departingOn);
        fb.setReturnDate(returningOn);

        fb.setDepartingTicketPrice(0, 3);

        fb.setReturnTicketPrice();

        fb.setTotalTicketPrice();

        for(int j=0; j<size; ++j){
            fb.setTicketNumber(j);
        }

        //Fixed the expectedTicketPrice test logic
        double expectedTicketPrice = 2* ((0*(300 + (0.15*300) + (0.1*300) + 250)) + (3*(300 + (0.15*300) + (0.1*300) + 250)));
        double returnedTicketPrice = fb.getTotalTicketPrice();


        for(int j=0; j<size; ++j){
            if((fb.getPassengerFullName(j) == fullName[j]) && (fb.getPassengerGender(j) == gender[j]) 
            && (fb.getPassengerAge(j) == age[j]) && (expectedTicketPrice == returnedTicketPrice)){
                assertEquals(1, 1);
            }
            else {
                assertEquals(1, 2);
            }
        } 
    }   
}
