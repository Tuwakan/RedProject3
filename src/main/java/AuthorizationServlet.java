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
        System.out.println(personalData);
        String login = personalData.substring(0, personalData.indexOf(":"));
        //String password = personalData.substring(personalData.indexOf(":") + 1);

        boolean isUserLogged;
        isUserLogged = DBReadWriter.isRegistered(personalData);

        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("login")) {
                response.addCookie(new Cookie("login", login));
            } else if (c.getName().equals("isLogged")) {
                response.addCookie(new Cookie("isLogged", Boolean.toString(isUserLogged)));
                break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("isLogged")) {
                response.setContentType("text/html");
                PrintWriter writer = response.getWriter();
                if (c.getValue().equals("true")) {
                    writer.print("true");
                } else if (c.getValue().equals("false")) {
                    writer.print("false");
                }
                writer.close();
            }
        }
    }
}
