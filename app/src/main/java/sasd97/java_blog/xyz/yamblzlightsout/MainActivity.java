package sasd97.java_blog.xyz.yamblzlightsout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import xyz.javablog.Engine;
import xyz.javablog.GameEngine;
import xyz.javablog.GameEngineProvider;
import xyz.javablog.common.fields.Field;
import xyz.javablog.common.points.Click;
import xyz.javablog.common.sizes.SquareSize;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Engine engine = GameEngineProvider.getEngine();
        Field field = engine.obtainNewField(new SquareSize(15));
        Log.d(TAG, field.toString());
        int score = engine.calculateCurrentScore(TimeUnit.MINUTES.toMillis(2), 8);
        Log.d(TAG, Integer.toString(score));
    }
}
