/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author CxrlosMX
 */
public interface Metodos {

    static String[] estadoCivil = {"Soltero", "Casado", "Divorciado", "Viudo"};

    static int generarNumero(int min, int max) { //Método que genera un numero
        return (int) Math.floor(Math.random() * (max - min + 1)) + min;
    }
    
    static char[] sexo={'H','M'};

}
