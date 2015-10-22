/**
 * 
 */
package org.jboss.windup.utils;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author mnovotny
 *
 */
public class CsvCompareOptions
{
    public static final Logger logger = LogManager.getLogger(CsvCompareOptions.class);
    
    public static final char DEFAULT_CSV_DELIMITER = ';';
    
    private String oldFile;
    private String newFile;
    private char delimiter = DEFAULT_CSV_DELIMITER;
    
    
    public void parse (String[] args) throws Exception {
        CommandLineParser parser = new DefaultParser();
        if (args.length <=1){
            logger.error("Missing required arguments old-file and new-file");
            printUsage(args);
            throw new IllegalArgumentException("Missing required arguments");
        }
            
        CommandLine line = parser.parse( getCMdOptions(), args );
        if ( line.hasOption('o')) {
            String oldFileOptionValue = line.getOptionValue("o");
            if (validateExistingFile(oldFileOptionValue)) {
                logger.error("file path in option old-file is wrong as file doesn't exist");
                throw new IllegalArgumentException("file path in option old-file is wrong as file doesn't exist");
            }
            this.setOldFile( oldFileOptionValue);
            logger.debug("old file is " + getOldFile());
        }
        if (line.hasOption('n')) {
            String newFileOptionValue = line.getOptionValue("n");
            if (validateExistingFile(newFileOptionValue)) {
                logger.error("file path in option new-file is wrong as file doesn't exist");
                throw new IllegalArgumentException("file path in option new-file is wrong as file doesn't exist");
            }
            this.setNewFile(newFileOptionValue);
            logger.debug("new file is " + getNewFile());
        }
        
        if (line.hasOption('d')) {
            this.setDelimiter(line.getOptionValue('d').charAt(0));
            logger.debug("CSV delimiter is " + getDelimiter());
        } 
        
        //validations
        
    }
    
    private boolean validateExistingFile(String strFilePath) {
        File file = new File(strFilePath);
        return file.isFile();
    }
    
    public String getOldFile()
    {
        return oldFile;
    }

    public void setOldFile(String oldFile)
    {
        this.oldFile = oldFile;
    }

    public String getNewFile()
    {
        return newFile;
    }

    public void setNewFile(String newFile)
    {
        this.newFile = newFile;
    }

    public char getDelimiter()
    {
        return delimiter;
    }

    public void setDelimiter(char delimiter)
    {
        this.delimiter = delimiter;
    }

    private static Options getCMdOptions() {
        
        Options options = new Options();
        options.addOption( Option.builder("o").required(true).hasArg(true).longOpt("old-file").build());
        options.addOption( Option.builder("n").required(true).hasArg(true).longOpt("new-file").build());
        options.addOption( Option.builder("d").hasArg(true).longOpt("csv-delimiter").build());
        
        return options;
    }
    
    /**
     * Prints the usage for cli options
     * @param args
     */
    private static void printUsage(String[] args) {
     // automatically generate the help statement
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("csvcompare", getCMdOptions());
    }
    
}
