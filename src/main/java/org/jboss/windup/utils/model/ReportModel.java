/**
 *
 */
package org.jboss.windup.utils.model;

/**
 *
 * Mapping to one line in CSV report
 *
 * @author mnovotny
 *
 */
public class ReportModel
{
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "ReportModel [ruleId=" + emptyStringIfNull(ruleId) + ", problemType=" + emptyStringIfNull(problemType) + ", application=" + emptyStringIfNull(application) + ", filename=" + emptyStringIfNull(filename)
                    + ", filePath=" + emptyStringIfNull(filePath) + ", lineNumber=" + emptyStringIfNull(lineNumber) + ", storyPoints=" + emptyStringIfNull(storyPoints) + "]";
    }

    private String ruleId;

    private String problemType;

    private String title;

    private String description;

    private String links;

    private String application;

    private String filename;

    private String filePath;

    private String lineNumber;

    private Integer storyPoints;


    public ReportModel() {
    }

    public String getRuleId()
    {
        return ruleId;
    }

    public void setRuleId(String ruleId)
    {
        this.ruleId = ruleId;
    }

    public String getProblemType()
    {
        return problemType;
    }

    public void setProblemType(String problemType)
    {
        this.problemType = problemType;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLinks()
    {
        return links;
    }

    public void setLinks(String links)
    {
        this.links = links;
    }

    public String getApplication()
    {
        return application;
    }

    public void setApplication(String application)
    {
        this.application = application;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public String getLineNumber()
    {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    public Integer getStoryPoints()
    {
        return storyPoints;
    }

    public void setStoryPoints(Integer storyPoints)
    {
        this.storyPoints = storyPoints;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((storyPoints == null) ? 0 : storyPoints.hashCode());
        result = prime * result + ((filename == null) ? 0 : filename.hashCode());
        result = prime * result + ((lineNumber == null) ? 0 : lineNumber.hashCode());
        result = prime * result + ((ruleId == null) ? 0 : ruleId.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReportModel other = (ReportModel) obj;
        if (storyPoints == null)
        {
            if (other.storyPoints != null)
                return false;
        }
        else if (!storyPoints.equals(other.storyPoints))
            return false;
        if (filename == null)
        {
            if (other.filename != null)
                return false;
        }
        else if (!filename.equals(other.filename))
            return false;
        if (lineNumber == null)
        {
            if (other.lineNumber != null)
                return false;
        }
        else if (!lineNumber.equals(other.lineNumber))
            return false;
        if (ruleId == null)
        {
            if (other.ruleId != null)
                return false;
        }
        else if (!ruleId.equals(other.ruleId))
            return false;
        return true;
    }

    public String[] getStringArray()
    {
        return new String[] { emptyStringIfNull(getRuleId()) , emptyStringIfNull(getProblemType()),
                    emptyStringIfNull(getLineNumber()), emptyStringIfNull(getFilename()),
                    emptyStringIfNull(getFilePath()), emptyStringIfNull(getStoryPoints()) };

    }

    private String emptyStringIfNull(Object obj) {

        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

}
