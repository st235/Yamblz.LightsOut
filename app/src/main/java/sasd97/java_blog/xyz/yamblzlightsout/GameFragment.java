package sasd97.java_blog.xyz.yamblzlightsout;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
    private FrameLayout frameLayout;
    private TextView textView;
    private long startTime;
    private Button undoButton;
    private Button restartButton;
    public TextView clicksTextView;
    private long currentTime;

    private Handler timerHandler = new Handler();
    private Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            textView.setText(setTime(millis / 1000));
            timerHandler.postDelayed(this, 1000);
        }
    };

    private String setTime(long time) {
        currentTime = time;

        String timeHHMMS = "00:00";
        int sec = 0;
        int min = 0;
        int hour;
        String s;
        String m;

        sec = (int) time % 60;
        hour = (int) (time / 3600);
        min = (int) (time % 3600) / 60;

        if (hour == 0) {

            if (sec < 10) {
                s = "0" + sec;
            } else s = String.valueOf(sec);
            if (min < 10) {

                m = "0" + min;
            } else m = String.valueOf(min);

            timeHHMMS = m + ":" + s;

        } else {

            if (sec < 10) {
                s = "0" + sec;
            } else s = String.valueOf(sec);
            if (min < 10) {

                m = "0" + min;
            } else m = String.valueOf(min);

            timeHHMMS = hour + ":" + m + ":" + s;
        }
        return timeHHMMS;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener = (OnGameListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game, container, false);

        startTime = System.currentTimeMillis();
        frameLayout = v.findViewById(R.id.containerFragment);
        textView = v.findViewById(R.id.timer_tv);
        final Engine engine = GameEngineProvider.getEngine();
        Field field = engine.obtainNewField(new SquareSize(5));
        Log.d("HERE", field.toString());
        timerHandler.postDelayed(timerRunnable, 0);

        gameView = v.findViewById(R.id.fragment_game_game_view);
        clicksTextView = v.findViewById(R.id.fragment_game_clicks_counter);
        undoButton = v.findViewById(R.id.fragment_game_button_undo);
        restartButton = v.findViewById(R.id.fragment_game_restart);
        gameView.setNewSize(new SquareSize(5));
        gameView.measure(frameLayout.getWidth(), frameLayout.getHeight());
        gameView.setMatrix(field.getMatrix());

        gameView.setListener(new GameView.OnGridItemClickListener() {
            @Override
            public void onItemClick(int x, int y) {
                Field f = engine.clickCurrentField(new Click(x, y));
                clicks++;
                clicksTextView.setText(String.valueOf(clicks));

                if (f.isSolved()) {
                    int score = engine.calculateCurrentScore(currentTime, clicks);
                    listener.onFinish(score);
                    return;
                }

                gameView.setMatrix(f.getMatrix());
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

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRestartListener();
            }
        });

        return v;
    }



}
