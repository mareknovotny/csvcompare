package org.jboss.windup.utils.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jboss.windup.utils.CsvWindupExportLoader;
import org.jboss.windup.utils.WindupReportComparison;
import org.jboss.windup.utils.model.ExportReportModelToCSV;
import org.jboss.windup.utils.model.ReportModel;
import org.junit.Test;

public class WindupReportComparisonTest
{

    @Test
    public void testCompareNewAndOldReports() throws Exception 
    {
        WindupReportComparison cmp = new WindupReportComparison(createList1(), createList2());
        List<ReportModel> result = cmp.compareNewAndOldReports();
        assertNotNull(result);
        assertEquals(1, result.size());
        //System.out.println(result);
        //(new ExportReportModelToCSV(result)).export(new File("result.csv"));
    }
    
    @Test
    public void testLoadAndCompareNewAndOldReports() throws Exception 
    {
        CsvWindupExportLoader loader1 = new CsvWindupExportLoader(getClass().getResource("/test1.csv"), ',');
        CsvWindupExportLoader loader2 = new CsvWindupExportLoader(getClass().getResource("/test2.csv"), ',');
        
        List<ReportModel> parsedCSV1 = loader1.parseCSV();
        assertEquals(4, parsedCSV1.size());
        assertNotNull("This should not be null!", ((ReportModel) parsedCSV1.get(0)).getApplication());
        List<ReportModel> parsedCSV2 = loader2.parseCSV();
        assertEquals(4, parsedCSV2.size());
        assertNotNull("This should not be null!", ((ReportModel) parsedCSV2.get(0)).getApplication());
        
        WindupReportComparison cmp = new WindupReportComparison(parsedCSV1, parsedCSV2);
        List<ReportModel> result = cmp.compareNewAndOldReports();
        assertNotNull(result);
        assertEquals(1, result.size());
    }
    
    /**
     * 
     * @return test data
     *  test-0001","hint","44","Test.java","src/main/java","1
     *  test-0002","hint","41","Sample.java","src/main/java","3
     *  test-0002","hint","44","Sample.java","src/main/java","3
     */
    private static List<ReportModel> createList1() {
        List<ReportModel> result = new ArrayList<ReportModel>();
        
        ReportModel rm = new ReportModel();
        rm.setApplication("Test");
        rm.setFilename("Test.java");
        rm.setFilePath("src/main/java");
        rm.setStoryPoints(1);
        rm.setLineNumber(44);
        rm.setProblemType("hint");
        rm.setRuleId("test-0001");
        rm.setTitle("Test 1");
        result.add(rm);
        
        ReportModel rm1 = new ReportModel();
        rm1.setApplication("Test");
        rm1.setFilename("Sample.java");
        rm1.setFilePath("src/main/java");
        rm1.setStoryPoints(3);
        rm1.setLineNumber(41);
        rm1.setProblemType("hint");
        rm1.setRuleId("test-0002");
        rm1.setTitle("Test 2");
        result.add(rm1);
        
        ReportModel rm2 = new ReportModel();
        rm2.setApplication("Test");
        rm2.setFilename("Sample.java");
        rm2.setFilePath("src/main/java");
        rm2.setStoryPoints(3);
        rm2.setLineNumber(44);
        rm2.setProblemType("hint");
        rm2.setRuleId("test-0002");
        rm2.setTitle("Test 2");
        result.add(rm2);
        
        return result;
    }
    
    /**
     *
     * @return test data
        test-0001","hint","44","Test.java","src/main/java","1
        test-0002","hint","41","Sample.java","src/main/java","0
        test-0002","hint","44","Sample.java","src/main/java","3
     *
     */
    private static List<ReportModel> createList2() {
        List<ReportModel> result = new ArrayList<ReportModel>();
        
        ReportModel rm = new ReportModel();
        rm.setApplication("Test");
        rm.setFilename("Test.java");
        rm.setFilePath("src/main/java");
        rm.setStoryPoints(1);
        rm.setLineNumber(44);
        rm.setProblemType("hint");
        rm.setRuleId("test-0001");
        rm.setTitle("Test 1");
        result.add(rm);
        
        ReportModel rm1 = new ReportModel();
        rm1.setApplication("Test");
        rm1.setFilename("Sample.java");
        rm1.setFilePath("src/main/java");
        rm1.setStoryPoints(0);
        rm1.setLineNumber(41);
        rm1.setProblemType("hint");
        rm1.setRuleId("test-0002");
        rm1.setTitle("Test 2");
        result.add(rm1);
        
        ReportModel rm2 = new ReportModel();
        rm2.setApplication("Test");
        rm2.setFilename("Sample.java");
        rm2.setFilePath("src/main/java");
        rm2.setStoryPoints(3);
        rm2.setLineNumber(44);
        rm2.setProblemType("hint");
        rm2.setRuleId("test-0002");
        rm2.setTitle("Test 2");
        result.add(rm2);
        
        return result;
    }
    
    @Test
    public void testExport() {
        
        ExportReportModelToCSV export1 = new ExportReportModelToCSV(createList1());
        File exportFile1 = new File("export1.csv");
        if (exportFile1.exists()) {
            exportFile1.delete();
        }
        try
        {
            export1.export(exportFile1);
        }
        catch (IOException e)
        {
            fail("export1 - This should not fail in exporting to file!");
        }
        assertTrue(exportFile1.length() > 0);
        
        ExportReportModelToCSV export2 = new ExportReportModelToCSV(createList2());
        File exportFile2 = new File("export2.csv");
        if (exportFile2.exists()) {
            exportFile2.delete();
        }
        try
        {
            export2.export(exportFile2);
        }
        catch (IOException e)
        {
            fail("export2 - This should not fail in exporting to file!");
        }
        assertTrue(exportFile2.length() > 0);
    }
}
