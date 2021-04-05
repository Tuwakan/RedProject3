public class Chat {
    private static String text = "";

    public static String getText() {
        return text;
    }

    public static void addMessage(String text) {
        Chat.text += text + "\n";
    }
}
