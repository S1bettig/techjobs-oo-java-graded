package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    private Job Red, Blue, Green, Yellow, Orange;

    @Test
    public void createJobs(){

        Employer testEmployer = new Employer("Acme");
        Location testLocation = new Location("Desert");
        PositionType testPositionType = new PositionType("Quality control");
        CoreCompetency testCoreCompetency = new CoreCompetency("Persistence");

        Red = new Job();
        Blue = new Job();
        Green = new Job("Product tester", testEmployer, testLocation, testPositionType, testCoreCompetency);
//        Yellow = new Job();
        Orange = new Job();
    }

    @Test
    public void testJobId(){
        Red = new Job();
        Blue = new Job();

        assertNotEquals(Red.getId(), Blue.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        Employer testEmployer = new Employer("Acme");
        Location testLocation = new Location("Desert");
        PositionType testPositionType = new PositionType("Quality control");
        CoreCompetency testCoreCompetency = new CoreCompetency("Persistence");

        Green = new Job("Product tester", testEmployer, testLocation, testPositionType, testCoreCompetency);

        assertEquals(Green.getName(), "Product tester");
        assertEquals(Green.getEmployer().toString(), "Acme");
        assertEquals(Green.getLocation().toString(), "Desert");
        assertEquals(Green.getPositionType().toString(), "Quality control");
        assertEquals(Green.getCoreCompetency().toString(),"Persistence");
    }

    @Test
    public  void testConstructorSetsCorrect(){

        Employer testEmployer2 = new Employer("Acme");
        Location testLocation2 = new Location("Desert");
        PositionType testPositionType2 = new PositionType("Quality control");
        CoreCompetency testCoreCompetency2 = new CoreCompetency("Persistence");

        Yellow = new Job("Product tester", testEmployer2, testLocation2, testPositionType2, testCoreCompetency2);
        assertTrue(Yellow.getEmployer() instanceof Employer);
        assertTrue(Yellow.getLocation() instanceof Location);
        assertTrue(Yellow.getPositionType() instanceof PositionType);
        assertTrue(Yellow.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testToString() {
        Employer testEmployer2 = new Employer("Acme");
        Location testLocation2 = new Location("Desert");
        PositionType testPositionType2 = new PositionType("Quality control");
        CoreCompetency testCoreCompetency2 = new CoreCompetency("Persistence");

        Yellow = new Job("Product tester", testEmployer2, testLocation2, testPositionType2, testCoreCompetency2);


        String output =
                "\nID: " + Yellow.getId() +
                "\nName: " + Yellow.getName() +
                "\nEmployer: " + Yellow.getEmployer() +
                "\nLocation: " + Yellow.getLocation() +
                "\nPosition Type: " + Yellow.getPositionType() +
                "\nCore Competency: " + Yellow.getCoreCompetency() +
                "\n"
                ;

        assertEquals(output, Yellow.toString());

    }
    @Test
    public void testToStringHandlesEmptyFieldWithDataNotAvailableResponse() {
        Employer testEmployer = new Employer("Cisco");
        Location testLocation = new Location("Bolingbrook");
        PositionType testPositionType = new PositionType("Analyst");
        CoreCompetency testCoreCompetency = new CoreCompetency("Intelligence");

        Orange = new Job("CyberAnalyst", testEmployer, testLocation, testPositionType, testCoreCompetency);

        Orange.getEmployer().setValue("");
        Orange.getCoreCompetency().setValue("");
        String output =
                "\nID: " + Orange.getId() +
                "\nName: " + Orange.getName() +
                "\nEmployer: Data is not available" +
                "\nLocation: " + Orange.getLocation() +
                "\nPosition Type: " + Orange.getPositionType() +
                "\nCore Competency: Data is not available" +
                "\n"
                ;

        assertEquals(output, Orange.toString());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Employer testEmployer = new Employer("Cisco");
        Location testLocation = new Location("Bolingbrook");
        PositionType testPositionType = new PositionType("Analyst");
        CoreCompetency testCoreCompetency = new CoreCompetency("Intelligence");

        Orange = new Job("CyberAnalyst", testEmployer, testLocation, testPositionType, testCoreCompetency);

        char line1 = Orange.toString().charAt(0);
        char lastLine = Orange.toString().charAt(Orange.toString().length() - 1);
//        Orange.toString().charAt(Orange.toString().length() - 1)

        assertEquals(line1, lastLine);
    }








}
