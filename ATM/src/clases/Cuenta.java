// Cuenta.java
// Represents a bank account
package clases;

public class Cuenta {

    private int numeroCuenta; // n�mero de cuenta
    private int nip; // NIP para autenticaci�n
    private double saldoDisponible; // fondos disponibles para retirar
    private double saldoTotal; // fondos disponibles + dep�sitos pendientes
    private CArchivo archivos = new CArchivo();

    // el constructor de Cuenta inicializa los atributos
    public Cuenta(int elNumeroDeCuenta, int elNIP,
            double elSaldoDisponible, double elSaldoTotal) {
        numeroCuenta = elNumeroDeCuenta;
        nip = elNIP;
        saldoDisponible = elSaldoDisponible;
        saldoTotal = elSaldoTotal;
    } // fin del constructor de Cuenta

    // determina si un NIP especificado por el usuario coincide con el NIP en la Cuenta
    public boolean validarNIP(int nipUsuario) {
        if (nipUsuario == nip) {
            return true;
        } else {
            return false;
        }
    } // fin del m�todo validarNIP

    // devuelve el saldo disponible
    public double obtenerSaldoDisponible() {
        return saldoDisponible;
    } // fin de obtenerSaldoDisponible

    // devuelve el saldo total
    public double obtenerSaldoTotal() {
        return saldoTotal;
    } // fin del m�todo obtenerSaldoTotal

    // abona un monto a la cuenta
    public void abonar(double monto) {
        archivos.modificarSaldo(numeroCuenta, nip, monto, 1);
        saldoTotal += monto; // lo suma al saldo total
    } // fin del m�todo abonar

    // carga un monto a la cuenta
    public void cargar(double monto) {
        archivos.modificarSaldo(numeroCuenta, nip, monto, 2);
        saldoDisponible -= monto; // lo resta del saldo disponible
        saldoTotal -= monto; // lo resta del saldo total
    } // fin del m�todo cargar

    // devuelve el n�mero de cuenta
    public int obtenerNumeroCuenta() {
        return numeroCuenta;
    } // fin del m�todo obtenerNumeroCuenta
} // fin de la clase Cuenta


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
