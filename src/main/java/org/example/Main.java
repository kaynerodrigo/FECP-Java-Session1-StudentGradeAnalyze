package org.example;

import java.util.*;

public class Main{


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sumStudentScore = 0.0;
        double aveStudentScore;

        int scoreA = 0;
        int scoreB = 0;
        int scoreC = 0;
        int scoreD = 0;
        int scoreF = 0;

        String topStudentName = "";
        int studentScoreLargest = -1;

        // gets the number of students
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        if (numStudents < 0) {
            System.out.println("Invalid Entry!");
            return;
        }
        // consume newline
        scanner.nextLine();
        System.out.println();

        // create a list to store the person objects
        List<StudentRecord> studentList = new ArrayList<>();

        for (int i = 0; i < numStudents ; i++) {
            System.out.print("Enter name of student " + (i+1) + ": ");
            String studentName = scanner.nextLine();

            int studentScore;
            do {
                System.out.print("Enter score for " + studentName + ": ");
                studentScore = scanner.nextInt();
                if (studentScore < 0 || studentScore > 100) {
                    System.out.println("Invalid score. Please enter a value between 0 and 100.");
                }
            } while (studentScore < 0 || studentScore > 100);

            StudentRecord newStudent = new StudentRecord(studentName, studentScore);

            studentList.add(newStudent);
            System.out.println(studentName + " got grade: " + newStudent.getLetterGrade());

            scanner.nextLine();
            System.out.println();
        }

        System.out.println("\n---- Class Summary ----");

        for (StudentRecord student : studentList) {
            sumStudentScore += student.studentScore();
            char currentLetterGrade = student.getLetterGrade();

            if (currentLetterGrade == 'A') scoreA++;
            else if (currentLetterGrade == 'B') scoreB++;
            else if (currentLetterGrade == 'C') scoreC++;
            else if (currentLetterGrade == 'D') scoreD++;
            else scoreF++;

            if (student.studentScore() > studentScoreLargest) {
                studentScoreLargest = student.studentScore();
                topStudentName = student.studentName();
            }


            //System.out.println("Record " + student.getStudentName() + ", Score " + student.getStudentScore() + ", Grade: " + student.getLetterGrade());
        }

        aveStudentScore = sumStudentScore / numStudents;

        System.out.printf("Average Score: %.2f%n", aveStudentScore);
        System.out.printf("Grade Counts: A:%d B:%d C:%d D:%d F:%d",scoreA, scoreB, scoreC, scoreD, scoreF);
        System.out.println("\nTop Student(s): " + topStudentName + " (" + studentScoreLargest + ")" );



    }
}

record StudentRecord(String studentName, int studentScore) {

    public char getLetterGrade() {
        char letterGrade = 0;
        if (studentScore >= 90 && studentScore <= 100) letterGrade = 'A';
        else if (studentScore >= 80 && studentScore <= 89) letterGrade = 'B';
        else if (studentScore >= 70 && studentScore <= 79) letterGrade = 'C';
        else if (studentScore >= 60 && studentScore <= 69) letterGrade = 'D';
        else if (studentScore >= 0 && studentScore <= 50) letterGrade = 'F';
        else {
            System.out.println("Invalid entry.");
        }
        return letterGrade;
    }
}
