package xyz.javablog.session;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Created by alexander on 12/08/2017.
 */

public final class SessionProvider {

    private SessionProvider() {
    }

    public static void checkSession(@Nullable Session session) {
        if (session == null) throw new SessionNotObtainedException();
        if (!session.isInit()) throw new SessionNotInitedException();
    }
}
