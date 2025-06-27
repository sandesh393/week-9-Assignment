package Navigation;

import Validation.*;

public class GPSNavigationModule implements NavigationService {

    @Override
    public void navigate(String startPoint, String endPoint, RouteValidator validator)
            throws NavigationFailedException {

        System.out.println("navigating  from " + startPoint + " to " + endPoint + "...");

        if (startPoint.equalsIgnoreCase("Kalanki")) {
            throw new NavigationFailedException("GPS signal lost ");
        }

        try {
            double distance = simulatedDistance(startPoint, endPoint);
            if (validator.isValidCommuteRoute(startPoint, endPoint, distance)) {
                System.out.println("Navigation successful.");
            }
        } catch (InvalidRouteException | SameLocationException e) {
            throw new NavigationFailedException("Route validation failed!", e);
        }
    }

    private double simulatedDistance(String start, String end) {
        // including random route distance for check.
        return 5.0;
    }
}
