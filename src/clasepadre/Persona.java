/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasepadre;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import metodos.Metodos;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 6/08/2021
 *
 */
public  class Persona {
    /*
     Aplicacón basica que simula el registro nacional de la campaña de vacunación contra el COVID
     */

    /*
     Atributos de la clase persona
    
     */
    private String nombre;
    private String apellido;
    private String estadoCivil;
    private String curp;
    private int edad;
    private String lugarProcedencia;
    private boolean vacunado;
    private char sexo;

    //Constructor
    public Persona(String nombre, String apellido, String estadoCivil, int edad, String lugarProcedencia, char sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        //Comprobamos el estado civil
        comprobarEstadoCivil(estadoCivil);
        //La curp se genera automaticamente
        this.curp = generarCurp();
        //Necesitamos verificar que la edad sea mayor a 0
        this.verificarEdad(edad);
        this.lugarProcedencia = lugarProcedencia;
        this.vacunado = false;
        //Verificamos que el sexo sea correcto
        this.verificarSexo(sexo);
    }

    //Métodos de comprobación
    //Comprobamos si el estado civil es correcto 
    private void comprobarEstadoCivil(String estadoC) {
        boolean encontrado = false;
        for (int i = 0; i < Metodos.estadoCivil.length && !encontrado; i++) {
            if (Metodos.estadoCivil[i].equalsIgnoreCase(estadoC)) {
                encontrado = true;
                this.estadoCivil = estadoC;
            }
        }
        if (!encontrado) {
            this.estadoCivil = "S/N";
        }
    }

    //Método para generar la curp
    private String generarCurp() {
        int n = 0;
        String cadena = "";
        char l;
        for (int i = 0; i < 5; i++) {
            n = Metodos.generarNumero(1, 2);

            if (n == 1) { //Generaremos una letra
                n = Metodos.generarNumero(65, 91);
                l = (char) n;
                cadena += l;
            } else { //Generamos una letra
                n = Metodos.generarNumero(48, 58);
                l = (char) n;
                cadena += l;
            }
        }

        return cadena;
    }

    //Método para verificar la edad
    private void verificarEdad(int e) {
        if (e >=10) {
            this.edad = e;
        } else {
            JOptionPane.showMessageDialog(null, "Introduce una edad correcta", "Solo valores mayores a 0", 2);
            boolean itsOK = false;
            do {
                int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce tu edad", "Introduciendo edad", 1));
                if (edad >= 10) {
                    this.edad = edad;
                    itsOK = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Introduce una edad correcta", "Solo valores mayores a 0", 2);
                }
            } while (!itsOK);
        }
    }

    //Método para verificar el Sexo
    private void verificarSexo(char sex) {
        boolean encontrado = false;
        for (int i = 0; i < Metodos.sexo.length && !encontrado; i++) {
            if (Metodos.sexo[i] == sex) {
                encontrado = true;
                this.sexo = sex;
            }
        }
        if (!encontrado) {
            this.sexo = 'U';
        }
    }

    //Método Vacunar
    public void vacunar(){
     if (!isVacunado()) {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();
            JOptionPane.showMessageDialog(null, "Vacunado contra el COVID-19" + "\nHora: " + dateFormat.format(date), "Vacunado", 1);
            setVacunado(true);
        } else {
            JOptionPane.showMessageDialog(null, "Usted ya recibio la dosis", "Usuario ya vacunado", 2);
        }
    }

    //Métodos get y sets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getLugarProcedencia() {
        return lugarProcedencia;
    }

    public void setLugarProcedencia(String lugarProcedencia) {
        this.lugarProcedencia = lugarProcedencia;
    }

    public boolean isVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    //Método que imprime los datos

    @Override
    public String toString() {
        return   "Nombre: " + nombre + "\nApellido: " + apellido + "\nEstado Civil: " + estadoCivil + "\nCurp: " + curp + "\nEdad: " + edad +" años"+ "\nLugar de Procedencia: " + lugarProcedencia + "\nVacunado: " + ((vacunado)?"Si": "No") + "\nSexo: " + sexo ;
    }
    
}
