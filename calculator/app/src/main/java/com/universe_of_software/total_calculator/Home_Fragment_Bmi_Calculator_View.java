package com.universe_of_software.total_calculator;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Home_Fragment_Bmi_Calculator_View extends Fragment   {

    //컨트롤러에서 받아온 bmi 정보
    static float bmi_weight_value,bmi_height_value;

    //계산 결과를 저장하고있는 bmi 결과  seekbar 위치이동에쓰일 변수들
    static int bmi_result_value,       bmi_result_seek_value,thumb_width,thumb_right,thumb_left,padding,sPos,xPos;

    //결과를 표시할 텍스트뷰 , seekbar thumb 위의 결과 출력할 텍스트뷰
    static TextView bmi_result_textview,bmi_result_seekbar_text;

    //결과를 시각적으로 표시하는 화살표
    static ImageView bmi_result_thumb;
    static LinearLayout bmi_result_Linerlayout;

    //결과를 시각적으로 표시하는 ImageView
    static ImageView bmi_result_background;




    ; //Recycler_Adapter 의 어뎁터 생성

    //해당 플라그먼트를 메인 엑티비티에서 불러올수 있도록 처리
    public static Home_Fragment_Bmi_Calculator_View newInstance(){
        Home_Fragment_Bmi_Calculator_View home_fragment_bmi_calculator_view = new Home_Fragment_Bmi_Calculator_View();
        Bundle bundle = new Bundle();
        home_fragment_bmi_calculator_view.setArguments(bundle);
        return home_fragment_bmi_calculator_view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    //뷰에다가 해당하는 layout 을 container에 삽입하기
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.b_home_fragment_bmi_calculator_view,container,false);

        //결과 텍스트 뷰 장착
        bmi_result_textview = (TextView)view.findViewById(R.id.Bmi_result_text);

        //seekbar위 결과 출력할 텍스트뷰
        bmi_result_seekbar_text = (TextView)view.findViewById(R.id.bmi_result_seekbar_text);

        //seekbar 장착착후 시커바 조정 불가상태로 만들기
        bmi_result_thumb = (ImageView) view.findViewById(R.id.bmi_result_thumb);
        bmi_result_Linerlayout = (LinearLayout) view.findViewById(R.id.bmi_result_Linerlayout);

        ViewTreeObserver result_Layout_observer = bmi_result_Linerlayout.getViewTreeObserver();


        //Seekber 하단 이미지 뷰 장착후 그라데이션 추가
        bmi_result_background = (ImageView) view.findViewById(R.id.bmi_result_background);
        FillResult_view_Gradient(bmi_result_background);

        //프래그먼트 만들어질때 실행
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener  = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int temp_resul_lay_width = bmi_result_Linerlayout.getWidth() / 186;
                bmi_result_thumb.setX((bmi_result_seek_value)*temp_resul_lay_width);

                bmi_result_seekbar_text.setX((bmi_result_seek_value-8)*temp_resul_lay_width);

                LinearLayout.LayoutParams Gradaint_Layout = new LinearLayout.LayoutParams(
                        temp_resul_lay_width*186, bmi_result_background.getHeight()
                );
                LinearLayout.LayoutParams result_Layout = new LinearLayout.LayoutParams(
                        temp_resul_lay_width*21, bmi_result_background.getHeight()
                );
                bmi_result_seekbar_text.setLayoutParams(result_Layout);
                bmi_result_background.setLayoutParams(Gradaint_Layout);

            }
        };

        result_Layout_observer.addOnGlobalLayoutListener(onGlobalLayoutListener);






        return view;
    }


    //컨트롤 프라그먼트에서 받은 정보로 결과변경
    public void set_bmi_result(float _bmi_age_value, float _bmi_weight_value, float _bmi_height_value, float _bmi_sex_value) {

        //몸무게와 키 결과값을 받아 결과값 산출
        bmi_weight_value = _bmi_weight_value;
        bmi_height_value = _bmi_height_value;
        bmi_result_value = (int)(bmi_weight_value/((bmi_height_value*bmi_height_value)/100000));
        bmi_result_seek_value = bmi_result_value-140;
        if(bmi_result_seek_value<0){
            bmi_result_seek_value = 0;
        }else if(bmi_result_seek_value>180){
            bmi_result_seek_value = 180;
        }

        //계산된 결과값을 text 뷰에 출력
        bmi_result_textview.setText(""+(float) bmi_result_value/10);

        if( bmi_result_seek_value< (int)45 ) {
            bmi_result_seekbar_text.setText("저체중");
        }else if( bmi_result_seek_value< (int)90 ) {
            bmi_result_seekbar_text.setText("정상");
        }else if( bmi_result_seek_value< (int)110 ) {
            bmi_result_seekbar_text.setText("과체중");
        }else if( bmi_result_seek_value< (int)160 ) {
            bmi_result_seekbar_text.setText("비만");
        }else{
            bmi_result_seekbar_text.setText("고도비만");
        }

        int temp_resul_lay_width = bmi_result_Linerlayout.getWidth() / 186;

        bmi_result_thumb.setX((bmi_result_seek_value)*temp_resul_lay_width);

        bmi_result_seekbar_text.setX((bmi_result_seek_value-8)*temp_resul_lay_width);

        Log.d("bmi_result_thumb",""+bmi_result_thumb.getX());
        Log.d("bmi_result_seekbar_text",""+bmi_result_seekbar_text.getX());




    }

//시커바 배경 커스텀 그라데이션으로 변경
    private void FillResult_view_Gradient(View v){
        final View view = v;
        Drawable[] layers = new Drawable[1];

        ShapeDrawable.ShaderFactory sf = new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                LinearGradient lg = new LinearGradient(
                        0,
                        0,
                        view.getWidth(),
                        0,
                        new int[] {
                                getResources().getColor(R.color.bmi_result_1), // please input your color from resource for color-4
                                getResources().getColor(R.color.bmi_result_2),
                                getResources().getColor(R.color.bmi_result_3),
                                getResources().getColor(R.color.bmi_result_4),
                                getResources().getColor(R.color.bmi_result_5)},
                        new float[] { 0, 0.19f, 0.53f,0.84f, 1 },
                        Shader.TileMode.CLAMP);
                return lg;
            }
        };

        PaintDrawable p = new PaintDrawable();
        p.setShape(new RectShape());
        p.setShaderFactory(sf);
        p.setCornerRadii(new float[] { 5, 5, 5, 5, 0, 0, 0, 0 });
        p.setCornerRadius(100);
        layers[0] = (Drawable) p;

        LayerDrawable composite = new LayerDrawable(layers);


        v.setBackground(p);
    }






}
