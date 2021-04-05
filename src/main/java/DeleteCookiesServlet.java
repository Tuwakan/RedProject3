import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Cookie[] cookies = request.getCookies();
        Cookie tmpCookie;

        for (Cookie c : cookies) {
            if (c.getName().equals("login")) {
                tmpCookie = new Cookie("login", null);
                tmpCookie.setMaxAge(0);
                response.addCookie(tmpCookie);
            } else if (c.getName().equals("isLogged")) {
                tmpCookie = new Cookie("isLogged", "false");
                tmpCookie.setMaxAge(0);
                response.addCookie(tmpCookie);
                break;
            }
        }
        PrintWriter writer = response.getWriter();
        writer.print("true");
        writer.close();
    }
}
