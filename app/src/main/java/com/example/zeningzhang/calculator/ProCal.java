package com.example.zeningzhang.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by ZeningZhang on 6/24/16.
 */
public class ProCal extends Fragment {

    private TextView result;
    private String secondNum = "";
    private String firstNum = "";
    //    private Boolean isEqualPress = false;
    private Boolean isOperationPress = false;
    private Boolean operationStatus = false;
    private String operator = "";
    private Boolean clearZero = true;
    private int decNumber=0;
    private String hexNumber="";
    private String octNumber="";

    private static final String STATUS_NUMBER = "status_number";
    public ProCal() {
    }

    public MyApplication getApplicationContext() {
        return ((MyApplication) getActivity().getApplicationContext());
    }

    public void setCheckedDec(){
        RadioButton dec = (RadioButton) getActivity().findViewById(R.id.dec);
        RadioButton oct = (RadioButton) getActivity().findViewById(R.id.oct);
        RadioButton hex = (RadioButton) getActivity().findViewById(R.id.hex);
        dec.setChecked(true);
        oct.setChecked(false);
        hex.setChecked(false);
    }
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ProCal newInstance() {
        ProCal fragment = new ProCal();
        return fragment;
    }

    class MyClickListener implements Button.OnClickListener {

        public void normalNumberBtn(String number){
            if (operationStatus == true) {
                result.setText("");
                operationStatus = false;
            }
            if(clearZero)
            {
                result.setText("");
                clearZero = false;
            }
            result.append(number);
            getApplicationContext().setMyPublicData(Double.parseDouble(result.getText().toString()));
        }

        @Override
        public void onClick(View v) {
            if(result==null)
            {
                result = (TextView) getActivity().findViewById(R.id.result);

            }
            hexNumber = Integer.toHexString(getApplicationContext().getMyPublicData().intValue());
            octNumber = Integer.toOctalString(getApplicationContext().getMyPublicData().intValue());

            switch (v.getId())
            {
                case R.id.btn1: {
                    normalNumberBtn("1");
                    break;
                }
                case R.id.btn2: {
                    normalNumberBtn("2");
                    break;
                }
                case R.id.btn3: {
                    normalNumberBtn("3");
                    break;
                }
                case R.id.btn4: {
                    normalNumberBtn("4");
                    break;
                }
                case R.id.btn5: {
                    normalNumberBtn("5");
                    break;
                }
                case R.id.btn6: {
                    normalNumberBtn("6");
                    break;
                }
                case R.id.btn7: {
                    normalNumberBtn("7");
                    break;
                }
                case R.id.btn8: {
                    normalNumberBtn("8");
                    break;
                }
                case R.id.btn9: {
                    normalNumberBtn("9");
                    break;
                }
                case R.id.btn0: {
                    if (operationStatus == true) {
                        result.setText("");
                        operationStatus = false;
                    }
                    if(result.getText().charAt(0)=='0')
                    {
                        break;
                    }
                    result.append("0");
                    getApplicationContext().setMyPublicData(Double.parseDouble(result.getText().toString()));
                    break;
                }
                case R.id.btnClear: {
                    result.setText("0.0");
                    getApplicationContext().setMyPublicData(Double.parseDouble(result.getText().toString()));
                    clearZero = true;
                    secondNum = "";
                    firstNum = "";
                    isOperationPress = false;
                    operationStatus = false;
                    operator = "";
                    break;
                }
                case R.id.oct:
                {
                    result.setText(octNumber);
                    clearZero = true;
                    RadioButton hex = (RadioButton)getActivity().findViewById(R.id.hex);
                    RadioButton dec = (RadioButton)getActivity().findViewById(R.id.dec);
                    hex.setChecked(false);
                    dec.setChecked(false);

                    break;
                }
                case R.id.hex:
                {
                    result.setText(hexNumber);
                    clearZero = true;
                    RadioButton oct = (RadioButton)getActivity().findViewById(R.id.oct);
                    RadioButton dec = (RadioButton)getActivity().findViewById(R.id.dec);
                    oct.setChecked(false);
                    dec.setChecked(false);
                    break;
                }
                case R.id.dec:
                {
                    result.setText(getApplicationContext().getMyPublicData().toString());
                    clearZero = true;
                    RadioButton hex = (RadioButton)getActivity().findViewById(R.id.hex);
                    RadioButton oct = (RadioButton)getActivity().findViewById(R.id.oct);
                    hex.setChecked(false);
                    oct.setChecked(false);
                    break;
                }
                case R.id.btnSqaure:
                {
                    getApplicationContext().setMyPublicData(getApplicationContext().getMyPublicData()*getApplicationContext().getMyPublicData());
                    result.setText(getApplicationContext().getMyPublicData().toString());
                    break;
                }


            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.program_cal, container, false);
        Button Btn0 = (Button) rootView.findViewById(R.id.btn0);
        Button Btn1 = (Button) rootView.findViewById(R.id.btn1);
        Button Btn2 = (Button) rootView.findViewById(R.id.btn2);
        Button Btn3 = (Button) rootView.findViewById(R.id.btn3);
        Button Btn4 = (Button) rootView.findViewById(R.id.btn4);
        Button Btn5 = (Button) rootView.findViewById(R.id.btn5);
        Button Btn6 = (Button) rootView.findViewById(R.id.btn6);
        Button Btn7 = (Button) rootView.findViewById(R.id.btn7);
        Button Btn8 = (Button) rootView.findViewById(R.id.btn8);
        Button Btn9 = (Button) rootView.findViewById(R.id.btn9);
        Button BtnClear = (Button) rootView.findViewById(R.id.btnClear);
        Button BtnDec = (Button) rootView.findViewById(R.id.dec);
        Button BtnOct = (Button) rootView.findViewById(R.id.oct);
        Button BtnHex = (Button) rootView.findViewById(R.id.hex);
        Button BtnSquare = (Button) rootView.findViewById(R.id.btnSqaure);
        MyClickListener listener = new MyClickListener();
        Btn0.setOnClickListener(listener);
        Btn1.setOnClickListener(listener);
        Btn2.setOnClickListener(listener);
        Btn3.setOnClickListener(listener);
        Btn4.setOnClickListener(listener);
        Btn5.setOnClickListener(listener);
        Btn6.setOnClickListener(listener);
        Btn7.setOnClickListener(listener);
        Btn8.setOnClickListener(listener);
        Btn9.setOnClickListener(listener);
        BtnClear.setOnClickListener(listener);
        BtnDec.setOnClickListener(listener);
        BtnHex.setOnClickListener(listener);
        BtnOct.setOnClickListener(listener);
        BtnSquare.setOnClickListener(listener);


        return rootView;
    }



}
