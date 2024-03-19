package uk.ac.ucl.model;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import uk.ac.ucl.main.DataLoader;
import uk.ac.ucl.main.DataFrame;

public class Model
{
  DataFrame dataFrame;
  // The example code in this class should be replaced by your Model class code.
  // The data should be stored in a suitable data structure.
  public List<String> getHeaderNames() {
    return this.dataFrame.getColumnNames();
  }
  
  public LinkedHashMap<String, Integer> getPeoplePerPlaceSorted(String placeHeader){
    LinkedHashMap<String, Integer> sortedPeoplePerPlace = new LinkedHashMap<>();
    HashMap<String, Integer> unsortedPeoplePerPlace = calculatePeoplePerPlace(placeHeader);
    List<Map.Entry<String, Integer>> tempList = new ArrayList<>(unsortedPeoplePerPlace.entrySet());
    
    //Sort By People 
    tempList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

    for(Map.Entry<String, Integer> peopleData : tempList){
      sortedPeoplePerPlace.put(peopleData.getKey(), peopleData.getValue());
    }

    return sortedPeoplePerPlace;
  }
  
  public HashMap<String, Integer> calculatePeoplePerPlace(String placeHeader){
    HashMap<String, Integer> peoplePerPlace = new HashMap<>();
    
    for(int i = 0; i < this.dataFrame.getRowCount(); i++){
      String place = this.dataFrame.getValue(placeHeader, i);
      if(peoplePerPlace.containsKey(place)){
        peoplePerPlace.put(place, peoplePerPlace.get(place) + 1);
      } else {
        peoplePerPlace.put(place, 1);
      }
    }

    return peoplePerPlace;

  }

  public List<List<String>> getData(String headerName, String searchString){
    List<List<String>> data = new ArrayList<>();
    data.add(this.dataFrame.getColumnNames());

    for (int i = 0; i < this.dataFrame.getRowCount(); i++) {
      if (this.dataFrame.getValue(headerName, i).contains(searchString)) {
        data.add(this.dataFrame.getRecord(i));
      }
    }
    
    return data;
  }

  public List<String> getPatientNames() {
    List<String> patientNames = new ArrayList<>();

    for (int i = 0; i < this.dataFrame.getRowCount(); i++) {
      String fullName = this.dataFrame.getValue("FIRST", i) + ", " + this.dataFrame.getValue("LAST", i);
      patientNames.add(fullName);
    }

    return patientNames;
  }

  // This method illustrates how to read csv data from a file.
  // The data files are stored in the root directory of the project (the directory your project is in),
  // in the directory named data.
public void readFile(String fileName) {
    DataLoader dataLoader = new DataLoader();
    this.dataFrame = dataLoader.createDataFrame(fileName);
  }

  // This also returns dummy data. The real version should use the keyword parameter to search
  // the data and return a list of matching items.
  public List<String> searchFor(String keyword)
  {
    return List.of("Search keyword is: "+ keyword, "result1", "result2", "result3");
  }
}
