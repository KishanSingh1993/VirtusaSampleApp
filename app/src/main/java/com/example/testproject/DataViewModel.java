package com.example.testproject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<Root> heroList;

    public int id;

    //we will call this method to get the data
    public LiveData<Root> getHeroes() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<Root>();
            //we will load it asynchronously from server in this method
            loadHeroes();
        }

        //finally we will return the list
        return heroList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<Root> call = api.getHeroes("https://reqres.in/api/users/"+id);


        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {

                //finally we are setting the list to our MutableLiveData
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }
}
