package com.example.android.todolist;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.android.todolist.database.AppDatabase;

public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final AppDatabase mDB;
    private final int mTaskId;

    public AddTaskViewModelFactory(AppDatabase mDB, int mTaskId) {
        this.mDB = mDB;
        this.mTaskId = mTaskId;
    }

    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new AddTaskViewModel(mDB, mTaskId);
    }


    // TODO (2) Add two member variables. One for the database and one for the taskId

    // TODO (3) Initialize the member variables in the constructor with the parameters received

    // TODO (4) Uncomment the following method
    // Note: This can be reused with minor modifications
    /*@Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new AddTaskViewModel(mDb, mTaskId);
    }*/
}
