public class CourseDetails {
    private String courseCode;
    private int courseUnit;
    private int courseScore;

    public CourseDetails(String courseCode, int courseUnit, int courseScore) {
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
        return GradingMethod.calculateGradeUnit(courseScore);}

}
