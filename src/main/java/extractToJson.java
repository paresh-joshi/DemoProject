import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class extractToJson {

    public static void main(String[] args) throws IOException {
    	//Convert JsonFile to JAVA object
        ObjectMapper o = new ObjectMapper();
        CustomerDetails1 c = o.readValue(new File("C:\\Users\\pjoshi\\IdeaProjects\\Demo\\info0.json"),CustomerDetails1.class);
        System.out.println(c.getCourseName());
    }
}
