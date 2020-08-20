
package Alumno;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
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
            private JTextField jtfDomicilioCalle;
            private JTextField jtfNro;
            private JTextField jtfPiso;
            private JTextField jtfTorre;
            private JTextField jtfDpto;
            private JTextField jtfLocalidad;
            private JTextField jtfCodPostal;
            private JTextField jtfTelefono;
            private JTextField jtfEmail;
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
            this.add ( this.jpDatosAlumno, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.BOTH, 0, 0, 1, 1, 1, 1, null ) );
            
            
    }
    
    private void agregarDocumento ( JPanel contenedorDocumento )
    {
        
        double Filas = 4.0;
        
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
        
        /*=====  End of Panel EstadoDoc  ======*/
        
        contenedorDocumento.add ( panelTipoDocumentos, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, 0, 0, 1, 1, 0.5, ( 1.0 / Filas ), null ) );
        contenedorDocumento.add ( panelEstado, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL, 1, 0, 1, 1, 0.5, ( 1.0 / Filas ), null ) );
        
        /*==================================================
        =            Panel Información Personal            =
        ==================================================*/
        JPanel panelInfoPers = new JPanel();
        double panelInfoFilas = 3.0;
            panelInfoPers.setLayout ( this.layout );
                
                /*----------  Apellido/s  ----------*/
                JLabel labelApellidos = new JLabel ( "Apellido/s: " );
                this.jtfApellido = new JTextField ( 15 );
                panelInfoPers.add ( labelApellidos, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 0, 1, 1, 0.1, ( 1.0 / panelInfoFilas ), null ) );
                panelInfoPers.add ( this.jtfApellido, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 0, 1, 1, 0.9, ( 1.0 / panelInfoFilas ), null ) );
                /*----------  End of Apellido/s  ----------*/
                
                /*----------  Nombre/s  ----------*/
                JLabel labelNombres = new JLabel ( "Nombre/s:" );
                this.jtfNombre = new JTextField ( 15 );
                panelInfoPers.add ( labelNombres, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.1, ( 1.0 / panelInfoFilas ), null ) );
                panelInfoPers.add ( this.jtfNombre, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.9, ( 1.0 / panelInfoFilas ), null ) );
                /*----------  End of Nombre/s  ----------*/
                
                /*----------  Sexo  ----------*/
                JLabel labelSexo = new JLabel ( "Sexo: " );
                String [] Sexos = { "Masculino", "Femenino" };
                this.jcbSexo = new JComboBox ( Sexos );
                panelInfoPers.add ( labelSexo, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 2, 1, 1, 0.1, ( 1.0 / panelInfoFilas ), null ) );
                panelInfoPers.add ( this.jcbSexo, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.9, ( 1.0 / panelInfoFilas ), null ) );
                /*----------  End of Sexo  ----------*/
                
        /*=====  End of Panel Información Personal  ======*/
        
        contenedorDocumento.add ( panelInfoPers, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.5, ( 1.0 / Filas ), null ) );
        
        /*========================================
        =            Panel Nacimiento            =
        ========================================*/
        JPanel panelNac = new JPanel ();
        double panelNacFilas = 3.0;
            panelNac.setLayout ( this.layout );
            Insets margenlabelsNacimiento = new Insets ( 0, 10, 0, 0 );
                
                /*----------  FechaNac  ----------*/
                JPanel panelFechaNac = new JPanel ();
                    JLabel labelFechaNac = new JLabel ( "Fecha de Nacimiento: " );
                    panelFechaNac.setLayout ( new FlowLayout ( FlowLayout.LEFT ) );
                    this.jtfDiaNacimiento = new JTextField ( 2 );
                    this.jtfMesNacimiento = new JTextField ( 2 );
                    this.jtfAnioNacimiento = new JTextField ( 4 );
                    panelFechaNac.add ( labelFechaNac );
                    panelFechaNac.add ( this.jtfDiaNacimiento );
                    panelFechaNac.add ( new JLabel ( "/" ) );
                    panelFechaNac.add ( this.jtfMesNacimiento );
                    panelFechaNac.add ( new JLabel ( "/" ) );
                    panelFechaNac.add ( this.jtfAnioNacimiento );
                panelNac.add ( panelFechaNac, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 0, 2, 1, 1.0, ( 1.0 / panelNacFilas ), margenlabelsNacimiento ) );
                /*----------  End of FechaNac  ----------*/
                
                /*----------  LugarNacimiento  ----------*/
                JLabel labelLugarNacimiento = new JLabel ( "Lugar de Nac: " );
                this.jtfLugarNacimiento = new JTextField ( 20 );
                panelNac.add ( labelLugarNacimiento, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.1, ( 1.0 / panelNacFilas ), margenlabelsNacimiento ) );
                panelNac.add ( this.jtfLugarNacimiento, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.9, ( 1.0 / panelNacFilas ), null )  );
                /*----------  End of LugarNacimiento  ----------*/
                
                /*----------  Nacionalidad  ----------*/
                JLabel labelNacionalidad = new JLabel ( "Nacionalidad: " );
                this.jtfNacionalidad = new JTextField ( 20 );
                panelNac.add ( labelNacionalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 2, 1, 1, 0.1, ( 1.0 / panelNacFilas ), margenlabelsNacimiento )  );
                panelNac.add ( this.jtfNacionalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.9, ( 1.0 / panelNacFilas ), null )  );
                /*----------  End of Nacionalidad  ----------*/
                
        /*=====  End of Panel Nacimiento  ======*/
        
        contenedorDocumento.add ( panelNac, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.5, ( 1.0 / Filas ), null ) );
        
        /*=======================================
        =            Panel Domicilio            =
        =======================================*/
        JPanel panelDomic = new JPanel ();
        double panelDomicFilas = 3.0;
            panelDomic.setLayout ( new GridBagLayout () );
                
                /*----------  Domicilio  ----------*/
                JLabel labelCalleDomicilio = new JLabel ( "Calle - Domicilio: " );
                this.jtfDomicilioCalle = new JTextField ( 20 );
                panelDomic.add ( labelCalleDomicilio, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 0, 1, 1, 0.1, ( 1.0 / panelDomicFilas ), null ) );
                panelDomic.add ( this.jtfDomicilioCalle, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 0, 3, 1, 0.9, ( 1.0 / panelDomicFilas ), null ) );
                /*----------  End of Domicilio  ----------*/
                
                /*----------  Número  ----------*/
                JLabel labelNro = new JLabel ( "N°: " );
                this.jtfNro = new JTextField ( 4 );
                panelDomic.add ( labelNro, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                panelDomic.add ( this.jtfNro, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                /*----------  End of Número  ----------*/
                
                /*----------  Piso  ----------*/
                JLabel labelPiso = new JLabel ( "Piso: " );
                this.jtfPiso = new JTextField ( 10 );
                panelDomic.add ( labelPiso, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 2, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                panelDomic.add ( this.jtfPiso, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 3, 1, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                /*----------  End of Piso  ----------*/
                
                /*----------  Torre  ----------*/
                JLabel labelTorre = new JLabel ( "Torre: " );
                this.jtfTorre = new JTextField ( 10 );
                panelDomic.add ( labelTorre, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                panelDomic.add ( this.jtfTorre, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                /*----------  End of Torre  ----------*/
                
                /*----------  Dpto  ----------*/
                JLabel labelDpto = new JLabel ( "Dpto: " );
                this.jtfDpto = new JTextField ( 10 );
                panelDomic.add ( labelDpto, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 2, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                panelDomic.add ( this.jtfDpto, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 3, 2, 1, 1, 0.25, ( 1.0 / panelDomicFilas ), null ) );
                /*----------  End of Dpto  ----------*/
                
        /*=====  End of Panel Domicilio  ======*/
        
        contenedorDocumento.add ( panelDomic, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 2, 1, 1, 0.5, ( 1.0 / Filas ), null ) );
        
        /*================================================
        =            Panel Localidad/Contacto            =
        ================================================*/
        JPanel panelLocalidadContacto = new JPanel ();
        double panelLocalidadContactoFilas = 4.0;
            panelLocalidadContacto.setLayout( new GridBagLayout () );
        
                /*----------  Localidad  ----------*/
                JLabel labelLocalidad = new JLabel ( "Localidad: " );
                this.jtfLocalidad = new JTextField ( 20 );
                panelLocalidadContacto.add ( labelLocalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 0, 1, 1, 0.1, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                panelLocalidadContacto.add ( this.jtfLocalidad, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 0, 3, 1, 0.9, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                /*----------  End of Localidad  ----------*/
                
                /*----------  Teléfono  ----------*/
                JLabel labelTelefono = new JLabel ( "Teléfono: " );
                this.jtfTelefono = new JTextField ( 12 );
                panelLocalidadContacto.add ( labelTelefono, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 0, 1, 1, 1, 0.07, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                panelLocalidadContacto.add ( this.jtfTelefono, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 1, 1, 1, 0.63, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                /*----------  End of Código Teléfono  ----------*/
                /*----------  Código Postal  ----------*/
                JLabel labelCodPostal = new JLabel ( "Código Postal: " );
                Insets margenlabelCodPostal = new Insets ( 0, 10, 0, 0 );
                this.jtfCodPostal = new JTextField ( 4 );
                panelLocalidadContacto.add ( labelCodPostal, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 2, 1, 1, 1, 0.03, ( 1.0 / panelLocalidadContactoFilas ), margenlabelCodPostal ) );
                panelLocalidadContacto.add ( this.jtfCodPostal, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 3, 1, 1, 1, 0.27, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                /*----------  End of Código Postal  ----------*/
                
                /*----------  Email  ----------*/
                JLabel labelEmail = new JLabel ( "E-mail: " );
                this.jtfEmail = new JTextField ( 20 );
                panelLocalidadContacto.add ( labelEmail, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.NONE, 0, 2, 1, 1, 0.1, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                panelLocalidadContacto.add ( this.jtfEmail, this.ConstraintsGridBag ( GridBagConstraints.NORTHWEST , GridBagConstraints.HORIZONTAL, 1, 2, 3, 1, 0.9, ( 1.0 / panelLocalidadContactoFilas ), null ) );
                /*----------  End of Email  ----------*/
                
        /*=====  End of Panel Localidad/Contacto  ======*/
        
        contenedorDocumento.add ( panelLocalidadContacto, this.ConstraintsGridBag ( GridBagConstraints.NORTHEAST , GridBagConstraints.HORIZONTAL, 1, 2, 1, 1, 0.5, ( 1.0 / Filas ), null ) );
        
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
