package activity;

import Exception.FestivalPlanningException;

public abstract class FestivalActivity {
    public String activityName;
    protected double estimatedCost;

    //constructor for giving name and cost required
    public FestivalActivity(String activityName, double estimatedCost) {
        this.activityName = activityName;
        this.estimatedCost = estimatedCost;
    }

    // Abstract method to be implemented by all subclasses
    public abstract void planActivity() throws FestivalPlanningException;

    // this Method will display activity details
    public void displayOverview() {
        System.out.println("Activity: " + activityName + ", Estimated Cost: " + estimatedCost);
    }
}
