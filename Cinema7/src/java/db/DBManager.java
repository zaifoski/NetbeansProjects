package db;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DBManager implements Serializable {
    // transient == non viene serializzato

    private transient Connection con;
    
    public DBManager(String dburl) throws SQLException {

        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver", true, getClass().getClassLoader());

        } catch(Exception e) {
            throw new RuntimeException(e.toString(), e);
        }
        
        Connection con = DriverManager.getConnection(dburl);
        this.con = con;

    }


    public static void shutdown() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).info(ex.getMessage());
        }
    }
    /**
     * Autentica un utente in base a un nome utente e a una password
     * 
     * @param username il nome utente
     * @param password la password
     * @return null se l'utente non è autenticato, un oggetto User se l'utente esiste ed è autenticato
     */

    public User authenticate(String username, String password) throws SQLException {
        // usare SEMPRE i PreparedStatement, anche per query banali. 
        // *** MAI E POI MAI COSTRUIRE LE QUERY CONCATENANDO STRINGHE !!!! ***

        PreparedStatement stm = con.prepareStatement("SELECT * FROM username.utenti WHERE email = ? AND pass = ?");
        try {
            stm.setString(1, username);
            stm.setString(2, password);
            
            ResultSet rs = stm.executeQuery();

            try {
                if (rs.next()) {
                    User user = new User();
                    user.setUsername(username);
//                    user.setFullname(rs.getString("fullname"));
                    
                    return user;
                } else {
                    return null;
                }
            } finally {
                // ricordarsi SEMPRE di chiudere i ResultSet in un blocco finally 
                rs.close();
            }
        } finally { // ricordarsi SEMPRE di chiudere i PreparedStatement in un blocco finally 
            stm.close();
        }
    }
    
    
    /*inizio registrazione*/
    public void registrati(String username, String password) throws SQLException {
        // usare SEMPRE i PreparedStatement, anche per query banali. 
        // *** MAI E POI MAI COSTRUIRE LE QUERY CONCATENANDO STRINGHE !!!! ***

        PreparedStatement stm = con.prepareStatement("INSERT INTO username.utenti"
		+ "(email, pass) VALUES"
		+ "(?,?)");
        try {
            stm.setString(1, username);
            stm.setString(2, password);
            
            stm.executeUpdate();

        } finally { // ricordarsi SEMPRE di chiudere i PreparedStatement in un blocco finally 
            stm.close();
        }
        
    }
    
     
    /*fine registrazione*/
}