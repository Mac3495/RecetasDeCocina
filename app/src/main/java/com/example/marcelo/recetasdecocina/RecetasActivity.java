package com.example.marcelo.recetasdecocina;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.marcelo.recetasdecocina.adapters.RecetaAdapter;
import com.example.marcelo.recetasdecocina.model.Receta;
import com.example.marcelo.recetasdecocina.model.ResultResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecetasActivity extends AppCompatActivity implements RecetaAdapter.OnRecetaSelectedListener{

    private RecyclerView recetasRecyclerView;
    private RecetaAdapter recetaAdapter;
    private View rootView;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        final int pos = getIntent().getExtras().getInt("posicion");

        recetasRecyclerView = (RecyclerView) findViewById(R.id.recycler_recetas);
        recetasRecyclerView.setHasFixedSize(true);
        recetasRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        recetaAdapter = new RecetaAdapter(this, this);

        recetasRecyclerView.setAdapter(recetaAdapter);

        rootView = findViewById(R.id.root_view);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorAccent);

        swipeRefreshLayout.setRefreshing(true);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                seleccionarDatos(pos);
            }
        });

        seleccionarDatos(pos);
    }

    private void seleccionarDatos(int posicion){
        switch (posicion){
            case 0:
                cargarDatos("meat");
                getSupportActionBar().setTitle(R.string.tipo1);
                break;
            case 1:
                cargarDatos("chicken");
                getSupportActionBar().setTitle(R.string.tipo2);
                break;
            case 2:
                cargarDatos("fish");
                getSupportActionBar().setTitle(R.string.tipo3);
                break;
            case 3:
                cargarDatos("pig");
                getSupportActionBar().setTitle(R.string.tipo4);
                break;
            case 4:
                cargarDatos("salad");
                getSupportActionBar().setTitle(R.string.tipo5);
                break;
            case 5:
                cargarDatos("dessert");
                getSupportActionBar().setTitle(R.string.tipo6);
                break;
            case 6:
                cargarDatos("juice");
                getSupportActionBar().setTitle(R.string.tipo7);
                break;
            case 7:
                cargarDatos("other");
                getSupportActionBar().setTitle(R.string.tipo8);
                break;
        }
    }

    private void cargarDatos(String comida) {

        DatosRecetaService service = ServiceGenerator.createService(DatosRecetaService.class);
        Call<ResultResponse> call = service.recetas(BuildConfig.FOOD2FORK_API_KEY, comida);

        call.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, final Response<ResultResponse> response) {
                swipeRefreshLayout.setRefreshing(false);
                if(response.isSuccessful()){

                    List<Receta> lista = response.body().getRecipes();
                    recetaAdapter.setDataset(lista);
                }else{
                    mostrarMensaje("Fallo en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
                mostrarMensaje("Error al conectarse: "+t.getMessage());
            }
        });

    }

    private void mostrarMensaje(String mensaje){
        Snackbar.make(rootView, mensaje, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onRecetaSelected(Receta comida) {
        String url = comida.getSourceURL();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}

