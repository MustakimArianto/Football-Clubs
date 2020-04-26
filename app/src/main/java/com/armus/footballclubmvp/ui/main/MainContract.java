package com.armus.footballclubmvp.ui.main;

import com.armus.footballclubmvp.data.model.TeamsItem;

import java.util.List;

public interface MainContract {
    interface View {
        void showProgress();
        void hideProgress();
        void showDataList(List<TeamsItem> teamsItems);
        void showFailureMessage(String msg);
    }

    interface Presenter {
        void getDataListTeams();
    }
}
