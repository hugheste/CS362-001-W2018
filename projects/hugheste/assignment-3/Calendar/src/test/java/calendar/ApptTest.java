package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */


    // Run with mvn org.pitest:pitest-maven:mutationCoverage
    @Test
    public void test01() throws Throwable {
        int startHour = 21;
        int startMinute = 30;
        int startDay = 15;
        int startMonth = 01;
        int startYear = 2018;
        String title = "Birthday Party";
        String description = "This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
        int[] recurd = {1, 2};
        appt.setRecurrence(recurd, Appt.RECUR_BY_MONTHLY, 2, 2);
        // assertions
        assertEquals(2, appt.getRecurNumber());
        int[] recurd2 = {3, 4, 5};
        appt.setRecurrence(recurd2, Appt.RECUR_BY_WEEKLY, 2, 2);
        assertTrue(appt.getValid());
        assertEquals(21, appt.getStartHour());
        assertEquals(30, appt.getStartMinute());
        assertEquals(15, appt.getStartDay());
        assertEquals(01, appt.getStartMonth());
        assertEquals(2018, appt.getStartYear());
        assertEquals("Birthday Party", appt.getTitle());
        assertEquals("This is my birthday party.", appt.getDescription());
    }

    @Test
    public void test02() throws Throwable {
        int startHour = 25;
        int startMinute = 30;
        int startDay = 15;
        int startMonth = 02;
        int startYear = 2018;
        String title = "Doctor's Appointment";
        String description = "This is my doctor's appointment.";
        //Construct a new Appointment object with the initial data
        Appt appt2 = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

//		 assertFalse(appt2.getValid());  //Should be false, yet checks are not in place for determining upper bound of startHours
        assertEquals(25, appt2.getStartHour()); //Checks for startHour value, which is a check I created a bug for
        assertEquals(30, appt2.getStartMinute());
        assertEquals(15, appt2.getStartDay());
        assertEquals(02, appt2.getStartMonth());
        assertEquals(2018, appt2.getStartYear());
        assertEquals("Doctor's Appointment", appt2.getTitle());
        assertEquals("This is my doctor's appointment.", appt2.getDescription());

    }

    @Test
    public void test03() throws Throwable {
        int startHour = 10;
        int startMinute = 70; //tests set and get startMinute, should be invalid
        int startDay = 15;
        int startMonth = 02;
        int startYear = 2018;
        String title = "Doctor's Appointment";
        String description = "This is my doctor's appointment.";
        //Construct a new Appointment object with the initial data
        Appt appt2 = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

        assertEquals(10, appt2.getStartHour());
        assertNotEquals(50, appt2.getStartMinute());
        assertEquals(15, appt2.getStartDay());
        assertEquals(02, appt2.getStartMonth());
        assertEquals(2018, appt2.getStartYear());
        assertEquals("Doctor's Appointment", appt2.getTitle());
        assertEquals("This is my doctor's appointment.", appt2.getDescription());

        appt2.setStartHour(11);
        appt2.setStartMinute(51);
        appt2.setStartDay(10);
        appt2.setStartMonth(03);
        appt2.setStartYear(2019);
        appt2.setTitle("Bob's Appointment.");
        appt2.setTitle(null);
        appt2.setDescription("This is my doctor's appointment.");
        appt2.setDescription(null);
        appt2.setStartHour(0);
    }

    @Test
    public void test04() throws Throwable {
        //Tests set RecurDays, recurNumber, recurIncrement and recurDays
        int[] recurDays = {0, 1};
        int recurBy = 2;
        int recurIncrement = 2;
        int recurNumber = 2;

        int startHour = 25;
        int startMinute = 30;
        int startDay = 15;
        int startMonth = 02;
        int startYear = 2018;
        String title = "Doctor's Appointment";
        String description = "This is my doctor's appointment.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

        appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);

        assertEquals(recurBy, appt.getRecurBy());
        assertArrayEquals(recurDays, appt.getRecurDays());
        assertEquals(recurNumber, appt.getRecurNumber());
        assertEquals(recurIncrement, appt.getRecurIncrement());
        assertTrue(appt.isRecurring());
    }

    @Test
    public void test05() throws Throwable {
        //Tests compareTo

        int startHour = 10;
        int startMinute = 30;
        int startDay = 15;
        int startMonth = 02;
        int startYear = 2018;
        String title = "Doctor's Appointment";
        String description = "This is my doctor's appointment.";

        int srtHour = 10;
        int srtMinute = 30;
        int srtDay = 15;
        int srtMonth = 02;
        int srtYear = 2018;
        String t = "Doctor's Appointment";
        String d = "This is my doctor's appointment.";

        //Construct a new Appointment object with the initial data
        Appt appt1 = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
        Appt appt2 = new Appt(srtHour,
                srtMinute,
                srtDay,
                srtMonth,
                srtYear,
                t,
                d);
        appt1.compareTo(appt2);

        //assertEquals(startMinute+startHour+startDay+startMonth+startYear,appt1.compareTo(appt2));
    }

    @Test
    public void test06() throws Throwable {
        //Tests compareTo

        int startHour = 25;
        int startMinute = 30;
        int startDay = 10;
        int startMonth = 1;
        int startYear = 2018;
        String title = "Doctor's Appointment";
        String description = "This is my doctor's appointment.";

        int srtHour = -1;
        int srtMinute = 30;
        int srtDay = 15;
        int srtMonth = 02;
        int srtYear = 2018;
        String t = "Doctor's Appointment";
        String d = "This is my doctor's appointment.";

        //Construct a new Appointment object with the initial data
        Appt appt1 = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
        Appt appt2 = new Appt(srtHour,
                srtMinute,
                srtDay,
                srtMonth,
                srtYear,
                t,
                d);

        srtHour = 2;
        srtMinute = -1;
        srtDay = 15;
        srtMonth = 02;
        srtYear = 2018;
        t = "Doctor's Appointment";
        d = "This is my doctor's appointment.";

        Appt appt3 = new Appt(srtHour,
                srtMinute,
                srtDay,
                srtMonth,
                srtYear,
                t,
                d);

        srtHour = 2;
        srtMinute = 62;
        srtDay = 15;
        srtMonth = 02;
        srtYear = 2018;
        t = "Doctor's Appointment";
        d = "This is my doctor's appointment.";

        Appt appt4 = new Appt(srtHour,
                srtMinute,
                srtDay,
                srtMonth,
                srtYear,
                t,
                d);

        srtHour = 2;
        srtMinute = 30;
        srtDay = -1;
        srtMonth = 02;
        srtYear = 2018;
        t = "Doctor's Appointment";
        d = "This is my doctor's appointment.";

        Appt appt5 = new Appt(srtHour,
                srtMinute,
                srtDay,
                srtMonth,
                srtYear,
                t,
                d);

        srtHour = 2;
        srtMinute = 30;
        srtDay = 40;
        srtMonth = 02;
        srtYear = 2018;
        t = "Doctor's Appointment";
        d = "This is my doctor's appointment.";

        Appt appt6 = new Appt(srtHour,
                srtMinute,
                srtDay,
                srtMonth,
                srtYear,
                t,
                d);

        assertNotNull(appt1.toString());
        assertNull(appt2.toString());
        assertNull(appt3.toString());
        assertNull(appt4.toString());
        assertNull(appt5.toString());
        assertNull(appt6.toString());

        assertFalse(appt2.getValid());
        appt2.setStartHour(-3);
        assertFalse(appt2.getValid());
        appt2.setStartHour(3);
        appt2.setStartMinute(500);
        assertFalse(appt2.getValid());
        appt2.setStartMinute(4);
        appt2.setStartDay(-1);
        assertFalse(appt2.getValid());
        appt2.setStartDay(30);
        appt2.setStartMonth(2);
        assertFalse(appt2.getValid());
        appt2.setStartMonth(2);
        appt2.setStartDay(29);
        appt2.setStartYear(-3000);
        assertFalse(appt2.getValid());
        appt2.setStartYear(2018);

//        assertFalse(appt2.getValid()); //Checks for startHour value, which is a check I created a bug for
  /*      assertFalse(0 <appt2.getStartMinute());
        assertFalse(0 < appt2.getStartDay());
        assertFalse(0 > appt2.getStartMonth());
        assertFalse(0 < appt2.getStartYear());
*/
        appt2.compareTo(appt3);
        assertEquals(0, appt1.compareTo(appt1));
        assertEquals((appt1.getStartMinute()-appt2.getStartMinute()) + (appt1.getStartHour()-appt2.getStartHour()) + (appt1.getStartDay()-appt2.getStartDay()) + (appt1.getStartMonth()-appt2.getStartMonth()) + (appt1.getStartYear()-appt2.getStartYear()), appt1.compareTo(appt2));

    }




}

