package GameManager;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class XMLAdapter implements Adapter {
    public void saveData(LinkedHashMap<String, User> userList) {
        try {
            XMLEncoder encoder = new XMLEncoder(new FileOutputStream("userList.xml"));
            encoder.writeObject(userList);
            encoder.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public LinkedHashMap<String, User> loadData() {
        try {
            XMLDecoder decoder = new XMLDecoder(new FileInputStream("userList.xml"));
            LinkedHashMap<String, User> userList = (LinkedHashMap<String, User>) decoder.readObject();
            decoder.close();
            return userList;
        }
        catch(FileNotFoundException fileNotFound){
            System.out.println(fileNotFound.getMessage());
            return null;
 }
    }
}
