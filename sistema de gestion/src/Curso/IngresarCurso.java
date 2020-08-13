
package Curso;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Lucas
 */

public class IngresarCurso extends JDialog{
 
    private JButton btnAceptar, btnCancelar;
    
    public IngresarCurso()
    {        
        this.setTitle("Ingresar Curso");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        
        this.add(new JLabel("Nombre del curso"));
        this.add(new JTextField(20));
        
        this.add(new JLabel("Cantidad de Alumnos"));
        this.add(new JTextField(20));
        
        this.add(new JLabel("Profesor a cargo"));
        this.add(new JTextField(20));
        
        btnAceptar = new JButton("Aceptar");
        //btnAceptar.addActionListener();
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                IngresarCurso.this.dispose();
            }
        });
        this.add(btnAceptar);
        this.add(btnCancelar);
    }
    
    public void Mostrar()
    {
        ImageIcon img = new ImageIcon("src/Imagenes/icon32.png");
        this.setIconImage(img.getImage());
        this.setSize (300, 300);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setModal(true);
    }
}
