package com.universe_of_software.total_calculator.ListView.itemActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.universe_of_software.total_calculator.R;
import com.universe_of_software.total_calculator.Recycler_Adapter;
import com.universe_of_software.total_calculator.Recycler_ViewType;
import com.universe_of_software.total_calculator.Recycler_item;

import java.util.ArrayList;

public class PatchNoteActivity extends AppCompatActivity {

    Recycler_Adapter recycler_adapter;
    ArrayList<Recycler_item> mList = null;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patch_note);
        this.setInitialize();
        recyclerView = (RecyclerView)findViewById(R.id.activity_patchnote_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);

        recycler_adapter = new Recycler_Adapter(mList);
        recyclerView.setAdapter(recycler_adapter);
        recycler_adapter.notifyDataSetChanged();


    }


    public void setInitialize(){
        mList = new ArrayList<>();
        mList.clear();
        mList.add(new Recycler_item("2020-08-01 : Final Test", Recycler_ViewType.ViewType.patchItem));
        mList.add(new Recycler_item("2020-07-29 : Final Process", Recycler_ViewType.ViewType.patchItem));
        mList.add(new Recycler_item("2020-07-23 : Add Unit Calculator", Recycler_ViewType.ViewType.patchItem));
        mList.add(new Recycler_item("2020-07-14 : Add BMI Calculator", Recycler_ViewType.ViewType.patchItem));
        mList.add(new Recycler_item("2020-07-02 : Add Normal Calculator", Recycler_ViewType.ViewType.patchItem));

    }
}