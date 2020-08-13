

package Main;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author Lucas Bois
 */

public class accesoDatos {
    
    protected Connection connectionDB;
    protected PreparedStatement ps;
    
    private static accesoDatos mAccesoDatos = null;
    
    static public accesoDatos getInstance()
    {
        if (mAccesoDatos == null)
            mAccesoDatos = new accesoDatos();
        
        return mAccesoDatos;
    }
        
    public void DBAccess() {
        
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver");
            this.connectionDB = DriverManager.getConnection("jdbc:mysql://database-gestioncfp.cfatz1npq7zg.sa-east-1.rds.amazonaws.com:3306/?user=root&password=1125107348");
            System.out.println("works ...");
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void VenderTicket() {
        
    }    
}   

/*    
    static private Singleton singleton = null;
     private Singleton() { }
     static public Singleton getSingleton() {
         if (singleton == null) {
             singleton = new Singleton();
         }
        return singleton;
    }
     public String metodo() {
         return "Singleton instanciado";
     }
 }

Singleton.getSingleton().metodo();
}
*/