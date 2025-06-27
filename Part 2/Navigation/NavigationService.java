package Navigation;


//Navigation service interface

import Validation.RouteValidator;
import Validation.InvalidRouteException;
import Validation.SameLocationException;

public interface NavigationService {
    void navigate(String startPoint, String endPoint, RouteValidator validator)
        throws NavigationFailedException;
}
