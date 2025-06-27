package tourism;

import java.util.List;
import java.util.Arrays;

public class HotelRegistrationsDataSource extends TouristDataSource {

    public HotelRegistrationsDataSource() {
        super("Kathmandu Hotels Registrations");
    }

    @Override
    public List<String> fetchData() throws DataSourceAccessException {
        try {
            if (sourceName.contains("Hotels") && Math.random() < 0.2) {
                throw new AuthenticationFailedException("Hotel  authentication failed");
            }
            return Arrays.asList("Hotel: HARI guest house,Guest: Ram shrestha, NP",
            "Hotel: Annapurna, Guest: kiara advani, AU","Hotel: Everest View, Guest:sanju , US");
        } catch (AuthenticationFailedException e) {
            throw new DataSourceAccessException("Failed to acess hotel registration data", e);
        }
    }
}
