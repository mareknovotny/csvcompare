/**
 * 
 */
package org.jboss.windup.utils.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVWriter;

/**
 * @author mnovotny
 *
 */
public class ExportReportModelToCSV
{
    public static final Logger logger = LogManager.getLogger(ExportReportModelToCSV.class);
    
    private List<ReportModel>  result; 
    
    public ExportReportModelToCSV(List<ReportModel> listOfLines) {
        this.result = listOfLines;
    }
    
    public void export(File exportFile) throws IOException {
        CSVWriter writer = null;
        try
        {
            writer = new CSVWriter(new FileWriter(exportFile));
        }
        catch (IOException e)
        {
            logger.error("IOException while writing to output file! " + e.getLocalizedMessage());
        }
        List<String[]> content = new ArrayList<String[]> ();
        for (ReportModel report : result) {
            content.add (report.getStringArray());
        }
        
        if (writer != null) {
            writer.writeAll(content, true);
            writer.close();
        }
        
    }
}
