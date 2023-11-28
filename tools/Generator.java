import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Generator {
    public static void main(String[] args) throws IOException {
        File file = new File("../index.csv");
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
        File out = new File("../hpc.json");
        out.createNewFile();
        FileWriter writer = new FileWriter(out);
        writer.write("[");
        int i = 0;
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] pattern = s.split(",");
            if (i != 0)
                writer.append(",");
            writer.append("{\"type\":\"" + pattern[0] + "\",\"id\":\"" + ((pattern.length > 1) ? pattern[1] : "") + "\",\"reason\":\"" + ((pattern.length > 2) ? pattern[2] : "") + "\",\"amount\":\"" + ((pattern.length > 3) ? pattern[3] : "") + "\"}");
            ++i;
        }
        writer.append(']');
        writer.close();
        scanner.close();
    }
}