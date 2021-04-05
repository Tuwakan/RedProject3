import java.io.*;

public class DBReadWriter {

    static String pathToDB = "C:\\Users\\Tuwakan\\IdeaProjects\\RedProject\\src\\main\\resources\\db.txt";
    static File file = new File(pathToDB);

    public static boolean isRegistered(String personalData) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            if (line.equals(personalData))
                return true;
            line = reader.readLine();
        }
        return false;
    }

    public static void registerUser(String personalData) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.append("\n").append(personalData);
        writer.close();
    }

    /*public static void getPasswordByLogin(String login) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            if (line.substring(0, line.indexOf(":") + 1).equals(login))
                return true;
            line = reader.readLine();
        }
        return false;
    }*/
}
