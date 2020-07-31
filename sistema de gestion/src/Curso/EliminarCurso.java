
package Curso;

import javax.swing.*;

/**
 * @author Lucas
 */

public class EliminarCurso extends JDialog{
 
    public EliminarCurso()
    {
        this.setTitle("Eliminar Curso");
        
        
        
        
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