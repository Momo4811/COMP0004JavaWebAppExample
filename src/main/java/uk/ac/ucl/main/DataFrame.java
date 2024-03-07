package uk.ac.ucl.main;

import java.util.ArrayList;
import java.util.Map;

public class DataFrame {
    private ArrayList<String> columnNames;
    private Map<String, Column> columns;

    public DataFrame(){
        this.columnNames = new ArrayList<>();
    }

    public void addColumn(Column column){
        this.columnNames.add(column.getName());
        this.columns.put(column.getName(), column);
    }

    public ArrayList<String> getColumnNames(){
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
}
