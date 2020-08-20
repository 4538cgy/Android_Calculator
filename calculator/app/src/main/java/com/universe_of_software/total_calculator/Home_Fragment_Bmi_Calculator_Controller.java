package com.universe_of_software.total_calculator;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;







public class Home_Fragment_Bmi_Calculator_Controller extends Fragment  {

    private Fragment_Bmi_Calculator_Fragment_Data_Controller_To_View_Communication_Listner bmi_calculator_fragment_data_controller_to_view_communication_listener = null;

    static int bmi_age_value=-1 ,bmi_weight_value=0,bmi_height_value=0,bmi_sex_value=0;

    //해당 시커바 이동시 이전의 thumb 위치
    static int bmi_age_value_check_point,bmi_height_value_check_point,bmi_weight_value_check_point;

    //컨드롤러의 시크바선언
    static SeekBar age_seekbar,weight_seekbar,height_seekbar,sex_seekbar;

    static TextView bmi_height_thumb_text,bmi_weight_thumb_text,bmi_age_thumb_text;

    static LinearLayout age_seekbar_show_layout,height_seekbar_show_layout,weight_seekbar_show_layout;

    private Context context;

    static LinearLayout bmi_controller_view,sex_LinearLayout,age_LinearLayout,height_LinearLayout,weight_LinearLayout,red_triangle_age,red_triangle_height,red_triangle_weight;

    static TextView bmi_controller_view_blank_1,bmi_controller_view_blank_2,bmi_controller_view_blank_3,bmi_controller_view_blank_4;

    //age seekbar에 눈금 이미지뷰
    static ImageView age_seek_bar_show1,age_seek_bar_show2,age_seek_bar_show3,age_seek_bar_show4,age_seek_bar_show5,age_seek_bar_show6,age_seek_bar_show7,age_seek_bar_show8,age_seek_bar_show9,age_seek_bar_show10,age_seek_bar_show11,age_seek_bar_show12,age_seek_bar_show13,age_seek_bar_show14,age_seek_bar_show15,age_seek_bar_show16,age_seek_bar_show17,age_seek_bar_show18,age_seek_bar_show19,age_seek_bar_show20,age_seek_bar_show21,age_seek_bar_show22,age_seek_bar_show23,age_seek_bar_show24,age_seek_bar_show25,age_seek_bar_show26,age_seek_bar_show27,age_seek_bar_show28,age_seek_bar_show29,age_seek_bar_show30,age_seek_bar_show31,age_seek_bar_show32,age_seek_bar_show33,age_seek_bar_show34,age_seek_bar_show35,age_seek_bar_show36,age_seek_bar_show37,age_seek_bar_show38,age_seek_bar_show39,age_seek_bar_show40,age_seek_bar_show41;
    ImageView[] age_seek_bar_show = new ImageView[41];


    //height seekbar에 눈금 이미지뷰
    static ImageView height_seek_bar_show1,height_seek_bar_show2,height_seek_bar_show3,height_seek_bar_show4,height_seek_bar_show5,height_seek_bar_show6,height_seek_bar_show7,height_seek_bar_show8,height_seek_bar_show9,height_seek_bar_show10,height_seek_bar_show11,height_seek_bar_show12,height_seek_bar_show13,height_seek_bar_show14,height_seek_bar_show15,height_seek_bar_show16,height_seek_bar_show17,height_seek_bar_show18,height_seek_bar_show19,height_seek_bar_show20,height_seek_bar_show21,height_seek_bar_show22,height_seek_bar_show23,height_seek_bar_show24,height_seek_bar_show25,height_seek_bar_show26,height_seek_bar_show27,height_seek_bar_show28,height_seek_bar_show29,height_seek_bar_show30,height_seek_bar_show31,height_seek_bar_show32,height_seek_bar_show33,height_seek_bar_show34,height_seek_bar_show35,height_seek_bar_show36,height_seek_bar_show37,height_seek_bar_show38,height_seek_bar_show39,height_seek_bar_show40,height_seek_bar_show41;
    ImageView[] height_seek_bar_show = new ImageView[41];


    //height seekbar에 눈금 이미지뷰
    static ImageView weight_seek_bar_show1,weight_seek_bar_show2,weight_seek_bar_show3,weight_seek_bar_show4,weight_seek_bar_show5,weight_seek_bar_show6,weight_seek_bar_show7,weight_seek_bar_show8,weight_seek_bar_show9,weight_seek_bar_show10,weight_seek_bar_show11,weight_seek_bar_show12,weight_seek_bar_show13,weight_seek_bar_show14,weight_seek_bar_show15,weight_seek_bar_show16,weight_seek_bar_show17,weight_seek_bar_show18,weight_seek_bar_show19,weight_seek_bar_show20,weight_seek_bar_show21,weight_seek_bar_show22,weight_seek_bar_show23,weight_seek_bar_show24,weight_seek_bar_show25,weight_seek_bar_show26,weight_seek_bar_show27,weight_seek_bar_show28,weight_seek_bar_show29,weight_seek_bar_show30,weight_seek_bar_show31,weight_seek_bar_show32,weight_seek_bar_show33,weight_seek_bar_show34,weight_seek_bar_show35,weight_seek_bar_show36,weight_seek_bar_show37,weight_seek_bar_show38,weight_seek_bar_show39,weight_seek_bar_show40,weight_seek_bar_show41;
    ImageView[] weight_seek_bar_show = new ImageView[41];



    //해당 플라그먼트를 메인 엑티비티에서 불러올수 있도록 처리
    public static Home_Fragment_Bmi_Calculator_Controller newInstance(){
        Home_Fragment_Bmi_Calculator_Controller home_fragment_bmi_calculator_controller = new Home_Fragment_Bmi_Calculator_Controller();
        Bundle bundle = new Bundle();
        home_fragment_bmi_calculator_controller.setArguments(bundle);

        return home_fragment_bmi_calculator_controller;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    //뷰에다가 해당하는 layout 을 container에 삽입하기
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.b_home_fragment_bmi_calculator_controller,container,false);


        //전체 를포장하는뷰
        bmi_controller_view = (LinearLayout)view.findViewById(R.id.bmi_controller_view);
        ViewTreeObserver bmi_controller_view_Observer = bmi_controller_view.getViewTreeObserver();
        sex_LinearLayout  = (LinearLayout) view.findViewById(R.id.sex_LinearLayout);
        age_LinearLayout  = (LinearLayout) view.findViewById(R.id.age_LinearLayout);
        height_LinearLayout  = (LinearLayout) view.findViewById(R.id.height_LinearLayout);
        weight_LinearLayout  = (LinearLayout) view.findViewById(R.id.weight_LinearLayout);
        bmi_controller_view_blank_1 = (TextView)view.findViewById(R.id.bmi_controller_view_blank_1);
        bmi_controller_view_blank_2 = (TextView)view.findViewById(R.id.bmi_controller_view_blank_2);
        bmi_controller_view_blank_3 = (TextView)view.findViewById(R.id.bmi_controller_view_blank_3);
        bmi_controller_view_blank_4 = (TextView)view.findViewById(R.id.bmi_controller_view_blank_4);

        //시크바에 뷰 할당 + 뷰의 변동을 체크하기위해 리스너장착
        age_seekbar = (SeekBar)view.findViewById(R.id.bmi_seekerbar_age);
        ViewTreeObserver age_seekbar_Observer = age_seekbar.getViewTreeObserver();
        age_seekbar.setPadding(0, 0, 0, 0);

        height_seekbar = (SeekBar)view.findViewById(R.id.bmi_seekerbar_height);
        ViewTreeObserver height_seekbar_Observer = height_seekbar.getViewTreeObserver();
        height_seekbar.setPadding(0, 0, 0, 0);

        weight_seekbar = (SeekBar)view.findViewById(R.id.bmi_seekerbar_weight);
        ViewTreeObserver weight_seekbar_Observer = weight_seekbar.getViewTreeObserver();
        weight_seekbar.setPadding(0, 0, 0, 0);

        sex_seekbar = (SeekBar)view.findViewById(R.id.bmi_seekerbar_sex);
        ViewTreeObserver sex_seekbar_Observer = sex_seekbar.getViewTreeObserver();
        weight_seekbar.setPadding(0, 0, 0, 0);

        //빨간 기준이될 삼각형 이미지뷰 할당
        red_triangle_age = (LinearLayout)view.findViewById(R.id.red_triangle_age);
        red_triangle_height = (LinearLayout)view.findViewById(R.id.red_triangle_height);
        red_triangle_weight = (LinearLayout)view.findViewById(R.id.red_triangle_weight);

        //seekbar 위 이미지 레이아웃 할당
        age_seekbar_show_layout = (LinearLayout)view.findViewById(R.id.age_seekbar_show_layout) ;
        ViewTreeObserver age_seekbar_show_layout_Observer = age_seekbar_show_layout.getViewTreeObserver();
        height_seekbar_show_layout = (LinearLayout)view.findViewById(R.id.height_seekbar_show_layout) ;
        ViewTreeObserver height_seekbar_show_layout_Observer = height_seekbar_show_layout.getViewTreeObserver();
        weight_seekbar_show_layout = (LinearLayout)view.findViewById(R.id.weight_seekbar_show_layout) ;
        ViewTreeObserver weight_seekbar_show_layout_Observer = weight_seekbar_show_layout.getViewTreeObserver();

        //텍스트뷰 할당
        bmi_height_thumb_text = (TextView)view.findViewById(R.id.bmi_height_thumb_text);
        bmi_weight_thumb_text = (TextView)view.findViewById(R.id.bmi_weight_thumb_text);
        bmi_age_thumb_text= (TextView)view.findViewById(R.id.bmi_age_thumb_text);

        //<editor-fold desc="region - age seekbar에 눈금 이미지뷰 할당">
        age_seek_bar_show1 = (ImageView) view.findViewById(R.id.age_seek_bar_show1);
        age_seek_bar_show2 = (ImageView) view.findViewById(R.id.age_seek_bar_show2);
        age_seek_bar_show3 = (ImageView) view.findViewById(R.id.age_seek_bar_show3);
        age_seek_bar_show4 = (ImageView) view.findViewById(R.id.age_seek_bar_show4);
        age_seek_bar_show5 = (ImageView) view.findViewById(R.id.age_seek_bar_show5);
        age_seek_bar_show6 = (ImageView) view.findViewById(R.id.age_seek_bar_show6);
        age_seek_bar_show7 = (ImageView) view.findViewById(R.id.age_seek_bar_show7);
        age_seek_bar_show8 = (ImageView) view.findViewById(R.id.age_seek_bar_show8);
        age_seek_bar_show9 = (ImageView) view.findViewById(R.id.age_seek_bar_show9);
        age_seek_bar_show10 = (ImageView) view.findViewById(R.id.age_seek_bar_show10);
        age_seek_bar_show11 = (ImageView) view.findViewById(R.id.age_seek_bar_show11);
        age_seek_bar_show12 = (ImageView) view.findViewById(R.id.age_seek_bar_show12);
        age_seek_bar_show13 = (ImageView) view.findViewById(R.id.age_seek_bar_show13);
        age_seek_bar_show14 = (ImageView) view.findViewById(R.id.age_seek_bar_show14);
        age_seek_bar_show15 = (ImageView) view.findViewById(R.id.age_seek_bar_show15);
        age_seek_bar_show16 = (ImageView) view.findViewById(R.id.age_seek_bar_show16);
        age_seek_bar_show17 = (ImageView) view.findViewById(R.id.age_seek_bar_show17);
        age_seek_bar_show18 = (ImageView) view.findViewById(R.id.age_seek_bar_show18);
        age_seek_bar_show19 = (ImageView) view.findViewById(R.id.age_seek_bar_show19);
        age_seek_bar_show20 = (ImageView) view.findViewById(R.id.age_seek_bar_show20);
        age_seek_bar_show21 = (ImageView) view.findViewById(R.id.age_seek_bar_show21);
        age_seek_bar_show22 = (ImageView) view.findViewById(R.id.age_seek_bar_show22);
        age_seek_bar_show23 = (ImageView) view.findViewById(R.id.age_seek_bar_show23);
        age_seek_bar_show24 = (ImageView) view.findViewById(R.id.age_seek_bar_show24);
        age_seek_bar_show25 = (ImageView) view.findViewById(R.id.age_seek_bar_show25);
        age_seek_bar_show26 = (ImageView) view.findViewById(R.id.age_seek_bar_show26);
        age_seek_bar_show27 = (ImageView) view.findViewById(R.id.age_seek_bar_show27);
        age_seek_bar_show28 = (ImageView) view.findViewById(R.id.age_seek_bar_show28);
        age_seek_bar_show29 = (ImageView) view.findViewById(R.id.age_seek_bar_show29);
        age_seek_bar_show30 = (ImageView) view.findViewById(R.id.age_seek_bar_show30);
        age_seek_bar_show31 = (ImageView) view.findViewById(R.id.age_seek_bar_show31);
        age_seek_bar_show32 = (ImageView) view.findViewById(R.id.age_seek_bar_show32);
        age_seek_bar_show33 = (ImageView) view.findViewById(R.id.age_seek_bar_show33);
        age_seek_bar_show34 = (ImageView) view.findViewById(R.id.age_seek_bar_show34);
        age_seek_bar_show35 = (ImageView) view.findViewById(R.id.age_seek_bar_show35);
        age_seek_bar_show36 = (ImageView) view.findViewById(R.id.age_seek_bar_show36);
        age_seek_bar_show37 = (ImageView) view.findViewById(R.id.age_seek_bar_show37);
        age_seek_bar_show38 = (ImageView) view.findViewById(R.id.age_seek_bar_show38);
        age_seek_bar_show39 = (ImageView) view.findViewById(R.id.age_seek_bar_show39);
        age_seek_bar_show40 = (ImageView) view.findViewById(R.id.age_seek_bar_show40);
        age_seek_bar_show41 = (ImageView) view.findViewById(R.id.age_seek_bar_show41);

        age_seek_bar_show[0] = age_seek_bar_show1;
        age_seek_bar_show[1] = age_seek_bar_show2;
        age_seek_bar_show[2] = age_seek_bar_show3;
        age_seek_bar_show[3] = age_seek_bar_show4;
        age_seek_bar_show[4] = age_seek_bar_show5;
        age_seek_bar_show[5] = age_seek_bar_show6;
        age_seek_bar_show[6] = age_seek_bar_show7;
        age_seek_bar_show[7] = age_seek_bar_show8;
        age_seek_bar_show[8] = age_seek_bar_show9;
        age_seek_bar_show[9] = age_seek_bar_show10;
        age_seek_bar_show[10] = age_seek_bar_show11;
        age_seek_bar_show[11] = age_seek_bar_show12;
        age_seek_bar_show[12] = age_seek_bar_show13;
        age_seek_bar_show[13] = age_seek_bar_show14;
        age_seek_bar_show[14] = age_seek_bar_show15;
        age_seek_bar_show[15] = age_seek_bar_show16;
        age_seek_bar_show[16] = age_seek_bar_show17;
        age_seek_bar_show[17] = age_seek_bar_show18;
        age_seek_bar_show[18] = age_seek_bar_show19;
        age_seek_bar_show[19] = age_seek_bar_show20;
        age_seek_bar_show[20] = age_seek_bar_show21;
        age_seek_bar_show[21] = age_seek_bar_show22;
        age_seek_bar_show[22] = age_seek_bar_show23;
        age_seek_bar_show[23] = age_seek_bar_show24;
        age_seek_bar_show[24] = age_seek_bar_show25;
        age_seek_bar_show[25] = age_seek_bar_show26;
        age_seek_bar_show[26] = age_seek_bar_show27;
        age_seek_bar_show[27] = age_seek_bar_show28;
        age_seek_bar_show[28] = age_seek_bar_show29;
        age_seek_bar_show[29] = age_seek_bar_show30;
        age_seek_bar_show[30] = age_seek_bar_show31;
        age_seek_bar_show[31] = age_seek_bar_show32;
        age_seek_bar_show[32] = age_seek_bar_show33;
        age_seek_bar_show[33] = age_seek_bar_show34;
        age_seek_bar_show[34] = age_seek_bar_show35;
        age_seek_bar_show[35] = age_seek_bar_show36;
        age_seek_bar_show[36] = age_seek_bar_show37;
        age_seek_bar_show[37] = age_seek_bar_show38;
        age_seek_bar_show[38] = age_seek_bar_show39;
        age_seek_bar_show[39] = age_seek_bar_show40;
        age_seek_bar_show[40] = age_seek_bar_show41;
        //</editor-fold>

        //<editor-fold desc="region - height seekbar에 눈금 이미지뷰 할당">
        height_seek_bar_show1 = (ImageView) view.findViewById(R.id.height_seek_bar_show1);
        height_seek_bar_show2 = (ImageView) view.findViewById(R.id.height_seek_bar_show2);
        height_seek_bar_show3 = (ImageView) view.findViewById(R.id.height_seek_bar_show3);
        height_seek_bar_show4 = (ImageView) view.findViewById(R.id.height_seek_bar_show4);
        height_seek_bar_show5 = (ImageView) view.findViewById(R.id.height_seek_bar_show5);
        height_seek_bar_show6 = (ImageView) view.findViewById(R.id.height_seek_bar_show6);
        height_seek_bar_show7 = (ImageView) view.findViewById(R.id.height_seek_bar_show7);
        height_seek_bar_show8 = (ImageView) view.findViewById(R.id.height_seek_bar_show8);
        height_seek_bar_show9 = (ImageView) view.findViewById(R.id.height_seek_bar_show9);
        height_seek_bar_show10 = (ImageView) view.findViewById(R.id.height_seek_bar_show10);
        height_seek_bar_show11 = (ImageView) view.findViewById(R.id.height_seek_bar_show11);
        height_seek_bar_show12 = (ImageView) view.findViewById(R.id.height_seek_bar_show12);
        height_seek_bar_show13 = (ImageView) view.findViewById(R.id.height_seek_bar_show13);
        height_seek_bar_show14 = (ImageView) view.findViewById(R.id.height_seek_bar_show14);
        height_seek_bar_show15 = (ImageView) view.findViewById(R.id.height_seek_bar_show15);
        height_seek_bar_show16 = (ImageView) view.findViewById(R.id.height_seek_bar_show16);
        height_seek_bar_show17 = (ImageView) view.findViewById(R.id.height_seek_bar_show17);
        height_seek_bar_show18 = (ImageView) view.findViewById(R.id.height_seek_bar_show18);
        height_seek_bar_show19 = (ImageView) view.findViewById(R.id.height_seek_bar_show19);
        height_seek_bar_show20 = (ImageView) view.findViewById(R.id.height_seek_bar_show20);
        height_seek_bar_show21 = (ImageView) view.findViewById(R.id.height_seek_bar_show21);
        height_seek_bar_show22 = (ImageView) view.findViewById(R.id.height_seek_bar_show22);
        height_seek_bar_show23 = (ImageView) view.findViewById(R.id.height_seek_bar_show23);
        height_seek_bar_show24 = (ImageView) view.findViewById(R.id.height_seek_bar_show24);
        height_seek_bar_show25 = (ImageView) view.findViewById(R.id.height_seek_bar_show25);
        height_seek_bar_show26 = (ImageView) view.findViewById(R.id.height_seek_bar_show26);
        height_seek_bar_show27 = (ImageView) view.findViewById(R.id.height_seek_bar_show27);
        height_seek_bar_show28 = (ImageView) view.findViewById(R.id.height_seek_bar_show28);
        height_seek_bar_show29 = (ImageView) view.findViewById(R.id.height_seek_bar_show29);
        height_seek_bar_show30 = (ImageView) view.findViewById(R.id.height_seek_bar_show30);
        height_seek_bar_show31 = (ImageView) view.findViewById(R.id.height_seek_bar_show31);
        height_seek_bar_show32 = (ImageView) view.findViewById(R.id.height_seek_bar_show32);
        height_seek_bar_show33 = (ImageView) view.findViewById(R.id.height_seek_bar_show33);
        height_seek_bar_show34 = (ImageView) view.findViewById(R.id.height_seek_bar_show34);
        height_seek_bar_show35 = (ImageView) view.findViewById(R.id.height_seek_bar_show35);
        height_seek_bar_show36 = (ImageView) view.findViewById(R.id.height_seek_bar_show36);
        height_seek_bar_show37 = (ImageView) view.findViewById(R.id.height_seek_bar_show37);
        height_seek_bar_show38 = (ImageView) view.findViewById(R.id.height_seek_bar_show38);
        height_seek_bar_show39 = (ImageView) view.findViewById(R.id.height_seek_bar_show39);
        height_seek_bar_show40 = (ImageView) view.findViewById(R.id.height_seek_bar_show40);
        height_seek_bar_show41 = (ImageView) view.findViewById(R.id.height_seek_bar_show41);

        height_seek_bar_show[0] = height_seek_bar_show1;
        height_seek_bar_show[1] = height_seek_bar_show2;
        height_seek_bar_show[2] = height_seek_bar_show3;
        height_seek_bar_show[3] = height_seek_bar_show4;
        height_seek_bar_show[4] = height_seek_bar_show5;
        height_seek_bar_show[5] = height_seek_bar_show6;
        height_seek_bar_show[6] = height_seek_bar_show7;
        height_seek_bar_show[7] = height_seek_bar_show8;
        height_seek_bar_show[8] = height_seek_bar_show9;
        height_seek_bar_show[9] = height_seek_bar_show10;
        height_seek_bar_show[10] = height_seek_bar_show11;
        height_seek_bar_show[11] = height_seek_bar_show12;
        height_seek_bar_show[12] = height_seek_bar_show13;
        height_seek_bar_show[13] = height_seek_bar_show14;
        height_seek_bar_show[14] = height_seek_bar_show15;
        height_seek_bar_show[15] = height_seek_bar_show16;
        height_seek_bar_show[16] = height_seek_bar_show17;
        height_seek_bar_show[17] = height_seek_bar_show18;
        height_seek_bar_show[18] = height_seek_bar_show19;
        height_seek_bar_show[19] = height_seek_bar_show20;
        height_seek_bar_show[20] = height_seek_bar_show21;
        height_seek_bar_show[21] = height_seek_bar_show22;
        height_seek_bar_show[22] = height_seek_bar_show23;
        height_seek_bar_show[23] = height_seek_bar_show24;
        height_seek_bar_show[24] = height_seek_bar_show25;
        height_seek_bar_show[25] = height_seek_bar_show26;
        height_seek_bar_show[26] = height_seek_bar_show27;
        height_seek_bar_show[27] = height_seek_bar_show28;
        height_seek_bar_show[28] = height_seek_bar_show29;
        height_seek_bar_show[29] = height_seek_bar_show30;
        height_seek_bar_show[30] = height_seek_bar_show31;
        height_seek_bar_show[31] = height_seek_bar_show32;
        height_seek_bar_show[32] = height_seek_bar_show33;
        height_seek_bar_show[33] = height_seek_bar_show34;
        height_seek_bar_show[34] = height_seek_bar_show35;
        height_seek_bar_show[35] = height_seek_bar_show36;
        height_seek_bar_show[36] = height_seek_bar_show37;
        height_seek_bar_show[37] = height_seek_bar_show38;
        height_seek_bar_show[38] = height_seek_bar_show39;
        height_seek_bar_show[39] = height_seek_bar_show40;
        height_seek_bar_show[40] = height_seek_bar_show41;
        //</editor-fold>

        //<editor-fold desc="region - weight seekbar에 눈금 이미지뷰 할당">
        weight_seek_bar_show1 = (ImageView) view.findViewById(R.id.weight_seek_bar_show1);
        weight_seek_bar_show2 = (ImageView) view.findViewById(R.id.weight_seek_bar_show2);
        weight_seek_bar_show3 = (ImageView) view.findViewById(R.id.weight_seek_bar_show3);
        weight_seek_bar_show4 = (ImageView) view.findViewById(R.id.weight_seek_bar_show4);
        weight_seek_bar_show5 = (ImageView) view.findViewById(R.id.weight_seek_bar_show5);
        weight_seek_bar_show6 = (ImageView) view.findViewById(R.id.weight_seek_bar_show6);
        weight_seek_bar_show7 = (ImageView) view.findViewById(R.id.weight_seek_bar_show7);
        weight_seek_bar_show8 = (ImageView) view.findViewById(R.id.weight_seek_bar_show8);
        weight_seek_bar_show9 = (ImageView) view.findViewById(R.id.weight_seek_bar_show9);
        weight_seek_bar_show10 = (ImageView) view.findViewById(R.id.weight_seek_bar_show10);
        weight_seek_bar_show11 = (ImageView) view.findViewById(R.id.weight_seek_bar_show11);
        weight_seek_bar_show12 = (ImageView) view.findViewById(R.id.weight_seek_bar_show12);
        weight_seek_bar_show13 = (ImageView) view.findViewById(R.id.weight_seek_bar_show13);
        weight_seek_bar_show14 = (ImageView) view.findViewById(R.id.weight_seek_bar_show14);
        weight_seek_bar_show15 = (ImageView) view.findViewById(R.id.weight_seek_bar_show15);
        weight_seek_bar_show16 = (ImageView) view.findViewById(R.id.weight_seek_bar_show16);
        weight_seek_bar_show17 = (ImageView) view.findViewById(R.id.weight_seek_bar_show17);
        weight_seek_bar_show18 = (ImageView) view.findViewById(R.id.weight_seek_bar_show18);
        weight_seek_bar_show19 = (ImageView) view.findViewById(R.id.weight_seek_bar_show19);
        weight_seek_bar_show20 = (ImageView) view.findViewById(R.id.weight_seek_bar_show20);
        weight_seek_bar_show21 = (ImageView) view.findViewById(R.id.weight_seek_bar_show21);
        weight_seek_bar_show22 = (ImageView) view.findViewById(R.id.weight_seek_bar_show22);
        weight_seek_bar_show23 = (ImageView) view.findViewById(R.id.weight_seek_bar_show23);
        weight_seek_bar_show24 = (ImageView) view.findViewById(R.id.weight_seek_bar_show24);
        weight_seek_bar_show25 = (ImageView) view.findViewById(R.id.weight_seek_bar_show25);
        weight_seek_bar_show26 = (ImageView) view.findViewById(R.id.weight_seek_bar_show26);
        weight_seek_bar_show27 = (ImageView) view.findViewById(R.id.weight_seek_bar_show27);
        weight_seek_bar_show28 = (ImageView) view.findViewById(R.id.weight_seek_bar_show28);
        weight_seek_bar_show29 = (ImageView) view.findViewById(R.id.weight_seek_bar_show29);
        weight_seek_bar_show30 = (ImageView) view.findViewById(R.id.weight_seek_bar_show30);
        weight_seek_bar_show31 = (ImageView) view.findViewById(R.id.weight_seek_bar_show31);
        weight_seek_bar_show32 = (ImageView) view.findViewById(R.id.weight_seek_bar_show32);
        weight_seek_bar_show33 = (ImageView) view.findViewById(R.id.weight_seek_bar_show33);
        weight_seek_bar_show34 = (ImageView) view.findViewById(R.id.weight_seek_bar_show34);
        weight_seek_bar_show35 = (ImageView) view.findViewById(R.id.weight_seek_bar_show35);
        weight_seek_bar_show36 = (ImageView) view.findViewById(R.id.weight_seek_bar_show36);
        weight_seek_bar_show37 = (ImageView) view.findViewById(R.id.weight_seek_bar_show37);
        weight_seek_bar_show38 = (ImageView) view.findViewById(R.id.weight_seek_bar_show38);
        weight_seek_bar_show39 = (ImageView) view.findViewById(R.id.weight_seek_bar_show39);
        weight_seek_bar_show40 = (ImageView) view.findViewById(R.id.weight_seek_bar_show40);
        weight_seek_bar_show41 = (ImageView) view.findViewById(R.id.weight_seek_bar_show41);

        weight_seek_bar_show[0] = weight_seek_bar_show1;
        weight_seek_bar_show[1] = weight_seek_bar_show2;
        weight_seek_bar_show[2] = weight_seek_bar_show3;
        weight_seek_bar_show[3] = weight_seek_bar_show4;
        weight_seek_bar_show[4] = weight_seek_bar_show5;
        weight_seek_bar_show[5] = weight_seek_bar_show6;
        weight_seek_bar_show[6] = weight_seek_bar_show7;
        weight_seek_bar_show[7] = weight_seek_bar_show8;
        weight_seek_bar_show[8] = weight_seek_bar_show9;
        weight_seek_bar_show[9] = weight_seek_bar_show10;
        weight_seek_bar_show[10] = weight_seek_bar_show11;
        weight_seek_bar_show[11] = weight_seek_bar_show12;
        weight_seek_bar_show[12] = weight_seek_bar_show13;
        weight_seek_bar_show[13] = weight_seek_bar_show14;
        weight_seek_bar_show[14] = weight_seek_bar_show15;
        weight_seek_bar_show[15] = weight_seek_bar_show16;
        weight_seek_bar_show[16] = weight_seek_bar_show17;
        weight_seek_bar_show[17] = weight_seek_bar_show18;
        weight_seek_bar_show[18] = weight_seek_bar_show19;
        weight_seek_bar_show[19] = weight_seek_bar_show20;
        weight_seek_bar_show[20] = weight_seek_bar_show21;
        weight_seek_bar_show[21] = weight_seek_bar_show22;
        weight_seek_bar_show[22] = weight_seek_bar_show23;
        weight_seek_bar_show[23] = weight_seek_bar_show24;
        weight_seek_bar_show[24] = weight_seek_bar_show25;
        weight_seek_bar_show[25] = weight_seek_bar_show26;
        weight_seek_bar_show[26] = weight_seek_bar_show27;
        weight_seek_bar_show[27] = weight_seek_bar_show28;
        weight_seek_bar_show[28] = weight_seek_bar_show29;
        weight_seek_bar_show[29] = weight_seek_bar_show30;
        weight_seek_bar_show[30] = weight_seek_bar_show31;
        weight_seek_bar_show[31] = weight_seek_bar_show32;
        weight_seek_bar_show[32] = weight_seek_bar_show33;
        weight_seek_bar_show[33] = weight_seek_bar_show34;
        weight_seek_bar_show[34] = weight_seek_bar_show35;
        weight_seek_bar_show[35] = weight_seek_bar_show36;
        weight_seek_bar_show[36] = weight_seek_bar_show37;
        weight_seek_bar_show[37] = weight_seek_bar_show38;
        weight_seek_bar_show[38] = weight_seek_bar_show39;
        weight_seek_bar_show[39] = weight_seek_bar_show40;
        weight_seek_bar_show[40] = weight_seek_bar_show41;
        //</editor-fold>

        //기존에 저장된 정보가 없을시
        if(bmi_age_value ==-1) {
            bmi_age_value = 20;
            age_seekbar.setProgress(10);
            bmi_height_value = 1700;
            height_seekbar.setProgress(10);
            bmi_weight_value = 630;
            weight_seekbar.setProgress(10);
            bmi_sex_value = sex_seekbar.getProgress();
            onDataTransferToView(bmi_age_value,Float.valueOf(bmi_weight_value)/10 ,Float.valueOf(bmi_height_value)/10,bmi_sex_value);
        }else {
            age_seekbar.setProgress(10);
            height_seekbar.setProgress(10);
            weight_seekbar.setProgress(10);
            sex_seekbar.setProgress(bmi_sex_value);
            onDataTransferToView(bmi_age_value,Float.valueOf(bmi_weight_value)/10 ,Float.valueOf(bmi_height_value)/10,bmi_sex_value);
        }

        //프래그먼트실행시 설정


        age_seekbar_Observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                bmi_age_thumb_text.setText(""+ bmi_age_value );
                set_age_seekbar((int)(bmi_age_value-20));
            }
        });

        height_seekbar_Observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                bmi_height_thumb_text.setText(""+(float) bmi_height_value/10);
                set_height_seekbar((int)(bmi_height_value-20));
            }
        });

        weight_seekbar_Observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                bmi_weight_thumb_text.setText(""+ (float)bmi_weight_value/10 );
                set_weight_seekbar((int)(bmi_weight_value-20));
            }
        });

        sex_seekbar_Observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (bmi_sex_value == 0) {
                    sex_seekbar.getThumb().setBounds(0, 0, sex_seekbar.getHeight(), sex_seekbar.getHeight());
                } else {
                    sex_seekbar.getThumb().setBounds(sex_seekbar.getWidth() - sex_seekbar.getHeight(), 0, sex_seekbar.getWidth(), sex_seekbar.getHeight());
                }
            }
        });



        ViewTreeObserver.OnGlobalLayoutListener age_onglobalListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                int temp_age_width = age_seekbar_show_layout.getWidth() / 43;

                LinearLayout.LayoutParams each_size = new LinearLayout.LayoutParams(
                        temp_age_width*2, age_seekbar_show_layout.getHeight()
                );
                LinearLayout.LayoutParams red_triangle_po = new LinearLayout.LayoutParams(
                        temp_age_width, age_seekbar_show_layout.getHeight()
                );

                red_triangle_age.setLayoutParams(red_triangle_po);
                red_triangle_age.setLeft(temp_age_width*22-red_triangle_age.getWidth()/2);

                for (int i = 0; i < 41; i++) {
                    age_seek_bar_show[i].setLayoutParams(each_size);
                    age_seek_bar_show[i].setLeft(i*temp_age_width+temp_age_width);
                }
            }
        };

        age_seekbar_show_layout_Observer.addOnGlobalLayoutListener(age_onglobalListener);

        ViewTreeObserver.OnGlobalLayoutListener height_onglobalListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                int temp_height_width = height_seekbar_show_layout.getWidth() / 43;

                LinearLayout.LayoutParams each_size = new LinearLayout.LayoutParams(
                        temp_height_width*2, height_seekbar_show_layout.getHeight()
                );
                LinearLayout.LayoutParams red_triangle_po = new LinearLayout.LayoutParams(
                        temp_height_width, height_seekbar_show_layout.getHeight()
                );

                red_triangle_height.setLayoutParams(red_triangle_po);
                red_triangle_height.setLeft(temp_height_width*22-red_triangle_height.getWidth()/2);

                for (int i = 0; i < 41; i++) {
                    height_seek_bar_show[i].setLayoutParams(each_size);
                    height_seek_bar_show[i].setLeft(i*temp_height_width+temp_height_width);
                }
            }
        };

        height_seekbar_show_layout_Observer.addOnGlobalLayoutListener(height_onglobalListener);

        ViewTreeObserver.OnGlobalLayoutListener weight_onglobalListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                int temp_weight_width = weight_seekbar_show_layout.getWidth() / 43;

                LinearLayout.LayoutParams each_size = new LinearLayout.LayoutParams(
                        temp_weight_width*2, weight_seekbar_show_layout.getHeight()
                );
                LinearLayout.LayoutParams red_triangle_po = new LinearLayout.LayoutParams(
                        temp_weight_width, weight_seekbar_show_layout.getHeight()
                );

                red_triangle_weight.setLayoutParams(red_triangle_po);
                red_triangle_weight.setLeft(temp_weight_width*22-red_triangle_weight.getWidth()/2);

                for (int i = 0; i < 41; i++) {
                    weight_seek_bar_show[i].setLayoutParams(each_size);
                    weight_seek_bar_show[i].setLeft(i*temp_weight_width+temp_weight_width);
                }
            }
        };

        weight_seekbar_show_layout_Observer.addOnGlobalLayoutListener(weight_onglobalListener);



        bmi_controller_view_Observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int rest_height = (int) ((float)(bmi_controller_view.getHeight()*0.6) - (sex_LinearLayout.getHeight()+age_LinearLayout.getHeight()+height_LinearLayout.getHeight()+height_LinearLayout.getHeight()))/5;

                Log.d("rest_height",""+rest_height);
                Log.d("bmi_controller_view",""+bmi_controller_view.getHeight());
                Log.d("sex_LinearLayout",""+sex_LinearLayout.getHeight());
                Log.d("age_LinearLayout",""+age_LinearLayout.getHeight());
                Log.d("height_LinearLayout",""+height_LinearLayout.getHeight());
                Log.d("weight_LinearLayout",""+weight_LinearLayout.getHeight());

                LinearLayout.LayoutParams each_size = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, rest_height
                );

                bmi_controller_view_blank_1.setLayoutParams(each_size);
                bmi_controller_view_blank_2.setLayoutParams(each_size);
                bmi_controller_view_blank_3.setLayoutParams(each_size);
                bmi_controller_view_blank_4.setLayoutParams(each_size);
            }
        });





        //AGE 시커바의 동작시 실행 bmi_age_value 값변경 bmi_age_thumb_text의텍스트변경+위치이동
        age_seekbar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){
                    @Override //드래그도즁
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if(bmi_age_value_check_point==-1){
                            bmi_age_value_check_point= seekBar.getProgress();
                        }
                        set_age_seekbar(bmi_age_value-20+(bmi_age_value_check_point-seekBar.getProgress()));
                        bmi_age_value = bmi_age_value + (bmi_age_value_check_point-seekBar.getProgress());
                        if(bmi_age_value<0){
                            bmi_age_value= 0;
                        }else if(bmi_age_value>140){
                            bmi_age_value=140;
                        }
                        bmi_age_thumb_text.setText(""+ bmi_age_value );
                        bmi_age_value_check_point = seekBar.getProgress();
                    }
                    @Override //드래그시작시
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        bmi_age_value_check_point = -1;
                        set_age_seekbar(bmi_age_value-20); //마지막 thumb위치 기반으로 스크롤위치 재조정
                    }

                    @Override//드래드 멈출떄떄
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        onDataTransferToView(bmi_age_value,Float.valueOf(bmi_weight_value)/10 ,Float.valueOf(bmi_height_value)/10,bmi_sex_value);
                    }
                }
        );





        //height 시커바의 동작시 실행 bmi_age_value 값변경 bmi_weight_thumb_text의텍스트변경+위치이동
        height_seekbar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){
                    @Override //드래그도즁
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if(bmi_height_value_check_point==-1){
                            bmi_height_value_check_point= seekBar.getProgress();
                        }
                        set_height_seekbar(bmi_height_value-20+(bmi_height_value_check_point-seekBar.getProgress()));
                        bmi_height_value = bmi_height_value + (bmi_height_value_check_point-seekBar.getProgress());
                        if(bmi_height_value<0){
                            bmi_height_value= 0;
                        }else if(bmi_height_value>2200){
                            bmi_height_value=2200;
                        }
                        bmi_height_thumb_text.setText(""+ ((float)bmi_height_value/10));
                        bmi_height_value_check_point = seekBar.getProgress();
                    }
                    @Override //드래그시작시
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        bmi_height_value_check_point = -1;
                        set_height_seekbar(bmi_height_value-20); //마지막 thumb위치 기반으로 스크롤위치 재조정
                        bmi_height_thumb_text.setText(""+ ((float)bmi_height_value/10));
                    }

                    @Override//드래드 멈출떄떄
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        onDataTransferToView(bmi_height_value,Float.valueOf(bmi_weight_value)/10 ,Float.valueOf(bmi_height_value)/10,bmi_sex_value);
                    }
                }
        );


        //weight 시커바의 동작시 실행 bmi_age_value 값변경 bmi_height_thumb_text의텍스트변경+위치이동
        weight_seekbar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){
                    @Override //드래그도즁
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if(bmi_weight_value_check_point==-1){
                            bmi_weight_value_check_point= seekBar.getProgress();
                        }
                        set_weight_seekbar(bmi_weight_value-20+(bmi_weight_value_check_point-seekBar.getProgress()));
                        bmi_weight_value = bmi_weight_value + (bmi_weight_value_check_point-seekBar.getProgress());
                        if(bmi_weight_value<0){
                            bmi_weight_value= 0;
                        }else if(bmi_weight_value>1500){
                            bmi_weight_value=1500;
                        }
                        bmi_weight_thumb_text.setText(""+ ((float)bmi_weight_value/10) );
                        bmi_weight_value_check_point = seekBar.getProgress();
                    }
                    @Override //드래그시작시
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        bmi_weight_value_check_point = -1;
                        set_weight_seekbar(bmi_weight_value-20); //마지막 thumb위치 기반으로 스크롤위치 재조정
                        bmi_weight_thumb_text.setText(""+ ((float)bmi_weight_value/10) );
                    }

                    @Override//드래드 멈출떄떄
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        onDataTransferToView(bmi_weight_value,Float.valueOf(bmi_weight_value)/10 ,Float.valueOf(bmi_height_value)/10,bmi_sex_value);
                    }
                }
        );


        //Sex 시커바의 동작시 실행
        sex_seekbar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){
                    @Override //드래그도즁
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                        if (progress == 0) {
                            sex_seekbar.getThumb().setBounds(0, 0, sex_seekbar.getHeight(), sex_seekbar.getHeight());
                            bmi_sex_value = 0;
                        } else if(progress == 1) {
                            sex_seekbar.getThumb().setBounds(sex_seekbar.getWidth() - sex_seekbar.getHeight(), 0, sex_seekbar.getWidth(), sex_seekbar.getHeight());
                            bmi_sex_value = 1;
                        }
                    }
                    @Override //드래그시작시
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override//드래드 멈출떄떄
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        onDataTransferToView(bmi_age_value,Float.valueOf(bmi_weight_value)/10 ,Float.valueOf(bmi_height_value)/10,bmi_sex_value);
                    }
                }
        );


        onDataTransferToView(bmi_weight_value,Float.valueOf(bmi_weight_value)/10 ,Float.valueOf(bmi_height_value)/10,bmi_sex_value);

        return view;
    }



    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Fragment_Bmi_Calculator_Fragment_Data_Controller_To_View_Communication_Listner){
            bmi_calculator_fragment_data_controller_to_view_communication_listener = (Fragment_Bmi_Calculator_Fragment_Data_Controller_To_View_Communication_Listner) context;
            this.context = context;
        }
        else {
           throw new RuntimeException(context.toString()+"must implement FragmentListener");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        bmi_calculator_fragment_data_controller_to_view_communication_listener = null;
    }

    public void setNormalCalculatorFragmentListener(Fragment_Bmi_Calculator_Fragment_Data_Controller_To_View_Communication_Listner fragmentListener){
        this.bmi_calculator_fragment_data_controller_to_view_communication_listener = fragmentListener;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof  Fragment_Bmi_Calculator_Fragment_Data_Controller_To_View_Communication_Listner){
            this.bmi_calculator_fragment_data_controller_to_view_communication_listener = (Fragment_Bmi_Calculator_Fragment_Data_Controller_To_View_Communication_Listner)getActivity();
        }
    }


    public void onDataTransferToView(float bmi_age_value,float bmi_weight_value,float bmi_height_value,float bmi_sex_value){
        bmi_calculator_fragment_data_controller_to_view_communication_listener.on_Bmi_Calculating_TextChange(bmi_age_value,bmi_weight_value,bmi_height_value,bmi_sex_value);
    }


    public void set_age_seekbar(int age_value){
        for(int i=0;i<41;i++){
            if(age_value+i>=0 && age_value+i <=140) {
                if ((age_value + i) % 10 == 0) {
                    int num = age_value + i;
                    age_seek_bar_show[i].setImageResource(R.drawable.stick);

                } else {
                    age_seek_bar_show[i].setImageResource(R.drawable.thin_stick);
                }
            }else{
                age_seek_bar_show[i].setImageResource(R.drawable.none_stick);
            }
        }
    }

    public void set_height_seekbar(int height_value){
        for(int i=0;i<41;i++){
            if(height_value+i>=0 && height_value+i <=2200) {
                if ((height_value + i) % 10 == 0) {
                    int num = (height_value + i) / 10;
                    height_seek_bar_show[i].setImageResource(R.drawable.stick);

                } else {
                    height_seek_bar_show[i].setImageResource(R.drawable.thin_stick);
                }
            }else{
                height_seek_bar_show[i].setImageResource(R.drawable.none_stick);
            }
        }
    }


    public void set_weight_seekbar(int weight_value){
        for(int i=0;i<41;i++){
            if(weight_value+i>=0 && weight_value+i <=1500) {
                if((weight_value+i)%10==0) {
                    int num = (weight_value+i)/10;
                    weight_seek_bar_show[i].setImageResource(R.drawable.stick);

                }else {
                    weight_seek_bar_show[i].setImageResource(R.drawable.thin_stick);
                }
            }else{
                weight_seek_bar_show[i].setImageResource(R.drawable.none_stick);
            }
        }
    }




}
