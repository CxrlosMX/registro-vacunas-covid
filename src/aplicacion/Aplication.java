/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import clasepadre.Persona;
import control.RegistroPersonas;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 10/08/2021
 *
 */
public class Aplication {

    public static void main(String[] args) {
        //Creación aplicación
        int op = 0;
        Persona p;
        RegistroPersonas control = new RegistroPersonas();
        JOptionPane.showMessageDialog(null,"BIENVENIDO SEGOB","Gobierno Federal", op);
        do {
            //op=Integer.parseInt(JOptionPane.showInputDialog(null, "", null, op))

        } while (op != 3);
    }

}
