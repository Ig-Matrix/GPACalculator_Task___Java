import java.util.List;

public class GradingMethod {
    public static int calculateGradeUnit(int score) {
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

    public static String getGrade(int score) {
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

    public static double calculateCGPA(List<CourseDetails> courses) {
        double totalQualityPoints = 0;
        int totalGradeUnits = 0;

        for (CourseDetails course : courses) {
            int gradeUnit = calculateGradeUnit(course.getCourseScore());
            double qualityPoint = course.getCourseUnit() * gradeUnit;

            totalQualityPoints += qualityPoint;
            totalGradeUnits += course.getGradeUnit();
        }

        if (totalGradeUnits == 0) {
            return 0;
        }
        return totalQualityPoints / totalGradeUnits;
    }
}
