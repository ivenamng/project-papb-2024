package ibm.mobile.progress4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private int kalori;
    private int kaloriMakan;
    private int kaloriKonsumsiPagi = 0;
    private int kaloriKonsumsiSiang = 0;
    private int kaloriKonsumsiMalam = 0;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi FragmentManager
        fragmentManager = getSupportFragmentManager();

        // Tampilkan kedua fragment
        loadFragments();

        // Ambil data dari intent
        Intent intentU = getIntent();
        String gender = intentU.getStringExtra("GENDER_INPUT");
        String inputTextBB = intentU.getStringExtra("BB_INPUT");
        String inputTextTB = intentU.getStringExtra("TB_INPUT");
        String inputTextU = intentU.getStringExtra("UMUR_INPUT");

        // Hitung kalori berdasarkan gender
        hitungKalori(gender, inputTextBB, inputTextTB, inputTextU);
    }

    private void loadFragments() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container_target, new FragmentTarget());
        transaction.replace(R.id.container_mealtime, new FragmentMealtime());
        transaction.commit();
    }

    private void hitungKalori(String gender, String bb, String tb, String umr) {
        int beratBadan = Integer.parseInt(bb);
        int tinggiBadan = Integer.parseInt(tb);
        int umur = Integer.parseInt(umr);

        if (gender.equals("pria")) {
            kalori = (int) Math.ceil(66.5 + (13.75 * beratBadan) + (5.003 * tinggiBadan) - (6.75 * umur));
        } else if (gender.equals("wanita")) {
            kalori = (int) Math.ceil(655.1 + (9.563 * beratBadan) + (1.850 * tinggiBadan) - (4.676 * umur));
        }

        // Bagikan nilai ke fragment menggunakan SharedPreferences
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("kaloriTarget", kalori);
        editor.putInt("kaloriSarapan", (int) Math.ceil(0.25 * kalori));
        editor.putInt("kaloriLunch", (int) Math.ceil(0.4 * kalori));
        editor.putInt("kaloriDinner", (int) Math.ceil(0.35 * kalori));
        editor.apply();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            int consumedCalories = data.getIntExtra("KONSUMSI", 0);
            String time = data.getStringExtra("TIME");

            // Update konsumsi kalori
            updateKaloriKonsumsi(time, consumedCalories);

            // Update fragment
            loadFragments();
        }
    }

    private void updateKaloriKonsumsi(String time, int consumedCalories) {
        if (time.equals("sarapan")) {
            kaloriKonsumsiPagi += consumedCalories;
        } else if (time.equals("lunch")) {
            kaloriKonsumsiSiang += consumedCalories;
        } else if (time.equals("dinner")) {
            kaloriKonsumsiMalam += consumedCalories;
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("kaloriKonsumsiPagi", kaloriKonsumsiPagi);
        editor.putInt("kaloriKonsumsiSiang", kaloriKonsumsiSiang);
        editor.putInt("kaloriKonsumsiMalam", kaloriKonsumsiMalam);
        editor.apply();
    }
}
