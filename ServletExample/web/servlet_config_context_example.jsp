<%-- 
    Document   : servlet_config_context_example
    Created on : 07-Sep-2019, 12:31:08
    Author     : KHALID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>ServletConfig Interface</h3>
        <div>An object of ServletConfig is created by the web container for each
            servlet. This object can be used to get configuration information from web.xml file.
            
                   If the configuration information is modified from the web.xml file,
            we don't need to change the servlet. So it is easier to manage the web application if 
            any specific content is modified from time to time.            
        </div>
        <h3>Advantage of ServletConfig</h3>
        The core advantage of servletConfig is that you don't need to edit 
        the servlet file if information is modified from the web.xml file.
        <br></br><h3>Methods of ServletConfig interface</h3>
        <ol>
            <li>
                <b>Public String getInitParameter(String name:)</b>
Returns the parameter value for the specified parameter name.</li>
            <li><b>Public Enumeration getInitParameterNames():</b>
Returns the enumeration of all the initialzation parameter names.</li>
            <li><b>public String getServletName():</b>Returns the name of the servlet.</li>
            <li><b>public ServletContext getServletContext():</b>
Returns an objects of ServletContext.</li>
        </ol>
        <h3>How to get the object of servletConfig</h3>
        <ol><li><b>getServletConfig()</b>method of Servlet interface
returns the object of ServletConfig.</li></ol>
        <a href="demo_servlet_config">Example</a>
    </body>
</html>
