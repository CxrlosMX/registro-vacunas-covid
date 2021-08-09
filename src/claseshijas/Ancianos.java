/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseshijas;

import clasepadre.Persona;
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
public class Ancianos extends Persona {

    private boolean somePadecimiento;
    private String p;

    public Ancianos(boolean somePadecimiento, String nombre, String apellido, String estadoCivil, int edad, String lugarProcedencia, boolean vacunado, char sexo) {
        super(nombre, apellido, estadoCivil, edad, lugarProcedencia, vacunado, sexo);
        this.somePadecimiento = somePadecimiento;
        p = givePadecimiento();
    }

    //Método que te pregunta tu enfermedad
    private String givePadecimiento() {
        if (this.somePadecimiento) {
            return JOptionPane.showInputDialog(null, "Introduce tu padecimiento", "Introduciendo Padecimiento", 1);
        } else {

            return null;
        }

    }

    //Métodos get y set
    public boolean isSomePadecimiento() {
        return somePadecimiento;
    }

    public void setSomePadecimiento(boolean somePadecimiento) {
        this.somePadecimiento = somePadecimiento;
    }

    //Datos
    @Override
    public String toString() {
        return super.toString() + "\nPadecimiento: " + ((somePadecimiento) ? "Si" : "No") + ((this.somePadecimiento) ? "Tipo de Padecimiento: " + p : "");
    }

}
