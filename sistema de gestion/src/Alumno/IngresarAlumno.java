
package Alumno;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
            private JTextField jtfNroDoc;
            private ButtonGroup bgEstadoDoc;
                private JRadioButton jrbBueno;
                private JRadioButton jrbMalo;
                private JRadioButton jrbEnTramite;
                private JRadioButton jrbNoPosee;
        //Nombre y Sexo:
            private JTextField jtfApellido;
            private JTextField jtfNombre;
            private JComboBox jcbSexo;
        //Nacimiento:
            private JTextField jtfDiaNacimiento;
            private JTextField jtfMesNacimiento;
            private JTextField jtfAnioNacimiento;
            private JTextField jtfLugarNacimiento;
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
        this.setSize ( 675, 200 );
        this.setMinimumSize ( new Dimension ( 675, 100 ) );
        this.setLayout ( this.layout );
        
    }
    
    private void agregarComponentes ()
    {
        
        this.jpDatosAlumno = new JPanel ();
            this.jpDatosAlumno.setBorder ( BorderFactory.createTitledBorder ( "Ingreso Alumnos" ) );
            this.agregarDocumento ( this.jpDatosAlumno );
            this.add ( this.jpDatosAlumno, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, 0, 0, 1, 1, 1, 1, null ) );
            
            
    }
    
    private void agregarDocumento ( JPanel contenedorDocumento )
    {
        
        double Filas = 2.0;
        
        contenedorDocumento.setLayout ( this.layout );
            
        /*============================================
        =            Panel TipoDocumentos            =
        ============================================*/
        JPanel panelTipoDocumentos = new JPanel ();
            panelTipoDocumentos.setLayout ( new GridLayout ( 2, 1 ) );
        
            /*----------  JComboBox TipoDoc  ----------*/
            JPanel paneltiposDocumentosComboBox = new JPanel ();
                String [] tiposDocumentos = { "DNI", "Cédula Identidad", "Pasaporte", "Libreta de Enrolamiento" };
                this.jcbTipoDoc = new JComboBox ( tiposDocumentos );
                paneltiposDocumentosComboBox.add ( this.jcbTipoDoc );    
                
                    panelTipoDocumentos.add ( paneltiposDocumentosComboBox );
            /*----------  Fin JComboBox TipoDoc  ----------*/
            
            /*----------  Panel NroDoc  ----------*/
                JPanel panelnroDoc = new JPanel ();
                    JLabel labelNroDoc = new JLabel ( "Nro Doc: " );
                    this.jtfNroDoc = new JTextField ( 8 );
                    
                    panelnroDoc.add ( labelNroDoc );
                    panelnroDoc.add ( this.jtfNroDoc );
                    panelTipoDocumentos.add ( panelnroDoc );
            /*----------  Fin Panel NroDoc  ----------*/
        
        contenedorDocumento.add ( panelTipoDocumentos, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, 0, 0, 1, 1, 0.5, 0.05, null ) );
        /*=====  End of Panel TipoDocumentos  ======*/
        
        /*=======================================
        =            Panel EstadoDoc            =
        =======================================*/
        JPanel panelEstado = new JPanel ();
            panelEstado.setSize ( 50, 50 );
            panelEstado.setBorder ( BorderFactory.createTitledBorder ( "Estado del documento: " ) );
            panelEstado.setLayout ( new FlowLayout ( FlowLayout.LEFT ) );
            
            /*----------  Botones EstadoDoc  ----------*/
                this.bgEstadoDoc = new ButtonGroup ();
                    this.jrbBueno = new JRadioButton ( "Bueno " );
                    this.jrbMalo = new JRadioButton ( "Malo " );
                    this.jrbEnTramite = new JRadioButton ( "En Trámite " );
                    this.jrbNoPosee = new JRadioButton ( "No Posee " );
                    
                    this.bgEstadoDoc.add ( this.jrbBueno );
                    this.bgEstadoDoc.add ( this.jrbMalo );
                    this.bgEstadoDoc.add ( this.jrbEnTramite );
                    this.bgEstadoDoc.add ( this.jrbNoPosee );
                    
                    panelEstado.add ( this.jrbBueno );
                    panelEstado.add ( this.jrbMalo );
                    panelEstado.add ( this.jrbEnTramite );
                    panelEstado.add ( this.jrbNoPosee );
            /*----------  Fin EstadoDoc  ----------*/
        
        contenedorDocumento.add ( panelEstado, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, 1, 0, 1, 1, 0.5, 0.05, null ) );
        /*=====  End of Panel EstadoDoc  ======*/
        
        /*==================================================
        =            Panel Información Personal            =
        ==================================================*/
        JPanel panelInfoPers = new JPanel();
        double panelInfoFilas = 3.0;
            panelInfoPers.setLayout ( this.layout );
                JLabel labelApellidos = new JLabel ( "Apellido/s: " );
                this.jtfApellido = new JTextField ( 15 );
                JLabel labelNombres = new JLabel ( "Nombre/s:" );
                this.jtfNombre = new JTextField ( 15 );
                JLabel labelSexo = new JLabel ( "Sexo: " );
                String [] Sexos = { "Masculino", "Femenino" };
                this.jcbSexo = new JComboBox ( Sexos );
                
                panelInfoPers.add ( labelApellidos, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 0, 1, 1, 0.1, ( 1.0 / panelInfoFilas ), null ) );
                panelInfoPers.add ( this.jtfApellido, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 0, 1, 1, 0.9, ( 1.0 / panelInfoFilas ), null ) );
                panelInfoPers.add ( labelNombres, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.1, ( 1.0 / panelInfoFilas ), null ) );
                panelInfoPers.add ( this.jtfNombre, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.9, ( 1.0 / panelInfoFilas ), null ) );
                panelInfoPers.add ( labelSexo, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 2, 1, 1, 0.1, ( 1.0 / panelInfoFilas ), null ) );
                panelInfoPers.add ( this.jcbSexo, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.9, ( 1.0 / panelInfoFilas ), null ) );
                
        contenedorDocumento.add ( panelInfoPers, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.5, 0.95, null ) );
        /*=====  End of Panel Información Personal  ======*/
        
        /*========================================
        =            Panel Nacimiento            =
        ========================================*/
        JPanel panelNac = new JPanel ();
        double panelNacFilas = 3.0;
            panelNac.setLayout ( this.layout );
                JLabel labelFechaNac = new JLabel ( "Fecha de Nacimiento: " );
                
                JPanel panelFechaNac = new JPanel ();
                    panelFechaNac.setLayout ( new FlowLayout ( FlowLayout.LEFT ) );
                    this.jtfDiaNacimiento = new JTextField ( 2 );
                    this.jtfMesNacimiento = new JTextField ( 2 );
                    this.jtfAnioNacimiento = new JTextField ( 4 );
                    panelFechaNac.add ( this.jtfDiaNacimiento );
                    panelFechaNac.add ( new JLabel ( "/" ) );
                    panelFechaNac.add ( this.jtfMesNacimiento );
                    panelFechaNac.add ( new JLabel ( "/" ) );
                    panelFechaNac.add ( this.jtfAnioNacimiento );
                    
                
                JLabel labelLugarNacimiento = new JLabel ( "Lugar de Nac: " );
                this.jtfLugarNacimiento = new JTextField ( 20 );
                JLabel labelNacionalidad = new JLabel ( "Nacionalidad: " );
                this.jtfNacionalidad = new JTextField ( 20 );
                
                panelNac.add ( labelFechaNac, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 0, 1, 1, 0.1, ( 1.0 / panelNacFilas ), null ) );
                panelNac.add ( panelFechaNac, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.BOTH, 1, 0, 1, 1, 0.9, ( 1.0 / panelNacFilas ), null ) );
                panelNac.add ( labelLugarNacimiento, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 1, 1, 1, 0.1, ( 1.0 / panelNacFilas ), null ) );
                panelNac.add ( this.jtfLugarNacimiento, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.9, ( 1.0 / panelNacFilas ), null )  );
                panelNac.add ( labelNacionalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 2, 1, 1, 0.1, ( 1.0 / panelNacFilas ), null )  );
                panelNac.add ( this.jtfNacionalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.9, ( 1.0 / panelNacFilas ), null )  );
                /*panelNac.add ( labelLugarNacimiento );
                panelNac.add ( this.jtfLugarNacimiento );
                panelNac.add ( labelNacionalidad );
                panelNac.add ( this.jtfNacionalidad );*/               
                
        contenedorDocumento.add ( panelNac, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.5, 0.95, null ) );
        /*=====  End of Panel Nacimiento  ======*/
        
    }
    
    private GridBagConstraints ConstraintsGridBag ( int Posicionrelativa, int Rellenar, int X, int Y, int Ancho, int Alto, double WeightX, double WeightY, Insets margen )
    {
        
        
        GridBagConstraints gbc = new GridBagConstraints ();
        
        gbc.gridx = X;
        gbc.gridy = Y;
        gbc.gridwidth = Ancho;
        gbc.gridheight = Alto;
        gbc.anchor = Posicionrelativa;
        gbc.fill = Rellenar;
        gbc.weightx = WeightX;
        gbc.weighty = WeightY;
        
        if ( margen != null )
            gbc.insets = margen;
        
        return gbc;
        
    }
    
    public void Mostrar ()
    {
        
        this.setVisible ( true );
        
    }
    
}
