/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Lourdes Lezcano
 */
public class Usuario {
      private int cantidad = 0;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad() {
        this.cantidad = getCantidad() + 1;
    }

    public void iniciar() {
        this.cantidad = 0;
    }
}
