import Validation.*;
import Navigation.*;

public class Main {

    public static void planMyCommute(String origin, String destination, RouteValidator validator, NavigationService navigator) {
        System.out.println("Planning your commute from " + origin + " to " + destination + "...");

        try {
            navigator.navigate(origin, destination, validator);
        } catch (NavigationFailedException e) {
            Throwable cause = e.getCause();

            if (cause instanceof SameLocationException) {
                System.out.println("Cannot plan: You entered the same place twice! (" + cause.getMessage() + ")");
            } else if (cause instanceof InvalidRouteException) {
                System.out.println("Cannot plan: Route error - " + cause.getMessage());
            } else {
                System.out.println("Cannot plan: GPS issue or unexpected failure - " + e.getMessage());
            }
        } finally {
            System.out.println("Commute planning for " + origin + " to " + destination + " completed.\n");
        }
    }

    public static void main(String[] args) {
        RouteValidator validator = new KathmanduTrafficValidator();
        NavigationService navigator = new GPSNavigationModule();

        //  Same origin and destination
        planMyCommute("Baneshwor", "Baneshwor", validator, navigator);

        // working  commute
        planMyCommute("Thamel", "Patan", validator, navigator);

        //  GPS failure simulation
        planMyCommute("Kalanki", "Balaju", validator, navigator);

    }
}
