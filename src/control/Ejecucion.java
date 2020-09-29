/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import splash.SplashScreen;

/**
 *
 * @author Rojeru San
 */
public class Ejecucion {
    public static void main(String[] args) {
        if(new Control().comprobar()){ 
            new SplashScreen().setVisible(true);
        }else{
            System.exit(0);
        }
    }
}
