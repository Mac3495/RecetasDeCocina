package com.example.marcelo.recetasdecocina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.marcelo.recetasdecocina.adapters.TipoComidaAdapter;
import com.example.marcelo.recetasdecocina.model.TipoComida;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<TipoComida> tipoComidaList;
    private RecyclerView tiposComidaRecyclerView;
    private TipoComidaAdapter tipoComidaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipoComidaList = new ArrayList<>();
        tiposComidaRecyclerView = (RecyclerView) findViewById(R.id.recycler_main);
        tiposComidaRecyclerView.setHasFixedSize(true);
        tiposComidaRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        llenarLista();


    }

    private void llenarLista() {
        tipoComidaList.add(new TipoComida(R.drawable.steak, "Res"));
        tipoComidaList.add(new TipoComida(R.drawable.meat, "Pollo"));
        tipoComidaList.add(new TipoComida(R.drawable.fish, "Pescado"));
        tipoComidaList.add(new TipoComida(R.drawable.pig, "Cerdo"));
        tipoComidaList.add(new TipoComida(R.drawable.salad1, "Ensaladas"));
        tipoComidaList.add(new TipoComida(R.drawable.salad, "Postres"));
        tipoComidaList.add(new TipoComida(R.drawable.glass, "Jugos"));
        tipoComidaList.add(new TipoComida(R.drawable.turkey, "Otros"));

        tipoComidaAdapter = new TipoComidaAdapter(tipoComidaList);

        tipoComidaAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecetasActivity.class);
                int itemPosition = tiposComidaRecyclerView.getChildLayoutPosition(v);
                intent.putExtra("posicion", itemPosition);
                startActivity(intent);
            }
        });
        tiposComidaRecyclerView.setAdapter(tipoComidaAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                startActivity(new Intent(getApplicationContext(),AcercaDeActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
