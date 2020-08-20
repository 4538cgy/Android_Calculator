package com.universe_of_software.total_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.ads.*;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
        , Fragment_Normal_Calculator_Fragment_Data_View_To_Controller_Communication_Listener
        , Fragment_Normal_Calculator_Fragment_Data_Controller_To_View_Communication_Listener
        , Fragment_Bmi_Calculator_Fragment_Data_Controller_To_View_Communication_Listner
        , Fragment_Unit_Calculator_Fragment_Data_Controller_To_View_Communication_Listener{



    private AdView adView;

    private final String TAG = MainActivity.class.getSimpleName();
   // private final String TAG = NativeAd.class.getSimpleName();



    ImageButton selectButton_normal,selectButton_bmi,selectButton_convert,selectButton_option;

    ViewGroup selector_frame;
    ArrayList<Recycler_item> mList = null;
    Recycler_Adapter recycler_adapter;

    Boolean calMenuOpened = false;

    LinearLayout linearLayout1,linearLayout2,linearLayout3;

   // ArrayList<Bmi_Recycler_View_Item> bmiList;
   // Bmi_RecyclerView_Adapter bmi_recycler_view_adapter;

    //(1)메인 뷰 위아래 두개를 각각만들기 (일반계산기)
    Home_Fragment_Normal_Calculator_View home_fragment_normal_calculator_view;
    Home_Fragment_Normal_Calculator_Controller home_fragment_normal_calculator_controller;

    Home_Fragment_Unit_Calculator_View home_fragment_unit_calculator_view;
    Home_Fragment_Unit_Calculator_Controller home_fragment_unit_calculator_controller;

    //BMI 뷰 생성
    Home_Fragment_Bmi_Calculator_View home_fragment_bmi_calculator_view;

    //bmi에서 전달할 인자
    int bmi_age_value, bmi_weight_value,bmi_height_value,bmi_sex_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdSettings.addTestDevice("b039a806-dbb5-4e65-941e-67901e0531d1");
        adView = new AdView(this,"YOUR_PLACEMENT_ID",AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer = (LinearLayout)findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adView.loadAd();


        linearLayout1 = (LinearLayout)findViewById(R.id.activity_main_linearLayout_1);
        linearLayout2 = (LinearLayout)findViewById(R.id.activity_main_linearLayout_2);
        linearLayout3 = (LinearLayout)findViewById(R.id.activity_main_linearLayout_3);

        //생성시 메인화면 tab바에있는 버튼에 온클릭 리스너 할당(활성화)

        selectButton_normal = (ImageButton)findViewById(R.id.select_button_normal_cal);
        selectButton_bmi = (ImageButton)findViewById(R.id.select_button_bmi_cal);
        selectButton_convert = (ImageButton)findViewById(R.id.select_button_convert_cal);
        selectButton_option = (ImageButton)findViewById(R.id.select_button_option);





        selector_frame = (RecyclerView)findViewById(R.id.selector_recycler);


        selectButton_normal.setOnClickListener(this);
        selectButton_convert.setOnClickListener(this);
        selectButton_option.setOnClickListener(this);
        selectButton_bmi.setOnClickListener(this);


        //(1)에서 만든 위아래 뷰에 일반계산기 프라그먼트 할당하기
        home_fragment_normal_calculator_view = Home_Fragment_Normal_Calculator_View.newInstance();
        home_fragment_normal_calculator_controller = Home_Fragment_Normal_Calculator_Controller.newInstance();


        home_fragment_unit_calculator_controller = Home_Fragment_Unit_Calculator_Controller.newInstance();
        home_fragment_unit_calculator_view = Home_Fragment_Unit_Calculator_View.newInstance();

        //(1)에서 만든 위아래 뷰에 BMI 프라그먼트 할당하기
        home_fragment_bmi_calculator_view = Home_Fragment_Bmi_Calculator_View.newInstance();

        //프라그 먼트 관리를위해 FragmentTransaction 가져오기
        //fragmentTransaction  가 위에있는    뷰의 플라그먼트 를담당
        //fragmentTransaction1 가 아래에 있는 뷰의 플라그먼트를 담당

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_view_frame,Home_Fragment_Normal_Calculator_View.newInstance()).commit();
        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction1.add(R.id.main_controller_frame,Home_Fragment_Normal_Calculator_Controller.newInstance()).commit();

        onRecyclerViewClickEvent();






    }

    @Override
    protected void onDestroy() {
        if (adView != null){
            adView.destroy();
        }
        super.onDestroy();
    }

    public void onCreateRecyclerView(String recyclerType){

        RecyclerView recyclerView = findViewById(R.id.selector_recycler);

        this.onRecyclerViewItem(recyclerType);

        recycler_adapter = new Recycler_Adapter(mList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(recycler_adapter);
        recyclerView.setHasFixedSize(true);

        recycler_adapter.setOnItemClickListener(new Recycler_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                String id = mList.get(position).getImage_title().toString();

            }
        });

        recycler_adapter.notifyDataSetChanged();


    }

    public void onRecyclerViewClickEvent(){



    }



    public void onRecyclerViewItem(String caltype){
        mList = new ArrayList<>();

        switch (caltype){

            case "일반 계산기":
                System.out.println("어레이리스트 삽입");
                    mList.clear();

                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.baseline_accessibility_new_black_24dp),"BMI 계산기", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.baseline_table_view_24),"일반 계산기", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.baseline_straighten_black_24dp),"단위 계산기", Recycler_ViewType.ViewType.ImageAndText));


                break;
            case "전문가용 계산기":
                mList.clear();
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"BMI 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"일반 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"BMI 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"일반 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"BMI 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"일반 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"BMI 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"일반 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"BMI 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"일반 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"BMI 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                mList.add(new Recycler_item(getResources().getDrawable(R.drawable.etc2),"일반 계산기\n(Pro)", Recycler_ViewType.ViewType.ImageAndText));
                break;
        }





    }


    @Override
    //탭바에 있는 버튼의 onclik 이벤트 담당
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.select_button_normal_cal:
                linearLayout1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0.25f));
                linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0.65f));
                replaceControllerFragment(Home_Fragment_Normal_Calculator_Controller.newInstance());
                replaceViewFragment(Home_Fragment_Normal_Calculator_View.newInstance());
                break;
            case R.id.select_button_bmi_cal:
                linearLayout1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0.5f));
                replaceViewFragment(Home_Fragment_Bmi_Calculator_View.newInstance());
                replaceControllerFragment(Home_Fragment_Bmi_Calculator_Controller.newInstance());

                break;
            case R.id.select_button_convert_cal:
                linearLayout1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0,0.5f));
                replaceControllerFragment(Home_Fragment_Unit_Calculator_Controller.newInstance());
                replaceViewFragment(Home_Fragment_Unit_Calculator_View.newInstance());

                break;
            case R.id.select_button_option:
                Intent intent = new Intent(getApplicationContext(),OptionActivity.class);
                startActivity(intent);
                break;



        }
    }




    //뷰 프라그먼트 교체 이벤트
    public void replaceViewFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_view_frame,fragment).commit();
    }


    //컨트롤러 프라그먼트 교체 이벤트
    public void replaceControllerFragment(Fragment fragment){
        Log.d("replace","replace 접속됨");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_controller_frame,fragment).commit();
    }

    //프라그먼트 교체 이벤트
    public void checkFragment(int count){
        switch (count){
            case 0:
                replaceControllerFragment(Home_Fragment_Normal_Calculator_Controller.newInstance());
                replaceViewFragment(Home_Fragment_Normal_Calculator_View.newInstance());
                break;
            case 1:
                replaceViewFragment(Home_Fragment_Bmi_Calculator_View.newInstance());
                replaceControllerFragment(Home_Fragment_Bmi_Calculator_Controller.newInstance());
                break;
            case 2:
                replaceControllerFragment(Home_Fragment_Unit_Calculator_Controller.newInstance());
                replaceViewFragment(Home_Fragment_Unit_Calculator_View.newInstance());
        }
    }



    @Override
    public void on_Normal_Calculating_TextChange1(String numText) {
        home_fragment_normal_calculator_view.SetNumberText(numText);
    }
    @Override
    public void on_Normal_Calculating_TextChange2(String code) {
        home_fragment_normal_calculator_view.SetCodeText( code);
    }

    @Override
    public void on_Normal_Calculating_TextChange3(String code) {
        home_fragment_normal_calculator_view.SetResultOperText( code);
    }
    //>>>>>>> .theirs


    //단위 계산기의 edittext의 입력값이 변경될 때 마다 입력값이 view로 전달되는 메서드.
    @Override
    public void onUnitControllerTextChange(String s) {
        home_fragment_unit_calculator_view.setText(s);
        System.out.println("edit Text의 변경된 값이 activity로 전달되었습니다.");
    }

    @Override
    public void setUnitDataType(String s) {
        home_fragment_unit_calculator_view.setUnitDataType(s);
        System.out.println("변경된 데이터 타입이 activity로 전달되었습니다.");
    }

    @Override
    public void setUnitDataStandardType(String s) {
        home_fragment_unit_calculator_view.setDataStandard(s);
    }

    @Override
    public void on_Bmi_Calculating_TextChange(float bmi_age_value, float bmi_weight_value, float bmi_height_value, float bmi_sex_value) {
        home_fragment_bmi_calculator_view.set_bmi_result(bmi_age_value, bmi_weight_value,bmi_height_value,bmi_sex_value);
    }
}
