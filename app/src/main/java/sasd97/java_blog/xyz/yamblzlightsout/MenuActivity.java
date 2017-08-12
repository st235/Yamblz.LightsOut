package sasd97.java_blog.xyz.yamblzlightsout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import sasd97.java_blog.xyz.yamblzlightsout.ui.GameView;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = MenuActivity.class.getCanonicalName();

    private GameView gameView;
    private RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}
