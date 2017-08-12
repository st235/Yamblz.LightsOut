package xyz.javablog;

/**
 * Created by alexander on 12/08/2017.
 */

public class GameEngineProvider {

    private static Engine engine;

    private GameEngineProvider() {
    }

    public static Engine getEngine() {
        if (engine == null) {
            engine = new GameEngine();
        }

        return engine;
    }
}
