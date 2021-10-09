// Retiro.java
// Representa una transacci�n de retiro en el ATM
package Deitel;

public class Retiro extends Transaccion
{
   private int monto; // monto a retirar
   private Teclado teclado; // referencia al teclado
   private DispensadorEfectivo dispensadorEfectivo; // referencia al dispensador de efectivo

   // constante que corresponde a la opci�n del men� a cancelar
   private final static int CANCELO = 6;

   // constructor de Retiro
   public Retiro( int numeroCuentaUsuario, Pantalla pantallaATM, 
      BaseDatosBanco baseDatosBanco, Teclado tecladoATM, 
      DispensadorEfectivo dispensadorEfectivoATM )
   {
      // inicializa las variables de la superclase
      super( numeroCuentaUsuario, pantallaATM, baseDatosBanco );
      
      // inicializa las referencias al teclado y al dispensador de efectivo
      teclado = tecladoATM;
      dispensadorEfectivo = dispensadorEfectivoATM;
   } // fin del constructor de Retiro

   // realiza la transacci�n
   public void ejecutar()
   {
      boolean efectivoDispensado = false; // no se ha dispensado a�n el efectivo
      double saldoDisponible; // monto disponible para retirar

      // obtiene referencias a la base de datos del banco y la pantalla
      BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco(); 
      Pantalla pantalla = obtenerPantalla();

      // itera hasta que se dispense el efectivo o que cancele el usuario
      do
      {
         // obtiene un monto de retiro elegido por el usuario
         monto = mostrarMenuDeMontos();
         
         // comprueba si el usuario eligi� un monto de retiro o si cancel�
         if ( monto != CANCELO )
         {
            // obtiene el saldo disponible de la cuenta implicada
            saldoDisponible = 
               baseDatosBanco.obtenerSaldoDisponible( obtenerNumeroCuenta() );
      
            // comprueba si el usuario tiene suficiente dinero en la cuenta 
            if ( monto <= saldoDisponible )
            {   
               // comprueba si el dispensador de efectivo tiene suficiente dinero
               if ( dispensadorEfectivo.haySuficienteEfectivoDisponible( monto ) )
               {
                  // actualiza la cuenta implicada para reflejar el saldo
                  baseDatosBanco.cargar( obtenerNumeroCuenta(), monto );
                  
                  dispensadorEfectivo.dispensarEfectivo( monto ); // dispensar efectivo
                  efectivoDispensado = true; // se dispens� el efectivo

                  // instruye al usuario que tome efectivo
                  pantalla.mostrarLineaMensaje( 
                     "\nTome ahora su efectivo." );
               } // fin de if
               else // el dispensador no tiene suficiente efectivo
                  pantalla.mostrarLineaMensaje( 
                     "\nNo hay suficiente efectivo disponible en el ATM." +
                     "\n\nSeleccione un monto menor." );
            } // fin de if
            else // no hay suficiente dinero disponible en la cuenta del usuario
            {
               pantalla.mostrarLineaMensaje( 
                  "\nNo hay suficientes fondos en su cuenta." +
                  "\n\nSeleccione un monto menor." );
            } // fin de else
         } // fin de if
         else // el usuario eligi� la opci�n cancelar del men�
         {
            pantalla.mostrarLineaMensaje( "\nCancelando transaccion..." );
            return; // regresa al men� principal porque el usuario cancel�
         } // fin de else
      } while ( !efectivoDispensado );

   } // fin del m�todo ejecutar

   // muestra un men� de montos de retiro y la opci�n para cancelar;
   // devuelve el monto elegido o 0 si el usuario elije cancelar
   private int mostrarMenuDeMontos()
   {
      int opcionUsuario = 0; // variable local para almacenar el valor de retorno

      Pantalla pantalla = obtenerPantalla(); // obtiene referencia a la pantalla
      
      // arreglo de montos que corresponde a los n�meros del men�
      int montos[] = { 0, 20, 40, 60, 100, 200 };

      // itera mientras no se haya elegido una opci�n v�lida
      while ( opcionUsuario == 0 )
      {
         // muestra el men�
         pantalla.mostrarLineaMensaje( "\nMenu de retiro:" );
         pantalla.mostrarLineaMensaje( "1 - $20" );
         pantalla.mostrarLineaMensaje( "2 - $40" );
         pantalla.mostrarLineaMensaje( "3 - $60" );
         pantalla.mostrarLineaMensaje( "4 - $100" );
         pantalla.mostrarLineaMensaje( "5 - $200" );
         pantalla.mostrarLineaMensaje( "6 - Cancelar transaccion" );
         pantalla.mostrarMensaje( "\nSeleccione un monto a retirar: " );

         int entrada = teclado.obtenerEntrada(); // obtiene la entrada del usuario mediante el teclado

         // determina c�mo proceder con base en el valor de la entrada
         switch ( entrada )
         {
            case 1: // si el usuario eligi� un monto de retiro
            case 2: // (es decir, si eligi� la opci�n 1, 2, 3, 4 o 5), devolver
            case 3: // el monto correspondiente del arreglo montos
            case 4:
            case 5:
               opcionUsuario = montos[ entrada ]; // guarda la elecci�n del usuario
               break;       
            case CANCELO: // el usuario eligi� cancelar
               opcionUsuario = CANCELO; // guarda la elecci�n del usuario
               break;
            default: // el usuario no introdujo un valor del 1 al 6
               pantalla.mostrarLineaMensaje( 
                  "\nSeleccion invalida. Intente de nuevo." );
         } // fin de switch
      } // fin de while

      return opcionUsuario; // devuelve el monto de retiro o CANCELO
   } // fin del m�todo mostrarMenuDeMontos
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