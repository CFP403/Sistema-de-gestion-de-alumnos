
package Curso;

import javax.swing.*;

/**
 * @author Lucas
 */

public class IngresarCurso extends JDialog{
 
    public IngresarCurso()
    {
        this.setTitle("Ingresar Curso");
    }
    
    public void Mostrar()
    {
        this.setModal(true);
        ImageIcon img = new ImageIcon("src/Imagenes/icon32.png");
        this.setIconImage(img.getImage());
        this.setSize (500, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
