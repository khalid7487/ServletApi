/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHALID
 */
public class DemoServletConfig extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        ServletConfig config=getServletConfig();
        String username=config.getInitParameter("username");
        out.print("User Name is:"+username);
        Enumeration<String> e=config.getInitParameterNames();
        
        String str="";
        while(e.hasMoreElements()){
            str=e.nextElement();
            out.print("<br>Name:"+str);
            out.print(" Value: "+config.getInitParameter(str));
        }
        out.close();
    }

  
}
