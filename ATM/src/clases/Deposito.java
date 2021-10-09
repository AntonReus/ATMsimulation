// Deposito.java
// Representa una transacci�n de dep�sito en el ATM
package clases;

import form.FrmMenDeposito;

public class Deposito extends Transaccion {

    private double monto; // monto a depositar
    RanuraDeposito ranuraDeposito = new RanuraDeposito(); // referencia a la ranura de dep�sito
    private final static int CANCELO = 0; // constante para la opci�n de cancelar

    // constructor de Deposito
    public Deposito(int numeroCuentaUsuario, BaseDatosBanco baseDatosBanco) {
        // inicializa las variables de la superclase
        super(numeroCuentaUsuario);
    } // fin del constructor de Deposito

    // realiza la transacci�n
    public String ejecutar() {
        BaseDatosBanco baseDatosBanco = new BaseDatosBanco(); // obtiene la referencia
        FrmMenDeposito menDep = new FrmMenDeposito();
        monto = menDep.op;

        baseDatosBanco.abonar(obtenerNumeroCuenta(), monto);
        return "\nSe recibio su sobre de "
                + "deposito.\nNOTA: El dinero que acaba de depositar no "
                + "estara disponible sino hasta que verifiquemos el monto del "
                + "efectivo y cualquier cheque incluido.";
    } // fin del m�todo ejecutar

} // fin de la clase Deposito



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
