/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import javax.servlet.*;
import java.sql.*;
public class MyListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        Connection con=null;
        try {
            con=GetCon.getCon();
            PreparedStatement ps=con.prepareStatement("CREATE TABLE `loginjdbc`.`fa_uom1` (\n" +
"  `uom_id` INT NOT NULL AUTO_INCREMENT,\n" +
"  `uom_name` VARCHAR(45) NOT NULL,\n" +
"  `uom_description` VARCHAR(45) NOT NULL,\n" +
"  PRIMARY KEY (`uom_id`));");
            ps.executeUpdate();
            ps=con.prepareStatement("INSERT INTO 'fa_uom'('uom_name','uom_description')"
                    + "VALUES(?,?)");
            ps.setString(1, "pes");
            ps.setString(2, "pieces");
            ps.executeUpdate();
            System.out.println("database created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("project undeployed");
    }
    
    
}
