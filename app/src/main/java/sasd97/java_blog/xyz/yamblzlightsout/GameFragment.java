package sasd97.java_blog.xyz.yamblzlightsout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game, container, false);

        final Engine engine = GameEngineProvider.getEngine();
        Field field = engine.obtainNewField(new SquareSize(5));
        Log.d("HERE", field.toString());

        gameView = v.findViewById(R.id.fragment_game_game_view);
        gameView.setNewSize(new SquareSize(5));

        gameView.setMatrix(field.getMatrix());

        gameView.setListener(new GameView.OnGridItemClickListener() {
            @Override
            public void onItemClick(int x, int y) {
                Log.d("HERE", "adsadasda");
                Field f = engine.clickCurrentField(new Click(x, y));
                Log.d("HERE", f.toString());
                gameView.setMatrix(f.getMatrix());
                gameView.invalidate();
            }
        });


        return v;
    }


}
