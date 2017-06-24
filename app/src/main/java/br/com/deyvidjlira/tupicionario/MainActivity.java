package br.com.deyvidjlira.tupicionario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callAnimalActivity(View view) {
        Intent intent = new Intent(MainActivity.this, AnimalActivity.class);
        startActivity(intent);
    }

    public void callFoodActivity(View view) {
        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
        startActivity(intent);
    }

    public void callPlantsActivity(View view) {
        Intent intent = new Intent(MainActivity.this, PlantsActivity.class);
        startActivity(intent);
    }

    public void callNativesActivity(View view) {
        Intent intent = new Intent(MainActivity.this, NativesActivity.class);
        startActivity(intent);
    }
}
