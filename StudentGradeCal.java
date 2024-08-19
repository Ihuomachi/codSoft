import java.util.Scanner;

public class StudentGradeCal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        int counter = 0;
        int totalMarks = 0;

        while (counter < numSubjects) {
            totalMarks += question();
            counter++;
        }
        scanner.close();
        // Calculating average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Average grade percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Results
        System.out.println("\nResults:");
        System.out.println("Total Marks:        " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade:              " + grade);
    }

    // subject scores question
    public static int question() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks for subject :");
        String markss = sc.nextLine();
        return Integer.parseInt(markss);

    }

}
