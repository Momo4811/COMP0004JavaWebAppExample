package uk.ac.ucl.main;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class DataFrame {
    private List<String> columnNames;
    private Map<String, Column> columns;

    public DataFrame(){
        this.columnNames = new ArrayList<>();
        this.columns = new HashMap<>();
    }

    public void addColumn(Column column){
        this.columnNames.add(column.getName());
        this.columns.put(column.getName(), column);
    }

    public List<String> getColumnNames(){
        return this.columnNames;
    }

    public int getRowCount(){
        return this.columns.get(columnNames.get(0)).getSize();
    }

    public String getValue(String columnName, int row){
        return this.columns.get(columnName).getRowValue(row);
    }

    public void putValue(String columnName, int row, String value){
        this.columns.get(columnName).setRowValue(row, value);
    }

    public void addValue(String columnName, String value){
        this.columns.get(columnName).addRowValue(value);
    }

    public List<String> getRecord(int row){
        List<String> record = new ArrayList<>();
        for (String columnName : this.columnNames){
            record.add(this.columns.get(columnName).getRowValue(row));
        }
        return record;
    };
}


