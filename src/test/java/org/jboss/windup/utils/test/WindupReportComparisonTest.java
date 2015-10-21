package org.jboss.windup.utils.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.jboss.windup.utils.WindupReportComparison;
import org.jboss.windup.utils.model.ReportModel;
import org.junit.Test;

public class WindupReportComparisonTest
{
    

    @Test
    public void testCompareNewAndOldReports()
    {
        WindupReportComparison cmp = new WindupReportComparison(createList1(), createList2());
        List<ReportModel> result = cmp.compareNewAndOldReports();
        assertNotNull(result);
        assertEquals(1, result.size());
        System.out.println(result);
    }
    
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

}
