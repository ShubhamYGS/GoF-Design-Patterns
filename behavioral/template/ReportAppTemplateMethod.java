package template;

import template.abstractclass.AbstractReportExporter;
import template.concrete.CsvReportExporter;
import template.concrete.PdfReportExporter;
import template.model.ReportData;

/**
 * Demo client for the Template Method pattern.
 * Chooses an exporter (CSV/PDF) and calls the same export workflow.
 */
public class ReportAppTemplateMethod {
    public static void main(String[] args) {
        // Input data used by all exporters.
        ReportData data = new ReportData();

        // Template method call: the workflow stays the same, only formatting changes.
        AbstractReportExporter csvExporter = new CsvReportExporter();
        csvExporter.exportReport(data, "sales_report");

        System.out.println();

        AbstractReportExporter pdfExporter = new PdfReportExporter();
        pdfExporter.exportReport(data, "financial_summary");
    }
}