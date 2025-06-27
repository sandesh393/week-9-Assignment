package tourism;

import java.util.List;

public class TourismReportGenerator {

    public static void generateOverallReport(List<TouristDataSource> dataSources, DataProcessor processor) {
        System.out.println("Generating overall tourism report...");

        for (TouristDataSource dataSource : dataSources) {
            List<String> rawData = null;

            try {
                rawData = dataSource.fetchData();
            } catch (DataSourceAccessException e) {
                System.err.println("Could not fetch data from " + dataSource.sourceName + ": " + e.getMessage() + ". Skipping this source.");
                if (e.getCause() != null) {
                    System.err.println("Reason: " + e.getCause().getMessage());
                }
                System.out.println("Data handling from " + dataSource.sourceName + " completed.\n");
                continue;
            }

            try {
                List<String> processed = processor.process(rawData);
                System.out.println("Processed data from " + dataSource.sourceName + ": " + processed);
            } catch (DataProcessingException e) {
                System.err.println("Error processing data from " + dataSource.sourceName + ": " + e.getMessage() + ". Skipping this data.");
            } finally {
                System.out.println("Data handling from " + dataSource.sourceName + " completed.\n");
            }
        }
    }

    public static void main(String[] args) {
        List<TouristDataSource> sources = List.of(
            new AirportArrivalsDataSource(),
            new HotelRegistrationsDataSource()
        );

        UniqueVisitorCounter processor = new UniqueVisitorCounter();

        generateOverallReport(sources, processor);
    }
}
