package template.abstractclass;

import template.model.ReportData;

/**
 * Template (base) class for exporting reports.
 * Defines the fixed export workflow; subclasses only customize the format-specific steps.
 */
public abstract class AbstractReportExporter {

    /**
     * Template Method: defines the algorithm skeleton in a fixed order.
     * In this demo, "filePath" is just a label printed to the console.
     */
    public final void exportReport(ReportData data, String filePath) {
        prepareData(data);
        openFile(filePath);
        writeHeader(data);
        writeDataRows(data);
        writeFooter(data);
        closeFile(filePath);
        System.out.println("Export complete: " + filePath);
    }

    // Hook method: common default step (subclasses may override if needed)
    protected void prepareData(ReportData data) {
        System.out.println("Preparing report data (common step)...");
    }

    // Hook method: default "open" behavior for the demo
    protected void openFile(String filePath) {
        System.out.println("Opening file '" + filePath + "'");
    }

    // Required steps: each exporter must implement its own formatting.
    protected abstract void writeHeader(ReportData data);

    protected abstract void writeDataRows(ReportData data);

    // Hook method: optional step (default is no footer)
    protected void writeFooter(ReportData data) {
        System.out.println("Writing footer (default: no footer).");
    }

    // Hook method: default "close" behavior for the demo
    protected void closeFile(String filePath) {
        System.out.println("Closing file '" + filePath + "'");
    }
}