/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lourdes Lezcano
 */
public class Metodo {
      public static void cargarTabla(JTable tabla, Object[] datos) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addRow(datos);
    }

    public static void limpiarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
    }

    public static void eliminarFila(JTable tabla, int fila) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.removeRow(fila);
    }

    public static String ultimoCodigo(String campo, String tabla) {
        String cod = "";

        Conexion cn = new Conexion();
        try {
            cn.conectar();
            ResultSet codigo = cn.consultar("select coalesce(max(" + campo + "),0)+1 as codigo from " + tabla);
            codigo.next();
            cod = codigo.getString("codigo");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Metodo.class.getName()).log(Level.SEVERE, null, ex);

        } catch (SQLException ex) {
            Logger.getLogger(Metodo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cod;
    }

    public static boolean evitarDuplicado(String tabla, String campoBD, String dato, String pk, String codigo) {

        Conexion cn = new Conexion();
        try {
            cn.conectar();
            ResultSet duplicado = cn.consultar("select * from " + tabla + " where upper(" + campoBD + ") = '" + dato.toUpperCase() + "' and " + pk + " != " + codigo);
            return duplicado.isBeforeFirst();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Metodo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static void cargarCombo(JComboBox combo, String campos, String tabla) {
        Conexion cn = new Conexion();
        try {
            cn.conectar();
            System.out.println("select " + campos + " as datos from " + tabla);
            ResultSet datos = cn.consultar("select " + campos + " as datos from " + tabla);
            combo.removeAllItems();
            if (datos.isBeforeFirst()) {
                while (datos.next()) {
                    combo.addItem(datos.getString("datos"));
                }
            } else {
                JOptionPane.showMessageDialog(null, "NO HAY REGISTROS EN " + tabla.toUpperCase());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Metodo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Metodo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
