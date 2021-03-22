import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class AuthorizationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String personalData = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        String login = personalData.substring(0, personalData.indexOf(":"));
        String password = personalData.substring(personalData.indexOf(":") + 1);
        if (DBReadWriter.isRegistered(personalData)) {
            System.out.println(login);
            request.getSession().setAttribute("login", login);
            System.out.println(password);
            request.getSession().setAttribute("password", password);
            response.sendRedirect(request.getContextPath() + "/UserGUI.jsp");
        }else{
            response.sendRedirect(request.getContextPath() + "/signInPage");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect(request.getContextPath() + "/logInPage");

        /*RequestDispatcher dispatcher = req.getRequestDispatcher("/UserGUI.jsp");
        dispatcher.forward(req, resp);*/
    }
}