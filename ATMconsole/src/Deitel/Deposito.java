// Deposito.java
// Representa una transacci�n de dep�sito en el ATM
package Deitel;

public class Deposito extends Transaccion
{
   private double monto; // monto a depositar
   private Teclado teclado; // referencia al teclado
   private RanuraDeposito ranuraDeposito; // referencia a la ranura de dep�sito
   private final static int CANCELO = 0; // constante para la opci�n de cancelar

   // constructor de Deposito
   public Deposito( int numeroCuentaUsuario, Pantalla pantallaATM, 
      BaseDatosBanco baseDatosBanco, Teclado tecladoATM, 
      RanuraDeposito ranuraDepositoATM )
   {
      // inicializa las variables de la superclase
      super( numeroCuentaUsuario, pantallaATM, baseDatosBanco );

      // inicializa las referencias al teclado y la ranura de dep�sito
      teclado = tecladoATM;
      ranuraDeposito = ranuraDepositoATM;
   } // fin del constructor de Deposito

   // realiza la transacci�n
   public void ejecutar()
   {
      BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco(); // obtiene la referencia
      Pantalla pantalla = obtenerPantalla(); // obtiene la referencia

      monto = pedirMontoADepositar(); // obtiene el monto a depositar del usuario

      // comprueba si el usuario introdujo un monto a depositar o cancel�
      if ( monto != CANCELO )
      {
         // solicita un sobre de dep�sito que contenga el monto especificado
         pantalla.mostrarMensaje( 
            "\nInserte un sobre que contenga " );
         pantalla.mostrarMontoDolares( monto );
         pantalla.mostrarLineaMensaje( "." );

         // recibe el sobre de dep�sito
         boolean seRecibioSobre = ranuraDeposito.seRecibioSobre();

         // comprueba si se recibi� el sobre de dep�sito
         if ( seRecibioSobre )
         {  
            pantalla.mostrarLineaMensaje( "\nSe recibio su sobre de " + 
               "deposito.\nNOTA: El dinero que acaba de depositar no " + 
               "estara disponible sino hasta que verifiquemos el monto del " +
               "efectivo y cualquier cheque incluido." );
            
            // hace un abono a la cuenta para reflejar el dep�sito
            baseDatosBanco.abonar( obtenerNumeroCuenta(), monto ); 
         } // fin de if
         else // no se recibi� el sobre de dep�sito
         {
            pantalla.mostrarLineaMensaje( "\nNo inserto un sobre de " +
               "deposito, por lo que el ATM ha cancelado su transaccion." );
         } // fin de else
      } // fin de if 
      else // el usuario cancel� en vez de introducir el monto
      {
         pantalla.mostrarLineaMensaje( "\nCancelando transaccion..." );
      } // fin de else
   } // fin del m�todo ejecutar

   // pide al usuario que introduzca un monto a depositar en centavos
   private double pedirMontoADepositar()
   {
      Pantalla pantalla = obtenerPantalla(); // obtiene referencia a la pantalla

      // muestra el indicador
      pantalla.mostrarMensaje( "\nIntroduzca un monto a depositar en " + 
         "CENTAVOS (o 0 para cancelar): " );
      int entrada = teclado.obtenerEntrada(); // recibe la entrada del monto de dep�sito
      
      // comprueba si el usuario cancel� o introdujo un monto v�lido
      if ( entrada == CANCELO ) 
         return CANCELO;
      else
      {
         return ( double ) entrada / 100; // devuelve el monto en d�lares
      } // fin de else
   } // fin del m�todo pedirMontoADepositar
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