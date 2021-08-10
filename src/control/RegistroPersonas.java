/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import clasepadre.Persona;
import java.util.ArrayList;
import java.util.List;

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
    
    //Método para verificar si nuestra lista esta vacia
    public boolean estaVacia(){
    return (this.contador==-1); //La lista esta vacia si el contador es igual a -1
    }

}
