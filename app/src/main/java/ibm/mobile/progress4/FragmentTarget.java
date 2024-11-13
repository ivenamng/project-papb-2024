package ibm.mobile.progress4;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FragmentTarget extends Fragment {

    private CardView cvTarget;
    private TextView TargetCalories;
    private TextView CaloriesLeftNumb;
    private TextView CaloriesLeft;
    private TextView CaloriesEatenNumb;
    private TextView CaloriesEaten;
    private ImageView logoMain;
    private ProgressBar progressBar;


    public FragmentTarget() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_target, container, false);

        this.cvTarget = v.findViewById(R.id.cvTarget);
        this.TargetCalories = v.findViewById(R.id.TargetCalories);
        this.CaloriesLeftNumb = v.findViewById(R.id.CaloriesLeftNumb);
        this.CaloriesLeft= v.findViewById(R.id.CaloriesLeft);
        this.CaloriesEatenNumb = v.findViewById(R.id.CaloriesEatenNumb);
        this.CaloriesEaten = v.findViewById(R.id.CaloriesEaten);
        this.progressBar = v.findViewById(R.id.progressBar);
        this.logoMain = v.findViewById(R.id.logoMain);

        return v;
    }
}