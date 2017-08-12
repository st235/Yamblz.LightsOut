package xyz.javablog.session;

/**
 * Created by Grechka on 12.08.2017.
 */

public class SessionNotInitedException extends RuntimeException {

    SessionNotInitedException() {
        super("Session not initialized. Please init current session before obtain-type operation. See below session.init() method.");
    }

}