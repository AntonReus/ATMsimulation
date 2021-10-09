// SolicitudSaldo.java
// Representa una transacci�n de solicitud de saldo en el ATM
package clases;

public class SolicitudSaldo extends Transaccion {

    private BaseDatosBanco baseDatosBanco = new BaseDatosBanco(); //  base de datos de informaci�n de las cuentas
    // constructor de SolicitudSaldo

    public SolicitudSaldo(int numeroCuentaUsuario) {
        super(numeroCuentaUsuario);
    } // fin del constructor de SolicitudSaldo

    // realiza la transacci�n
    public String ejecutar() {
        // obtiene referencias a la base de datos del banco y la pantalla
        //BaseDatosBanco baseDatosBanco =  new obtenerBaseDatosBanco(); Con esta linea no jala
        BaseDatosBanco baseDatosBanco = new BaseDatosBanco();
        double saldoDisponible = 0;
        try {
            saldoDisponible = baseDatosBanco.obtenerSaldoDisponible(obtenerNumeroCuenta());
        } catch (Exception e) {
            System.out.print(e);
        }
        // obtiene el saldo disponible para la cuenta implicada

        // obtiene el saldo total para la cuenta implicada
        double saldoTotal = 0;
        try {
            saldoTotal = baseDatosBanco.obtenerSaldoTotal(obtenerNumeroCuenta());
        } catch (Exception e) {
            System.out.print(e);
        }

        return String.valueOf(saldoDisponible + "-" + saldoTotal);
    } // fin del m�todo ejecutar
} // fin de la clase SolicitudSaldo



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
