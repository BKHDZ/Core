/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.structures.Row;
import core.structures.Table;
import database.ConnectionParameters;
import database.mysql.ManagerMysql;
import java.util.Map;

/**
 *
 * @author FAMILIA
 */
public class Core {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ManagerMysql managerMysql = new ManagerMysql();
        
        double a=100.5;
        double b=100.0;
        
   
        
        try {
            managerMysql.getConnection(new ConnectionParameters("training_usser", "training_usser1", "192.168.100.5", "3306", "training", null));

//            managerMysql.executeSelect("SELECT * FROM t1");
//            Row cRow;
//            while (managerMysql.getNextRow()) {
//                cRow=managerMysql.getCurrentRow();
//                System.out.println(cRow.getUnit("c1").getDataAsString() +" ////// "+cRow.getUnit("c2").getDataAsString()   );
//            }


            Table data=managerMysql.executeSelectAsTable("SELECT * FROM t1");
            for (Map.Entry<String, Row> entry : data.getRows().entrySet()) {
            entry.getValue().getUnit("c1").getDataAsString();
                
            }

            managerMysql.closeConnection();
            System.out.println("Termino Correctamente");
        } catch (Exception e) {
            System.out.println("Error Terminal [" + e.getMessage() + "]");
        }

    }

}
