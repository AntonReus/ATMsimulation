// ATM.java
// Representa a un cajero autom�tico

package Deitel;

public class ATM 
{
   private boolean usuarioAutenticado; // indica si el usuario es autenticado
   private int numeroCuentaActual; // current user's account number
   private Pantalla pantalla; // pantalla del ATM
   private Teclado teclado; // teclado del ATM
   private DispensadorEfectivo dispensadorEfectivo; // dispensador de efectivo del ATM
   private RanuraDeposito ranuraDeposito; // ranura de dep�sito del ATM
   private BaseDatosBanco baseDatosBanco; //  base de datos de informaci�n de las cuentas

   // constantes correspondientes a las opciones del men� principal
   private static final int SOLICITUD_SALDO = 1;
   private static final int RETIRO = 2;
   private static final int DEPOSITO = 3;
   private static final int SALIR = 4;

   // el constructor sin argumentos de ATM inicializa las variables de instancia
   public ATM() 
   {
      usuarioAutenticado = false; // al principio, el usuario no est� autenticado
      numeroCuentaActual = 0; // al principio, no hay n�mero de cuenta
      pantalla = new Pantalla(); // crea la pantalla
      teclado = new Teclado(); // crea el teclado 
      dispensadorEfectivo = new DispensadorEfectivo(); // crea el dispensador de efectivo
      ranuraDeposito = new RanuraDeposito(); // crea la ranura de dep�sito
      baseDatosBanco = new BaseDatosBanco(); // crea la base de datos de informaci�n de cuentas
   } // fin del constructor sin argumentos de ATM

   // inicia el ATM 
   public void run()
   {
      // da la bienvenida al usuario y lo autentica; realiza transacciones
      while ( true )
      {
         // itera mientras el usuario no haya sido autenticado
         while ( !usuarioAutenticado ) 
         {
            pantalla.mostrarLineaMensaje( "\nBienvenido!" );       
            autenticarUsuario(); // autentica el usuario
         } // fin de while
         
         realizarTransacciones(); // ahora el usuario est� autenticado 
         usuarioAutenticado = false; // restablece antes de la siguiente sesi�n con el ATM
         numeroCuentaActual = 0; // restablece antes de la siguiente sesi�n con el ATM 
         pantalla.mostrarLineaMensaje( "\nGracias! Adios!" );
      } // fin de while   
   } // fin del m�todo run

   // trata de autenticar al usuario en la base de datos
   private void autenticarUsuario() 
   {
      pantalla.mostrarMensaje( "\nEscriba su numero de cuenta: " );
      int numeroCuenta = teclado.obtenerEntrada(); // recibe como entrada el n�mero de cuenta
      pantalla.mostrarMensaje( "\nEscriba su NIP: " ); // pide el NIP
      int nip = teclado.obtenerEntrada(); // recibe como entrada el NIP
      
      // establece usuarioAutenticado con el valor booleano devuelto por la base de datos
      usuarioAutenticado = 
         baseDatosBanco.autenticarUsuario( numeroCuenta, nip );
      
      // verifica si la autenticaci�n tuvo �xito
      if ( usuarioAutenticado )
      {
         numeroCuentaActual = numeroCuenta; // guarda el # de cuenta del usuario
      } // fin de if
      else
         pantalla.mostrarLineaMensaje( 
             "Numero de cuenta o NIP invalido. Intente de nuevo." );
   } // fin del m�todo autenticarUsuario

   // muestra el men� principal y realiza transacciones
   private void realizarTransacciones() 
   {
      // variable local para almacenar la transacci�n que se procesa actualmente
      Transaccion transaccionActual = null;
      
      boolean usuarioSalio = false; // el usuario no ha elegido salir

      // itera mientras que el usuario no haya elegido la opci�n para salir del sistema
      while ( !usuarioSalio )
      {     
         // muestra el men� principal y obtiene la selecci�n del usuario
         int seleccionMenuPrincipal = mostrarMenuPrincipal();

         // decide c�mo proceder, con base en la opci�n del men� seleccionada por el usuario
         switch ( seleccionMenuPrincipal )
         {
            // el usuario eligi� realizar uno de tres tipos de transacciones
            case SOLICITUD_SALDO: 
            case RETIRO: 
            case DEPOSITO:

               // inicializa como nuevo objeto del tipo elegido
               transaccionActual = 
                  crearTransaccion( seleccionMenuPrincipal );

               transaccionActual.ejecutar(); // ejecuta la transacci�n
               break; 
            case SALIR: // el usuario eligi� terminar la sesi�n
               pantalla.mostrarLineaMensaje( "\nCerrando el sistema..." );
               usuarioSalio = true; // esta sesi�n con el ATM debe terminar
               break;
            default: // el usuario no introdujo un entero de 1 a 4
               pantalla.mostrarLineaMensaje( 
                  "\nNo introdujo una seleccion valida. Intente de nuevo." );
               break;
         } // fin de switch
      } // fin de while
   } // fin del m�todo realizarTransacciones
   
   // muestra el men� principal y devuelve una selecci�n de entrada
   private int mostrarMenuPrincipal()
   {
      pantalla.mostrarLineaMensaje( "\nMenu principal:" );
      pantalla.mostrarLineaMensaje( "1 - Ver mi saldo" );
      pantalla.mostrarLineaMensaje( "2 - Retirar efectivo" );
      pantalla.mostrarLineaMensaje( "3 - Depositar fondos" );
      pantalla.mostrarLineaMensaje( "4 - Salir\n" );
      pantalla.mostrarMensaje( "Escriba una opcion: " );
      return teclado.obtenerEntrada(); // devuelve la opcion seleccionada por el usuario
   } // fin del m�todo mostrarMenuPrincipal
         
   // devuelve un objeto de la subclase especificada de Transaccion
   private Transaccion crearTransaccion( int tipo )
   {
      Transaccion temp = null; // variable temporal Transaccion
      
      // determina qu� tipo de Transaccion crear     
      switch ( tipo )
      {
         case SOLICITUD_SALDO: // crea una nueva transacci�n SolicitudSaldo
            temp = new SolicitudSaldo( 
               numeroCuentaActual, pantalla, baseDatosBanco );
            break;
         case RETIRO: // crea una nueva transacci�n Retiro
            temp = new Retiro( numeroCuentaActual, pantalla, 
               baseDatosBanco, teclado, dispensadorEfectivo );
            break; 
         case DEPOSITO: // crea una nueva transacci�n Deposito
            temp = new Deposito( numeroCuentaActual, pantalla, 
               baseDatosBanco, teclado, ranuraDeposito );
            break;
      } // fin de switch

      return temp; // devuelve el obejto reci�n creado
   } // fin del m�todo crearTransaccion
} // fin de la clase ATM



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