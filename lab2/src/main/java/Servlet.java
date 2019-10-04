import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class Servlet extends javax.servlet.http.HttpServlet {

    private HashMap<Integer, Set<String>> hashMap;
    private Set<String> sessionIds;

    public void init() {
        hashMap = new HashMap();
        sessionIds = Singleton.getInstance().getSessionIds();
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        int res = Integer.parseInt(request.getParameter("res"));
        String hash = request.getSession().getAttribute("hash").toString();

        if (hashMap.containsKey(res)) {
            if (hashMap.get(res).contains(hash)) {
                String sessionId = UUID.randomUUID().toString();
                sessionIds.add(sessionId);
                Cookie cookie = new Cookie("sessionId", sessionId);
                response.addCookie(cookie);
                response.sendRedirect("/webappSumCheck_war_exploded/hello_inside.jsp");
            }
        } else {
            response.sendRedirect("/webappSumCheck_war_exploded/");
        }
    }


    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        final int minInRange = -125;
        final int maxInRange = 347;

        java.util.Random random = new java.util.Random();
        int digit1 = random.nextInt((maxInRange - minInRange) + 1) + minInRange;
        int digit2 = random.nextInt((maxInRange - minInRange) + 1) + minInRange;
        int sum = digit1 + digit2;

        String hash = Integer.toString((Long.valueOf(sum + System.currentTimeMillis())).hashCode());

        if (hashMap.containsKey(sum)) {
            hashMap.get(sum).add(hash);
        } else {
            Set<String> hashes = new HashSet();
            hashes.add(hash);
            hashMap.put(sum, hashes);
        }

        request.setAttribute("digit1", digit1);
        request.setAttribute("digit2", digit2);
        request.getSession().setAttribute("hash", hash);
        request.getRequestDispatcher("/count_to_get_in.jsp").forward(request, response);
    }
}
