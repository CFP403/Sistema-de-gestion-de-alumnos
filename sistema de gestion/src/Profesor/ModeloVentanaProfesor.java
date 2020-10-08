
package Profesor;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import validadoresjtfenfoco.SoloLetras;
import validadoresjtfenfoco.SoloNumeros;

/**
 *
 * @author VarelaVargasLeandro
 */
public class ModeloVentanaProfesor extends JInternalFrame
{
    
    public static enum TipoVentana
    {
        
        Crear,
        Modificar
        
    }
    
    protected TipoVentana tipo;
    
    protected final LayoutManager layout = new GridLayout ( 4, 1 );
    protected JTextField jtfNombre;
    protected JComboBox jcbNroDNI;
    protected JTextField jtfNroDNI;
    protected JTextField jtfTeléfono;
    protected JButton jbAceptar;
    
    public ModeloVentanaProfesor ( String titulo, TipoVentana tipo )
    {
        
        super ( titulo );
        
        this.tipo = tipo;
        
        this.Configurar();
        this.AgregarComponentes();
    }
    
    private void AgregarComponentes()
    {
        
        this.setLayout ( this.layout );
        
        switch ( this.tipo )
        {
            
            case Crear:
            {    
                JPanel panelNroDNI = new JPanel ();
                    panelNroDNI.add ( new JLabel ( "DNI: " ) );
                    this.jtfNroDNI = new JTextField (8);
                        this.jtfNroDNI.addFocusListener( new SoloNumeros() );
                    panelNroDNI.add ( this.jtfNroDNI );
                this.add (panelNroDNI);
        
                break;
            }
            
            default:
            { 
                JPanel panelNroDNI = new JPanel ();
                    panelNroDNI.add ( new JLabel ( "DNI: " ) );
                    this.jcbNroDNI = new JComboBox ( this.obtenerDatos() );
                    this.jcbNroDNI.setSelectedIndex(-1);
                    panelNroDNI.add ( this.jcbNroDNI );
                this.add (panelNroDNI);
            }
            
        }
        
        JPanel panelNombre = new JPanel();
            panelNombre.add ( new JLabel ("Nombre: ") );
            this.jtfNombre = new JTextField (30);
                    this.jtfNombre.addFocusListener(new SoloLetras());
            panelNombre.add ( this.jtfNombre );
        this.add ( panelNombre );
        
        JPanel panelTelefono = new JPanel ();
            panelTelefono.add ( new JLabel ("Teléfono: ") );
            this.jtfTeléfono = new JTextField (8);
                this.jtfTeléfono.addFocusListener( new SoloNumeros() );
            panelTelefono.add ( this.jtfTeléfono );
        this.add ( panelTelefono );
        
        switch ( this.tipo )
        {
            
            case Modificar:
            {
                
                JPanel panelBoton = new JPanel();
                    this.jbAceptar = new JButton ( "Modificar en Base de Datos" );
                    panelBoton.add ( this.jbAceptar );
                this.add ( panelBoton );
                
                break;
            }
            
            case Crear:
            {
                
                JPanel panelBoton = new JPanel();
                    this.jbAceptar = new JButton ( "Ingresar a Base de Datos" );
                    panelBoton.add ( this.jbAceptar );
                this.add ( panelBoton );
                
            }
            
        }
        
        
        
    }
    
    private void Configurar ()
    {
        
        this.setResizable ( false );
        this.setClosable ( true );
        this.setMaximizable ( true );
        this.setIconifiable ( true );
        this.setSize ( 450 , 200 );
        this.setVisible ( true );
        
    }
    
     private String [] obtenerDatos() 
    {
        String [] ret = {"4", "5", "6"};
        return ret;
    }
    
}
