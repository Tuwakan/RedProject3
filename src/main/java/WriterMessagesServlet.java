import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;


public class WriterMessagesServlet extends HttpServlet {

    static String lastMessage = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String message = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        CookiesManipulator cm = new CookiesManipulator(request);

        lastMessage += cm.getValueOfCookieOnName("login") + ": " + message + "\n";
        //Chat.addMessage(cm.getValueOfCookieOnName("login") + ": " + message);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write(lastMessage);
    }
}
