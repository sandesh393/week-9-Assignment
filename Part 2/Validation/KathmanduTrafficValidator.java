package Validation;

public class KathmanduTrafficValidator implements RouteValidator {

    @Override
    public boolean isValidCommuteRoute(String origin, String destination, double distanceKm)
            throws InvalidRouteException, SameLocationException {

        if (origin.equalsIgnoreCase(destination)) {
            throw new SameLocationException("Origin and destination cannot be the same");
        }

        if (distanceKm < 0.1 || distanceKm > 30.0) {
            throw new InvalidRouteException("Distance " + distanceKm + "km  is not valid for route");
        }

        return true;
    }
}
