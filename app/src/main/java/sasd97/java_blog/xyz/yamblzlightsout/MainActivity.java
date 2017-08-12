package sasd97.java_blog.xyz.yamblzlightsout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import sasd97.java_blog.xyz.yamblzlightsout.ui.GameView;
import xyz.javablog.models.Matrix;
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
        Size size = new SizeImpl(5, 5);

        int[][] ar = new int[5][5];

        ar[1][1] = 1;

        ar[4][4] = 1;

        Matrix matrix = new MatrixImpl(ar);

        gameView.measure(rl.getWidth(), rl.getHeight());
        gameView.setNewSize(size);
        gameView.setMatrix(matrix);

    }
}
