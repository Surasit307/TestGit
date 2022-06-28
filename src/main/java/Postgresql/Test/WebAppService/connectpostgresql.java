package Postgresql.Test.WebAppService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectpostgresql {
		private final String url = "jdbc:postgresql://database-1.ceablswslmfv.ap-southeast-1.rds.amazonaws.com:5432/postgres";
	    private final String user = "adminprogress";
	    private final String password = "password";

	    /**
	     * Connect to the PostgreSQL database
	     *
	     * @return a Connection object
	     */
	    public Connection connect() {
	        Connection conn = null;  
	        
	        try {
	            conn = DriverManager.getConnection(url, user, password);

	            if (conn != null) {
	                System.out.println("Connected to the PostgreSQL server successfully.");
	            } else {
	                System.out.println("Failed to make connection!");
	            }

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	        return conn;
	    }

	    public static void main(String[] args) {
	        connectpostgresql app = new connectpostgresql();
	        app.connect();
	    }
	
}
