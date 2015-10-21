package org.jboss.windup.utils.test;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.List;

import org.jboss.windup.utils.CsvWindupExportLoader;
import org.jboss.windup.utils.ReportModel;
import org.junit.Test;

public class CsvLoaderTest
{
    
    private static final String FILE_TO_TEST = "/test1.csv";

    @Test
    public void testParseCSV()
    {
        URL testResource = getClass().getResource(FILE_TO_TEST);
        assertNotNull(testResource);
        assertTrue(!testResource.getFile().isEmpty());

        CsvWindupExportLoader loader = new CsvWindupExportLoader(testResource, ',');
        assertNotNull(loader);
        List<ReportModel> list = loader.parseCSV();
        assertNotNull(list);
        assertEquals(4, list.size());
        assertEquals("environment-dependent-calls-02000", ((ReportModel) list.get(0)).getRuleId());
        assertEquals(1, ((ReportModel) list.get(0)).getStoryPoints().intValue());
    }

}
