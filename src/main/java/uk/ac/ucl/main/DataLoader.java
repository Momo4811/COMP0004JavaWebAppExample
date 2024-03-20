package uk.ac.ucl.main;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

// This class is responsible for loading data
// from a CSV file into a DataFrame object
// and from a DataFrame object to a CSV file.
public class DataLoader {
    public void loadCSV(String fileName, DataFrame dataFrame) {
        try (
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));
            CSVPrinter csvPrinter = CSVFormat.DEFAULT.withHeader(dataFrame.getColumnNames().toArray(new String[0])).print(writer)
        ) {
            for (int i = 0; i < dataFrame.getRowCount(); i++) {
                csvPrinter.printRecord(dataFrame.getRecord(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
