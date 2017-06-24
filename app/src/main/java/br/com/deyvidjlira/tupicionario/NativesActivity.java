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

public class NativesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natives);

        String[] nativesArray = getResources().getStringArray(R.array.natives_array);
        final String[] nativesDescArray = getResources().getStringArray(R.array.natives_desc_array);

        ArrayList<Item> listItem = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            String title = nativesArray[i];
            String description = nativesDescArray[i];

            Item item = new Item(title, description, R.drawable.ic_povos_nativos);
            listItem.add(item);
        }

        ItemAdapter adapter = new ItemAdapter(this, listItem, R.color.colorNativesCategory);

        ListView listView = (ListView) findViewById(R.id.listViewNatives);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String description = nativesDescArray[position];
                Toast.makeText(NativesActivity.this, description, Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);
    }
}
