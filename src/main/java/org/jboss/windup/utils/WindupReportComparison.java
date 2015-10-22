/**
 * 
 */
package org.jboss.windup.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.windup.utils.model.ReportModel;

/**
 * @author mnovotny
 *
 */
public class WindupReportComparison
{

    public static final Logger logger = LogManager.getLogger(WindupReportComparison.class);
    
    private List<ReportModel> originalReport;
    
    private List<ReportModel> newReport;
    
    
    public List<ReportModel> compareNewAndOldReports() {
        List<ReportModel> result = new ArrayList<ReportModel>();
        if (originalReport == null || newReport == null) {
            logger.debug("One of the reports is empty");
            return null;
        }
        
        Set<ReportModel> intersect = new HashSet<ReportModel>(originalReport);
        intersect.retainAll(newReport);
        logger.trace("Intersection has got " + intersect.size());
        
        result.addAll(newReport);
        logger.trace("Result has got " + result.size());
        result.removeAll(intersect);
        logger.trace("Result has got " + result.size());
        
        return result;
    }

    public WindupReportComparison(List<ReportModel> oldList, List<ReportModel> newList) {
        this.newReport = newList;
        this.originalReport = oldList;
    }
}
