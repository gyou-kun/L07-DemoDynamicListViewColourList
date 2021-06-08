package sg.edu.rp.c346.id20024466.l07demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etColour;
    Button btnAdd;
    ListView lv;
    EditText etIndex;

    ArrayList<String> alColour;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etColour = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAdd);
        lv = findViewById(R.id.listView);
        etIndex = findViewById(R.id.editTextIndex);

        alColour = new ArrayList<>();
        alColour.add("Red");
        alColour.add("Orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColour);

        lv.setAdapter(aaColour);

//        btnAdd.setOnClickListener(v -> {
//            String newColour = etColour.getText().toString();
//            alColour.add(newColour);
//            aaColour.notifyDataSetChanged();
//            etColour.setText(null);
//        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etIndex.getText().toString();
                int pos = Integer.parseInt(etIndex.getText().toString());
                alColour.add(pos, colour);
                aaColour.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColour.get(position);
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();
            }
        });


    }
}