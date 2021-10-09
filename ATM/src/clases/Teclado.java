// Teclado.java
// Representa el teclado del ATM
package clases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner; // el programa usa a Scanner para obtener la entrada del usuario
import javax.swing.JTextArea;

public class Teclado {

    // el constructor sin argumentos inicializa el objeto Scanner
    public Teclado() {
    } // fin del constructor sin argumentos de Teclado
    
    public void obtenerEntrada(JTextArea modificar, int tecla)
    {
        String input = "1";
        try {
            Robot robot = new Robot();
            modificar.requestFocus();
            switch (tecla){
                case 1:
                    robot.keyPress(KeyEvent.VK_1); // Simula presionar la tecla
                    robot.keyRelease(KeyEvent.VK_1); // Simula soltar la tecla
                    break;
                case 2:
                    robot.keyPress(KeyEvent.VK_2); // Simula presionar la tecla
                    robot.keyRelease(KeyEvent.VK_2); // Simula soltar la tecla
                    break;
                case 3:
                    robot.keyPress(KeyEvent.VK_3); // Simula presionar la tecla
                    robot.keyRelease(KeyEvent.VK_3); // Simula soltar la tecla
                    break;
                case 4:
                    robot.keyPress(KeyEvent.VK_4); // Simula presionar la tecla
                    robot.keyRelease(KeyEvent.VK_4); // Simula soltar la tecla
                    break;
                case 5:
                    robot.keyPress(KeyEvent.VK_5); // Simula presionar la tecla
                    robot.keyRelease(KeyEvent.VK_5); // Simula soltar la tecla
                    break;
                case 6:
                    robot.keyPress(KeyEvent.VK_6); // Simula presionar la tecla
                    robot.keyRelease(KeyEvent.VK_6); // Simula soltar la tecla
                    break;
                case 7:
                    robot.keyPress(KeyEvent.VK_7); // Simula presionar la tecla
                    robot.keyRelease(KeyEvent.VK_7); // Simula soltar la tecla
                    break;
                case 8:
                    robot.keyPress(KeyEvent.VK_8); // Simula presionar la tecla
                    robot.keyRelease(KeyEvent.VK_8); // Simula soltar la tecla
                    break;
                case 9:
                    robot.keyPress(KeyEvent.VK_9); // Simula presionar la tecla
                    robot.keyRelease(KeyEvent.VK_9); // Simula soltar la tecla
                    break;
                case 0:
                    robot.keyPress(KeyEvent.VK_0); // Simula presionar la tecla
                    robot.keyRelease(KeyEvent.VK_0); // Simula soltar la tecla
                    break;
            }
        } catch (AWTException e) {
            System.out.print(e);
        }
    }
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
