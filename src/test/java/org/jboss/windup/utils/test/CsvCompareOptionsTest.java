/**
 * 
 */
package org.jboss.windup.utils.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.windup.utils.CsvCompareOptions;
import org.junit.Test;

/**
 * @author mnovotny
 *
 */
public class CsvCompareOptionsTest
{
    public static final Logger logger = LogManager.getLogger(CsvCompareOptionsTest.class);
    
    /**
     * Test method for {@link org.jboss.windup.utils.CsvCompareOptions#parse(java.lang.String[])}.
     */
    @Test
    public void testAllArgsParse()
    {
        String[] testArgs = new String[] {"-o","file1.txt","-n","file2.txt", "-d",";"};
        CsvCompareOptions ccOptions = new CsvCompareOptions();
        try
        {
            ccOptions.parse(testArgs);
        }
        catch (Exception e)
        {
            fail("This should not fail!");
        }
        assertNotNull(ccOptions.getDelimiter());
        assertNotNull(ccOptions.getNewFile());
        assertNotNull(ccOptions.getOldFile());
        assertEquals("Delimiter is not set correctly", ';', ccOptions.getDelimiter());
        assertEquals("new-file is not set correctly", "file2.txt", ccOptions.getNewFile());
        assertEquals("old-file is not set correctly", "file1.txt", ccOptions.getOldFile());
        
    }
    
    @Test
    public void testDefaultDelimiterParse()
    {
        String[] testArgs = new String[] {"-o","file1.txt","-n","file2.txt"};
        CsvCompareOptions ccOptions = new CsvCompareOptions();
        
        try
        {
            ccOptions.parse(testArgs);
        }
        catch (Exception e)
        {
            fail("This should not fail!");
        }
        assertNotNull(ccOptions.getDelimiter());
        assertNotNull(ccOptions.getNewFile());
        assertNotNull(ccOptions.getOldFile());
        assertEquals("Delimiter is not set correctly", CsvCompareOptions.DEFAULT_CSV_DELIMITER, ccOptions.getDelimiter());
        assertEquals("new-file is not set correctly", "file2.txt", ccOptions.getNewFile());
        assertEquals("old-file is not set correctly", "file1.txt", ccOptions.getOldFile());
    }
    
    @Test
    public void testRequiredArgsParse() 
    {
        String[] testArgs = new String[] {};
        CsvCompareOptions ccOptions = new CsvCompareOptions();
        try {
            ccOptions.parse(testArgs);
        } catch (Exception pe) {
            logger.debug(pe.getLocalizedMessage());
            assertTrue(pe instanceof IllegalArgumentException);
            assertNotNull(ccOptions.getDelimiter());
            assertEquals("Default delimiter should be set correctly", CsvCompareOptions.DEFAULT_CSV_DELIMITER, ccOptions.getDelimiter());
        }
    }    

}
