package com.example.testproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {

    String BASE_URL = "https://reqres.in/api/users/";

    @GET
    Call<Root> getHeroes(@Url String url);


}
