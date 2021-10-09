// Transaccion.java
// La superclase abstracta Transaccion representa una transacci�n con el ATM
package Deitel;

public abstract class Transaccion
{
   private int numeroCuenta; // indica la cuenta implicada
   private Pantalla pantalla; // pantalla del ATM
   private BaseDatosBanco baseDatosBanco; // base de datos de informaci�n de cuentas

   // el constructor de Transaccion es invocado por las subclases mediante super()
   public Transaccion( int numeroCuentaUsuario, Pantalla pantallaATM, 
      BaseDatosBanco baseDatosBancoATM )
   {
      numeroCuenta = numeroCuentaUsuario;
      pantalla = pantallaATM;
      baseDatosBanco = baseDatosBancoATM;
   } // fin del constructor de Transaccion

   // devuelve el n�mero de cuenta 
   public int obtenerNumeroCuenta()
   {
      return numeroCuenta; 
   } // fin del m�todo obtenerNumeroCuenta

   // devuelve una referencia a la pantalla
   public Pantalla obtenerPantalla()
   {
      return pantalla;
   } // fin del m�todo obtenerPantalla

   // devuelve una referencia a la base de datos del banco
   public BaseDatosBanco obtenerBaseDatosBanco()
   {
      return baseDatosBanco;
   } // fin del m�todo obtenerBaseDatosBanco

   // realiza la transacci�n (cada subclase sobrescribe este m�todo)
   abstract public void ejecutar();
} // fin de la clase Transaccion



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