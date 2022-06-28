package Postgresql.Test.WebAppService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class InsertService {

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
			String sql = "INSERT INTO cardlite.embossing_file2(sid,emr_fie_txt)" + "VALUES(3,'test3');";
			stmt.executeUpdate(sql);
			
			/*sql = "INSERT INTO cardlite.embossing_file2(sid,emr_fie_txt)" + "VALUES(6,'test7');";
			stmt.executeUpdate(sql);*/
			
			/*
			if(x > 0) {
				System.out.println("Insert Data Success");
			}else {
			System.out.print("Insert Data Failed");
			}*/
			
			stmt.close();
			conn.commit();
			conn.close();
		}
	       catch (Exception e) {
	           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	           System.exit(0);
	       }
	       System.out.println("Records created successfully");
	    }
	

}
