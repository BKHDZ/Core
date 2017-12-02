/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.mysql;

import core.structures.Column;
import core.structures.Row;
import core.structures.Table;
import core.structures.Unit;
import database.ConnectionParameters;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Map;

/**
 *
 * @author FAMILIA
 */
public class ManagerMysql {
    
    Unit currentUnit;
    Row currentRow;
    Table currentTable;
    Connection connection;
    Statement st;
    ResultSet rs;
    
    public ManagerMysql() {
        connection = null;
        st = null;
        rs = null;
    }
    
    public void getConnection(ConnectionParameters connectionParameters) throws Exception {
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://" + connectionParameters.getHost() + "/" + connectionParameters.getDb() + "?user=" + connectionParameters.getUser() + "&password=" + connectionParameters.getPassword() + "");
        }
    }
    
    public void closeConnection() throws Exception {
        if (connection != null) {
            closeOthers();
            connection.close();
            connection = null;
        }
    }
    
    public void executeSelect(String query) throws Exception {
        currentTable = new Table();
        st = connection.createStatement();
        rs = st.executeQuery(query);
        
        ResultSetMetaData rsmd = rs.getMetaData();
        Column currentColumn;
        String dbName;
        Column.DB_TYPE db_type;
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            db_type = Column.DB_TYPE.UNDEFINED;
            dbName = rsmd.getColumnName(i);
            if (rsmd.getColumnTypeName(i).equals("VARCHAR")) {
                db_type = Column.DB_TYPE.VARCHAR;
            }
            if (rsmd.getColumnTypeName(i).equals("INT")) {
                db_type = Column.DB_TYPE.NUMBER;
            }
            currentColumn = new Column(i - 1, dbName, db_type);
            currentTable.addColumn(currentColumn.getDbName(), currentColumn);
        }
        
    }
    
    public Table executeSelectAsTable(String query) throws Exception {
        executeSelect(query);
        while (getNextRow()) {
            currentTable.addRow(currentTable.getRows().size() + "", currentRow);
        }
        return currentTable;
    }
    
    public boolean getNextRow() throws Exception {
        if (rs.next()) {
            currentRow = new Row();
            for (Map.Entry<String, Column> entry : currentTable.getColumns().entrySet()) {
                currentUnit = new Unit(rs.getObject(entry.getValue().getDbName()));
                currentRow.addUnit(entry.getValue().getDbName(), currentUnit);
            }
            return true;
        } else {
            closeOthers();
            return false;
        }
    }
    
    public Row getCurrentRow() {
        return currentRow;
    }
    
    private void closeOthers() {
        try {
            st.close();
        } catch (Exception e) {
        }
        try {
            rs.close();
        } catch (Exception e) {
        }
        currentUnit = null;
        currentRow = null;
        st = null;
        rs = null;
    }
    
}
