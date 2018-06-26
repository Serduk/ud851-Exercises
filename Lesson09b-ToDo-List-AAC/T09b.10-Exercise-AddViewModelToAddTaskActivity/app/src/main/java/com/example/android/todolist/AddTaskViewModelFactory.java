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
}
