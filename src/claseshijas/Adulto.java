/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseshijas;

import clasepadre.Persona;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 8/08/2021
 *
 */
public class Adulto extends Persona {

    private String trabajo;
    private double sueldo;

    public Adulto(String trabajo, double sueldo, String nombre, String apellido, String estadoCivil, int edad, String lugarProcedencia, boolean vacunado, char sexo) {
        super(nombre, apellido, estadoCivil, edad, lugarProcedencia, vacunado, sexo);
        this.trabajo = trabajo;
        this.sueldo = sueldo;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTrabajo: " + trabajo + "\nSueldo: " + sueldo;
    }

    
   
}
