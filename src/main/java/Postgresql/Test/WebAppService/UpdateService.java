package Postgresql.Test.WebAppService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class UpdateService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;

		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://database-1.ceablswslmfv.ap-southeast-1.rds.amazonaws.com:5432/postgres",
					"adminprogress","password");
			conn.setAutoCommit(false);
			System.out.println("Open database successfully");
			
			stmt = conn.createStatement();
			String sql = "UPDATE cardlite.embossing_file2 set emr_fie_txt = 'Test1234' where sid=3";
	        stmt.executeUpdate(sql);
	        conn.commit();
	         
	         
			ResultSet rs = stmt.executeQuery( "SELECT * FROM cardlite.embossing_file2;" );
	         while (rs.next() ) {
	            int sid = rs.getInt("sid");
	            String  emr_fie_txt = rs.getString("emr_fie_txt");
	            
	            System.out.println( "sid = " + sid );
	            System.out.println( "emr_fie_txt = " + emr_fie_txt );

	            System.out.println();
	         }
			
			
			stmt.close();
			conn.commit();
			conn.close();
		}
	       catch (Exception e) {
	           System.err.println(e.getClass().getName()+": "+ e.getMessage() );
	           System.exit(0);
	       }
	       System.out.println("Operation done successfully");
	    }
	

}
