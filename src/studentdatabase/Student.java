/**
 * File: Student.java
 * Author: Matthew Towles
 * Date: 12/10/2018
 * Purpose: Defines a student's record
 */
package studentdatabase;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Defines a student record with name, major, credits completed, quality points
 * Does not contain student ID 
 * 
 * @author matthew.towles
 */
public class Student {
    
    // instance vars:
    private String name;
    private String major;
    // total of credits completed
    private int credits;
    // total of:  (numericGrade * credits) per course
    private double qualityPoints;
    
    /**
     * Constant to look up Grade numerical value
     * e.g.: GRADE_POINTS['A'] is 4.0
     */
    private static final Map<Character, Double> GRADE_POINTS = initGradePoints();

    /**
     * Constructor
     * 
     * @param name
     * @param major
     */
    public Student(String name, String major) {
        this.name = name;
        this.major = major;
        this.credits = 0;
        this.qualityPoints = 0.0;
    }
    
    /**
     * Updates credits and qualityPoints
     * Called by event listener when update is chosen
     * 
     * @param grade
     * @param credits
     */
    public void courseCompleted(char grade, int credits) {
       
        // add to total number of credits
        this.credits += credits;
       
        // look up letter grade numerical value
        double gradeVal = GRADE_POINTS.get(grade);
        
        // add to total quality points
        this.qualityPoints += (credits * gradeVal);
    }
    
    /**
     * Returns formatted string of student info
     * 
     * @return 
     */
    @Override
    public String toString() {
        String output = "\nName: " + this.name
                + "\nMajor: " + this.major
                + "\nGPA: " + this.getGPA();
        return output;
    }
    
    /**
     * Returns the student's GPA
     * GPA = qualityPoints / credits
     * 
     * @return
     */
    private double getGPA() {
        
        double gpa;
        
        // if no credits completed - default to 4.0
        if (this.credits == 0) {
            gpa = 4.0;
        } else {
            gpa = this.qualityPoints / this.credits;
        }        
        
        return gpa;
    }
    
    /**
     * Initialize the GRADE_POINTS constant
     * GRADE_POINTS used for grade numerical value 
     * 
     * @return gradePoints
     */
    private static Map<Character, Double> initGradePoints() {
        HashMap<Character, Double> gradePoints = new HashMap<>();
        
        gradePoints.put('A', 4.0);
        gradePoints.put('B', 3.0);
        gradePoints.put('C', 2.0);
        gradePoints.put('D', 1.0);
        gradePoints.put('F', 0.0);

        return Collections.unmodifiableMap(gradePoints);
    }
    
    /**
     * Returns a Set of the letter grades
     * @return
     */
    public static Set<Character> getGrades() {
        return GRADE_POINTS.keySet();
    }
    
    /**
     * Returns GRADE_POINTS Map
     * @return 
     */
    public static Map<Character, Double> getGradePoints() {
        return GRADE_POINTS;
    }
    
}