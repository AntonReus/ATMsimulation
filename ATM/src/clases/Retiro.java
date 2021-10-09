// Retiro.java
// Representa una transacci�n de retiro en el ATM
package clases;

import form.FrmMenRetiro;

public class Retiro extends Transaccion {

    private int monto; // monto a retirar
    DispensadorEfectivo dispensadorEfectivo = new DispensadorEfectivo(); // referencia al dispensador de efectivo

    // constante que corresponde a la opci�n del men� a cancelar
    private final static int CANCELO = 6;

    // constructor de Retiro
    public Retiro(int numeroCuentaUsuario, BaseDatosBanco baseDatosBanco) {
        // inicializa las variables de la superclase
        super(numeroCuentaUsuario);
    } // fin del constructor de Retiro

    // realiza la transacci�n
    public String ejecutar() {
        FrmMenRetiro menR = new FrmMenRetiro();
        monto = menR.op;
        boolean efectivoDispensado = false; // no se ha dispensado a�n el efectivo
        double saldoDisponible; // monto disponible para retirar

        // obtiene referencias a la base de datos del banco y la pantalla
        BaseDatosBanco baseDatosBanco = new BaseDatosBanco();

        // obtiene el saldo disponible de la cuenta implicada
        saldoDisponible = baseDatosBanco.obtenerSaldoDisponible(obtenerNumeroCuenta());
        System.out.println("Saldo disponible: " + saldoDisponible);

        // comprueba si el usuario tiene suficiente dinero en la cuenta 
        if (monto <= saldoDisponible) {
            // comprueba si el dispensador de efectivo tiene suficiente dinero
            if (dispensadorEfectivo.haySuficienteEfectivoDisponible(monto)) {
                // actualiza la cuenta implicada para reflejar el saldo
                baseDatosBanco.cargar(obtenerNumeroCuenta(), monto);

                dispensadorEfectivo.dispensarEfectivo(monto); // dispensar efectivo
                efectivoDispensado = true; // se dispens� el efectivo

                // instruye al usuario que tome efectivo
                return "\nTome ahora su efectivo.";
            } // fin de if
            else // el dispensador no tiene suficiente efectivo
            {
                return "\nNo hay suficiente efectivo disponible en el ATM."
                        + "\n\nSeleccione un monto menor.";
            }
        } // fin de if
        else // no hay suficiente dinero disponible en la cuenta del usuario
        {
            return "\nNo hay suficientes fondos en su cuenta."
                    + "\n\nSeleccione un monto menor.";
        } // fin de else
    } // fin del m�todo ejecutar
} // fin de la clase Retiro



/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/
