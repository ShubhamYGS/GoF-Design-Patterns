package template.concrete;

import template.abstractclass.AbstractReportExporter;
import template.model.ReportData;

import java.util.Map;

/**
 * Concrete exporter for CSV format.
 * Only overrides the required steps (header + rows); uses default hooks for the rest.
 */
public class CsvReportExporter extends AbstractReportExporter {
    //prepareData() not overridden - default will be used
    //openFile() not overridden - default will be used

    @Override
    protected void writeHeader(ReportData data) {
        // CSV header is a comma-separated list of column names.
        System.out.println("CSV: Writing header: " + String.join(",", data.getHeaders()));
    }

    @Override
    protected void writeDataRows(ReportData data) {
        System.out.println("CSV: Writing data rows...");
        for (Map<String, Object> row : data.getRows()) {
            System.out.println("CSV: " + row.values());
        }
    }

    // writeFooter() not overridden - default will be used
    // closeFile() not overridden - default will be used
}