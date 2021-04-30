package org.apache.jsp.formularios;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import clases.Sesion;
import clases.Conexion;
import java.sql.ResultSet;

public final class Alumno_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>ABM ALUMNOS</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> ");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/alertify.core.css\">\n");
      out.write("        <link href=\"../css/bootstrap-theme.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/alertify.default.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/menuresponsive.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/chosenselect.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <div class=\"panel panel-primary \">\n");
      out.write("                        <div class=\"panel-heading\" style=\"text-align: center;font-size: 25px\">\n");
      out.write("                            ALUMNOS\n");
      out.write("                        </div>\n");
      out.write("                        <br> \n");
      out.write("\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("\n");
      out.write("                                <form id=\"formulario\" class=\"form-horizontal\" role=\"form\">\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"col-md-3\"></div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <label class=\"control-label\" for=\"codigo\" style= \"color:#063847\">Código</label> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <input type=\"text\" name=\"txtcodigo\" id=\"txtcodigo\" class=\"form-control\" placeholder=\"Autoincrementable\" disabled/>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"col-md-3\"></div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <label class=\"control-label\" for=\"codigo\" style= \"color:#063847\">Nombres</label> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-4\">\n");
      out.write("                                            <input type=\"text\" name=\"txtnombre\" id=\"txtnombre\" class=\"form-control\" placeholder=\"Ingrese Nombre\" disabled=\"\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"col-md-3\"></div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <label class=\"control-label\" for=\"codigo\" style= \"color:#063847\">Apellidos</label> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-4\">\n");
      out.write("                                            <input type=\"text\" name=\"txtapellido\" id=\"txtapellido\" class=\"form-control\" placeholder=\"Ingrese Apellido\" disabled=\"\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"col-md-3\"></div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <label class=\"control-label\" for=\"codigo\" style= \"color:#063847\">Nº Documento</label> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-4\">\n");
      out.write("                                            <input type=\"text\" name=\"txtndoc\" id=\"txtndoc\" class=\"form-control\" placeholder=\"Ingrese numero de CI\" disabled=\"\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"col-md-3\"></div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <label class=\"control-label\" for=\"carrera\"style= \"color:#000\">Carrera</label> \n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <select class=\"form-control chosen-select\" name=\"cbocarrera\" id=\"cbocarrera\">\n");
      out.write("                                                <option value=\"0\">--- Seleccione carrera ---</option>\n");
      out.write("                                                ");

                                                    Conexion cn = new Conexion();
                                                    cn.conectar();
                                                    ResultSet rsalumnos = cn.consultar("select * from carreras order by id_carrera");
                                                    while (rsalumnos.next()) {
                                                
      out.write("\n");
      out.write("                                                <option value=\"");
      out.print( rsalumnos.getString("id_carrera"));
      out.write("\"> ");
      out.print( rsalumnos.getString("descripcion"));
      out.write("</option>\n");
      out.write("                                                ");


                                                    }
                                                
      out.write("\n");
      out.write("                                            </select>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <strong><a href=\"./carreras.jsp\" style=\"text-decoration: none\"><input id=\"btnAgregarCarrera\" type=\"button\" class=\"form-control btn-primary\" value=\"Agregar Carrera\" title=\"SALIR\"></a></strong>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"col-md-3\"></div>\n");
      out.write("\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <input id=\"btnAgregar\" type=\"button\" class=\"form-control btn-primary\" value=\"Agregar\" onclick=\"agregar();\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <input id=\"btnModificar\" type=\"button\" class=\"form-control btn-primary\" value=\"Modificar\" onclick=\"modificar();\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <input id=\"btnBorrar\" type=\"button\" class=\"form-control btn-primary\" value=\"Borrar\" onclick=\"borrar();\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"col-md-3\"></div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <input id=\"btnCancelar\" type=\"button\" class=\"form-control btn-primary\" value=\"Cancelar\" disabled=\"\" onclick=\"cancelar();\"/>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <input id=\"btnGrabar\" type=\"button\" class=\"form-control btn-primary\" value=\"Grabar\" disabled=\"\" onclick=\"grabar();\"/>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\" id=\"panel\">\n");
      out.write("                                        <div class=\"col-md-3\"></div>\n");
      out.write("                                        <div class=\"col-md-6\">\n");
      out.write("                                            <table class=\"table table-hover\" id=\"grilla\">\n");
      out.write("                                                <thead>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <th class=\"primary\"style= \"color:#063847\">Código</th>\n");
      out.write("                                                        <th class=\"primary\"style= \"color:#063847\">Nombres</th>\n");
      out.write("                                                        <th class=\"primary\"style= \"color:#063847\">Apellidos</th>\n");
      out.write("                                                        <th class=\"primary\"style= \"color:#063847\">N° Documento</th>\n");
      out.write("                                                        <th class=\"hidden\">Id Carrera</th>\n");
      out.write("                                                        <th class=\"primary\"style>Carrera</th>\n");
      out.write("\n");
      out.write("                                                </thead>\n");
      out.write("                                                <tbody>\n");
      out.write("\n");
      out.write("                                                </tbody>\n");
      out.write("                                            </table>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <input type=\"hidden\" id=\"operacion\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"../js/jquery-1.12.2.min.js\"></script> \n");
      out.write("        <script src=\"../js/bootstrap.min.js\"></script> \n");
      out.write("        <script src=\"../js/alertify.js\"></script> \n");
      out.write("        <script src=\"../js/chosenselect.js\"></script> \n");
      out.write("        <script src=\"Alumno.js\"></script> \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
