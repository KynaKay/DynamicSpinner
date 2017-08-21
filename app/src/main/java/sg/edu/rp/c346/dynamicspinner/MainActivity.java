package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // Step 1a define the variable for the 3 UI elements
    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;

    // Step 1b define the array adapter
    ArrayList<String> alNumbers = new ArrayList<String>();
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 2 Bind the 3 UI elements to the 3 variables
        spn1 = (Spinner)findViewById(R.id.spinner1);
        spn2 = (Spinner)findViewById(R.id.spinner2);
        btnUpdate = (Button)findViewById(R.id.buttonUpdate);

        // Step 3
        // Create an ArrayAdapter using the default spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);
        // Bind ArrayAdapter to the Spinner
        spn2.setAdapter(aaNumbers);

        // Step 4 Change the spn2 when the button clicks
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();
                if(.pos==0) {
                    // Approach 2
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
                else {
                    // Approach 2
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    aaNumbers.addAll(Arrays.asList(strNumbers));
                }
                aaNumbers.notifyDataSetChanged();
            }

        });

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();
                if(pos==0) {
                    // Approach 2
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spn2.setSelection(2); // 6 is at position 2
                }
                else {
                    // Approach 2
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    aaNumbers.addAll(Arrays.asList(strNumbers));
                    spn2.setSelection(1); // 3 is at position 1
                }
                aaNumbers.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}