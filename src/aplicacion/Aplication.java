/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import clasepadre.Persona;
import control.RegistroPersonas;
import javax.swing.ImageIcon;
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
        //Variables de uso-----
        int op = 0, op2 = 0, op3 = 0, x = 0, n = 0;
        String curp;
        Persona p;
        //-----
        RegistroPersonas control = new RegistroPersonas();
        //Mensaje bienvenida
        JOptionPane.showMessageDialog(null, "SECRETARIA DE SALUD", "Gobierno Federal", -1, new ImageIcon("recursos/logo.jpg"));

        //Ménu principal
        do {
            try {

                op = Integer.parseInt(JOptionPane.showInputDialog(null, "REGISTRO CAMPAÑA VACUNACIÓN\n"
                        + "1.-Iniciar Sesión\n"
                        + "2.-Registrarse\n"
                        + "3.-Buscar mi Información\n"
                        + "4.-Registros\n"
                        + "5.-Cerrar Programa", "Camapaña Vacunación", 3));
                switch (op) {
                    case 1: {
                        if (control.noVacia()) {
                            curp = JOptionPane.showInputDialog(null, "Introduce tu CURP para iniciar sesión", "Introduce CURP", 1);
                            p = control.iniciarSesion(curp);
                            if (p == null) {
                                JOptionPane.showMessageDialog(null, "CURP no encontrada", "Error", 0, new ImageIcon("recursos/error.png"));
                                do {
                                    x = JOptionPane.showOptionDialog(null, "            Desea seguir intentando iniciar sesión?", "Seguir Introduciendo CURP", JOptionPane.YES_NO_OPTION, 1, null, null, null);
                                    if (x == 0) {
                                        curp = JOptionPane.showInputDialog(null, "Introduce tu CURP para iniciar sesión", "Introduce CURP", 1);
                                        p = control.iniciarSesion(curp);
                                        if (p == null) {
                                            JOptionPane.showMessageDialog(null, "CURP no encontrada", "Error", 0, new ImageIcon("recursos/error.png"));
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
                                        op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "GOBF MIS DATOS\n1.-Vacunarse\n"
                                                + "2.-Mis Datos\n"
                                                + "3.-Mostrar Personas Registradas\n"
                                                + "4.-Cerrar Sesión", "Bienvenido", 3));
                                        switch (op2) {
                                            case 1: {//Vacunarse
                                                control.vacunar(p.getCurp());
                                                break;
                                            }
                                            //Caso Datos generales
                                            case 2: {
                                                JOptionPane.showMessageDialog(null, p, "Mis datos", 1);
                                                break;
                                            }
                                            case 3: {
                                                control.mostrarDatosGenerales();
                                                break;
                                            }
                                            case 4: {
                                                JOptionPane.showMessageDialog(null, "Cerrando Sesión", "Saliendo al menu principal", 1);
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
                                } while (op2 != 4);

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
                    case 3: { //Método para buscar datos por nombtr
                        if (control.noVacia()) {
                            curp = JOptionPane.showInputDialog(null, "Introdusca su Nombre", "Introduciendo Nombre", 1);
                            control.buscarPersona(curp);
                        } else {
                            JOptionPane.showMessageDialog(null, "El registro se encuentra parcialmente vacio", "Registro Vacio", 2);
                        }
                        break;
                    }
                    case 4: {
                        if (control.noVacia()) {
                            do {
                                try {
                                    op3 = Integer.parseInt(JOptionPane.showInputDialog(null, "REGISTROS"
                                            + "\n1.-Seleccionar Registro\n"
                                            + "2.-Mostrar Registro Vacunados\n"
                                            + "3.-Mostrar Registro No Vacunados\n"
                                            + "4.-Salir al menu principal\n¿Elija una opción?", "MENU REGISTRO", 3));
                                    switch (op3) {
                                        case 1: {
                                            Object[] a = {"Jovenes", "Adultos", "Ancianos"};
                                            x = JOptionPane.showOptionDialog(null, "Mostrar:", "Elija una opción", JOptionPane.DEFAULT_OPTION, 1, null, a, null);
                                            if(x==0){
                                            control.mostrarDatosPersonales(1);
                                            }
                                            else if(x==1){
                                           control.mostrarDatosPersonales(2);
                                            }
                                            else {
                                            control.mostrarDatosPersonales(3);
                                            }
                                            
                                            break;
                                        }
                                        case 2: {
                                            control.mostrasVacunados();
                                            break;
                                        }
                                        case 3: {
                                            control.mostrarNoVacunados();
                                            break;
                                        }
                                        case 4: {
                                            JOptionPane.showMessageDialog(null, "Saliendo al menu principal", "Saliendo", 1);
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

                            } while (op3 != 4);
                        } else {
                            JOptionPane.showMessageDialog(null, "El registro se encuentra parcialmente vacio", "Registro Vacio", 2);
                        }
                        break;
                    }
                    case 5: {
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
        } while (op != 5);
    }

}
