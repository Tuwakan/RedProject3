import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionInitialisationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean hasRedirect = false;

        Cookie[] cookies = request.getCookies();
        String cookieName = "isLogged";
        if(cookies != null) {
            for(Cookie c: cookies) {
                if(cookieName.equals(c.getName())) {
                    if (c.getValue().equals("true")) {
                        response.sendRedirect("http://localhost:8080/UserGUI.jsp");
                        hasRedirect = true;
                        break;
                    }
                }
            }
            if (!hasRedirect)
                response.sendRedirect("http://localhost:8080/LogInPage.html");
        }
        else {
            response.addCookie(new Cookie("login", null));
            response.addCookie(new Cookie("isLogged", null));
        }
    }
}
