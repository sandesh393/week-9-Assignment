package skillnepal;

@FunctionalInterface
public interface EligibilityRule {
    boolean isEligible(String studentId, String courseId) throws EnrollmentDeniedException;
}
