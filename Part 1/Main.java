import activity.FestivalActivity;
import Deusi.DeusiBhailo;
import Planner.DashainFestivalPlanner;
import Tika.TikaCeremony;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create activities
        FestivalActivity tikaCeremony = new TikaCeremony(30000, 10, "Grandfather");
        FestivalActivity deusiEvent = new DeusiBhailo(20000, List.of("Ward 5", "Ward 6", "Ward 7"), 5);

        // Add to a list
        List<FestivalActivity> festivalPlan = Arrays.asList(tikaCeremony, deusiEvent);

        // Execute plan
        DashainFestivalPlanner.executeFestivalPlan(festivalPlan);
    }
}
