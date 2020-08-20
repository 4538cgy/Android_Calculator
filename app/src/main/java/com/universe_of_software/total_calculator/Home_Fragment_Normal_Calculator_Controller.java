package com.universe_of_software.total_calculator;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.text.DecimalFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Home_Fragment_Normal_Calculator_Controller extends Fragment implements View.OnClickListener {
    String resultText;
    List<String> resultTexts;

    private Fragment_Normal_Calculator_Fragment_Data_Controller_To_View_Communication_Listener normal_calculator_fragment_data_controller_to_view_communication_listener = null;

    boolean isFirstInput = true; //첫번째 입력인지 체크
    double number1 = 0;
    double number2 = 0;
    String operCode = "+" ;

    String clearText ;  //삭제할때 저장할 데이터

    String inputText;   //입력한 숫자
    DecimalFormat decimalFormat = new DecimalFormat("###,###.##########");

    //해당 플라그먼트를 메인 엑티비티에서 불러올수 있도록 처리  -> 자신의 뷰를 플래드먼트로 만들어 반환
    public static Home_Fragment_Normal_Calculator_Controller newInstance(){
        Home_Fragment_Normal_Calculator_Controller home_fragment_normal_calculator_controller = new Home_Fragment_Normal_Calculator_Controller();
        Bundle bundle = new Bundle();
        home_fragment_normal_calculator_controller.setArguments(bundle);

        return home_fragment_normal_calculator_controller;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    //뷰에다가 해당하는 layout 을 container에 삽입하기
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.b_home_fragment_normal_calculator_controller,container,false);

        //버튼에 해당하는 버튼을 할당하고 온클릭 리스너 장착
        Button parenthesisButton,percentButton,divideButton,multipleButton,sevenButton,eightButton
                ,nineButton,minusButton,fourButton,fiveButton,sixButton,plusButton,oneButton,twoButton
                ,threeButton,clearButton,zeroButton,dotButton,equalButton,backSpaceButton;

       // testTextView =(TextView)view.findViewById(R.id.testTextView);

        backSpaceButton = (Button)view.findViewById(R.id.normal_calculator_button_backspace);
        percentButton = (Button)view.findViewById(R.id.normal_calculator_button_percent);
        divideButton = (Button)view.findViewById(R.id.normal_calculator_button_divide);
        multipleButton = (Button)view.findViewById(R.id.normal_calculator_button_multiple);
        minusButton = (Button)view.findViewById(R.id.normal_calculator_button_minus);
        plusButton = (Button)view.findViewById(R.id.normal_calculator_button_plus);
        clearButton = (Button)view.findViewById(R.id.normal_calculator_button_clear);
        dotButton = (Button)view.findViewById(R.id.normal_calculator_button_dot);
        equalButton = (Button)view.findViewById(R.id.normal_calculator_button_equal);
        oneButton = (Button)view.findViewById(R.id.normal_calculator_button_one);
        twoButton = (Button)view.findViewById(R.id.normal_calculator_button_two);
        threeButton = (Button)view.findViewById(R.id.normal_calculator_button_three);
        fourButton = (Button)view.findViewById(R.id.normal_calculator_button_four);
        fiveButton = (Button)view.findViewById(R.id.normal_calculator_button_five);
        sixButton = (Button)view.findViewById(R.id.normal_calculator_button_six);
        sevenButton = (Button)view.findViewById(R.id.normal_calculator_button_seven);
        eightButton = (Button)view.findViewById(R.id.normal_calculator_button_eight);
        nineButton = (Button)view.findViewById(R.id.normal_calculator_button_nine);
        zeroButton = (Button)view.findViewById(R.id.normal_calculator_button_zero);

        backSpaceButton.setOnClickListener(this);
        percentButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
        multipleButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        plusButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        dotButton.setOnClickListener(this);
        equalButton.setOnClickListener(this);
        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        sevenButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        zeroButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof Fragment_Normal_Calculator_Fragment_Data_Controller_To_View_Communication_Listener){
            normal_calculator_fragment_data_controller_to_view_communication_listener = (Fragment_Normal_Calculator_Fragment_Data_Controller_To_View_Communication_Listener)context;
        }else {
            throw new RuntimeException(context.toString()+"must implement FragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        normal_calculator_fragment_data_controller_to_view_communication_listener = null;
    }

    public void setNormalCalculatorFragmentListener(Fragment_Normal_Calculator_Fragment_Data_Controller_To_View_Communication_Listener fragmentListener){
        this.normal_calculator_fragment_data_controller_to_view_communication_listener = fragmentListener;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof  Fragment_Normal_Calculator_Fragment_Data_Controller_To_View_Communication_Listener){
            this.normal_calculator_fragment_data_controller_to_view_communication_listener = (Fragment_Normal_Calculator_Fragment_Data_Controller_To_View_Communication_Listener)getActivity();
        }
    }

    //액티비티에서 전달한 진행값을 받아옴
   // public void setCalculating(String c)         calculatingText = c;

    //액티비티에서 전달한 결과값을 받아옴
    public void setResult(String s){
        resultText = s;
    }

    /*
    public void onDataTransferToView(String text,String result){
        normal_calculator_fragment_data_controller_to_view_communication_listener.on_Normal_Calculating_TextChange(text);
        normal_calculator_fragment_data_controller_to_view_communication_listener.on_Normal_Calculating_ResultChange(result);
    }*/

    public void OnDataTransferToView1(String num1){
        normal_calculator_fragment_data_controller_to_view_communication_listener.on_Normal_Calculating_TextChange1(num1);
    }

    public void OnDataTransferToView2(String code){
        normal_calculator_fragment_data_controller_to_view_communication_listener.on_Normal_Calculating_TextChange2(code);
    }
    public void OnDataTransferToView3(String text){
        normal_calculator_fragment_data_controller_to_view_communication_listener.on_Normal_Calculating_TextChange3(text);
    }


    @Override
    public void onClick(View v) {
        Button getBtn = v.findViewById(v.getId());
        Log.d("Btn 클릭", getBtn.getText().toString() +"버튼이 클릭되었습니다.");

        switch (v.getId()) {
            case R.id.normal_calculator_button_dot:
                if(isFirstInput){
                    inputText = "0.";
                    isFirstInput = false;
                }else{
                    if(!inputText.contains(".")){
                        inputText += ".";
                    }
                }
                OnDataTransferToView1(inputText);
                break;
            case R.id.normal_calculator_button_clear:
                SetClear();
                SetClearText("0");

                OnDataTransferToView1(inputText);
                OnDataTransferToView2("");
                OnDataTransferToView3(resultText);

                break;

            case R.id.normal_calculator_button_backspace:
                if (!isFirstInput ) {
                    if(inputText.length() > 1 ){
                        String value = inputText.replace(",","");
                        String subString = value.substring(0, value.length()-1);
                        //String decimalString = GetDecimalString(subString);
                        inputText = GetDecimalString(subString);
                    }else{
                        //SetClear();
                        SetClearText("0");
                        OnDataTransferToView3(resultText);
                    }
                    OnDataTransferToView1(inputText);
                }
                break;
            case R.id.normal_calculator_button_percent:

            case R.id.normal_calculator_button_equal:
            case R.id.normal_calculator_button_divide:
            case R.id.normal_calculator_button_multiple:
            case R.id.normal_calculator_button_minus:
            case R.id.normal_calculator_button_plus:

                if(resultText != null ){
                    if(resultText.length()>1){
                        char temp = resultText.charAt(resultText.length() -2);

                        if(temp == '+' ||temp == '-' ||temp == '*' ||temp == '/' ||temp == '%' )
                        {
                            resultText = resultText.substring(0, resultText.length()-2) + resultText.substring(resultText.length()-1);
                        }
                    }
                }
                Log.d("isFirstInput",isFirstInput ? "true":"false");
                String operator = v.getTag().toString();
                String getResult = GetResult(isFirstInput, inputText, operator);

                OnDataTransferToView1(getResult);
                OnDataTransferToView2(operCode);
                OnDataTransferToView3(resultText);
                isFirstInput = true;
                break;
            case R.id.normal_calculator_button_seven:
            case R.id.normal_calculator_button_eight:
            case R.id.normal_calculator_button_nine:
            case R.id.normal_calculator_button_four:
            case R.id.normal_calculator_button_five:
            case R.id.normal_calculator_button_six:
            case R.id.normal_calculator_button_one:
            case R.id.normal_calculator_button_two:
            case R.id.normal_calculator_button_three:
            case R.id.normal_calculator_button_zero:
                if(isFirstInput){
                    inputText = v.getTag().toString();

                    isFirstInput = false;

                    OnDataTransferToView1(inputText);
                }else{
                    if(inputText.equals("0")){
                        SetClear();
                        SetClearText("0");
                    }else{
                        String getText = inputText + v.getTag().toString();

                        if(getText.length()>15){

                        }else{
                            inputText += v.getTag().toString();
                            String getInputText = inputText.replace(",","");
                            inputText = GetDecimalString(getInputText);

                            OnDataTransferToView1(inputText);
                        }

                    }
                }


                break;
            default:
                break;
        }
     }

     public String GetDecimalString(String changeString){
        String setChangeString = changeString.replace(",","");
        return decimalFormat.format(Double.parseDouble(setChangeString));
     }
    public String GetDecimalString(double changeNumber){
        return decimalFormat.format(changeNumber);
    }



    public void SetClearText(String setText){
        isFirstInput = true;
        inputText = setText;
    }

    public void SetClear(){
        number1 =0;
        number2 =0;
        operCode = "+";
        resultText = "";
    }
    public String GetResult(boolean isFirstInput, String getResultString, String operator){
        if (isFirstInput) {
            if(operator.equals("=")){
                number1 = CalculateDouble(number1, number2, operCode);
                resultText = GetDecimalString(number1);
            }else{
                operCode = operator;
                if(resultText == null || resultText.equals("")){
                    if(getResultString == null || getResultString.equals("")){
                        resultText = operator;
                    }else{
                        resultText = getResultString + " " + operator;
                    }
                }
                else {
                    if(resultText.length()>1) {
                        char temp = resultText.charAt(resultText.length() - 1);

                        if (temp == '+' || temp == '-' || temp == '*' || temp == '/' || temp == '%') {
                            resultText = resultText.substring(0, resultText.length() - 1)  + operator;
                        } else {
                            resultText = resultText + operator;
                        }
                    }else{
                        resultText = resultText + operator;
                    }
                }
            }
        } else {
            number2 = Double.parseDouble(getResultString.replace(",",""));
            number1 = CalculateDouble(number1,number2,operCode);

            if(operator.equals("=")){
                resultText = GetDecimalString(number1);
            }else{
                if(resultText == null|| resultText.equals("")){
                    resultText = getResultString + " " + operator;
                }else
                {
                    resultText = resultText + " " + getResultString + " " + operator;
                    //resultText = resultText + " " + operCode + " " + getResultString + " " + operator;
                }
                operCode = operator;
            }
        }
        return GetDecimalString(number1);
    }


    public double CalculateDouble(double number1, double number2, String operator){

        switch (operator){
            case "+":
                number1 += number2;

                break;
            case "-":
                number1 -= number2;
                break;
            case "*" :
                number1 *= number2;
                break;
            case "/":
                number1 /= number2;
                break;
            case "%" :
                number1 %= number2;
                break;

        }
        return number1;
    }
}
