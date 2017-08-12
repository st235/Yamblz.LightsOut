package xyz.javablog.session;

/**
 * Created by alexander on 12/08/2017.
 */

public final class SessionProvider {

    private SessionProvider() {
    }

    public static void checkSession(Session session) {
        if (session == null) throw new SessionNotObtainedException();
        if (!session.isInit()) throw new SessionNotInitedException();
    }
}
