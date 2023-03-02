import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WiseSayingFile {
    final static String route = "C:\\Users\\sue\\java-project\\wise-saying\\wise-saying.txt";
    static File file = new File(route);

    public void createFile() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeFile(List<WiseSaying> list) {
        try {
            FileOutputStream outputStream = new FileOutputStream(file);

            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            return;
        }
    }

    public List<WiseSaying> readFile() {
        List<WiseSaying> wiseSayingList = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(file);

            ObjectInputStream ois = new ObjectInputStream(inputStream);
            wiseSayingList = (ArrayList<WiseSaying>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            return wiseSayingList;
        }

        return wiseSayingList;
    }
}
