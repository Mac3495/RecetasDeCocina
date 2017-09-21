package com.example.marcelo.recetasdecocina;

import com.example.marcelo.recetasdecocina.model.ResultResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Marcelo on 14/09/2017.
 */

public interface DatosRecetaService {

    @GET("/api/search")
    Call<ResultResponse> recetas(@Query("key") String apiKey, @Query("q") String tipo);

}
