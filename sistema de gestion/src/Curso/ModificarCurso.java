
package Curso;

import javax.swing.*;

/**
 * @author Lucas
 */

public class ModificarCurso extends JDialog{
 
    public ModificarCurso()
    {
        this.setTitle("Modificar Curso");
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