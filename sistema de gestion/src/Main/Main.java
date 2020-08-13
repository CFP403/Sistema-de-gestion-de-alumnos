
package Main;

import Ventanas.VentanaPrincipal;

/**
 * @author lucas
 */

public class Main {
    public static void main(String[] args) {
    
        accesoDatos bd = new accesoDatos();
        bd.DBAccess();
        
        VentanaPrincipal root = new VentanaPrincipal();
        root.Mostrar();

    }
}
