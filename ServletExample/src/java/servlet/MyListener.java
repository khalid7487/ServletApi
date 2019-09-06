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
            PreparedStatement ps=con.prepareStatement("CREATE TABLE IF"
                    + "NOT EXISTS 'fa_uom'("
                    + " 'uom_id' int(10) unsigned NOT NULL auto_increment,"
                    + "'uom_name' varchar(45) NOT NULL,"
                    + "'uom_description' varchar(45) NOT NULL,"
                    + "PRIMARY KEY ('uom_id'))"
                    + "ENGINE=InnoDB DEFAULT CHARSET=latin1;");
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
