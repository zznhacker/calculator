package com.example.zeningzhang.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by ZeningZhang on 6/24/16.
 */
public class NormalCal extends Fragment {
    private Boolean clearZero = true;
    private TextView result;
    private static final String STATUS_NUMBER = "status_number";
    private String secondNum = "";
    private String firstNum = "";
    //    private Boolean isEqualPress = false;
    private Boolean isOperationPress = false;
    private Boolean operationStatus = false;
    private String operator = "";
    public NormalCal() {
    }

    public MyApplication getApplicationContext() {
        return ((MyApplication) getActivity().getApplicationContext());
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NormalCal newInstance() {
        NormalCal fragment = new NormalCal();
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

        public void normalOperatorBtn(String sign){
            if(operator.equals(""))
                operator = sign;
            operationStatus = true;
            if (isOperationPress == false) {
                firstNum = result.getText().toString();
                isOperationPress = true;
            } else {
                secondNum = result.getText().toString();
                Double temp = caculate(firstNum,secondNum,operator);
                operator = sign;
                result.setText(temp.toString());
                firstNum = Double.toString(temp);
                secondNum = "";
                getApplicationContext().setMyPublicData(Double.parseDouble(result.getText().toString()));
            }
        }

        @Override
        public void onClick(View v) {
            if(result==null)
            {
                result = (TextView) getActivity().findViewById(R.id.result);

            }

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
                case R.id.btnDot: {
                    if (operationStatus == true) {
                        result.setText("");
                        operationStatus = false;
                    }
                    if (result.getText().toString().contains(".")) {
                        break;
                    }
                    result.append(".");
                    clearZero = false;
                    break;
                }
                case R.id.btnPlus: {
                    normalOperatorBtn("+");
                    break;
                }

                case R.id.btnMult: {
                    normalOperatorBtn("*");
                    break;
                }

                case R.id.btnDivide: {
                    normalOperatorBtn("/");
                    break;
                }


                case R.id.btnminus: {
                    normalOperatorBtn("-");
                    break;
                }

                case R.id.btnEqual: {
                    isOperationPress = false;
                    if (!firstNum.equals("") && (secondNum.equals(""))) {
                        if (!operator.equals("")) {
                            secondNum = result.getText().toString();
                            Double tempResult = caculate(firstNum,secondNum,operator);
                            result.setText(tempResult.toString());
                            firstNum = tempResult.toString();
                            secondNum = "";
                            clearZero = true;
                            operator = "";
                        }
                        else if(operator.equals(""))
                        {
                            result.setText(firstNum);
                        }
                    }
                    else if (!firstNum.equals("") && (!secondNum.equals("")))
                    {
                        Double tempResult = caculate(firstNum,secondNum,operator);
                        result.setText(tempResult.toString());
                        firstNum = tempResult.toString();
                        secondNum = "";
                        operator = "";
                        clearZero = true;
                    }
                    getApplicationContext().setMyPublicData(Double.parseDouble(result.getText().toString()));
                    break;

                }
            }

        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.normal_cal, container, false);

//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

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
        Button BtnDot = (Button) rootView.findViewById(R.id.btnDot);
        Button BtnPlus = (Button) rootView.findViewById(R.id.btnPlus);
        Button BtnMinus = (Button) rootView.findViewById(R.id.btnminus);
        Button BtnMulti = (Button) rootView.findViewById(R.id.btnMult);
        Button BtnDiv = (Button) rootView.findViewById(R.id.btnDivide);
        Button BtnEqual = (Button) rootView.findViewById(R.id.btnEqual);
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
        BtnDot.setOnClickListener(listener);
        BtnPlus.setOnClickListener(listener);
        BtnMinus.setOnClickListener(listener);
        BtnMulti.setOnClickListener(listener);
        BtnDiv.setOnClickListener(listener);
        BtnEqual.setOnClickListener(listener);
        return rootView;
    }


    public Double caculate(String firstNum, String secondNum, String operator){
        if(operator.equals("+"))
        {
            return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
        }
        else if(operator.equals("-"))
        {
            return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
        }
        else if(operator.equals("*"))
        {
            return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
        }
        else if(operator.equals("/"))
        {
            return Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
        }
        return 0.0;
        //Error
    }
}