package tourism;

import java.util.List;
import java.util.Arrays;

public class AirportArrivalsDataSource extends TouristDataSource {

    public AirportArrivalsDataSource() {
        super("Tribhuvan Airport Arrivals");
    }

    @Override
    public List<String> fetchData() throws DataSourceAccessException {
        try {
            if (sourceName.contains("Tribhuvan") && Math.random() < 0.3) {
                throw new ConnectionLostException("Airport data connection lost!");
            }
            return Arrays.asList( "Visitor: ravi teja , USA","Visitor: salman khan , UK","Visitor: Ram Shrestha, NP");
        } catch (ConnectionLostException e) {
            throw new DataSourceAccessException("Failed to identify  airport arrivals data", e);
        }
    }
}
