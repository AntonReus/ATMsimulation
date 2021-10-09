// Teclado.java
// Representa el teclado del ATM
package Deitel;

import java.util.Scanner; // el programa usa a Scanner para obtener la entrada del usuario

public class Teclado
{
   private Scanner entrada; // lee datos de la l�nea de comandos
                         
   // el constructor sin argumentos inicializa el objeto Scanner
   public Teclado()
   {
      entrada = new Scanner( System.in );    
   } // fin del constructor sin argumentos de Teclado

   // devuelve un valor entero introducido por el usuario
   public int obtenerEntrada()
   {
      return entrada.nextInt(); // suponemos que el usuario introduce un entero  
   } // fin del m�todo obtenerEntrada
} // fin de la clase Teclado  



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