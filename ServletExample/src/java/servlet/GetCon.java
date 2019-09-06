/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.sql.*;
public class GetCon {
    private GetCon(){}
    public static Connection con;
    static {
        try {
            Class.forName(DBIntializer.DRIVER);
            con=DriverManager.getConnection(DBIntializer.CON_STRING, DBIntializer.USERNAME,
                    DBIntializer.PASSWORD);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException ex) {
            System.out.println("Exception in GetCon");
        }
    }
    public static Connection getCon(){
        return con;
    }
}
