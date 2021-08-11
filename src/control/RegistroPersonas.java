/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clasepadre.Persona;
import claseshijas.Adulto;
import claseshijas.Ancianos;
import claseshijas.Joven;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
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
        int x = 0;

        String nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre", "Nombre", 1);
        String apellido = JOptionPane.showInputDialog(null, "Introduce tu apellido", "Apellido", 1);
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce tu edad", "Edad", 1));
        String lugarProcedencia = JOptionPane.showInputDialog(null, "Introduce tu Lugar de Procedencia", "Localidad/Ciudad", 1);
        String estadoCivil = JOptionPane.showInputDialog(null, "Introduce tu estado Civil", "Estado Civil", 1);
        /*
         Opción para definir el sexo con JOption
         */
        Object arreglo[] = {'H', 'M'};
        x = JOptionPane.showOptionDialog(null, "            Elige el Sexo", "Sexo", JOptionPane.DEFAULT_OPTION, 1, null, arreglo, null);
        char sexo;
        if (x == 0) {
            sexo = 'H';
        } else {
            sexo = 'M';
        }
        //Joven
        if (edad >= 10 && edad <= 20) {
            boolean isEstudiante;
            Object a[] = {"Si", "No"};
            x = JOptionPane.showOptionDialog(null, "            Es Estudiante", "Verificar Estudios", JOptionPane.DEFAULT_OPTION, 1, null, a, null);
            if (x == 0) {
                isEstudiante = true;
            } else {
                isEstudiante = false;
            }
            return new Joven(isEstudiante, nombre, apellido, estadoCivil, edad, lugarProcedencia, isEstudiante, sexo);
        } else if (edad >= 21 && edad <= 40) { //Adulto
            String trabajo = JOptionPane.showInputDialog(null, "Que tipo de trabajo realizar", "Trabajo", 1);
            double sueldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Cual es su sueldo ?", "Sueldo", 1));
            return new Adulto(trabajo, sueldo, nombre, apellido, estadoCivil, edad, lugarProcedencia, true, sexo);
        } else { //Anciano
            boolean somePadecimiento;
            Object a[] = {"Si", "No"};
            x = JOptionPane.showOptionDialog(null, "           Algun Padecimiento", "Verificar Padecimiento", JOptionPane.DEFAULT_OPTION, 1, null, a, null);
            if (x == 0) {
                somePadecimiento = true;
            } else {
                somePadecimiento = false;
            }
            return new Ancianos(somePadecimiento, nombre, apellido, estadoCivil, edad, lugarProcedencia, somePadecimiento, sexo);
        }

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
     Método para registrar una persona
     */
    public void registrarPersona(Persona p) {
        lista.add(p);
        JOptionPane.showMessageDialog(null, "Usted ha sido registrado con exito\nCurp:" + p.getCurp(), "Registro", 1);
        contador++;
    }

    /*
     Muestra el registro completo sin excepciones
     */
    public void mostrarDatosGenerales() {
        if (this.noVacia()) {
            String cadena = "";
            for (Persona i : lista) {
                cadena = cadena + "\n" + i;
            }
            JOptionPane.showMessageDialog(null, cadena, "Registro Federal", 1);
        } else {
            JOptionPane.showMessageDialog(null, "El registro se encuentra vacio", "Registro Vacio", 0);
        }
    }
    /*
     Muestra solo los datos de un tipo de persona
     */

    public void mostrarDatosPersonales(int j) {
        if (this.noVacia()) {
            String cadena = "";
            for (Persona i : lista) {
                if (j == 1) { //Joven
                    if (i instanceof Joven) {
                        cadena = cadena + "\n" + i;
                    }
                }
                if (j == 2) {//Adulto
                    if (i instanceof Adulto) {
                        cadena = cadena + "\n" + i;
                    }
                } else { //Anciano
                    cadena = cadena + "\n" + i;
                }
            }
            JOptionPane.showMessageDialog(null, cadena, "Registro " + ((j == 1) ? "Jovenes" : (j == 2) ? "Adultos" : "Ancianos"), 1);
        } else {
            JOptionPane.showMessageDialog(null, "El registro se encuentra vacio", "Registro Vacio", 0);
        }
    }

    //Método para mostrar solo a las personas vacunadas
    public void mostrasVacunados() {
        if (this.noVacia()) {
            String cadena = "";
            for (Persona i : lista) {
                if (i.isVacunado()) {
                    cadena = cadena + "\n" + i;
                }
            }
            JOptionPane.showMessageDialog(null, "Personas Vacunadas\n" + cadena, "Lista Personas Vacunadas", 1);

        } else {
            JOptionPane.showMessageDialog(null, "El registro esta vacio", "Registro Vacio", 2);
        }
    }

    //Método para mostrar las personas que no se han vacunado
    public void mostrarNoVacunados() {
        if (this.noVacia()) {
            String cadena = "";
            for (Persona i : lista) {
                if (!i.isVacunado()) {
                    cadena = cadena + "\n" + i;
                }
            }
            JOptionPane.showMessageDialog(null, "Personas No Vacunadas\n" + cadena, "Lista Personas No Vacunadas", 1);

        } else {
            JOptionPane.showMessageDialog(null, "El registro esta vacio", "Registro Vacio", 2);
        }
    }

    //Método para buscar una persona
    public void buscarPersona(String curp) {
        boolean encontrado = false;
        for (int i = 0; i < lista.size() && !encontrado; i++) {
            if (lista.get(i).getCurp().equalsIgnoreCase(curp)) {
                encontrado = true;
                JOptionPane.showMessageDialog(null, lista.get(i), "Persona encontrada", 1);
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Persona no encontrada", "Error de busqueda", 2);
        }
    }

    /*
     Método para vacunar
     */
    public void vacunar(String curp) {
        boolean encontrado = false;
        for (int i = 0; i < lista.size() && !encontrado; i++) {
            if (lista.get(i).getCurp().equals(curp)) {
                encontrado = true;
                lista.get(i).vacunar();
            }
        }
    }

    //Método para verificar si nuestra lista esta vacia
    public boolean noVacia() {
        return (this.contador != -1); //La lista esta vacia si el contador es igual a -1
    }

}
