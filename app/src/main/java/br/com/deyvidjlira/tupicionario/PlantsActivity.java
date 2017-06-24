package br.com.deyvidjlira.tupicionario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);

        String[] plantsArray = getResources().getStringArray(R.array.plants_array);
        final String[] plantsDescArray = getResources().getStringArray(R.array.plants_desc_array);

        ArrayList<Item> listItem = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            String title = plantsArray[i];
            String description = plantsDescArray[i];

            Item item = new Item(title, description, R.drawable.ic_plantas);
            listItem.add(item);
        }

        ItemAdapter adapter = new ItemAdapter(this, listItem, R.color.colorPlantsCategory);

        ListView listView = (ListView) findViewById(R.id.listViewPlants);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String description = plantsDescArray[position];
                Toast.makeText(PlantsActivity.this, description, Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);
    }
}
