import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XMLtoJSONConverter {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("C:\\Users\\yusib\\IdeaProjects\\HomeWorkFiles\\src\\main\\java\\XMLFILE.xml");
            File jsonFile = new File("output.json");

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(jsonFile, xmlFile);

            System.out.println("Ugurlu oldu.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
