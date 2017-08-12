package xyz.javablog.session;

/**
 * Created by Grechka on 12.08.2017.
 */

public class SessionNotObtainedException extends RuntimeException {

    SessionNotObtainedException() {
        super("Session not created. Please create new session before obtain-type operation. See below obtainNewField() method.");
    }

}