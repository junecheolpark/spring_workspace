/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.78
 * Generated at: 2022-07-11 02:30:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/coding/backup/spring_workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Board/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1655173300509L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"/>\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.6.0.js\"></script>\n");
      out.write("	<title>메인</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<div class=\"container\">\n");
      out.write("		<div class=\"row m-3\"> \n");
      out.write("			<div class=\"col d-flex justify-content-center\">\n");
      out.write("				<h2>로그인</h2>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("		<form id=\"loginForm\">\n");
      out.write("			<div class=\"mb-3\">\n");
      out.write("				<label for=\"id\" class=\"form-label\">아이디</label> \n");
      out.write("				<input type=\"text\" class=\"form-control\" id=\"id\" name=\"id\" value=\"abc123\">\n");
      out.write("			</div>\n");
      out.write("			<div class=\"mb-3\">\n");
      out.write("				<label for=\"pw\" class=\"form-label\">비밀번호</label>\n");
      out.write("				<input type=\"password\" class=\"form-control\" id=\"pw\" name=\"pw\" value=\"abc123\">\n");
      out.write("			</div>\n");
      out.write("			<div class=\"mb-3 form-check d-flex justify-conte-center\">\n");
      out.write("				<input type=\"checkbox\" class=\"form-check-input\" id=\"rememberId\">\n");
      out.write("				<label class=\"form-check-label\" for=\"maintainId\">아이디 기억하기</label>\n");
      out.write("			</div>\n");
      out.write("			<div class=\"mb-3 form-check text-center\">\n");
      out.write("				<button type=\"button\" id=\"loginBtn\" class=\"btn btn-primary\">로그인</button>\n");
      out.write("				<button type=\"button\" id=\"toSignup\" class=\"btn btn-warning\">회원가입</button>\n");
      out.write("			</div>\n");
      out.write("		</form>\n");
      out.write("	</div>\n");
      out.write("	<script>\n");
      out.write("	\n");
      out.write("		// 회원가입 페이지 요청\n");
      out.write("		document.getElementById(\"toSignup\").onclick = function(){\n");
      out.write("			location.href = \"/member/toSignup\";\n");
      out.write("		}\n");
      out.write("		\n");
      out.write("		// 로그인 요청 \n");
      out.write("		document.getElementById(\"loginBtn\").onclick = function(){\n");
      out.write("			$.ajax({\n");
      out.write("				url : \"/member/login\"\n");
      out.write("				,type : \"post\"\n");
      out.write("				,data : {id : $(\"#id\").val(), pw : $(\"#pw\").val()}\n");
      out.write("				, success: function(data){\n");
      out.write("					console.log(data);\n");
      out.write("					if(data == \"success\"){\n");
      out.write("						location.href = \"/member/toWelcome\";\n");
      out.write("					}else if(data == \"fail\"){\n");
      out.write("						alert(\"아이디 혹은 비밀번호가 일치하지 않습니다.\");\n");
      out.write("					}\n");
      out.write("				}, error : function(e){\n");
      out.write("					console.log(e);\n");
      out.write("				}\n");
      out.write("			})\n");
      out.write("		}\n");
      out.write("		\n");
      out.write("	</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
