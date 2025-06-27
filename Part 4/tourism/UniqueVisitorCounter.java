package tourism;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class UniqueVisitorCounter implements DataProcessor {

    @Override
    public List<String> process(List<String> rawData) throws DataProcessingException {
        if (rawData == null || rawData.isEmpty()) {
            throw new EmptyDataException("No  data to process");
        }

        Set<String> uniqueVisitors = new HashSet<>();

        for (String entry : rawData) {
            String name = extractName(entry);
            if (name != null && !name.isEmpty()) {
                uniqueVisitors.add(name.trim());
            }
        }

        List<String> result = new ArrayList<>();
        result.add("Unique Visitors: " + uniqueVisitors.size());
        return result;
    }

    private String extractName(String data) {
        String lower = data.toLowerCase();

        if (lower.contains("visitor:")) {
            int start = lower.indexOf("visitor:") + "visitor:".length();
            int end = data.indexOf(",", start);
            if (end == -1) end = data.length();
            return data.substring(start, end).trim();
        } else if (lower.contains("guest:")) {
            int start = lower.indexOf("guest:") + "guest:".length();
            int end = data.indexOf(",", start);
            if (end == -1) end = data.length();
            return data.substring(start, end).trim();
        }
        return null;
    }
}
