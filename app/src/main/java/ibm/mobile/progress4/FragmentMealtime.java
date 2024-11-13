package ibm.mobile.progress4;

import android.os.Bundle;
import android.content.Intent;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentMealtime extends Fragment {


    private CardView cvSarapan, cvLunch, cvDinner;
    private Button buttonSarapan, buttonLunch, buttonDinner;
    private ImageView imageSarapan, imageLunch, imageDinner;
    private TextView infoSarapan, infoLunch, infoDinner;
    private TextView JudulSarapan, JudulLunch, JudulDinner;
    private TextView TargetSarapan, TargetLunch, TargetDinner;
    private TextView slashSarapan, slashLunch, slashDinner;
    private TextView TargetFixSarapan, TargetFixLunch, TargetFixDinner;

    public FragmentMealtime() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mealtime, container, false);

        // Sarapan
        this.cvSarapan = v.findViewById(R.id.cvSarapan);
        this.buttonSarapan = v.findViewById(R.id.buttonSarapan);
        this.imageSarapan = v.findViewById(R.id.imageViewSarapan);
        this.infoSarapan= v.findViewById(R.id.infoSarapan);
        this.JudulSarapan = v.findViewById(R.id.JudulSarapan);
        this.TargetSarapan = v.findViewById(R.id.TargetSarapan);
        this.slashSarapan = v.findViewById(R.id.slashSarapan);
        this.TargetFixSarapan = v.findViewById(R.id.TargetFixSarapan);

        // Lunch
        this.cvLunch = v.findViewById(R.id.cvLunch);
        this.buttonLunch = v.findViewById(R.id.buttonLunch);
        this.imageLunch = v.findViewById(R.id.imageViewLunch);
        this.infoLunch= v.findViewById(R.id.InfoLunch);
        this.JudulLunch = v.findViewById(R.id.JudulLunch);
        this.TargetLunch = v.findViewById(R.id.TargetLunch);
        this.slashLunch = v.findViewById(R.id.slashLunch);
        this.TargetFixLunch = v.findViewById(R.id.TargetFixLunch);

        // Dinner
        this.cvDinner = v.findViewById(R.id.cvDinner);
        this.buttonDinner = v.findViewById(R.id.buttonDinner);
        this.imageDinner = v.findViewById(R.id.imageViewDinner);
        this.infoDinner= v.findViewById(R.id.InfoDinner);
        this.JudulDinner = v.findViewById(R.id.JudulDinner);
        this.TargetDinner = v.findViewById(R.id.TargetDinner);
        this.slashDinner = v.findViewById(R.id.slashDinner);
        this.TargetFixDinner = v.findViewById(R.id.TargetFixDinner);


        buttonSarapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDaftarMenuActivity("sarapan");
            }
        });

        buttonLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDaftarMenuActivity("lunch");
            }
        });

        buttonDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDaftarMenuActivity("dinner");
            }
        });

        return v;
    }

    private void startDaftarMenuActivity(String time) {
        Intent intent = new Intent(getActivity(), DaftarMenuActivity.class);
        intent.putExtra("TIME", time); // Kirim informasi waktu ke activity
        startActivity(intent);
    }
}