import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class oneSingleJson {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        // TODO Auto-generated method stub

        
    	 Class.forName("com.mysql.cj.jdbc.Driver");
        /* For Database PostgreSql
        //Class.forName("org.postgresql.Driver");
        // For Database MongoDB
        //Class.forName("mongodb.jdbc.MongoDriver")*/
        
        ArrayList<CustomerDetails> a = new ArrayList<CustomerDetails>();
        JsonArray js = new JsonArray();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "Expleo12345");
        Statement st = conn.createStatement();
        
        ResultSet rs = st.executeQuery("select * from CustomerInfo where location = 'Asia';");
        while (rs.next()) {
        	CustomerDetails c = new CustomerDetails();
            c.setCourseName(rs.getString(1));
            c.setPurchasedDate(rs.getString(2));
            c.setAmount(rs.getInt(3));
            c.setLocation(rs.getString(4));
            a.add(c);
            //System.out.println(rs.getInt(3));
            //System.out.println(rs.getString(1));
            //System.out.println(rs.getString(2));
            //System.out.println(rs.getString(4));
            System.out.println(c.getCourseName());
            System.out.println(c.getAmount());
            System.out.println(c.getPurchasedDate());
            System.out.println(c.getLocation());
            
        }

        for (int i = 0; i < a.size(); i++) {
            ObjectMapper o = new ObjectMapper();
            o.writeValue(new File("C:\\Users\\pjoshi\\IdeaProjects\\Demo\\info"+i+".json"),a.get(i));
            Gson g = new Gson();
            String jsonString = g.toJson(a.get(i));
            js.add(jsonString);
        }

        JSONObject jo = new JSONObject();
        jo.put("data",js);
        System.out.println(jo.toJSONString());
        String unescapeString = StringEscapeUtils.unescapeJava(jo.toJSONString());
        System.out.println(unescapeString);
        String String1 = unescapeString.replace("\"{","{");
        String finalString = String1.replace("}\"","}");
        System.out.println(finalString);
        try(FileWriter file = new FileWriter("C:\\Users\\pjoshi\\IdeaProjects\\Demo\\oneSingleJson.json")){
            file.write(finalString);
        }
    }

}

