package com.universe_of_software.total_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.universe_of_software.total_calculator.ListView.ListViewAdapter;
import com.universe_of_software.total_calculator.ListView.ListViewItem;
import com.universe_of_software.total_calculator.ListView.itemActivity.PatchNoteActivity;

public class OptionActivity extends AppCompatActivity {


    ListView listView;
    ListViewAdapter listViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        listView = (ListView) findViewById(R.id.activity_option_listview);
        listViewAdapter = new ListViewAdapter();

        listView.setAdapter(listViewAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ListViewItem item = (ListViewItem)parent.getItemAtPosition(position);

                switch (item.getTitle()){

                    case "패치 노트":
                        Intent intent = new Intent(getApplicationContext(), PatchNoteActivity.class);
                        startActivity(intent);
                        break;
                    case "문의":

                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.setType("plain/text");
                        String[] address = {"4538cgy@gmail.com"};
                        email.putExtra(Intent.EXTRA_EMAIL,address);
                        email.putExtra(Intent.EXTRA_SUBJECT,"문의");
                        email.putExtra(Intent.EXTRA_TEXT,"TeamUniverseSoft \n 문의 주셔서 감사합니다. \n 1.버그를 발견하셨다면 상세 내용을 적어주세요. \n 2.건의 사항이 있으시다면 건의 사항을 상세하게 적어주세요. \n 추가를 원하시는 계산기가 있다면 계산기의 종류를 적어주세요");

                        //Intent intent1 = new Intent(getApplicationContext(), ContactUsActivity.class);
                        startActivity(email);
                        break;

                }

            }
        });

        listViewAdapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_patch),"패치 노트");
        listViewAdapter.addItem(ContextCompat.getDrawable(this,R.drawable.ic_contact),"문의");
    }
}