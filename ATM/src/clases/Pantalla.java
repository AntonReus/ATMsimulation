// Pantalla.java
// Representa a la pantalla del ATM
package clases;

import javax.swing.JTextArea;

public class Pantalla {
    // muestra un mensaje sin un retorno de carro

    public void mostrarMensaje(JTextArea pantalla, String mensaje) {
        pantalla.setText(pantalla.getText() + mensaje);
    } // fin del m�todo mostrarMensaje

    // muestra un mensaje con un retorno de carro
    public void mostrarLineaMensaje(JTextArea pantalla, String mensaje) {
        pantalla.setText(mensaje);
    } // fin del m�todo mostrarLineaMensaje
} // fin de la clase Pantalla



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
