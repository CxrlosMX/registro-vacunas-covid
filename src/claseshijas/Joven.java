/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseshijas;

import clasepadre.Persona;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 8/08/2021
 *
 */
public class Joven extends Persona {

    private boolean isEstudiante;

    public Joven(boolean isEstudiante, String nombre, String apellido, String estadoCivil, int edad, String lugarProcedencia, boolean vacunado, char sexo) {
        super(nombre, apellido, estadoCivil, edad, lugarProcedencia, sexo);
        this.isEstudiante = isEstudiante;
    }

    //Si es estudiante, asignaremos el grado escolar segun su edad
    private String dameGrado() {

        if (this.isEstudiante) {
            int n = super.getEdad();
            if (n >= 6 && n <= 11) {
                return "Primaria";
            } else if (n >= 12 && n <= 14) {
                return "Secundaria";
            } else if (n >= 15 && n <= 17) {
                return "Bachillerato";
            } else {
                return "Universidad";
            }
        } else {
            return null;
        }

    }
    //Método get y set

    public boolean isIsEstudiante() {
        return isEstudiante;
    }

    public void setIsEstudiante(boolean isEstudiante) {
        this.isEstudiante = isEstudiante;
    }

  

    //Método para mostrar los datos 
    @Override
    public String toString() {
        return super.toString() + "\nEstudiante: " + ((isEstudiante) ? "Si" : "No") + ((isEstudiante) ? "\nGrado: " + this.dameGrado() : "");
    }

}
