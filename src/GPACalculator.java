import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GPACalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to IGHAWOSA'S GPA Calculator");

        int numberOfCourses = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter the number of courses: ");
                numberOfCourses = input.nextInt();
                input.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Kindly enter a valid number.");
                input.nextLine();
            }
        }


        List<CourseDetails> courses = new ArrayList<>();

        for (int i = 1; i <= numberOfCourses; i++) {
            System.out.println("Enter details for Course " + i + " below:");
            System.out.print("Enter Course & Code: ");
            String courseCode = input.nextLine();

            validInput = false;
            int courseUnit = 0;
            while (!validInput) {
                try {
                    System.out.print("Enter course unit: ");
                    courseUnit = input.nextInt();
                    input.nextLine();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Kindly enter a valid number for the course unit.");
                    input.nextLine();
                }

            }
            int courseScore = 0;
            validInput=false;
            while (!validInput) {
                try {
                    System.out.print("Enter course score: ");
                    courseScore = input.nextInt();
                    input.nextLine();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Kindly enter a valid number for the course score.");
                    input.nextLine();
                }
            }


            CourseDetails course = new CourseDetails(courseCode, courseUnit, courseScore);
            courses.add(course);
        }


        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");

        for (CourseDetails course : courses) {
            System.out.printf("| %-26s | %-21d | %-10s | %-19d |\n",
                    course.getCourseCode(), course.getCourseUnit(),
                    GradingMethod.getGrade(course.getCourseScore()), course.getGradeUnit());
        }

        double cgpa = GradingMethod.calculateCGPA(courses);
        System.out.print("|---------------------------------------------------------------------------------------|\n");
        System.out.printf("Your GPA is = %.2f to 2 decimal places.\n", cgpa);
    }
}
