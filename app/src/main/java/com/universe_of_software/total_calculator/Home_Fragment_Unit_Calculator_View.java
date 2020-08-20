package com.universe_of_software.total_calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Home_Fragment_Unit_Calculator_View extends Fragment {

    static TextView criteria_textview1
                    ,criteria_textview2
                    ,criteria_textview3
                    ,criteria_textview4
                    ,criteria_textview5
                    ,criteria_textview6
                    ,criteria_textview7
                    ,criteria_textview8
                    ,criteria_textview9
                    ,criteria_textview10
                    ,criteria_textview11
                    ,criteria_textview12;
    static TextView criteria_title_textview1
                    ,criteria_title_textview2
                    ,criteria_title_textview3
                    ,criteria_title_textview4
                    ,criteria_title_textview5
                    ,criteria_title_textview6
                    ,criteria_title_textview7
                    ,criteria_title_textview8
                    ,criteria_title_textview9
                    ,criteria_title_textview10
                    ,criteria_title_textview11
                    ,criteria_title_textview12;

    String text;

    String ViewType = "길이";
    String standardType = "밀리미터(mm)";
    Unit_Calculator_Modifier unit_calculator_modifier;

    public static Home_Fragment_Unit_Calculator_View newInstance(){
        Home_Fragment_Unit_Calculator_View home_fragment_unit_calculator_view = new Home_Fragment_Unit_Calculator_View();
        Bundle bundle = new Bundle();
        home_fragment_unit_calculator_view.setArguments(bundle);

        return home_fragment_unit_calculator_view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.b_home_fragment_unit_calculator_view,container,false);

        criteria_textview1 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview1);
        criteria_textview2 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview2);
        criteria_textview3 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview3);
        criteria_textview4 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview4);
        criteria_textview5 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview5);
        criteria_textview6 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview6);
        criteria_textview7 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview7);
        criteria_textview8 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview8);
        criteria_textview9 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview9);
        criteria_textview10 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview10);
        criteria_textview11 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview11);
        criteria_textview12 = (TextView)view.findViewById(R.id.unit_calculator_criteria_textview12);
        criteria_title_textview1 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview1);
        criteria_title_textview2 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview2);
        criteria_title_textview3 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview3);
        criteria_title_textview4 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview4);
        criteria_title_textview5 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview5);
        criteria_title_textview6 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview6);
        criteria_title_textview7 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview7);
        criteria_title_textview8 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview8);
        criteria_title_textview9 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview9);
        criteria_title_textview10 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview10);
        criteria_title_textview11 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview11);
        criteria_title_textview12 = (TextView)view.findViewById(R.id.unit_calculator_criteria_title_textview12);
        initializedTextView();

        return view;


    }

    public void initializedTextView(){

        criteria_title_textview1.setText("밀리미터(mm)");
        criteria_title_textview2.setText("센티미터(cm)");
        criteria_title_textview3.setText("미터(m)");
        criteria_title_textview4.setText("킬로미터(km)");
        criteria_title_textview5.setText("인치(in)");
        criteria_title_textview6.setText("피트(ft)");
        criteria_title_textview7.setText("야드(yd)");
        criteria_title_textview8.setText("마일(mile)");
        criteria_title_textview9.setText("자(尺)");
        criteria_title_textview10.setText("간(間)");
        criteria_title_textview11.setText("정(町)");
        criteria_title_textview12.setText("리(理)");
        criteria_textview1.setText("0");
        criteria_textview2.setText("0");
        criteria_textview3.setText("0");
        criteria_textview4.setText("0");
        criteria_textview5.setText("0");
        criteria_textview6.setText("0");
        criteria_textview7.setText("0");
        criteria_textview8.setText("0");
        criteria_textview9.setText("0");
        criteria_textview10.setText("0");
        criteria_textview11.setText("0");
        criteria_textview12.setText("0");

    }
    public void setDataStandard(String s){
        standardType = s;
    }

    public void setText(String s){
        text = s;
        System.out.println("최종적으로 변경된 값이 전달되었습니다.");
        unit_calculator_modifier = new Unit_Calculator_Modifier();
        switch (ViewType){
            case "길이":

                criteria_textview1.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview1.getText().toString())));

                criteria_textview2.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview2.getText().toString())));
                criteria_textview3.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview3.getText().toString())));
                criteria_textview4.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview4.getText().toString())));
                criteria_textview5.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview5.getText().toString())));
                criteria_textview6.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview6.getText().toString())));
                criteria_textview7.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview7.getText().toString())));
                criteria_textview8.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview8.getText().toString())));
                criteria_textview9.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview9.getText().toString())));
                criteria_textview10.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview10.getText().toString())));
                criteria_textview11.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview11.getText().toString())));
                criteria_textview12.setText(""+String.format("%.2f",unit_calculator_modifier.getAtoB(s,standardType,criteria_title_textview12.getText().toString())));


                break;
            case "면적":
                criteria_textview1.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview1.getText().toString())));
                criteria_textview2.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview2.getText().toString())));
                criteria_textview3.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview3.getText().toString())));
                criteria_textview4.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview4.getText().toString())));
                criteria_textview5.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview5.getText().toString())));
                criteria_textview6.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview6.getText().toString())));
                criteria_textview7.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview7.getText().toString())));
                criteria_textview8.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview8.getText().toString())));
                criteria_textview9.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview9.getText().toString())));
                criteria_textview10.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview10.getText().toString())));
                criteria_textview11.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview11.getText().toString())));

                break;
            case "무게":
                criteria_textview1.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview1.getText().toString())));
                criteria_textview2.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview2.getText().toString())));
                criteria_textview3.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview3.getText().toString())));
                criteria_textview4.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview4.getText().toString())));
                criteria_textview5.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview5.getText().toString())));
                criteria_textview6.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview6.getText().toString())));
                criteria_textview7.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview7.getText().toString())));
                criteria_textview8.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview8.getText().toString())));
                criteria_textview9.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview9.getText().toString())));
                criteria_textview10.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview10.getText().toString())));
                criteria_textview11.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview11.getText().toString())));
                criteria_textview12.setText(""+String.format("%.2f",unit_calculator_modifier.getWeight(s,standardType,criteria_title_textview12.getText().toString())));
                break;
            case "부피":
                criteria_textview1.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview1.getText().toString())));
                criteria_textview2.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview2.getText().toString())));
                criteria_textview3.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview3.getText().toString())));
                criteria_textview4.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview4.getText().toString())));
                criteria_textview5.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview5.getText().toString())));
                criteria_textview6.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview6.getText().toString())));
                criteria_textview7.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview7.getText().toString())));
                criteria_textview8.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview8.getText().toString())));
                criteria_textview9.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview9.getText().toString())));
                criteria_textview10.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview10.getText().toString())));
                criteria_textview11.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview11.getText().toString())));
                criteria_textview12.setText(""+String.format("%.2f",unit_calculator_modifier.getVolume(s,standardType,criteria_title_textview12.getText().toString())));
                break;
                /*
            case "온도":
                criteria_textview1.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview1.getText().toString())));
                criteria_textview2.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview2.getText().toString())));
                criteria_textview3.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview3.getText().toString())));
                criteria_textview4.setText(""+String.format("%.2f",unit_calculator_modifier.getAreaConvert(s,standardType,criteria_title_textview4.getText().toString())));

                break;
*/
            case "압력":
                criteria_textview1.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview1.getText().toString())));
                criteria_textview2.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview2.getText().toString())));
                criteria_textview3.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview3.getText().toString())));
                criteria_textview4.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview4.getText().toString())));
                criteria_textview5.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview5.getText().toString())));
                criteria_textview6.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview6.getText().toString())));
                criteria_textview7.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview7.getText().toString())));
                criteria_textview8.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview8.getText().toString())));
                criteria_textview9.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview9.getText().toString())));
                criteria_textview10.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview10.getText().toString())));
                criteria_textview11.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview11.getText().toString())));
                criteria_textview12.setText(""+String.format("%.2f",unit_calculator_modifier.getPressure(s,standardType,criteria_title_textview12.getText().toString())));
                break;

            case "속도":
                criteria_textview1.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview1.getText().toString())));
                criteria_textview2.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview2.getText().toString())));
                criteria_textview3.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview3.getText().toString())));
                criteria_textview4.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview4.getText().toString())));
                criteria_textview5.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview5.getText().toString())));
                criteria_textview6.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview6.getText().toString())));
                criteria_textview7.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview7.getText().toString())));
                criteria_textview8.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview8.getText().toString())));
                criteria_textview9.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview9.getText().toString())));
                criteria_textview10.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview10.getText().toString())));
                criteria_textview11.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview11.getText().toString())));
                criteria_textview12.setText(""+String.format("%.2f",unit_calculator_modifier.getSpeed(s,standardType,criteria_title_textview12.getText().toString())));
                break;

            case "연비":
                criteria_textview1.setText(""+String.format("%.2f",unit_calculator_modifier.getMlieage(s,standardType,criteria_title_textview1.getText().toString())));
                criteria_textview2.setText(""+String.format("%.2f",unit_calculator_modifier.getMlieage(s,standardType,criteria_title_textview2.getText().toString())));
                criteria_textview3.setText(""+String.format("%.2f",unit_calculator_modifier.getMlieage(s,standardType,criteria_title_textview3.getText().toString())));

                break;

            case "데이터양":
                criteria_textview1.setText(""+String.format("%.2f",unit_calculator_modifier.getData(s,standardType,criteria_title_textview1.getText().toString())));
                criteria_textview2.setText(""+String.format("%.2f",unit_calculator_modifier.getData(s,standardType,criteria_title_textview2.getText().toString())));
                criteria_textview3.setText(""+String.format("%.2f",unit_calculator_modifier.getData(s,standardType,criteria_title_textview3.getText().toString())));
                criteria_textview4.setText(""+String.format("%.2f",unit_calculator_modifier.getData(s,standardType,criteria_title_textview4.getText().toString())));
                criteria_textview5.setText(""+String.format("%.2f",unit_calculator_modifier.getData(s,standardType,criteria_title_textview5.getText().toString())));
                criteria_textview6.setText(""+String.format("%.2f",unit_calculator_modifier.getData(s,standardType,criteria_title_textview6.getText().toString())));
                criteria_textview7.setText(""+String.format("%.2f",unit_calculator_modifier.getData(s,standardType,criteria_title_textview7.getText().toString())));
                criteria_textview8.setText(""+String.format("%.2f",unit_calculator_modifier.getData(s,standardType,criteria_title_textview8.getText().toString())));

                break;


        }








    }

    public void setUnitDataType(String s){
        //메인 액티비티에서 전달된 dataType을 받아와  TextViewType에 전달
        setTextViewType(s);

    }

    public void setTextViewType(String s){

        ViewType = s;
        switch (s)
        {
            case "길이":
                criteria_textview1.setText("0");
                criteria_textview2.setText("0");
                criteria_textview3.setText("0");
                criteria_textview4.setText("0");
                criteria_textview5.setText("0");
                criteria_textview6.setText("0");
                criteria_textview7.setText("0");
                criteria_textview8.setText("0");
                criteria_textview9.setText("0");
                criteria_textview10.setText("0");
                criteria_textview11.setText("0");
                criteria_textview12.setText("0");

                criteria_title_textview1.setText("밀리미터(mm)");
                criteria_title_textview2.setText("센티미터(cm)");
                criteria_title_textview3.setText("미터(m)");
                criteria_title_textview4.setText("킬로미터(km)");
                criteria_title_textview5.setText("인치(in)");
                criteria_title_textview6.setText("피트(ft)");
                criteria_title_textview7.setText("야드(yd)");
                criteria_title_textview8.setText("마일(mile)");
                criteria_title_textview9.setText("자(尺)");
                criteria_title_textview10.setText("간(間)");
                 criteria_title_textview11.setText("정(町)");
                criteria_title_textview12.setText("리(理)");


                break;
            case "면적":
                criteria_textview1.setText("0");
                criteria_textview2.setText("0");
                criteria_textview3.setText("0");
                criteria_textview4.setText("0");
                criteria_textview5.setText("0");
                criteria_textview6.setText("0");
                criteria_textview7.setText("0");
                criteria_textview8.setText("0");
                criteria_textview9.setText("0");
                criteria_textview10.setText("0");
                criteria_textview11.setText("0");
                criteria_textview12.setText("");
                criteria_title_textview1.setText("제곱미터(m²)");
                criteria_title_textview2.setText("아르(a)");
                criteria_title_textview3.setText("헥타르(ha)");
                criteria_title_textview4.setText("제곱킬로미터(km²)");
                criteria_title_textview5.setText("제곱피트(ft²)");
                criteria_title_textview6.setText("제곱야드(yd²)");
                criteria_title_textview7.setText("에이커(ac)");
                criteria_title_textview8.setText("평방자");
                criteria_title_textview9.setText("평");
                criteria_title_textview10.setText("단보");
                criteria_title_textview11.setText("정보");
                criteria_title_textview12.setText("");
                break;
            case "무게":
                criteria_textview1.setText("0");
                criteria_textview2.setText("0");
                criteria_textview3.setText("0");
                criteria_textview4.setText("0");
                criteria_textview5.setText("0");
                criteria_textview6.setText("0");
                criteria_textview7.setText("0");
                criteria_textview8.setText("0");
                criteria_textview9.setText("0");
                criteria_textview10.setText("0");
                criteria_textview11.setText("0");
                criteria_textview12.setText("0");
                criteria_title_textview1.setText("밀리그램(mg)");
                criteria_title_textview2.setText("그램(g)");
                criteria_title_textview3.setText("킬로그램(kg)");
                criteria_title_textview4.setText("톤(t)");
                criteria_title_textview5.setText("킬로톤(kt)");
                criteria_title_textview6.setText("그레인(gr)");
                criteria_title_textview7.setText("온스(oz)");
                criteria_title_textview8.setText("파운드(lb)");
                criteria_title_textview9.setText("돈");
                criteria_title_textview10.setText("냥");
                criteria_title_textview11.setText("근");
                criteria_title_textview12.setText("관");
                break;
            case "부피":
                criteria_textview1.setText("0");
                criteria_textview2.setText("0");
                criteria_textview3.setText("0");
                criteria_textview4.setText("0");
                criteria_textview5.setText("0");
                criteria_textview6.setText("0");
                criteria_textview7.setText("0");
                criteria_textview8.setText("0");
                criteria_textview9.setText("0");
                criteria_textview10.setText("0");
                criteria_textview11.setText("0");
                criteria_textview12.setText("0");
                criteria_title_textview1.setText("시시(cc)");
                criteria_title_textview2.setText("밀리리터(㎖)");
                criteria_title_textview3.setText("데시리터(㎗)");
                criteria_title_textview4.setText("리터(ℓ)");
                criteria_title_textview5.setText("세제곱센티미터(cm³)");
                criteria_title_textview6.setText("세제곱미터(m³)");
                criteria_title_textview7.setText("세제곱인치(in³)");
                criteria_title_textview8.setText("세제곱피트(ft³)");
                criteria_title_textview9.setText("세제곱야드(yd³)");
                criteria_title_textview10.setText("갤런(gal)");
                criteria_title_textview11.setText("배럴(bbl)");
                criteria_title_textview12.setText("온스(oz)");
                break;
            case "온도":
                criteria_textview1.setText("0");
                criteria_textview2.setText("0");
                criteria_textview3.setText("0");
                criteria_textview4.setText("0");
                criteria_textview5.setText("");
                criteria_textview6.setText("");
                criteria_textview7.setText("");
                criteria_textview8.setText("");
                criteria_textview9.setText("");
                criteria_textview10.setText("");
                criteria_textview11.setText("");
                criteria_textview12.setText("");
                criteria_title_textview1.setText("섭씨온도(℃)");
                criteria_title_textview2.setText("화씨온도(℉)");
                criteria_title_textview3.setText("절대온도(K)");
                criteria_title_textview4.setText("(°R)");
                criteria_title_textview5.setText("");
                criteria_title_textview6.setText("");
                criteria_title_textview7.setText("");
                criteria_title_textview8.setText("");
                criteria_title_textview9.setText("");
                criteria_title_textview10.setText("");
                criteria_title_textview11.setText("");
                criteria_title_textview12.setText("");
                break;

            case "압력":
                criteria_textview1.setText("0");
                criteria_textview2.setText("0");
                criteria_textview3.setText("0");
                criteria_textview4.setText("0");
                criteria_textview5.setText("0");
                criteria_textview6.setText("0");
                criteria_textview7.setText("0");
                criteria_textview8.setText("0");
                criteria_textview9.setText("0");
                criteria_textview10.setText("0");
                criteria_textview11.setText("0");
                criteria_textview12.setText("0");
                criteria_title_textview1.setText("기압(atm)");
                criteria_title_textview2.setText("파스칼(Pa)");
                criteria_title_textview3.setText("헥토파스칼(hPa)");
                criteria_title_textview4.setText("킬로파스칼(kPa)");
                criteria_title_textview5.setText("메가파스칼(MPa)");
                criteria_title_textview6.setText("dcyn/cm²");
                criteria_title_textview7.setText("밀리바(mb)");
                criteria_title_textview8.setText("바(bar)");
                criteria_title_textview9.setText("kgf(cm²)");
                criteria_title_textview10.setText("프사이(psi)");
                criteria_title_textview11.setText("수은주밀리미터(mmHg)");
                criteria_title_textview12.setText("inchHg");
                break;

            case "속도":
                criteria_textview1.setText("0");
                criteria_textview2.setText("0");
                criteria_textview3.setText("0");
                criteria_textview4.setText("0");
                criteria_textview5.setText("0");
                criteria_textview6.setText("0");
                criteria_textview7.setText("0");
                criteria_textview8.setText("0");
                criteria_textview9.setText("0");
                criteria_textview10.setText("0");
                criteria_textview11.setText("0");
                criteria_textview12.setText("0");
                criteria_title_textview1.setText("m/s");
                criteria_title_textview2.setText("k/s");
                criteria_title_textview3.setText("km/s");
                criteria_title_textview4.setText("km/h");
                criteria_title_textview5.setText("in/s");
                criteria_title_textview6.setText("in/h");
                criteria_title_textview7.setText("ft/s");
                criteria_title_textview8.setText("ft/h");
                criteria_title_textview9.setText("mi/s");
                criteria_title_textview10.setText("mi/h");
                criteria_title_textview11.setText("노트(kn)");
                criteria_title_textview12.setText("마하(mach)");
                break;

            case "연비":
                criteria_textview1.setText("0");
                criteria_textview2.setText("0");
                criteria_textview3.setText("0");
                criteria_textview4.setText("");
                criteria_textview5.setText("");
                criteria_textview6.setText("");
                criteria_textview7.setText("");
                criteria_textview8.setText("");
                criteria_textview9.setText("");
                criteria_textview10.setText("");
                criteria_textview11.setText("");
                criteria_textview12.setText("");
                criteria_title_textview1.setText("km/l");
                criteria_title_textview2.setText("mi/g");
                criteria_title_textview3.setText("l/100km");
                criteria_title_textview4.setText("");
                criteria_title_textview5.setText("");
                criteria_title_textview6.setText("");
                criteria_title_textview7.setText("");
                criteria_title_textview8.setText("");
                criteria_title_textview9.setText("");
                criteria_title_textview10.setText("");
                criteria_title_textview11.setText("");
                criteria_title_textview12.setText("");
                break;

            case "데이터양":
                criteria_textview1.setText("0");
                criteria_textview2.setText("0");
                criteria_textview3.setText("0");
                criteria_textview4.setText("0");
                criteria_textview5.setText("0");
                criteria_textview6.setText("0");
                criteria_textview7.setText("0");
                criteria_textview8.setText("0");
                criteria_textview9.setText("");
                criteria_textview10.setText("");
                criteria_textview11.setText("");
                criteria_textview12.setText("");
                criteria_title_textview1.setText("비트(bit)");
                criteria_title_textview2.setText("바이트(B)");
                criteria_title_textview3.setText("킬로바이트(KB)");
                criteria_title_textview4.setText("메가바이트(MB)");
                criteria_title_textview5.setText("기가바이트(GB)");
                criteria_title_textview6.setText("테라바이트(TB)");
                criteria_title_textview7.setText("페타바이트(PB)");
                criteria_title_textview8.setText("엑사바이트(EB)");
                criteria_title_textview9.setText("");
                criteria_title_textview10.setText("");
                criteria_title_textview11.setText("");
                criteria_title_textview12.setText("");
                break;
        }

    }




}
