import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {

    private Set<String> sessionIds;

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {
        sessionIds = Singleton.getInstance().getSessionIds();
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        Cookie[] cookies = request.getCookies();

        if (!sessionIds.isEmpty()) {
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("sessionId") && sessionIds.contains(cookie.getValue())) {
                        request.getRequestDispatcher("/hello_inside.jsp").forward(request, response);
                    }
                }
            }
        }

        chain.doFilter(req, resp);
    }
}
