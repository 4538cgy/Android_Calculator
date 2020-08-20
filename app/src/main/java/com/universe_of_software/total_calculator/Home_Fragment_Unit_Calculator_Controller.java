package com.universe_of_software.total_calculator;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Home_Fragment_Unit_Calculator_Controller extends Fragment implements TextWatcher {

    public ArrayList<Recycler_item> mList = null;
    Recycler_Adapter recycler_adapter;
    EditText unit_input_EditText;
    ArrayAdapter<String> arrayAdapter;
    String[] arrayList;
    Spinner spinner, spinner2;
    String selectedPath1 = "밀리미터(mm)", selectedPath2 = "센티미터(cm)";
    Unit_Calculator_Modifier unit_calculator_modifier;
    TextView convertedTextview;
    TextView unitTextView, unitTextView2;
    String id = "길이";
    String inputText = "0";


    private Fragment_Unit_Calculator_Fragment_Data_Controller_To_View_Communication_Listener fragment_unit_calculator_fragment_data_controller_to_view_communication_listener;


    public static Home_Fragment_Unit_Calculator_Controller newInstance() {
        Home_Fragment_Unit_Calculator_Controller home_fragment_unit_calculator_controller = new Home_Fragment_Unit_Calculator_Controller();
        Bundle bundle = new Bundle();
        home_fragment_unit_calculator_controller.setArguments(bundle);

        return home_fragment_unit_calculator_controller;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.b_home_fragment_unit_calculator_controller, container, false);

        this.setUnitMenu();

        unit_calculator_modifier = new Unit_Calculator_Modifier();

        spinner = (Spinner) view.findViewById(R.id.unit_calculator_spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.unit_calculator_spinner2);

        unitTextView = (TextView) view.findViewById(R.id.criteria_textview1);
        unitTextView2 = (TextView) view.findViewById(R.id.criteria_textview2);

        convertedTextview = (TextView) view.findViewById(R.id.converted_textview);

        String[] list = getResources().getStringArray(R.array.length);
        arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter);

        unit_input_EditText = (EditText) view.findViewById(R.id.unit_calculator_input_text_EditText);
        unit_input_EditText.addTextChangedListener(this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.unit_calculator_menu_recycler);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(manager);

        recycler_adapter = new Recycler_Adapter(mList);
        recyclerView.setAdapter(recycler_adapter);
        recycler_adapter.notifyDataSetChanged();


        recycler_adapter.setOnItemClickListener(new Recycler_Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                id = mList.get(position).getTitle().toString();
                onCreateSpinnerItem(id);


            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPath1 = spinner.getSelectedItem().toString();
                unitTextView.setText(selectedPath1);
                fragment_unit_calculator_fragment_data_controller_to_view_communication_listener.setUnitDataStandardType(selectedPath1);
                setTextModified(inputText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPath2 = spinner2.getSelectedItem().toString();
                unitTextView2.setText(selectedPath2);
                setTextModified(inputText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }

    public void setFragment_unit_calculator_fragment_data_controller_to_view_communication_listener(Fragment_Unit_Calculator_Fragment_Data_Controller_To_View_Communication_Listener fragment_unit_calculator_fragment_data_controller_to_view_communication_listener) {
        this.fragment_unit_calculator_fragment_data_controller_to_view_communication_listener = fragment_unit_calculator_fragment_data_controller_to_view_communication_listener;
    }

    public void onCreateSpinnerItem(String s) {
        arrayList = getResources().getStringArray(R.array.weight);


        switch (s) {

            case "길이":
                convertedTextview.setText("0");
                unit_input_EditText.setText("");
                arrayList = getResources().getStringArray(R.array.length);
                selectedPath1 = "밀리미터(mm)";
                selectedPath2 = "밀리미터(mm)";
                setTextModified(inputText);
                fragment_unit_calculator_fragment_data_controller_to_view_communication_listener.setUnitDataType("길이");

                break;
            case "면적":
                convertedTextview.setText("0");
                unit_input_EditText.setText("");
                selectedPath1 = "제곱미터(m²)";
                selectedPath2 = "제곱미터(m²)";
                arrayList = getResources().getStringArray(R.array.area);
                setTextModified(inputText);
                fragment_unit_calculator_fragment_data_controller_to_view_communication_listener.setUnitDataType("면적");

                break;
            case "무게":
                convertedTextview.setText("0");
                unit_input_EditText.setText("");
                selectedPath1 = "밀리그램(mg)";
                selectedPath2 = "밀리그램(mg)";
                arrayList = getResources().getStringArray(R.array.weight);
                setTextModified(inputText);
                fragment_unit_calculator_fragment_data_controller_to_view_communication_listener.setUnitDataType("무게");

                break;
            case "부피":
                convertedTextview.setText("0");
                unit_input_EditText.setText("");
                selectedPath1 = "시시(cc)";
                selectedPath2 = "시시(cc)";
                arrayList = getResources().getStringArray(R.array.volume);
                setTextModified(inputText);
                fragment_unit_calculator_fragment_data_controller_to_view_communication_listener.setUnitDataType("부피");

                break;
                /*
            case "온도":
                convertedTextview.setText("0");
                unit_input_EditText.setText("");
                selectedPath1 = "섭씨온도(℃)";
                selectedPath2 = "섭씨온도(℃)";
                arrayList = getResources().getStringArray(R.array.temperature);
                setTextModified(inputText);
                fragment_unit_calculator_fragment_data_controller_to_view_communication_listener.setUnitDataType("온도");

                break;

                 */
            case "압력":
                convertedTextview.setText("0");
                unit_input_EditText.setText("");
                selectedPath1 = "기압(atm)";
                selectedPath2 = "기압(atm)";
                arrayList = getResources().getStringArray(R.array.pressure);
                setTextModified(inputText);
                fragment_unit_calculator_fragment_data_controller_to_view_communication_listener.setUnitDataType("압력");

                break;
            case "속도":
                convertedTextview.setText("0");
                unit_input_EditText.setText("");
                selectedPath1 = "m/s";
                selectedPath2 = "m/s";
                arrayList = getResources().getStringArray(R.array.speed);
                setTextModified(inputText);
                fragment_unit_calculator_fragment_data_controller_to_view_communication_listener.setUnitDataType("속도");

                break;
            case "연비":
                convertedTextview.setText("0");
                unit_input_EditText.setText("");
                selectedPath1 = "km/l";
                selectedPath2 = "km/l";
                arrayList = getResources().getStringArray(R.array.mileage);
                setTextModified(inputText);
                fragment_unit_calculator_fragment_data_controller_to_view_communication_listener.setUnitDataType("연비");

                break;
            case "데이터양":
                convertedTextview.setText("0");
                unit_input_EditText.setText("");
                selectedPath1 = "비트(bit)";
                selectedPath2 = "비트(bit)";
                arrayList = getResources().getStringArray(R.array.data);
                setTextModified(inputText);
                fragment_unit_calculator_fragment_data_controller_to_view_communication_listener.setUnitDataType("데이터양");

                break;

        }

        arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.support_simple_spinner_dropdown_item, arrayList);

        spinner.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter);
    }

    public void setUnitMenu() {
        mList = new ArrayList<>();
        mList.clear();
        mList.add(new Recycler_item("길이", Recycler_ViewType.ViewType.Only_Text_List));
        mList.add(new Recycler_item("면적", Recycler_ViewType.ViewType.Only_Text_List));
        mList.add(new Recycler_item("무게", Recycler_ViewType.ViewType.Only_Text_List));
        mList.add(new Recycler_item("부피", Recycler_ViewType.ViewType.Only_Text_List));
      //  mList.add(new Recycler_item("온도", Recycler_ViewType.ViewType.Only_Text_List));
        mList.add(new Recycler_item("압력", Recycler_ViewType.ViewType.Only_Text_List));
        mList.add(new Recycler_item("속도", Recycler_ViewType.ViewType.Only_Text_List));
        mList.add(new Recycler_item("연비", Recycler_ViewType.ViewType.Only_Text_List));
        mList.add(new Recycler_item("데이터양", Recycler_ViewType.ViewType.Only_Text_List));


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Fragment_Unit_Calculator_Fragment_Data_Controller_To_View_Communication_Listener) {
            fragment_unit_calculator_fragment_data_controller_to_view_communication_listener = (Fragment_Unit_Calculator_Fragment_Data_Controller_To_View_Communication_Listener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement FragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragment_unit_calculator_fragment_data_controller_to_view_communication_listener = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof Fragment_Unit_Calculator_Fragment_Data_Controller_To_View_Communication_Listener) {
            this.fragment_unit_calculator_fragment_data_controller_to_view_communication_listener = (Fragment_Unit_Calculator_Fragment_Data_Controller_To_View_Communication_Listener) getActivity();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (fragment_unit_calculator_fragment_data_controller_to_view_communication_listener != null) {
            fragment_unit_calculator_fragment_data_controller_to_view_communication_listener.onUnitControllerTextChange(s.toString());
            System.out.println("edit Text의 값이 변경되고있습니다.");
            if (!s.toString().isEmpty()) {
                setTextModified(s.toString());
                inputText = s.toString();
            } else {
                setTextModified("0");
                inputText = "0";
            }
        }
    }

    public void setSelectedItemTextView(String item) {

    }

    public void setTextModified(String s) {


        switch (id) {

            case "길이":
                convertedTextview.setText("" + unit_calculator_modifier.getAtoB(s, selectedPath1, selectedPath2));

                break;
            case "면적":

                convertedTextview.setText("" + unit_calculator_modifier.getAreaConvert(s, selectedPath1, selectedPath2));
                break;
            case "무게":
                convertedTextview.setText("" + unit_calculator_modifier.getWeight(s, selectedPath1, selectedPath2));
                break;
            case "부피":
                convertedTextview.setText("" + unit_calculator_modifier.getVolume(s, selectedPath1, selectedPath2));
                break;
                /*
            case "온도":
                convertedTextview.setText("" + unit_calculator_modifier.getAreaConvert(s, selectedPath1, selectedPath2));
                break;

                 */
            case "압력":
                convertedTextview.setText("" + unit_calculator_modifier.getPressure(s, selectedPath1, selectedPath2));
                break;
            case "속도":
                convertedTextview.setText("" + unit_calculator_modifier.getSpeed(s, selectedPath1, selectedPath2));
                break;
            case "연비":
                convertedTextview.setText("" + unit_calculator_modifier.getMlieage(s, selectedPath1, selectedPath2));
                break;
            case "데이터양":
                convertedTextview.setText("" + unit_calculator_modifier.getData(s, selectedPath1, selectedPath2));
                break;

        }
    }
}
