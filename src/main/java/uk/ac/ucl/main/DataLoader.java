package uk.ac.ucl.main;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/* Requirement 3. Write a class DataLoader that can read a .csv data file and load the data into an
empty DataFrame. The Column names are found as the first row in the .csv data file. It should
have a method that returns a filled DataFrame.*/
public class DataLoader {

    public DataFrame createDataFrame(String fileName) {
        DataFrame dataFrame = new DataFrame();
    
        try (
            Reader reader = new FileReader(fileName);
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            
            // Add header to the DataFrame
            for (String headerName : csvParser.getHeaderNames()) {
                Column column = new Column(headerName);
                dataFrame.addColumn(column);  
            } 
    
            for (CSVRecord record : csvParser) {
                for (String columnName : dataFrame.getColumnNames()) {
                    String value = record.get(columnName);
                    dataFrame.addValue(columnName, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFrame;
    }

}
