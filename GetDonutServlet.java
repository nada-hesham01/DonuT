package donuts;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDonutServlet
 */
@WebServlet("/GetDonutServlet")
public class GetDonutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int donutID;

	protected void doGet(HttpServletRequest request, HttpServletResponse response, int donutID) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to the MySQL database
            String url = "jdbc:mysql://localhost:3306/Donut";
            String user = "root";
            String password = "P@$$w0rd";
            Connection con = DriverManager.getConnection(url, user, password);

            // Retrieve the name and price of a donut from the database
            this.donutID = donutID;
            String query = "SELECT Donut_name, Donut_price FROM donuts WHERE donutID = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, donutID);
            ResultSet rs = stmt.executeQuery();

            // Display the name and price of the donut in an HTML page
            out.println("<html>");
            out.println("<head><title>Donut Information</title></head>");
            out.println("<body>");
            if (rs.next()) {
                String name = rs.getString("Donut_name");
                float price = rs.getFloat("Donut_price");
                out.println("<h1>" + name + "</h1>");
                out.println("<p>Price: $" + price + "</p>");
            } else {
                out.println("<p>No donut found with ID " + donutID + "</p>");
            }
            out.println("</body>");
            out.println("</html>");

            // Close the database connection
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
