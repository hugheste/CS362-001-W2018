package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
         boolean diagnose = true;

         /** Collection of all of the appointments for the calendar day */
         LinkedList<Appt> listAppts = new LinkedList<Appt>();
         System.out.println("Calendar Main: \n" );


         /** the month the user is currently viewing **/
         int thisMonth;

         /** the year the user is currently viewing **/
         int thisYear;

         /** todays date **/
         int thisDay;

         //get todays date
         Calendar rightnow = Calendar.getInstance();
         //current month/year/date is today
         thisMonth = rightnow.get(Calendar.MONTH)+1;
         thisYear = rightnow.get(Calendar.YEAR);
         thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

         int startHour=15;
         int startMinute=30;
         int startDay=thisDay+1;
         int startMonth=thisMonth;
         int startYear=thisYear;
         String title="Birthday Party";
         String description="This is my birthday party.";
         //Construct a new Appointment object with the initial data
         Appt appt = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                 description);
         if(diagnose){
             System.out.println(appt.toString());
         }

         listAppts.add(appt);

         startHour=15;
         startMinute=30;
         startDay=thisDay;
         startMonth=thisMonth;
         startYear=thisYear;
         title="Dentist Appointment";
         description="This is my dentist appointment.";
         //Construct a new Appointment object with the initial data
         Appt appt2 = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                 description);
         listAppts.add(appt2);
         assertTrue(appt2.getValid());

         if(diagnose){
             System.out.println(appt.toString());
         }

         startHour=15;
         startMinute=70;
         startDay=thisDay;
         startMonth=thisMonth;
         startYear=thisYear;
         title="Dentist Appointment";
         description="This is my dentist appointment.";
         //Construct a new Appointment object with the initial data
         Appt appt3 = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                 description);

         assertFalse(appt3.getValid());
         listAppts.add(appt3);
        assertNotEquals(appt3,listAppts.get(1));

        assertTrue(appt.getValid());
        assertTrue(appt2.getValid());
        assertFalse(appt3.getValid());
        int [] recurs = {1,2,3};
        appt.setRecurrence(recurs,2,2,3);
        assertEquals(2,appt.getRecurIncrement());
        title = "Birthday Party";
        //assertEquals(appt,appt.toString());
        assertNotEquals(appt2.toString(),appt.toString());

         GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
         GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
         tomorrow.add(Calendar.DAY_OF_MONTH,1);
         String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
         String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);



         if(diagnose){
             System.out.println("today is:" + todatDate);
             System.out.println("tomorrow is:" + tomorrowDate);
         }

         TimeTable timeTable=new TimeTable();
         //Create a linked list of calendar days to return
         LinkedList<CalDay> calDays = new LinkedList<CalDay>();

         if (diagnose) {
             System.out.println("The number of appointments between "+ todatDate +" and " + tomorrowDate);
             //calDays = new LinkedList<CalDay>();
             calDays = timeTable.getApptRange(listAppts, today, tomorrow);
             for (int i = 0; i < calDays.size(); i++)
                 System.out.println(calDays.get(i).toString());
         }
         today.set(2018,Calendar.MARCH,12);
         assertEquals(2018,calDays.get(0).getYear());
         assertEquals(2,calDays.get(0).getMonth());
         assertEquals(12,calDays.get(0).getDay());

         assertEquals(1,calDays.get(0).getSizeAppts());
         calDays.get(0).getAppts().getFirst().setStartDay(40);
        assertNotNull(calDays.get(0).getAppts().getFirst());
        assertTrue(calDays.getFirst().isValid());


         startHour=15;
         startMinute=70;
         startDay=thisDay;
         startMonth=thisMonth;
         startYear=thisYear;
         title="Dentist Appointment";
         description="This is my dentist appointment.";
         //Construct a new Appointment object with the initial data
         Appt appt4 = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                 description);
       // assertno(calDays.get(0).addAppt(appt4));

         CalDay c = calDays.get(0);
         c.addAppt(appt4);
         appt.setDescription(null);
         c.addAppt(appt);
//         assertFalse(c.isValid());

         //assertFalse(c.isValid());
         assertNotNull(c.toString());
        CalDay b = null;

        assertNull(b);
         calDays.getFirst().getAppts().removeLast();
        b = calDays.get(0);

        b.addAppt(appt4);
        listAppts.add(appt4);
         assertFalse(b.getAppts().getFirst().isRecurring());
//        assertNull(listAppts.iterator());
         LinkedList<Appt> someArr = new LinkedList<Appt>();
       someArr.add(null);
        assertFalse(b.getAppts().getFirst().isRecurring());
        assertNotEquals(appt4,b.getAppts().getFirst());
         LinkedList<CalDay> someDays = new LinkedList<CalDay>();
        someDays = timeTable.getApptRange(listAppts,today,tomorrow);
        assertNotNull(calDays.listIterator());
        assertNull(appt4.toString());
        assertNotNull(appt.toString());
         assertNotNull(someDays.toString());

        //.,someDays.listIterator());
//        b.addAppt(appt);


//        assertNull(b.toString());

         /*my changes
         TimeTable timeTable=new TimeTable();
         //Create a linked list of calendar days to return
         LinkedList<CalDay> calDays = new LinkedList<CalDay>();
         if (diagnose) {
             System.out.println("The number of appointments between "+ todatDate +" and " + tomorrowDate);
             calDays = new LinkedList<CalDay>();
             calDays = timeTable.getApptRange(listAppts, today, tomorrow);
             for (int i = 0; i < calDays.size(); i++)
                 System.out.println(calDays.get(i).toString());
         }
*/
      //  assertEquals(appt2,calDays.get(0).getAppts());
     //   assertEquals(null,calDays.get(0).iterator());
      //  assertFalse(calDays.get(3).isValid());


         //listAppts.get(0);
         //assertEquals(null,calday.iterator());



     }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed	
}
