package xyz.javablog.session;

/**
 * Created by Grechka on 12.08.2017.
 */

public class SessionNotObtainedException extends Exception {

    SessionNotObtainedException(String message) {
        super(message);
    }

}