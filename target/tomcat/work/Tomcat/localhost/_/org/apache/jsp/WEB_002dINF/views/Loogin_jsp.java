/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-08-26 22:09:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Loogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");

	response.setHeader("Pragma","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Expires","0");
	response.setDateHeader("Expires",-1	);
	session.invalidate();


      out.write("   <title>login form</title>\r\n");
      out.write("<link href=\"/resources/cssFiles/loginstyle.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<META Http-Equiv=\"Cache-Control\" Content=\"no-cache\">\r\n");
      out.write("<META Http-Equiv=\"Pragma\" Content=\"no-cache\">\r\n");
      out.write("<META Http-Equiv=\"Expires\" Content=\"0\">\r\n");
      out.write("<body>\r\n");
      out.write("<script>\r\n");
      out.write("\twindow.onload = function(){\r\n");
      out.write("\t\tvar error = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorLoggingIn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("\t\tif(!error == \"\"){\r\n");
      out.write("\t\t\talert(error);\r\n");
      out.write("\t\t\twindow.location.replace(\"/Loogin\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script>\r\n");
      out.write("    function Validate() {\r\n");
      out.write("\t    var email = document.getElementById('email').value;\r\n");
      out.write("\t   \r\n");
      out.write("\t   if (/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/.test(email))\r\n");
      out.write("\t      true;\r\n");
      out.write("\t   else{\r\n");
      out.write("\t      alert(\"You have entered an invalid email address!\");\r\n");
      out.write("\t      return false;\r\n");
      out.write("\t    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<a href=\"/Home2\"><img src=\"/resources/images/BackButton.png\" width=\"70px\" border= \"none\";></a>\r\n");
      out.write("\r\n");
      out.write(" <div class=\"loginBox\">\r\n");
      out.write("\t<!--<img src=\" class=\"user\" >-->\r\n");
      out.write("  \r\n");
      out.write("\t<h2>Login</h2>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<form id=\"loginForm\" onsubmit=\"return Validate();\" modelAttribute=\"login\" action=\"loginProcess\" method=\"get\">\r\n");
      out.write("\t\t<p>Email</p>\r\n");
      out.write("\t\t<input type=\"email\" path=\"email\" name=\"email\" placeholder=\"Enter Email\" maxlength = \"75\">\r\n");
      out.write("\t\t<p>Password</p>\r\n");
      out.write("\t\t<input type=\"password\" path=\"password\" name=\"password\" placeholder=\"Enter Password\" maxlength = \"25\">\r\n");
      out.write("\t\t<input type=\"submit\" name=\"\" value=\"Log In\">\r\n");
      out.write("\t\t<a href=\"#\">Forget Password</a><br><br>\r\n");
      out.write("\t\t<p align=\"center\";>Are you new?<a href=\"#\"> Sign Up</a></p>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
