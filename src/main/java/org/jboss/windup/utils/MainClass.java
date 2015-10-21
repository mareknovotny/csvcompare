/**
 * 
 */
package org.jboss.windup.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.windup.utils.model.ReportModel;

/**
 * @author mnovotny
 *
 */
public class MainClass
{
    public static final Logger logger = LogManager.getLogger(MainClass.class);
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        CsvCompareOptions csvCompareOptions = new CsvCompareOptions();
        try
        {
            csvCompareOptions.parse(args);
        }
        catch(Exception exp ) {
            logger.error("Parsing failed.  Reason: " + exp.getMessage());
        }
        
        try
        {
            CsvWindupExportLoader loader1 = new CsvWindupExportLoader(new URL(csvCompareOptions.getOldFile()), csvCompareOptions.getDelimiter());
            CsvWindupExportLoader loader2 = new CsvWindupExportLoader(new URL(csvCompareOptions.getNewFile()), csvCompareOptions.getDelimiter());
            WindupReportComparison reportCmp = new WindupReportComparison(loader1.parseCSV(), loader2.parseCSV());
            List<ReportModel> listDiff = reportCmp.compareNewAndOldReports();
            if (listDiff.size()> 0) {
                System.out.println(listDiff);
                System.exit(-1);
            }
            System.exit(0);
        }
        catch (MalformedURLException e)
        {
           logger.error("Wrong CSV file path " + e.getLocalizedMessage());
        }
    }

}
