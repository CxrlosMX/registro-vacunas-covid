/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clasepadre.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import metodos.Metodos;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 8/08/2021
 *
 */
public class RegistroPersonas {

    private ArrayList<Persona> lista;
    private int contador;

    public RegistroPersonas() {
        lista = new ArrayList<Persona>();
        contador = -1;
    }
    /*
     Método para rellenar los valores
     -Segun la edad nos devolvera el tipo de Personas 
     */

    public Persona dameObjetoPersona() {
        Persona p = null;
        String nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre", "Nombre", 1);
        String apellido = JOptionPane.showInputDialog(null, "Introduce tu apellido", "Apellido", 1);
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce tu edad", "Edad", 1));
        String lugarProcedencia = JOptionPane.showInputDialog(null, "Introduce tu Lugar de Procedencia", "Localidad/Ciudad", 1);
        String estadoCivil = JOptionPane.showInputDialog(null, "Introduce tu estado Civil", "Estado Civil", 1);
        /*
         Opción para definir el sexo con JOption
         */
        Object arreglo[] = {'H', 'M'};
        int x = JOptionPane.showOptionDialog(null, "            Elige el Sexo", "Sexo", JOptionPane.DEFAULT_OPTION, 1, null, arreglo, null);
        char sexo;
        if (x == 0) {
            sexo = 'H';
        } else {
            sexo = 'M';
        }

        return p;
    }

    /*
     Método para inciar sesión
     *-Este método nos devuelve la personas  que inicia sesión
     */
    public Persona iniciarSesion(String curp) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCurp().equals(curp)) {
                return lista.get(i);

            }
        }
        return null;
    }

    /*
    
     */
    //Método para verificar si nuestra lista esta vacia
    public boolean estaVacia() {
        return (this.contador == -1); //La lista esta vacia si el contador es igual a -1
    }

}
