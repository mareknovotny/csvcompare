/**
 * 
 */
package org.jboss.windup.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        
    }

}
