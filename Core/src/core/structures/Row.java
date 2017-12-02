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
public class Row {

    public LinkedHashMap<String, Unit> data;

    public Row() {
        this.data = new LinkedHashMap<String, Unit>();
    }

    public void addUnit(String key, Unit data) {
        this.data.put(key, data);
    }

    public Unit getUnit(String key) {
        return this.data.get(key);
    }

}
