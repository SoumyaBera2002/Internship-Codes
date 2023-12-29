import java.util.Scanner;

public class studentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();


        String[] subjectNames = new String[numberOfSubjects];
        int[] subjectMarks = new int[numberOfSubjects];


        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter the name of subject " + (i + 1) + ": ");
            scanner.nextLine();
            subjectNames[i] = scanner.nextLine();

            System.out.print("Enter marks(should be between 0-100) for subject " + subjectNames[i] + ": ");
            subjectMarks[i] = scanner.nextInt();
        }


        int totalMarks = 0;
        for (int marks : subjectMarks) {
            totalMarks += marks;
        }


        double averagePercentage = (double) totalMarks / numberOfSubjects;


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
