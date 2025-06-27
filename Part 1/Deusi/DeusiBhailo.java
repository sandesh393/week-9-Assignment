package Deusi;

import activity.FestivalActivity;               //importing the festivalactivity package
import Exception.FestivalPlanningException;     //importing  festival plaanning exception
import Exception.NoRouteException;              //importing no route exception

import java.util.List;

public class DeusiBhailo extends FestivalActivity {
    private List<String> plannedRoutes;       //we can input list of string only route should be in string
    private int numberOfPerformers;

    //constructor 
    public DeusiBhailo(double estimatedCost, List<String> plannedRoutes, int numberOfPerformers) {
        super("Deusi Bhailo Program", estimatedCost);             
        this.plannedRoutes = plannedRoutes;
        this.numberOfPerformers = numberOfPerformers;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {
        if (plannedRoutes == null || plannedRoutes.isEmpty()) {
            throw new NoRouteException("No routes planned for Deusi Bhailo");
        }
        if (numberOfPerformers < 3) {
            throw new FestivalPlanningException("Need at least 3 performers for a  Deusi Bhailo!");
        }

        System.out.println("Deusi Bhailo program with " + numberOfPerformers + " performers planned for " + plannedRoutes.size() + " routes!");
    }

    // for testing main 
    public static void main(String[] args) {
        try {
            DeusiBhailo event = new DeusiBhailo(20000, List.of("Ward 1", "Ward 2"), 2);  //it will be throwing message of nedded atleast 3 member
            event.planActivity();
        } catch (FestivalPlanningException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
