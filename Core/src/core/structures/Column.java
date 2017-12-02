/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.structures;

/**
 *
 * @author FAMILIA
 */
public class Column {

    public enum DB_TYPE {
        UNDEFINED,VARCHAR, NUMBER
    }

    int position;
    String dbName;
    DB_TYPE dbType;

    public Column(int position, String dbName, DB_TYPE dbType) {
        this.position = position;
        this.dbName = dbName;
        this.dbType = dbType;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public DB_TYPE getDbType() {
        return dbType;
    }

    public void setDbType(DB_TYPE dbType) {
        this.dbType = dbType;
    }
    
    

}
