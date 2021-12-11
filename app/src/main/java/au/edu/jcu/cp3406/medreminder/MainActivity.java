package au.edu.jcu.cp3406.medreminder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ArrayList<Medicine> medInfoList;
    ListView listView;
    MedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create objs
        medInfoList = new ArrayList<>();
        Medicine med1 = new Medicine("hypertension", 2, "tablets", "AM");
        Medicine med2 = new Medicine("diabetes", 1, "tablets", "AM");
        Medicine med3 = new Medicine("TCM", 30, "liquid", "PM");
        medInfoList.add(med1);
        medInfoList.add(med2);
        medInfoList.add(med3);
        // link listView
        listView = findViewById(R.id.medList);
        adapter = new MedAdapter(this, R.layout.med, medInfoList);
        listView.setAdapter(adapter);
    }

    public void settingsClicked(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}