package sn.ucad.esp.glsi;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnexionBD {
    public static Connection ouvrir() throws Exception {
        Properties p = new Properties();
        try (InputStream in = ConnexionBD.class.getResourceAsStream("/db.properties")) {
            p.load(in);
        }
        return DriverManager.getConnection(
                p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
    }

    public static void main(String[] args) {
        try (Connection c = ouvrir()) {
            System.out.println("Connexion OK : " + c.getMetaData().getURL());
        } catch (Exception e) {
            System.out.println("Echec : " + e.getMessage());
        }
    }
}
