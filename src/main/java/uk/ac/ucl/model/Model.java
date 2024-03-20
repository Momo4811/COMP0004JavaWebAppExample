package uk.ac.ucl.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import uk.ac.ucl.main.DataLoader;
import uk.ac.ucl.main.DataFrame;
import uk.ac.ucl.main.JSONWriter;

public class Model {
  private DataFrame dataFrame;

  // The example code in this class should be replaced by your Model class code.
  // The data should be stored in a suitable data structure.
  public List<String> getHeaderNames() {
    return this.dataFrame.getColumnNames();
  }

  public void saveDataAsJson(String fileName) {
    JSONWriter jsonWriter = new JSONWriter();
    jsonWriter.writeJSON(fileName, this.dataFrame);
  }

  public void updateCSV() {
    DataLoader dataLoader = new DataLoader();
    dataLoader.loadCSV("data/patients100.csv", this.dataFrame);
  }

  public List<String> getPatientRecord(int index) {
    return this.dataFrame.getRecord(index);
  }

  public void addRecord(Map<String, String> newRecord) {
    for (String columnName : this.dataFrame.getColumnNames()) {
      this.dataFrame.addValue(columnName, newRecord.get(columnName));
    }
  }

  public void deleteRecord(int patientIndex) {
    this.dataFrame.removeRecord(patientIndex);
  }

  public void updateRecord(int patientIndex, Map<String, String> newValues) {
    for (int i = 0; i < this.dataFrame.getColumnNames().size(); i++) {
      String currentColumn = this.dataFrame.getColumnNames().get(i);
      this.dataFrame.putValue(currentColumn, patientIndex, newValues.get(currentColumn));
    }
  }
  
  public Map<Character, Integer> getLetterOccurrencesSorted(String columnType) {
    Map<Character, Integer> letterOccurrences = new HashMap<>();
    for (int i = 0; i < this.dataFrame.getRowCount(); i++) {
      String value = this.dataFrame.getValue(columnType, i).toLowerCase();
      for (char c : value.toCharArray()) {
        if (Character.isLetter(c)) {
          letterOccurrences.put(c, letterOccurrences.getOrDefault(c, 0) + 1);
        }
      }
    }
  
    List<Map.Entry<Character, Integer>> list = new ArrayList<>(letterOccurrences.entrySet());
    list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
  
    Map<Character, Integer> sortedMap = new LinkedHashMap<>();
    for (Map.Entry<Character, Integer> entry : list) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }
  
    return sortedMap;
  }

  public LinkedHashMap<String, String> getOldestPerson() {
    LinkedHashMap<String, String> oldestPerson = new LinkedHashMap<>();
    LocalDate now = LocalDate.now();
    Period oldestAge = null;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    for (int i = 0; i < this.dataFrame.getRowCount(); i++) {
        LocalDate birthDate = LocalDate.parse(this.dataFrame.getValue("BIRTHDATE", i), formatter);
        Period age = Period.between(birthDate, now);

        if (oldestAge == null || age.getYears() > oldestAge.getYears()) {
            oldestAge = age;
            oldestPerson.put("FIRST", this.dataFrame.getValue("FIRST", i));
            oldestPerson.put("LAST", this.dataFrame.getValue("LAST", i));
            oldestPerson.put("BIRTHDATE", this.dataFrame.getValue("BIRTHDATE", i));
            String deathDate = this.dataFrame.getValue("DEATHDATE", i);
            if (deathDate != null) {
                oldestPerson.put("DEATHDATE", deathDate);
            }
        }
    }
    return oldestPerson;
  }


  public LinkedHashMap<String, Integer> getPeoplePerPlaceSorted(String placeHeader) {
    LinkedHashMap<String, Integer> sortedPeoplePerPlace = new LinkedHashMap<>();
    HashMap<String, Integer> unsortedPeoplePerPlace = calculatePeoplePerPlace(placeHeader);
    List<Map.Entry<String, Integer>> tempList = new ArrayList<>(unsortedPeoplePerPlace.entrySet());

    // Sort By People
    tempList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

    for (Map.Entry<String, Integer> peopleData : tempList) {
      sortedPeoplePerPlace.put(peopleData.getKey(), peopleData.getValue());
    }

    return sortedPeoplePerPlace;
  }

  public HashMap<String, Integer> calculatePeoplePerPlace(String placeHeader) {
    HashMap<String, Integer> peoplePerPlace = new HashMap<>();

    for (int i = 0; i < this.dataFrame.getRowCount(); i++) {
      String place = this.dataFrame.getValue(placeHeader, i);
      if (peoplePerPlace.containsKey(place)) {
        peoplePerPlace.put(place, peoplePerPlace.get(place) + 1);
      } else {
        peoplePerPlace.put(place, 1);
      }
    }

    return peoplePerPlace;

  }

  public List<List<String>> searchFor(String headerName, String searchString) {
    List<List<String>> data = new ArrayList<>();
    
    for (int i = 0; i < this.dataFrame.getRowCount(); i++) {
      String currentValue = this.dataFrame.getValue(headerName, i).toLowerCase();
      if (currentValue.contains(searchString.toLowerCase())) {
        data.add(this.dataFrame.getRecord(i));
      }
    }

    return data;
  }

  public int getPatientRecordIndex(String id) {
    for (int i = 0; i < this.dataFrame.getRowCount(); i++) {
      if (this.dataFrame.getValue("ID", i).equals(id)) {
        return i;
      }
    }
    System.out.println("No patient with the given ID is found");
    return 0;
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
  // The data files are stored in the root directory of the project (the directory
  // your project is in),
  // in the directory named data.
  public void readFile(String fileName) {
    DataLoader dataLoader = new DataLoader();
    this.dataFrame = dataLoader.createDataFrame(fileName);
  }
}
