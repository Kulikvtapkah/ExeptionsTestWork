package ExeptionsTestWork;

import java.io.FileWriter;
import java.io.IOException;

public class DataSaver {
    public static void saveToFile(String fileName, String dataToAdd) {

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(dataToAdd);

            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

}
