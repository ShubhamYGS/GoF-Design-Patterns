package template.concrete;

import template.abstractclass.AbstractReportExporter;
import template.model.ReportData;

import java.util.Map;

/**
 * Concrete exporter for a PDF-like format (console demo).
 * Same workflow as CSV, but prints using PDF-specific formatting.
 */
public class PdfReportExporter extends AbstractReportExporter {
    //prepareData() not overridden - default will be used
    //openFile() not overridden - default will be used

    @Override
    protected void writeHeader(ReportData data) {
        System.out.println("PDF: Writing header: " + String.join(",", data.getHeaders()));
    }

    @Override
    protected void writeDataRows(ReportData data) {
        System.out.println("PDF: Writing data rows...");
        for (Map<String, Object> row : data.getRows()) {
            System.out.println("PDF: " + row.values());
        }
    }

    // writeFooter() not overridden - default will be used
    // closeFile() not overridden - default will be used
}