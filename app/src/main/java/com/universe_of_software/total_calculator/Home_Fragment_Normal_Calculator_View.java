package com.universe_of_software.total_calculator;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Home_Fragment_Normal_Calculator_View extends Fragment {

    static TextView textView,textView2;//해당 프라그 먼트에서 적혀있던 내용 저장할 변수
    static TextView resultTextView;

    private Fragment_Normal_Calculator_Fragment_Data_View_To_Controller_Communication_Listener normal_calculator_fragment_data_communication_listener = null ;

    //해당 플라그먼트를 메인 엑티비티에서 불러올수 있도록 처리
    public static Home_Fragment_Normal_Calculator_View newInstance(){
        Home_Fragment_Normal_Calculator_View home_fragment_normal_calculator_view = new Home_Fragment_Normal_Calculator_View();
        Bundle bundle = new Bundle();
        home_fragment_normal_calculator_view.setArguments(bundle);

        return home_fragment_normal_calculator_view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    //뷰에다가 해당하는 layout 을 container에 삽입하기
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.b_home_fragment_normal_calculator_view,container,false);

        textView = (TextView)view.findViewById(R.id.normal_calculator_textview1);
        textView2 = (TextView)view.findViewById(R.id.normal_calculator_textview2);
        resultTextView = (TextView)view.findViewById(R.id.result_operator_textview);

        //해당뷰의 글자수가 바뀔때마다 실행
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
                    if(textView.length() >30 ){
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    }else if(textView.length() >25 ){
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                    }
                    else if(textView.length() >20 ){
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    }
                    else if(textView.length() > 15){
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                    }else{
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                    }
                }
            }
        });
        resultTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O){
                    if(resultTextView.length() >49 ){
                        resultTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 5);
                    }else if(resultTextView.length() >44 ){
                        resultTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
                    }
                    else if(resultTextView.length() >39 ){
                        resultTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                    }
                    else{
                        resultTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                    }
                }
            }
        });
        //해당뷰의 글자수가 바뀔때마다 실행
        textView2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //String result = textView2.getText().toString();
                //normal_calculator_fragment_data_communication_listener.on_Normal_Calculator_ResultChange(result);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;

    }

    //프라그 먼트 생명주기 관련

    @Override
    //프라그 먼트 생성때 호출
    //인터페이스 설정
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Fragment_Normal_Calculator_Fragment_Data_View_To_Controller_Communication_Listener){
            normal_calculator_fragment_data_communication_listener = (Fragment_Normal_Calculator_Fragment_Data_View_To_Controller_Communication_Listener)context;

        }else  {
            throw new RuntimeException(context.toString()+"must implement FragmentListener");
        }
    }

    @Override
    //프라그먼트 (다른걸로)교체시 호출
    public void onDetach() {
        super.onDetach();
        normal_calculator_fragment_data_communication_listener = null;
    }

    public void setNormalCaculatorFragmentListener(Fragment_Normal_Calculator_Fragment_Data_View_To_Controller_Communication_Listener fragmentListener){
        this.normal_calculator_fragment_data_communication_listener = fragmentListener;
    }

    @Override
    //프라그 먼트 붙일 엑티비티 생성될떄 호출
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() instanceof Fragment_Normal_Calculator_Fragment_Data_View_To_Controller_Communication_Listener){
            this.normal_calculator_fragment_data_communication_listener = (Fragment_Normal_Calculator_Fragment_Data_View_To_Controller_Communication_Listener)getActivity();
        }
    }

    public void SetNumberText(String inputText1) {

        if(inputText1 != null){
            Log.d("확인 : ", inputText1);

            textView.setText(inputText1);
        }
    }
    public void SetCodeText( String inputCode) {
        if(inputCode != null){
            Log.d("확인2 : ", inputCode);
            textView2.setText(inputCode);

        }
    }
    public void SetResultOperText(String inputResultOper){
        if(inputResultOper != null){
            resultTextView.setText(inputResultOper);
        }
    }



}
