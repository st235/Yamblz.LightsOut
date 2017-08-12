package sasd97.java_blog.xyz.yamblzlightsout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import sasd97.java_blog.xyz.yamblzlightsout.ui.GameView;
import sasd97.java_blog.xyz.yamblzlightsout.ui.SizeImpl;
import xyz.javablog.models.Size;

public class MainActivity extends AppCompatActivity {

    private GameView gameView;
    private RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl = (RelativeLayout) findViewById(R.id.ll);
        gameView = (GameView) findViewById(R.id.game_view);
        Size size = new SizeImpl(3, 3);
        gameView.measure(rl.getWidth(), rl.getHeight());
        gameView.setNewSize(size);

    }
}
