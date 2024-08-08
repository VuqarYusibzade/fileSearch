import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JSONtoXMLConverter {
    public static void main(String[] args) {
        try {
            File jsonFile = new File("C:\\Users\\yusib\\IdeaProjects\\HomeWorkFiles\\src\\main\\java\\JSONFILE.json");
            File xmlFile = new File("output.xml");

            ObjectMapper jsonMapper = new ObjectMapper();
            Object jsonObject = jsonMapper.readValue(jsonFile, Object.class);

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(xmlFile, jsonObject);

            System.out.println("Ugurlu oldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
