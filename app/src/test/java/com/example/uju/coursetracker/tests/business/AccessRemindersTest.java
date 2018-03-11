package com.example.uju.coursetracker.tests.business;

import com.example.uju.coursetracker.application.DatabaseService;
import com.example.uju.coursetracker.business.AccessReminders;
import com.example.uju.coursetracker.objects.Reminder;
import com.example.uju.coursetracker.presentation.MainActivity;
import com.example.uju.coursetracker.tests.persistence.StubDatabase;
import junit.framework.TestCase;


public class AccessRemindersTest extends TestCase
{
    private static String dbName = MainActivity.dbName;

    public AccessRemindersTest(String arg0)
    {
        super(arg0);
    }

    public void test1()
    {
        AccessReminders ar;
        Reminder reminder;

        DatabaseService.closeDataAccess();

        System.out.println("\nStarting test AccessReminders");

        DatabaseService.createDataAccess(new StubDatabase(dbName));

        ar = new AccessReminders();

        reminder = ar.getSequentialReminders();

        assertEquals("SOCO 1200", reminder.getCourseID());
        assertEquals("Assignment", reminder.getReminderType());
        assertEquals("01/02/2018", reminder.getDueDate());

        // ... ADD MORE



        DatabaseService.closeDataAccess();
        System.out.println("Finished test AccessReminders");
    }
}
