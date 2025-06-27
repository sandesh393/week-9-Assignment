package Planner;

import activity.FestivalActivity;
import Exception.InvalidGuestCountException;
import Exception.BudgetExceededException;
import Exception.NoRouteException;
import Tika.TikaCeremony;
import Exception.FestivalPlanningException;

import java.util.ArrayList;
import java.util.List;

import Deusi.DeusiBhailo;

public class DashainFestivalPlanner {
    public static void executeFestivalPlan(List<FestivalActivity> activities) {
        for (FestivalActivity activity : activities) {
            activity.displayOverview();
            try {
                activity.planActivity();
            } catch (InvalidGuestCountException e) {
                System.out.println("Planning Warning (Guests): " + e.getMessage());
            } catch (BudgetExceededException e) {
                System.out.println("Planning Warning (Budget): " + e.getMessage());
            } catch (NoRouteException e) {
                System.out.println("Planning Warning (Routes): " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("General Planning Error: " + e.getMessage());
            } finally {
                System.out.println("Activity planning attempt for " + activity.activityName + " completed.\n");
            }
        }
    }

    // main method for testing
    public static void main(String[] args) {
        List<FestivalActivity> activities = new ArrayList<>();

        //without eception
        activities.add(new DeusiBhailo(20000, List.of("Ward 1", "Ward 2"), 5));

        // without routes so it will show the no route exception 
        activities.add(new DeusiBhailo(15000, List.of(), 4));

        // DeusiBhailo with FestivalPlanningException
        activities.add(new DeusiBhailo(10000, List.of("Ward 1"), 2));

        // without exception TikaCeremony
        activities.add(new TikaCeremony(30000, 10, "Grandfather"));

        // TikaCeremony with InvalidGuestCountException
        activities.add(new TikaCeremony(25000, 3, "Grandmother"));

        // TikaCeremony with  BudgetExceededException
        activities.add(new TikaCeremony(60000, 15, "Elder Uncle"));

        executeFestivalPlan(activities);
    }
}

