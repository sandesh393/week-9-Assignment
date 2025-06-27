package skillnepal;

public class StudentDashboard {

    public void displayCourseStatus(String studentId, String courseId, EligibilityRule rule) {
        System.out.println("Checking enrollment status for " + studentId + " in " + courseId + "...");

        try {
            if (rule.isEligible(studentId, courseId)) {
                System.out.println(" You are enrolled.");
            } else {
                System.out.println(" You are not enrolled in this course.");
            }
        } catch (EnrollmentDeniedException e) {
            System.out.println(" Enrollment unsucceded: " + e.getMessage() + ". Please contact support.");
        } finally {
            System.out.println("Status check completed for " + studentId + ".");
        }
    }

    public static void main(String[] args) {
        EligibilityRule rule = (studentId, courseId) -> {
            if (studentId.equals("SKILL999")) {
                throw new EnrollmentDeniedException("Student account suspended due to outstanding fees.");
            }

            if (courseId.equals("JAVA101")) {
                if (!studentId.startsWith("SKILL")) {
                    throw new EnrollmentDeniedException("Invalid student ID format. Please use 'SKILL'");
                }
                return true;
            }

            return false;
        };

        StudentDashboard dashboard = new StudentDashboard();

        // Test cases
        dashboard.displayCourseStatus("SKILL123", "JAVA101", rule);     // Valid
        dashboard.displayCourseStatus("SKILL999", "PYTHON202", rule);   // Suspended student
        dashboard.displayCourseStatus("STUDENT001", "JAVA101", rule);   // Invalid ID format
    }
}
