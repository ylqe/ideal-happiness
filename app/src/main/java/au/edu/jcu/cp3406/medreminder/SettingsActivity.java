package au.edu.jcu.cp3406.medreminder;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    ArrayList<String> medDDList;
    ArrayAdapter<String> adapter;
    private TextInputLayout nameLayout, ddLayout, qtyLayout;
    private TextInputEditText nameText, qtyText;
    private String medName, medType, medQty;
    private AutoCompleteTextView dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // link UI
        nameText = findViewById(R.id.nameText);
        nameLayout = findViewById(R.id.nameLayout);
        qtyText = findViewById(R.id.qtyText);
        qtyLayout = findViewById(R.id.qtyLayout);
        dropdown = findViewById(R.id.typeDD);
        ddLayout = findViewById(R.id.layoutDD);
        String[] medTypeList = getResources().getStringArray(R.array.medTypeList);

        // set adapter to populate dropdown list from string array res
        medDDList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, medDDList);
        medDDList.addAll(Arrays.asList(medTypeList));
        dropdown.setAdapter(adapter);

        nameLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // get string and validate
                medName = s.toString();
                if (medName.isEmpty() | medName.length() == 0) {
                    nameLayout.setError("Error here!");
                }
            }
        });

        qtyLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // get string and validate
                medQty = s.toString();
                if (medQty.isEmpty() | medQty.length() == 0) {
                    qtyLayout.setError("Error!");
                } else {
                    qtyLayout.setError(null);
                }
            }
        });

        ddLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // get string and validate
                medType = s.toString();
                if (medType.length() == 0) {
                    ddLayout.setError("FINALLY!");
                }
            }
        });

        dropdown.setOnClickListener(v -> {
            // show the dropdown options
            dropdown.showDropDown();
        });

        dropdown.setOnItemClickListener((parent, view, position, id) -> {
            // set text to selected item (don't filter options)
            dropdown.setText(parent.getItemAtPosition(position).toString(), false);
            ddLayout.setError(null);
        });
    }

    public void addClicked(View view) {
        if (medName.length() == 0 | medType.length() == 0 | medQty.length() == 0) {
            Toast toast = Toast.makeText(this, "Please ensure there are no empty fields!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this, "Success!", Toast.LENGTH_SHORT);
            toast.show();
            finish();
        }
    }
}