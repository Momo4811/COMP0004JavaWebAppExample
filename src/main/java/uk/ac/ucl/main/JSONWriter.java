package uk.ac.ucl.main;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;

public class JSONWriter {
    public void writeJSON(String fileName, DataFrame dataFrame) {
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < dataFrame.getRowCount(); i++) {
            JSONObject record = new JSONObject();
            for (String columnName : dataFrame.getColumnNames()) {
                record.put(columnName, dataFrame.getValue(columnName, i));
            }
            jsonArray.put(record);
        }

        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonArray.toString(2));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}