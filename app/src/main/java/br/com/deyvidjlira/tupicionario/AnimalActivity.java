package br.com.deyvidjlira.tupicionario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        String[] animalsArray = getResources().getStringArray(R.array.animal_array);
        final String[] animalsDescArray = getResources().getStringArray(R.array.animal_desc_array);

        ArrayList<Item> listItem = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            String title = animalsArray[i];
            String description = animalsDescArray[i];

            Item item = new Item(title, description, R.drawable.ic_bichos);
            listItem.add(item);
        }

        ItemAdapter adapter = new ItemAdapter(this, listItem, R.color.colorAnimalCategory);

        ListView listView = (ListView) findViewById(R.id.listViewAnimal);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String description = animalsDescArray[position];
                Toast.makeText(AnimalActivity.this, description, Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);
    }
}
