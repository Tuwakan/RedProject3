import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookiesManipulator {

    Cookie[] cookies;

    public CookiesManipulator(HttpServletRequest request) {
        cookies = request.getCookies();
    }

    public String getValueOfCookieOnName(String nameOfCookie) {
        for (Cookie c : cookies) {
            if (c.getName().equals(nameOfCookie)) {
                return c.getValue();
            }
        }
        return null;
    }

    /*public void deleteCookieOnName(String nameOfCookie) {
        for (Cookie c : cookies) {
            if (c.getName().equals(nameOfCookie)) {
                c.setMaxAge(0);
            }
        }
    }*/
}
