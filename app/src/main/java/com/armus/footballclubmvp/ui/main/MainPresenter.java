package com.armus.footballclubmvp.ui.main;

import com.armus.footballclubmvp.data.model.ResponseAllTeam;
import com.armus.footballclubmvp.data.remote.ApiClient;
import com.armus.footballclubmvp.data.remote.ApiInterface;
import com.armus.footballclubmvp.helper.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getDataListTeams() {
        view.showProgress();

        Call<ResponseAllTeam> call = apiInterface.getAllTeam(Constants.LEAGUE_NAME);
        call.enqueue(new Callback<ResponseAllTeam>() {
            @Override
            public void onResponse(Call<ResponseAllTeam> call, Response<ResponseAllTeam> response) {
                view.hideProgress();
                if(response.body() != null) {
                    view.showDataList(response.body().getTeams());
                }
            }

            @Override
            public void onFailure(Call<ResponseAllTeam> call, Throwable t) {
                view.hideProgress();
                view.showFailureMessage(t.getMessage());
            }
        });

    }
}
