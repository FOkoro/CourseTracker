package com.example.uju.coursetracker.business;


import com.example.uju.coursetracker.objects.Course;

import java.util.ArrayList;

public class CalculateCurrentCGPA
{
    //This is where we will calculate the current CGPA based on the already completed courses of the user
    public static double calculate(ArrayList<Course> completedCoursesList)
    {
        String temp = "";
        double totalPoints = 0.0;
        double currCGPA;
        boolean flag = false;

        if(completedCoursesList != null && completedCoursesList.size() > 0 && completedCoursesList.get(0) != null)
        {
            for (int i = 0; i < completedCoursesList.size(); i++)
            {
                temp = (completedCoursesList.get(i)).getGrade();

                if (temp.equals("A+"))
                {
                    totalPoints += 4.5;
                }
                else if (temp.equals("A"))
                {
                    totalPoints += 4.0;
                }
                else if (temp.equals("B+"))
                {
                    totalPoints += 3.5;
                }
                else if (temp.equals("B"))
                {
                    totalPoints += 3.0;
                }
                else if (temp.equals("C+"))
                {
                    totalPoints += 2.5;
                }
                else if (temp.equals("C"))
                {
                    totalPoints += 2.0;
                }
                else if (temp.equals("D"))
                {
                    totalPoints += 1.0;
                }
                else if (temp.equals("F"))
                {
                    totalPoints += 0.0;
                }
                else
                {
                    flag = true;
                }

            }//for
        }
        else
        {
            flag = true;
        }


        if(!flag)
        {
            currCGPA = totalPoints / (completedCoursesList.size());
            currCGPA  = Math.round(currCGPA*100.0)/100.0;
        }
        else
        {
            currCGPA = -1.0;
        }

        return currCGPA;

    }
}
