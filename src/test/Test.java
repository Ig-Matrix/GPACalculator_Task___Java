package test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("WELCOME TO IG'S GPA CALCULATOR");
        int numberOfCourses = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter the number of courses: ");
                numberOfCourses = input.nextInt();
                input.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine();
            }
        }

        List<Course> courses = new ArrayList<>();

        for (int i = 1; i <= numberOfCourses; i++) {
            System.out.println("Enter details for course " + i + " below");
            System.out.print("Enter course and code: ");
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
                    System.out.println("Invalid input. Please enter a valid number.");
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
                    System.out.println("Invalid input. Please enter a valid number.");
                    input.nextLine();
                }
            }

            Course course = new Course(courseCode, courseUnit, courseScore);
            courses.add(course);
        }

        System.out.println("|----------------------------|-----------------------|------------|---------------------|");
        System.out.println("| COURSE & CODE              | COURSE UNIT           | GRADE      | GRADE-UNIT          |");
        System.out.println("|----------------------------|-----------------------|------------|---------------------|");


        for (Course course : courses) {
            System.out.printf("| %-26s | %-21d | %-10s | %-19d |\n", course.getCourseCode(), course.getCourseUnit(), gradeUnit(course.courseScore), calcGradeUnit(course.courseScore));
            System.out.println("|---------------------------------------------------------------------------------------|\n");
        }
    }

    public static class Course {
        private String courseCode;
        private int courseUnit;
        private int courseScore;

        public Course(String courseCode, int courseUnit, int courseScore) {
            this.courseCode = courseCode;
            this.courseUnit = courseUnit;
            this.courseScore = courseScore;
        }

        public String getCourseCode() {
            return courseCode;
        }

        public int getCourseUnit() {
            return courseUnit;
        }

        public int getCourseScore() {
            return courseScore;
        }

        public int getGradeUnit() {
            return calcGradeUnit(courseScore);
        }

    }

    public static String gradeUnit(int score) {
        if (score >= 70) {
            return "A";
        } else if (score >= 60) {
            return "B";
        } else if (score >= 50) {
            return "C";
        } else if (score >= 45) {
            return "D";
        } else if (score >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    public static int calcGradeUnit(int score) {
        if (score >= 70) {
            return 5;
        } else if (score >= 60) {
            return 4;
        } else if (score >= 50) {
            return 3;
        } else if (score >= 45) {
            return 2;
        } else if (score >= 40) {
            return 1;
        } else {
            return 0;
        }
    }


}

