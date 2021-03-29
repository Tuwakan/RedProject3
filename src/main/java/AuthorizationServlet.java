import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
        //String password = personalData.substring(personalData.indexOf(":") + 1);

        System.out.println(login);

        if (DBReadWriter.isRegistered(personalData)) {
            Cookie[] cookies = request.getCookies();
            System.out.println("KEKW");
            for (Cookie c : cookies) {
                if (c.getName().equals("login")) {
                    c.setValue(login);
                } else if (c.getName().equals("isLogged")) {
                    c.setValue("true");
                    break;
                }
            }
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("true");
            writer.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //response.sendRedirect(request.getContextPath() + "/logInPage");

        /*RequestDispatcher dispatcher = req.getRequestDispatcher("/UserGUI.jsp");
        dispatcher.forward(req, resp);*/
    }
}