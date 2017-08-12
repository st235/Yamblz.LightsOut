package sasd97.java_blog.xyz.yamblzlightsout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import sasd97.java_blog.xyz.yamblzlightsout.ui.GameView;
import xyz.javablog.Engine;
import xyz.javablog.GameEngineProvider;
import xyz.javablog.common.fields.Field;
import xyz.javablog.common.points.Click;
import xyz.javablog.common.sizes.SquareSize;

/**
 * Created by alexander on 12/08/2017.
 */

public class GameFragment extends Fragment {

    private GameView gameView;
    private int clicks = 0;
    public TextView clicksTextView;
    private Button undoButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game, container, false);

        final Engine engine = GameEngineProvider.getEngine();
        Field field = engine.obtainNewField(new SquareSize(5));
        Log.d("HERE", field.toString());

        gameView = v.findViewById(R.id.fragment_game_game_view);
        clicksTextView = v.findViewById(R.id.CLICKSTextView);
        undoButton = v.findViewById(R.id.undoButton);
        gameView.setNewSize(new SquareSize(5));

        gameView.setMatrix(field.getMatrix());

        gameView.setListener(new GameView.OnGridItemClickListener() {
            @Override
            public void onItemClick(int x, int y) {
                Log.d("HERE", "adsadasda");
                Field f = engine.clickCurrentField(new Click(x, y));
                Log.d("HERE", f.toString());
                gameView.setMatrix(f.getMatrix());
                clicks++;
                clicksTextView.setText(String.valueOf(clicks));

                gameView.invalidate();
            }
        });

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Field f = engine.getPreviousField(1);
                gameView.setMatrix(f.getMatrix());

                gameView.invalidate();
            }
        });



        return v;
    }



}
