/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHALID
 */
public class DemoServletContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        //to set attribute
        context.setAttribute("company", "IBM");
        //to get attibute
        String n = (String) context.getAttribute("company");
        out.println("Welcome to " + n);
        //get all attributes
        Enumeration<String> e = context.getInitParameterNames();
        String str = "";
        while (e.hasMoreElements()) {
            str = e.nextElement();
            out.print("<br>Name:" + str);
            out.print(" Value: " + context.getInitParameter(str));
        }
        out.close();

    }


}
