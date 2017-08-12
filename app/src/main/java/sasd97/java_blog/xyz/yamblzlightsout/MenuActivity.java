package sasd97.java_blog.xyz.yamblzlightsout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sasd97.java_blog.xyz.yamblzlightsout.events.OnGameListener;

public class MenuActivity extends AppCompatActivity implements OnGameListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        startGame();
    }

    @Override
    public void onRestartListener() {
        startGame();
    }

    @Override
    public void onFinish(int score) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_menu_fragment_container, FinishFragment.getInstance(score))
                .commit();
    }

    private void startGame() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_menu_fragment_container, new GameFragment())
                .commit();
    }
}
