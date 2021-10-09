// BaseDatosBanco.java
// Representa a la base de datos de informaci�n de cuentas bancarias
package Deitel;

public class BaseDatosBanco
{
   private Cuenta cuentas[]; // arreglo de objetos Cuenta
   
   // el constructor sin argumentos de BaseDatosBanco inicializa a cuentas
   public BaseDatosBanco()
   {
      cuentas = new Cuenta[ 2 ]; // s�lo 2 cuentas para probar
      cuentas[ 0 ] = new Cuenta( 12345, 54321, 1000.0, 1200.0 );
      cuentas[ 1 ] = new Cuenta( 98765, 56789, 200.0, 200.0 );  
   } // fin del constructor sin argumentos de BaseDatosBanco
   
   // obtiene el objeto Cuenta que contiene el n�mero de cuenta especificado
   private Cuenta obtenerCuenta( int numeroCuenta )
   {
      // itera a trav�s de cuentas, buscando el n�mero de cuenta que coincida
      for ( Cuenta cuentaActual : cuentas )
      {
         // devuelve la cuenta actual si encuentra una coincidencia
         if ( cuentaActual.obtenerNumeroCuenta() == numeroCuenta )
            return cuentaActual;
      } // fin de for

      return null; // si no se enontr� una cuenta que coincida, devuelve null
   } // fin del m�todo obtenerCuenta

   // determina si el n�mero de cuenta y el NIP especificados por el usuario coinciden
   // con los de una cuenta en la base de datos
   public boolean autenticarUsuario( int numeroCuentaUsuario, int nipUsuario )
   {
      // trata de obtener la cuenta con el n�mero de cuenta
      Cuenta cuentaUsuario = obtenerCuenta( numeroCuentaUsuario );

      // si la cuenta existe, devuelve el resultado del m�todo validarNIP de Cuenta
      if ( cuentaUsuario != null )
         return cuentaUsuario.validarNIP( nipUsuario );
      else
         return false; // no se encontr� el n�mero de cuenta, por lo que devuelve false
   } // fin del m�todo autenticarUsuario

   // devuelve el saldo disponible de la Cuenta con el n�mero de cuenta especificado
   public double obtenerSaldoDisponible( int numeroCuentaUsuario )
   {
      return obtenerCuenta( numeroCuentaUsuario ).obtenerSaldoDisponible();
   } // fin del m�todo obtenerSaldoDisponible

   // devuelve el saldo total de la Cuenta con el n�mero de cuenta especificado
   public double obtenerSaldoTotal( int numeroCuentaUsuario )
   {
      return obtenerCuenta( numeroCuentaUsuario ).obtenerSaldoTotal();
   } // fin del m�todo obtenerSaldoTotal

   // abona un monto a la Cuenta a trav�s del n�mero de cuenta especificador
   public void abonar( int numeroCuentaUsuario, double monto )
   {
      obtenerCuenta( numeroCuentaUsuario ).abonar( monto );
   } // fin del m�todo abonar

   // carga un monto a la Cuenta con el n�mero de cuenta especificado
   public void cargar( int numeroCuentaUsuario, double monto )
   {
      obtenerCuenta( numeroCuentaUsuario ).cargar( monto );
   } // fin del m�todo cargar
} // fin de la clase BaseDatosBanco



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