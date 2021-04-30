/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lourdes Lezcano
 */
public class Conexion {
    public Connection cn;
    public Statement st;
    public ResultSet rs;
    
    public void conectar() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/examen","postgres","123");
    }
    
   public ResultSet consultar(String sql) throws SQLException{ 
        st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = st.executeQuery(sql);
        return rs;
    } 
    
    public void actualizar(String sql) throws SQLException{
        st = cn.createStatement();
        st.executeUpdate(sql);
    }
    
    public void desconectar() throws SQLException{
        st.close();
        cn.close();
    }
}
