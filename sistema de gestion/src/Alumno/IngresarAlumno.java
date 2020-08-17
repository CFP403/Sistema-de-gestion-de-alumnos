
package Alumno;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Varela Vargas Leandro Gastón
 */
public class IngresarAlumno extends JInternalFrame
{

    private final GridBagLayout layout = new GridBagLayout ();
    
    private JPanel jpDatosAlumno;
        //Documento:
            private JComboBox jcbTipoDoc;
            private JTextField tjfNroDoc;
            private ButtonGroup bgEstadoDoc;
                private JRadioButton jrbBueno;
                private JRadioButton jrbMalo;
                private JRadioButton jrbEnTramite;
                private JRadioButton jrbNoPosee;
        //Nombre y Sexo:
            private JTextField jtfApellido;
            private JTextField jtfNombre;
            private JTextField jtfSexo;
        //Nacimiento:
            private JTextField jtfDiaNacimiento;
            private JTextField jtfMesNacimiento;
            private JTextField jtfAnioNacimiento;
            private JTextField jtfLugarNaciomiento;
            private JTextField jtfNacionalidad;
        //Domicilio:
            private JTextField jtfCalleDomicilio;
            private JTextField jtfNroDomicilio;
            private JTextField jtfPisoDomicilio;
            private JTextField jtfTorreDomicilio;
            private JTextField jtfDptoDomicilio;
            private JTextField jtfLocalidadDomicilio;
            private JTextField jtfCodPostalDomicilio;
        //Nivel Instrucción:
            private ButtonGroup jbgNivelInstruccion;
                private JRadioButton jrbNinguno;
                private JRadioButton jrbPrimario;
                private JRadioButton jrbSecundario;
                private JRadioButton jrbTerciario;
                private JRadioButton jrbUniversitario;
                private JRadioButton jrbPosgrado;
                    private ButtonGroup jbgHasta;
                        private JRadioButton jrbCompleto;
                        private JRadioButton jrbIncompleto;
                        private JRadioButton jrbHastaAnio;
                            private JTextField jtfAnioCompleto;
    
    public IngresarAlumno ()
    {
        
        super ( "Ingresar Alumno" );
        
        this.Configurar();
        this.agregarComponentes();
        this.Mostrar();
        
    }
    
    private void Configurar ()
    {
        
        this.setResizable ( true );
        this.setClosable ( true );
        this.setMaximizable ( true );
        this.setIconifiable ( true );
        this.setSize ( 250 , 200 );
        this.setLayout ( this.layout );
        
    }
    
    private void agregarComponentes ()
    {
        
        
            
    }
    
    private void agregarComponenteGridBag ( Container contenedor, JComponent componente, int Posicionrelativa, int Rellenar, int Fila, int Columna, int Ancho, int Alto, double ExpansionFila, double ExpansionColumna )
    {
        
        GridBagConstraints gbc = new GridBagConstraints ();
        
        gbc.gridx = Fila;
        gbc.gridy = Columna;
        gbc.gridwidth = Ancho;
        gbc.gridheight = Alto;
        gbc.anchor = Posicionrelativa;
        gbc.fill = Rellenar;
        gbc.weightx = ExpansionFila;
        gbc.weighty = ExpansionColumna;
        
        contenedor.add ( componente , gbc );
        
    }
    
    public void Mostrar ()
    {
        
        this.setVisible ( true );
        
    }
    
}
