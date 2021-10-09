// DispensadorEfectivo.java
// Representa al dispensador de efectivo del ATM
package clases;

public class DispensadorEfectivo {
    // el n�mero inicial predeterminado de billetes en el dispensador de efectivo

    private final static int CUENTA_INICIAL = 500;
    private int cuenta; // n�mero restante de billetes de $20 

    // el constructor sin argumentos de DispensadorEfectivo inicializa cuenta con el valor predeterminado
    public DispensadorEfectivo() {
        cuenta = CUENTA_INICIAL; // establece el atributo cuenta al valor predeterminado
    } // fin del constructor de DispensadorEfectivo

    // simula la acci�n de dispensar el monto especificado de efectivo
    public void dispensarEfectivo(int monto) {
        int billetesRequeridos = monto / 20; // n�mero de billetes de $20 requeridos
        cuenta -= billetesRequeridos; // actualiza la cuenta de billetes
    } // fin del m�todo dispensarEfectivo

    // indica si el dispensador de efectivo puede dispensar el monto deseado
    public boolean haySuficienteEfectivoDisponible(int monto) {
        int billetesRequeridos = monto / 20; // n�mero de billetes de $20 requeridos

        if (cuenta >= billetesRequeridos) {
            return true; // hay suficientes billetes disponibles
        } else {
            return false; // no hay suficientes billetes disponibles
        }
    } // fin del m�todo haySuficienteEfectivoDisponible
} // fin de la clase DispensadorEfectivo



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
