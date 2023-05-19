package donuts;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {


		//Donuts lemon = new Donuts();
		MySqlConnection conn = new MySqlConnection("jdbc:mysql://localhost:3306/Donut", "root", "P@$$w0rd");
		//lemon=
				conn.getDonuts(4);
		//lemon.printDonut();
		

	}

}
