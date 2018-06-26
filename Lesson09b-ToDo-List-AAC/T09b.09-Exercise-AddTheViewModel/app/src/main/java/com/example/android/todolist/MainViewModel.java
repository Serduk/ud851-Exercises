package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final static String LOG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<TaskEntry>> getTasks() {
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(LOG, "MainViewModel USED");
        tasks = database.taskDao().loadAllTasks();
        return tasks;
    }

    // TODO (2) Add a tasks member variable for a list of TaskEntry objects wrapped in a LiveData

    // TODO (4) In the constructor use the loadAllTasks of the taskDao to initialize the tasks variable

    // TODO (3) Create a getter for the tasks variable
}
