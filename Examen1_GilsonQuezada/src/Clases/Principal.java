/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class Principal {

    public static void main(String[] args) {
        Banco ban = new Banco();

        String menu = "Seleccione una de las siguientes opciones\n"
                + "1-> Registrar Cuenta Ahorro\n"
                + "2-> Registrar Cuenta Prestamo\n"
                + "3-> Registrar Cuenta Hipoteca\n"
                + "4-> Depositar o Retirar\n"
                + "5-> Depositar Cuenta Hipotecaria\n"
                + "6-> Salir";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Colas", JOptionPane.INFORMATION_MESSAGE));
            switch (op) {
                case 1://INGRESAR ELEMENTOS
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre", "Cuenta Ahorro", JOptionPane.INFORMATION_MESSAGE);
                    String tipocuenta = JOptionPane.showInputDialog(null, "Ingrese el tipo cuenta", "Cuenta Ahorro", JOptionPane.INFORMATION_MESSAGE);
                    double balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el balance o monto", "Cuenta Ahorro", JOptionPane.INFORMATION_MESSAGE));
                    double taza = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el interes ejemplo 0.14 si es 14", "Cuenta Ahorro", JOptionPane.INFORMATION_MESSAGE));
                    CuentaAhorro cuentaA = new CuentaAhorro(nombre, tipocuenta, balance, taza);
                    ban.agregar(cuentaA);
                    ban.grabar();
                    break;
                case 2://MOSTRAR ELEMENTOS
                    String nombre1 = JOptionPane.showInputDialog(null, "Ingrese el nombre", "Cuenta Prestamo", JOptionPane.INFORMATION_MESSAGE);
                    String tipocuenta1 = JOptionPane.showInputDialog(null, "Ingrese el tipo de cuenta", "Cuenta Prestamo", JOptionPane.INFORMATION_MESSAGE);
                    double balance1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el balance o monto", "Cuenta Prestamo", JOptionPane.INFORMATION_MESSAGE));
                    double taza1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el interes ejemplo 0.14 si es 14", "Cuenta Prestamo", JOptionPane.INFORMATION_MESSAGE));
                    CuentaPrestamo cuentaP = new CuentaPrestamo(nombre1, tipocuenta1, balance1, balance1);
                    ban.agregar(cuentaP);
                    ban.grabar();
                    break;
                case 3://INVERTIR Y MOSTRAR ELEMENTOS
                    String nombre2 = JOptionPane.showInputDialog(null, "Ingrese el nombre", "Cuenta Hipoteca", JOptionPane.INFORMATION_MESSAGE);
                    String tipocuenta2 = JOptionPane.showInputDialog(null, "Ingrese el tipo de cuenta", "Cuenta Hipoteca", JOptionPane.INFORMATION_MESSAGE);
                    double balance2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el balance o monto", "Cuenta Hipoteca", JOptionPane.INFORMATION_MESSAGE));
                    double taza2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el interes ejemplo 0.14 si es 14", "Cuenta Hipoteca", JOptionPane.INFORMATION_MESSAGE));
                    CuentaHipoteca cuentaH = new CuentaHipoteca(nombre2, tipocuenta2, balance2, taza2);
                    int meses = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese los meses a pagar el prestamo", "Cuenta Hipoteca", JOptionPane.INFORMATION_MESSAGE));
                    cuentaH.setMeses(meses);
                    ban.agregar(cuentaH);
                    ban.grabar();
                    break;
                case 4://SALIR
                    String menu2 = "Seleccione una de las siguientes opciones\n"
                            + "1-> Depositar \n"
                            + "2-> Retirar\n";
                    int op2 = Integer.parseInt(JOptionPane.showInputDialog(null, menu2, "Cuenta de Ahorros", JOptionPane.INFORMATION_MESSAGE));
                    switch (op2) {
                        case 1://INGRESAR ELEMENTOS
                            CuentaAhorro cuentaAH = (CuentaAhorro) ban.buscarCuentaAhorro();
                            double monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto", "Cuenta Ahorros", JOptionPane.INFORMATION_MESSAGE));
                            cuentaAH.depositar(monto);
                            System.out.println(cuentaAH.toString());
                            break;
                        case 2://INGRESAR ELEMENTOS
                            CuentaAhorro cuentaAH2 = (CuentaAhorro) ban.buscarCuentaAhorro();
                            double monto2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el monto", "Cuenta Ahorros", JOptionPane.INFORMATION_MESSAGE));
                            cuentaAH2.depositar(monto2);
                            System.out.println(cuentaAH2.toString());
                            break;    
                    }
                    ban.grabar();
                case 5://SALIR
                    CuentaHipoteca cuentaH2 = (CuentaHipoteca) ban.buscarCuentaHipoteca();
                    cuentaH2.depositarTazaInteres();
                    ban.grabar();
                    break;
                case 6://SALIR
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion valida", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        } while (op != 6);

    }

}
