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
public class ShowRequestHeader extends HttpServlet {

    String paramName=null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.paramName=config.getInitParameter("version");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         String title="Requesr Header";
       //  out.println(paramName);
         out.println("<HTML>\n"
                 + "<HEAD><TITLE>"+title+"</TITLE></HEAD>\n"
                 + "<BODY BGCOLOR=\"4FD5E6\">\n"
                 + "<B>Request Method:</B>"
                  +request.getMethod()+"<BR>\n"
                  + "<B>Request URI:</B>"
                +request.getRequestURI()+"<BR>\n"
                + "<B>Request Protocol:</B>"
                     +request.getProtocol()+"<BR><BR>\n"
                         + "<TABLE BORDER=1 ALIGN=\"CENTER\">\n"
                             + "<TR BGCOLOR=\"#FFAD00\">\n"
                             + "<TH>Header Name<TH>Header Value");
          Enumeration<String> headerNames=request.getHeaderNames();
          while(headerNames.hasMoreElements()){
              String headerName=headerNames.nextElement();
              out.println("<TR><TH>"+headerName);
              out.println("<TD>"+request.getHeader(headerName));
          }
         out.println("</TABLE>\n</BODY></HTML>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

   
}
