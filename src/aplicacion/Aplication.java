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
        int op = 0, op2 = 0, x = 0;
        String curp;
        Persona p;
        RegistroPersonas control = new RegistroPersonas();
        JOptionPane.showMessageDialog(null, "BIENVENIDO SEGOB", "Gobierno Federal", -1);
        do {
            try {

                op = Integer.parseInt(JOptionPane.showInputDialog(null, "REGISTRO CAMPAÑA VACUNACIÓN\n"
                        + "1.-Iniciar Sesión\n"
                        + "2.-Registrarse\n"
                        + "3.-Cerrar Programa", "Camapaña Vacunación", 3));
                switch (op) {
                    case 1: {
                        if (control.noVacia()) {
                            curp = JOptionPane.showInputDialog(null, "Introduce tu Curp para iniciar sesión", "Introduce CURP", 1);
                            p = control.iniciarSesion(curp);
                            if (p == null) {
                                JOptionPane.showMessageDialog(null, "CURP no encontrada", "Error", 0);
                                do {
                                    x = JOptionPane.showOptionDialog(null, "            Desea seguir?", "Seguir Introduciendo CURP", JOptionPane.YES_NO_OPTION, 1, null, null, null);
                                    if (x == 0) {
                                        curp = JOptionPane.showInputDialog(null, "Introduce tu Curp para iniciar sesión", "Introduce CURP", 1);
                                        p = control.iniciarSesion(curp);
                                        if (p == null) {
                                            JOptionPane.showMessageDialog(null, "CURP no encontrada", "Error", 0);
                                        }
                                    } else {
                                        break;
                                    }
                                } while (p == null);

                            }
                            if (p != null) { //Cuando el valor de P sea diferente a nulo, osea si tiene valores
                                JOptionPane.showMessageDialog(null, "Bienvenido " + p.getNombre(), "Bienvenido", 1);
                                do {
                                    try {
                                        op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "         GOBF MIS DATOS\n1.-Vacunarse\n"
                                                + "2-", "Bienvenido", 3));
                                        switch (op2) {
                                            case 1: {
                                                control.vacunar(p.getCurp());
                                                break;
                                            }
                                            //Caso 2
                                            case 2: {

                                                break;
                                            }
                                            case 3: {

                                                break;
                                            }
                                            default: {
                                                JOptionPane.showMessageDialog(null, "Introduce valores correctos", "Valores Incorrectos", 2);
                                                break;
                                            }
                                        }
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", 0);
                                    }
                                } while (op2 != 3);

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El registro se encuentra parcialmente vacio", "Registro Vacio", 2);
                        }

                        break;
                    }
                    case 2: {
                        p = control.dameObjetoPersona();
                        control.registrarPersona(p);
                        break;
                    }
                    case 3: {
                        JOptionPane.showMessageDialog(null, "Cerrando Programa", "Saliendo", 1);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Introduce valores correctos", "Valores Incorrectos", 2);
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", 0);
            }
        } while (op != 3);
    }

}
