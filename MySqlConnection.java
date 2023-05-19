package donuts;
import java.sql.*;


public class MySqlConnection {
	

	    private Connection con;

	    public MySqlConnection(String url, String user, String password) throws SQLException {
	        con = DriverManager.getConnection(url, user, password);
	    }

	    public void getDonuts(int donutID) throws SQLException {
	        String query = "SELECT * FROM donuts WHERE donutID = ?";
	        PreparedStatement stmt = con.prepareStatement(query);
	        stmt.setInt(1, donutID);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            int id = rs.getInt("donutID");
	            String name = rs.getString("Donut_name");
	            float price = rs.getFloat("Donut_price");
	            new Donuts(id, name, price).printDonut();
	        } else {
	        	System.out.print("Error occurred");
	        }
	    }

	    public void close() throws SQLException {
	        con.close();
	    }
	}


