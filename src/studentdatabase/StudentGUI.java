/**
 * File: Student.java
 * Author: Matthew Towles
 * Date: 12/10/2018
 * Purpose: GUI and main for StudentGUI database
 */
package studentdatabase;

import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

/** 
 * This class handles the GUI and database interactions
 * 
 * @author matthew.towles
 */
public class StudentGUI extends javax.swing.JFrame {

    // the student "database"
    private HashMap<Integer, Student> studentDb = new HashMap<>();
    // ID field as an int
    private int id;
    // possible values for credits taken
    private static Integer[] CREDITS_OPTIONS = {3, 6};
    
    /**
     * Creates new form StudentGUI
     */
    public StudentGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        majorLabel = new javax.swing.JLabel();
        selectionLabel = new javax.swing.JLabel();
        selectionBox = new javax.swing.JComboBox<>();
        submitButton = new javax.swing.JButton();
        nameField = new javax.swing.JTextField();
        majorField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        idLabel.setText("Id:");

        nameLabel.setText("Name:");

        majorLabel.setText("Major:");

        selectionLabel.setText("Choose Selection:");

        selectionBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insert", "Delete", "Find", "Update" }));
        selectionBox.setRequestFocusEnabled(false);
        selectionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionBoxActionPerformed(evt);
            }
        });

        submitButton.setText("Process Request");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        idField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                idFieldFocusLost(evt);
            }
        });
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(selectionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(majorLabel)
                            .addComponent(nameLabel)
                            .addComponent(idLabel))
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField)
                            .addComponent(majorField)
                            .addComponent(idField))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(submitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLabel)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(majorLabel)
                    .addComponent(majorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectionLabel))
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionBoxActionPerformed
        
    }//GEN-LAST:event_selectionBoxActionPerformed

    /**
     * Submit Button Event Listener
     * @param evt 
     */
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // all operations require ID field 
        if (isValid(this.idField.getText())) { 
            this.processRequest();
        } else {
            // ID was not filled in
            JOptionPane.showMessageDialog(this, "ID is a required field.",
                    "ID Required!", ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void idFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFieldFocusLost
        this.updateId();
    }//GEN-LAST:event_idFieldFocusLost

    
    /**
     * Runs the request and routes to correct methods
     * Called by submit button event listener
     */
    private void processRequest() {

        // save selected operation submitted
        String operation = selectionBox.getSelectedItem().toString();

        // does key exist in student db?
        if (this.studentDb.containsKey(this.id)) {
            // ID must exist for delete, find, update ops
            switch(operation) {
                case "Delete":
                    this.delete();
                    break;
                case "Find":
                    this.find();
                    break;
                case "Update":
                    this.update();
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Invalid operation!", 
                            "Invalid Operation", ERROR_MESSAGE);
            }
        } 
        // no ID in database - are we inserting?
        else if (operation.equals("Insert")) {
            if (this.isInsertReady()) {
                this.insert();
            }
        } else { // no record, not inserting
            this.printNoRecord();
        }
        
    }
    
    
    /**
     * Inserts a new student record into studentDb
     * 
     * Key must not exist in studentDb
     * All fields must be completed
     */
    private void insert() {
        Student student = new Student(this.nameField.getText(), 
                this.majorField.getText());
        
        // key does not exist AND id is valid - add student
        if (this.id > 0) {
            studentDb.put(this.id, student);
        }
        
        // make sure student was added to the studentDb
        if (studentDb.containsKey(this.id)) {
            // confirmation with added student details
            JOptionPane.showMessageDialog(this, student.toString());
        } else {
            this.printNoRecord();
        }
    }
    
    
    /**
     * Deletes a record in the studentsDB
     */
    private void delete() {
        studentDb.remove(this.id);
        // if removed - let user know
        if (!studentDb.containsKey(this.id)) {
            JOptionPane.showMessageDialog(this, "Removed record for " + this.id);
        } else {
            // could not be removed
            JOptionPane.showMessageDialog(this, "Record could not be removed for " 
                    + this.id);
        }
    }
    
    /**
     * Shows a window with id, name, major, and GPA
     */
    private void find() {
        if (studentDb.containsKey(this.id)) {
            // create current student object when form submitted
            Student student = studentDb.get(this.id);
            JOptionPane.showMessageDialog(this, student.toString());
        } else {
            this.printNoRecord();
        }
    }
    
    /**
     * Update an existing student record with a course completed
     * 
     * Prompts for grade, credits taken for course
     */
    private void update() {
        if  (studentDb.containsKey(this.id)) {
            // array of possible grades
            Character grade = this.promptGrade();
            
            // once user has selected a grade
            if (grade != null) {
                // prompt user for credits grade is worth
                try {
                    int credits = this.promptCredits();
                    Student student = studentDb.get(this.id);
                    student.courseCompleted(grade, credits);
                    JOptionPane.showMessageDialog(this, student.toString(), 
                            "Updated Successful!", PLAIN_MESSAGE);
                } catch (NullPointerException e) {
                    // error if user closes credits prompt 
                    JOptionPane.showMessageDialog(this, "Credits must be chosen.",
                            "Credits Not Chosen", ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Grade must be chosen.",
                        "No Grade Chosen", ERROR_MESSAGE);
            }
        } else {
            this.printNoRecord();
        }
    }
    
    /**
     * Prompts user for grade when updating student record
     * 
     * @return Character grade
     */
    private Character promptGrade() {
        // array of possible grades
        Character[] gradeOptions = getGradeOptions();
        
        // prompt user for grade and save it:
        Character grade = (Character) JOptionPane.showInputDialog(
                this, "Select letter grade: ", "Choose Grade", QUESTION_MESSAGE,
                null, gradeOptions, gradeOptions[0]
        );
        
        return grade;
    }
    
    
    /**
     * Prompts user for credits of class when updating student record
     * 
     * @return integer credits
     */
    private int promptCredits() {
        // prompt user for credits taken for class
        int credits = (int) JOptionPane.showInputDialog(
                this, "Select number of credits for course: ",
                "Choose Credits", QUESTION_MESSAGE,
                null, CREDITS_OPTIONS, CREDITS_OPTIONS[0]
        ); 
        
        return credits;
    }
    
    
    /**
     * Returns Array of possible grades
     * Possible grades are the keys set in Student.GRADE_POINTS
     * 
     * @return Character[] gradeOptions
     */
    private static Character[] getGradeOptions() {
        // get list of the grades in a combo box
        Set<Character> grades = Student.getGrades();
        
        // array of grades
        Character[] gradeOptions = new Character[grades.size()];
        
        // convert set to array
        gradeOptions = grades.toArray(gradeOptions);
        
        return gradeOptions;
    }

    
    /**
     * Update this.id with the value user entered
     * 
     * @throws NumberFormatException
     */
    private void updateId() {
        try {
            if (isValid(this.idField.getText())) {
                int id = Integer.parseInt(this.idField.getText());
                if (id > 0) {
                    this.id = id;
                } else {
                    throw new NumberFormatException();
                }
            } else {
                throw new NumberFormatException();
            }
        } catch(NumberFormatException e) {
            // reset ID field text
            this.idField.setText(null);
            JOptionPane.showMessageDialog(this, "ID must be an integer.", 
                    "Input Mismatch", ERROR_MESSAGE);
        }
    }
    
    
    /**
     * Return true if string is alphanumeric
     * 
     * @param test
     * @return 
     */
    private static boolean isValid(String test) {
        return test != null && !test.trim().isEmpty() && test.length() > 0;
    }
    
    
    /**
     * Called by methods if no record found in lookup for ID
     */
    private void printNoRecord() {
        JOptionPane.showMessageDialog(this, "No record found for ID " 
                    + this.id, "No Record Found", ERROR_MESSAGE);
    }
    
    
    /**
     * Return true if we can perform insert operation
     * ID must not exist in studentDb
     * + name field must be filled in
     * + major field must be filled in
     * 
     * @return boolean
     */
    private boolean isInsertReady() {
        if (!studentDb.containsKey(this.id)) {
            if (isValid(this.nameField.getText())) {
                if (isValid(this.majorField.getText())) {
                    return true;
                    // major field not filled
                } else {
                    JOptionPane.showMessageDialog(this, "Must have record for "
                            + "major", "Empty Fields", ERROR_MESSAGE);
                }
                // name field not filled
            } else {
                JOptionPane.showMessageDialog(this, "Must have record for name",
                        "Empty Fields", ERROR_MESSAGE);
            }
            // ID exists in studentDb:
        } else {
            JOptionPane.showMessageDialog(this, "ID already exists in database.",
                    "Duplicate Record", ERROR_MESSAGE);
        }
        return false;
    }
    
    
    /**
     * Main
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField majorField;
    private javax.swing.JLabel majorLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JComboBox<String> selectionBox;
    private javax.swing.JLabel selectionLabel;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}