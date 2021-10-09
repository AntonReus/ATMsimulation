/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author elagu
 */
public class CArchivo {

    public String leerBD() {
        File path = new File(".");
        String pathIni = "";
        try {
            pathIni = path.getCanonicalPath();
        } catch (Exception e) {
        }
        try {
            FileReader lee = new FileReader(pathIni + "\\Num Ctas ATM.txt");
            BufferedReader br = new BufferedReader(lee);
            String aux, cadena = "";

            while ((aux = br.readLine()) != null) {
                cadena = cadena + aux + " ";
            }

            return cadena;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    public String[] getCuentas() {
        int filas = obtenerFilas();
        String[] cuentas = new String[filas];
        String cadenaBD = leerBD();
        cuentas = cadenaBD.split(" ");
        return cuentas;
    }

    public boolean buscarCuenta(int ncuenta) {
        File path = new File(".");
        String pathIni = "", aux = "";
        try {
            pathIni = path.getCanonicalPath();
        } catch (Exception e) {
        }
        try {
            FileReader lee = new FileReader(pathIni + "\\Num Ctas ATM.txt");
            BufferedReader br = new BufferedReader(lee);

            //Lee linea por linea a los usuarios registrados en la base de datos
            while ((aux = br.readLine()) != null) {
                //Separa los datos por el signo "-" siendo estos nnnnnn-ccccc-nnnnnn-$$$$$$
                String[] parts = aux.split(",");
                //Si la cuenta coincide con lo que está en la base de datos
                if (parts[0].equals(String.valueOf(ncuenta))) {
                    return true;
                }
            }
            return false;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public int obtenerFilas() {
        int n = 0;
        String aux;
        File path = new File(".");
        String pathIni = "";
        try {
            pathIni = path.getCanonicalPath();
        } catch (Exception e) {
        }
        try {
            FileReader lee = new FileReader(pathIni + "\\Num Ctas ATM.txt");
            BufferedReader br = new BufferedReader(lee);
            while ((aux = br.readLine()) != null) {
                n++;
            }
        } catch (Exception e) {
        }
        return n;
    }

    public void modificarSaldo(int ncuenta, int nip, double monto, int tipo) {
        //1: depósito
        //2: retiro
        //3: confirmación depósito
        File path = new File(".");
        String pathIni = "", aux = "", cadena = "", modificar = "";
        try {
            pathIni = path.getCanonicalPath();
        } catch (Exception e) {
        }
        try {
            FileReader lee = new FileReader(pathIni + "\\Num Ctas ATM.txt");
            BufferedReader br = new BufferedReader(lee);

            //Lee linea por linea a los usuarios registrados en la base de datos
            while ((aux = br.readLine()) != null) {
                //Separa los datos por el signo "-" siendo estos nnnnnn-ccccc-nnnnnn-$$$$$$
                String[] parts = aux.split(",");
                //Si la cuenta coincide con lo que está en la base de datos
                if (parts[0].equals(String.valueOf(ncuenta))) {
                    //Modificar obtiene el valor nnnnnn-ccccc-nnnnnn-$$$$$$ de la linea que se lee
                    modificar = aux;
                } else {
                    //Cadena va obteniendo los valores de la base de datos linea por linea separados por " " (Un espacio)
                    cadena = cadena + aux + " ";
                }
            }
            //parts obtiene los valores de modificar por el signo "," siendo estos nnnnnn-ccccc-nnnnnn-$$$$$$
            String[] parts = modificar.split(",");
            //Se guarda la información en vairables
            String noCuenta_actual = parts[0], nip_actual = parts[1];
            //Se obtiene el monto actual de la base de datos
            double sdisp_actual = Double.parseDouble(parts[2]);
            double stotal_actual = Double.parseDouble(parts[3]);
            switch (tipo) {
                case 1:
                    //Si el tipo de cambio en la base de datos es un depósito se hace esta operación
                    stotal_actual = stotal_actual + monto;
                    break;
                case 2:
                    //Si el tipo de cambio en la base de datos es un retiro se hace esta operación
                    sdisp_actual = sdisp_actual - monto;
                    stotal_actual = stotal_actual - monto;
                    break;
                case 3:
                    //Si el tipo de cambio en la base de datos es una confirmación de depósito se hace esta operación
                    sdisp_actual = stotal_actual;
                    break;
            }
            //Se obtiene la nueva cadena del perfil que se modifica y se almacenará en la base de datos
            String nueva_cadena = cadena + noCuenta_actual + "," + nip_actual
                    + "," + String.valueOf(sdisp_actual) + "," 
                    + String.valueOf(stotal_actual);
            File archivo = new File(pathIni + "\\Num Ctas ATM.txt");
            PrintWriter escribe = new PrintWriter(archivo, "UTF-8");
            String newparts[] = nueva_cadena.split(" ");
            int i = 0;
            for (String e : newparts) {
                escribe.println(newparts[i]);
                i++;
            }
            escribe.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void crearCuenta(int cuenta, int nip) {
        boolean existe = buscarCuenta(cuenta);
        if (!existe) {
            File path = new File(".");
            String pathIni = "", aux = "", cadena = "";
            String modificar = String.valueOf(cuenta) + ","
                    + String.valueOf(nip) + "," + "0.00" + "," + "0.00" + " ";
            try {
                pathIni = path.getCanonicalPath();
            } catch (Exception e) {
            }
            try {
                FileReader lee = new FileReader(pathIni + "\\Num Ctas ATM.txt");
                BufferedReader br = new BufferedReader(lee);

                //Lee linea por linea a los usuarios registrados en la base de datos
                while ((aux = br.readLine()) != null) {
                    //Cadena va obteniendo los valores de la base de datos linea por linea separados por " " (Un espacio)
                    cadena = cadena + aux + " ";
                }
                //parts obtiene los valores de modificar por el signo "," siendo estos nnnnnn-ccccc-nnnnnn-$$$$$$
                //Se obtiene la nueva cadena del perfil que se modifica y se almacenará en la base de datos
                String nueva_cadena = cadena + modificar;

                File archivo = new File(pathIni + "\\Num Ctas ATM.txt");
                PrintWriter escribe = new PrintWriter(archivo, "UTF-8");
                String newparts[] = nueva_cadena.split(" ");
                int i = 0;
                for (String e : newparts) {
                    escribe.println(newparts[i]);
                    i++;
                }
                escribe.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void borrarCuenta(int ncuenta) {
        File path = new File(".");
        String pathIni = "", aux = "", cadena = "", modificar = "";
        try {
            pathIni = path.getCanonicalPath();
        } catch (Exception e) {
        }
        try {
            FileReader lee = new FileReader(pathIni + "\\Num Ctas ATM.txt");
            BufferedReader br = new BufferedReader(lee);

            //Lee linea por linea a los usuarios registrados en la base de datos
            while ((aux = br.readLine()) != null) {
                //Separa los datos por el signo "-" siendo estos nnnnnn-ccccc-nnnnnn-$$$$$$
                String[] parts = aux.split(",");
                //Si la cuenta coincide con lo que está en la base de datos
                if (parts[0].equals(String.valueOf(ncuenta))) {
                    //Modificar obtiene el valor nnnnnn-ccccc-nnnnnn-$$$$$$ de la linea que se lee
                    modificar = aux;
                } else {
                    //Cadena va obteniendo los valores de la base de datos linea por linea separados por " " (Un espacio)
                    cadena = cadena + aux + " ";
                }
            }
            //parts obtiene los valores de modificar por el signo "," siendo estos nnnnnn-ccccc-nnnnnn-$$$$$$
            //Se obtiene la nueva cadena del perfil que se modifica y se almacenará en la base de datos
            String nueva_cadena = cadena;

            File archivo = new File(pathIni + "\\Num Ctas ATM.txt");
            PrintWriter escribe = new PrintWriter(archivo, "UTF-8");
            String newparts[] = nueva_cadena.split(" ");
            int i = 0;
            for (String e : newparts) {
                escribe.println(newparts[i]);
                i++;
            }
            escribe.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
