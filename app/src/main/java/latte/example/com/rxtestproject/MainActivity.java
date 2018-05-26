package latte.example.com.rxtestproject;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import latte.example.com.rxtestproject.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    public static final String INTENT_ROOT = "latte.example.com.androidstudyproject.";

    RecyclerView projectList;
    ProjectAdapter projectAdapter;
    ActivityMainBinding mViewBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        projectList = mViewBinding.projectList;
        projectList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        projectAdapter = new ProjectAdapter(getApplicationContext());
        projectAdapter.setProjectItems(getProjectItems());
        projectAdapter.setOnItemClickListener(item -> {
            startActivity(new Intent(INTENT_ROOT + item.getProjectorder()));
        });
        projectList.setAdapter(projectAdapter);
    }

    private List<ProjectItem> getProjectItems(){
        List<ProjectItem> projectItems = new ArrayList<>();
        projectItems.add(new ProjectItem("~ 2018. 5. 23."
                ,"Background work & concurrency","A"));
        projectItems.add(new ProjectItem("~ 2018. 5. 23."
                ,"Accumulate calls","B"));
        projectItems.add(new ProjectItem("~ 2018. 5. 23."
                ,"Instant/Auto searching text listeners","C"));


        return projectItems;
    }
}
