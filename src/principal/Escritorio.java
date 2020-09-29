
package principal;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class Escritorio extends JDesktopPane{

       Image IMG=new ImageIcon(getClass().getResource("/imagenes/fondo.jpg")).getImage();

       @Override
        public void paintChildren(Graphics g){
            g.drawImage(IMG, 0, 0, getWidth(), getHeight(), this);
            super.paintChildren(g);
        }
    } 
