package Tika;

import activity.FestivalActivity;
import Exception.FestivalPlanningException;
import Exception.InvalidGuestCountException;
import Exception.BudgetExceededException;

public class TikaCeremony extends FestivalActivity {
    private int expectedGuests;
    private String mainFamilyElder;

    public TikaCeremony(double estimatedCost, int expectedGuests, String mainFamilyElder) {
        super("Tika Ceremony", estimatedCost);
        this.expectedGuests = expectedGuests;
        this.mainFamilyElder = mainFamilyElder;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {
        if (expectedGuests < 5) {
            throw new InvalidGuestCountException("Not enough guests for a lively Tika! Is everyone on vacation?");
        }
        if (estimatedCost > 50000) {
            throw new BudgetExceededException("Tika budget too high! Is this for the whole village?");
        }
        System.out.println("Tika ceremony with " + mainFamilyElder + " planned successfully for " + expectedGuests + " guests!");
    }

    //  main method for  testing
    public static void main(String[] args) {
        try {
            TikaCeremony validTika = new TikaCeremony(30000, 10, "Grandfather");
            validTika.planActivity();

            TikaCeremony lowGuests = new TikaCeremony(30000, 3, "Grandmother");
            lowGuests.planActivity();

        } catch (FestivalPlanningException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            TikaCeremony expensiveTika = new TikaCeremony(60000, 10, "Elder Uncle");
            expensiveTika.planActivity();
        } catch (FestivalPlanningException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
