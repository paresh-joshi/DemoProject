import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Jackson {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        // TODO Auto-generated method stub

        
    	 Class.forName("com.mysql.cj.jdbc.Driver");
        /* For Database PostgreSql
        //Class.forName("org.postgresql.Driver");
        // For Database MongoDB
        //Class.forName("mongodb.jdbc.MongoDriver")*/
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "Expleo12345");
        Statement st = conn.createStatement();
        ArrayList<CustomerDetails> a = new ArrayList<CustomerDetails>();
        ResultSet rs = st.executeQuery("select * from CustomerInfo where location = 'Asia';");
        while (rs.next()) {
        	
        	CustomerDetails c = new CustomerDetails();
            c.setCourseName(rs.getString(1));
            c.setPurchasedDate(rs.getString(2));
            c.setAmount(rs.getInt(3));
            c.setLocation(rs.getString(4));
            a.add(c);
            System.out.println(c.getCourseName());
            System.out.println(c.getAmount());
            System.out.println(c.getPurchasedDate());
            System.out.println(c.getLocation());
            
        }

        for (int i = 0; i < a.size(); i++) {
            ObjectMapper o = new ObjectMapper();
            o.writeValue(new File("C:\\Users\\pjoshi\\IdeaProjects\\Demo\\info"+i+".json"),a.get(i));
            
}
	}
}
