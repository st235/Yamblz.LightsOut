package sasd97.java_blog.xyz.yamblzlightsout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import sasd97.java_blog.xyz.yamblzlightsout.events.OnGameListener;
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

    private OnGameListener listener;

    private int clicks = 0;
    private GameView gameView;
    private Button undoButton;
    private Button restartButton;
    public TextView clicksTextView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener = (OnGameListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game, container, false);

        final Engine engine = GameEngineProvider.getEngine();
        Field field = engine.obtainNewField(new SquareSize(5));

        gameView = v.findViewById(R.id.fragment_game_game_view);
        clicksTextView = v.findViewById(R.id.fragment_game_clicks_counter);
        undoButton = v.findViewById(R.id.fragment_game_button_undo);
        restartButton = v.findViewById(R.id.fragment_game_restart);
        gameView.setNewSize(new SquareSize(5));

        gameView.setMatrix(field.getMatrix());

        gameView.setListener(new GameView.OnGridItemClickListener() {
            @Override
            public void onItemClick(int x, int y) {
                Field f = engine.clickCurrentField(new Click(x, y));
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

                if (f.isSolved()) {
                    return;
                }

                gameView.setMatrix(f.getMatrix());
                gameView.invalidate();
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRestartListener();
            }
        });

        return v;
    }



}
