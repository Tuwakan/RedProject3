import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String personalData = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        if (DBReadWriter.isRegistered(personalData))
            request.getSession().setAttribute("isRegistered", true);
        else
            request.getSession().setAttribute("isRegistered", false);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("http://localhost:8080/UserGUI.jsp");
    }
}