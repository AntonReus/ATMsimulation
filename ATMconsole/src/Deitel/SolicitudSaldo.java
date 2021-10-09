// SolicitudSaldo.java
// Representa una transacci�n de solicitud de saldo en el ATM
package Deitel;

public class SolicitudSaldo extends Transaccion
{
   // constructor de SolicitudSaldo
   public SolicitudSaldo( int numeroCuentaUsuario, Pantalla pantallaATM, 
      BaseDatosBanco baseDatosBanco )
   {
      super( numeroCuentaUsuario, pantallaATM, baseDatosBanco );
   } // fin del constructor de SolicitudSaldo

   // realiza la transacci�n
   public void ejecutar()
   {
      // obtiene referencias a la base de datos del banco y la pantalla
      BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco();
      Pantalla pantalla = obtenerPantalla();

      // obtiene el saldo disponible para la cuenta implicada
      double saldoDisponible = 
         baseDatosBanco.obtenerSaldoDisponible( obtenerNumeroCuenta() );

      // obtiene el saldo total para la cuenta implicada
      double saldoTotal = 
         baseDatosBanco.obtenerSaldoTotal( obtenerNumeroCuenta() );
      
      // muestra la informaci�n del saldo en la pantalla
      pantalla.mostrarLineaMensaje( "\nInformacion de saldo:" );
      pantalla.mostrarMensaje( " - Saldo disponible: " ); 
      pantalla.mostrarMontoDolares( saldoDisponible );
      pantalla.mostrarMensaje( "\n - Saldo total:     " );
      pantalla.mostrarMontoDolares( saldoTotal );
      pantalla.mostrarLineaMensaje( "" );
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