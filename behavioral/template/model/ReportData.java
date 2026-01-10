package template.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Simple input model for the report exporters.
 * Returns a few sample headers/rows so the demo can run without a database.
 */
public class ReportData {
    public List<String> getHeaders() {
        // Column names
        return Arrays.asList("ID", "Name", "Value");
    }

    public List<Map<String, Object>> getRows() {
        // Each map represents a row: column name -> value
        return Arrays.asList(
                Map.of("ID", 1, "Name", "Item A", "Value", 100.0),
                Map.of("ID", 2, "Name", "Item B", "Value", 150.5),
                Map.of("ID", 3, "Name", "Item C", "Value", 75.25)
        );
    }
}