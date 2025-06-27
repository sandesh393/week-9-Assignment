package skillnepal;

public class CourseEnrollmentManager {

    public static void enrollStudent(String studentId, String courseId, EligibilityRule rule) {
        System.out.println("Attempting to enroll " + studentId + " in " + courseId + "...");

        try {
            if (rule.isEligible(studentId, courseId)) {
                System.out.println("Enrollment successful for " + studentId + " in " + courseId + " Happy learning");
            } else {
                System.out.println("Enrollment failed for " + studentId + ": Not eligible to enroll.");
            }
        } catch (EnrollmentDeniedException e) {
            System.out.println("Enrollment failed for " + studentId + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    EligibilityRule rule = (studentId, courseId) -> {
        if (studentId.equals("SKILL999")) {
            throw new EnrollmentDeniedException("Student account suspended due to outstanding fees");
        }
        if (courseId.equals("JAVA101")) {
            if (!studentId.startsWith("SKILL")) {
                throw new EnrollmentDeniedException("Invalid student ID format.");
            }
            return true;
        }
        return false;
    };

    // Array of test cases: {studentId, courseId}
    String[][] testCases = {
        {"SKILL123", "JAVA101"},
        {"SKILL999", "JAVA101"},
        {"STUDENT001", "JAVA101"},
        {"SKILL123", "PYTHON202"}
    };

    for (String[] testCase : testCases) {
        enrollStudent(testCase[0], testCase[1], rule);
    }
}

}
