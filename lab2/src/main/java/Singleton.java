import java.util.HashSet;
import java.util.Set;


public class Singleton {

    private static Singleton singleInstance;
    private Set<String> sessionIds;

    private Singleton() {
        sessionIds = new HashSet();
    }

    public static Singleton getInstance() {
        if (singleInstance == null) {
            singleInstance = new Singleton();
        }
        return singleInstance;
    }

    public Set<String> getSessionIds() {
        return sessionIds;
    }
}
