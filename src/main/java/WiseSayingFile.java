import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WiseSayingFile {
    final static String fileRoute = "C:\\Users\\sue\\java-project\\wise-saying\\wise-saying.txt";
    static File textFile = new File(fileRoute);

    public void createFile() {
        try {
            textFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(List<WiseSaying> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(textFile);

            ObjectOutputStream fileOos = new ObjectOutputStream(fileOutputStream);

            fileOos.writeObject(list);
            fileOos.close();

        } catch (Exception e) {
            return;
        }
    }

    public List<WiseSaying> readFile() {
        List<WiseSaying> wiseSayingList = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream(textFile);

            ObjectInputStream ois = new ObjectInputStream(inputStream);
            wiseSayingList = (ArrayList<WiseSaying>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            return wiseSayingList;
        }

        return wiseSayingList;
    }
}
