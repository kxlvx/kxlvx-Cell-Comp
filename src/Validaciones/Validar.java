/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author kalva
 */
public class Validar {

    //Metodo que permite la entrada de un numero decimal, recible un evento de teclado y un caracter
    public static void NumerosDecimales(KeyEvent evt, JTextField jtexto) {
        char c = evt.getKeyChar();
        if (c > 32 && c != 127) {
            if (c == '.') {
                if (jtexto.getText().contains(".")) {
                    jtexto.setCaretColor(java.awt.Color.red);
                    JOptionPane.showMessageDialog(null, "Recibe un solo punto");
                    evt.consume();

                }
            } else {
                if ((c < '0' || c > '9')) {
                    JOptionPane.showMessageDialog(null, "Se permite solo numeros");
                    evt.consume();
                }
            }
        }
    }

    public static boolean esFlotante(JTextField txt) {
        return (!txt.getText().trim().matches("[0-9]{1,10}[.]{0,1}[0-9]{0,}"));

    }
    //Metodo que permite la entrada de letras, recibe un evento de teclado y un caracter,utiliza el codigo ancci para verificar

    public static void SoloLetras(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (c > 32 && c != 127) {// 127 es suprimir
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                JOptionPane.showMessageDialog(null, "Se permite solo letras");
                evt.consume();
            }
        }
    }
    //Metodo que permite la entrada de numeros, recibe un evento de teclado y un caracter,utiliza el codigo ancci para verificar

    public static void SoloNumeros(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (c > 32 && c != 127) {// 127 es suprimir
            if ((c < '0' || c > '9')) {
                JOptionPane.showMessageDialog(null, "Se permite solo numeros");
                evt.consume();
            }
        }
    }

    public static boolean esNumero(JTextField txt) {
        return (!txt.getText().trim().matches("[0-9-]{2,}"));
    }
}
