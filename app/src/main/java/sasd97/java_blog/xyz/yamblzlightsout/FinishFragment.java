package sasd97.java_blog.xyz.yamblzlightsout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import sasd97.java_blog.xyz.yamblzlightsout.events.OnGameListener;

/**
 * Created by alexander on 12/08/2017.
 */

public class FinishFragment extends Fragment {

    private static final String SCORE_ARGS = "args.score";

    private TextView scoreTextView;
    private Button scoreRestart;
    private OnGameListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener = (OnGameListener) getActivity();
    }

    public static final FinishFragment getInstance(int score) {
        FinishFragment finishFragment = new FinishFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SCORE_ARGS, score);
        finishFragment.setArguments(bundle);
        return finishFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_score, container, false);
        scoreTextView = v.findViewById(R.id.fragment_score);
        scoreRestart = v.findViewById(R.id.fragment_score_restart);

        scoreRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRestartListener();
            }
        });
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();
        if (args == null) return;

        int score = args.getInt(SCORE_ARGS);
        scoreTextView.setText(getString(R.string.fragment_game_score_points, score));

    }
}
