import java.util.Scanner;

public class studentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Array to store subject names and marks
        String[] subjectNames = new String[numberOfSubjects];
        int[] subjectMarks = new int[numberOfSubjects];

        // Input: Take subject names and marks
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter the name of subject " + (i + 1) + ": ");
            scanner.nextLine(); // consume the newline character
            subjectNames[i] = scanner.nextLine();

            System.out.print("Enter marks for subject " + subjectNames[i] + ": ");
            subjectMarks[i] = scanner.nextInt();
        }

        // Calculate Total Marks
        int totalMarks = 0;
        for (int marks : subjectMarks) {
            totalMarks += marks;
        }

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Grade Calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results in a Table-like Structure
        System.out.println("--------------------------------------------------------------");
        System.out.println("\nResults:");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("| %-15s | %-10s |\n", "Subject", "Marks");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.printf("| %-15s | %-10d |\n", subjectNames[i], subjectMarks[i]);
            System.out.println("--------------------------------------------------------------");
        }

        System.out.printf("| %-15s | %-10d |\n", "Total Marks", totalMarks);
        System.out.printf("| %-15s | %-10.2f%% |\n", "Average Percentage", averagePercentage);
        System.out.printf("| %-15s | %-10s |\n", "Grade", grade);
        System.out.println("--------------------------------------------------------------");

        scanner.close();
    }
}
