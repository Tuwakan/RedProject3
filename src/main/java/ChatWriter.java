import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ChatWriter {

    static String pathToDB = "C:\\Users\\Tuwakan\\IdeaProjects\\RedProject\\src\\main\\webapp\\chat.txt";
    static File file = new File(pathToDB);

    public static void writeMessage(String message) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.append(message).append("\n");
        writer.close();
    }
}
