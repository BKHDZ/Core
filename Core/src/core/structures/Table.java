/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.structures;

import java.util.LinkedHashMap;

/**
 *
 * @author FAMILIA
 */
public class Table {

    LinkedHashMap<String, Column> columns;
    LinkedHashMap<String, Row> rows;

    public Table() {
        this.columns = new LinkedHashMap<String, Column>();
        this.rows = new LinkedHashMap<String, Row>();
    }

    public void addColumn(String key, Column column) {
        columns.put(key, column);
    }

    public void addRow(String key, Row row) {
        rows.put(key, row);
    }

    public LinkedHashMap<String, Column> getColumns() {
        return columns;
    }

    public LinkedHashMap<String, Row> getRows() {
        return rows;
    }
    
    
    

}
