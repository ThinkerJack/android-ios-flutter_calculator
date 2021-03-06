package com.example.android_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCalculate();
    }

    public Calculate initCalculate() {
        return Calculate.CalculateBuilder
                .aCalculate()
                .withBtn_0(findViewById(R.id.btn_0))
                .withBtn_1(findViewById(R.id.btn_1))
                .withBtn_2(findViewById(R.id.btn_2))
                .withBtn_3(findViewById(R.id.btn_3))
                .withBtn_4(findViewById(R.id.btn_4))
                .withBtn_5(findViewById(R.id.btn_5))
                .withBtn_6(findViewById(R.id.btn_6))
                .withBtn_7(findViewById(R.id.btn_7))
                .withBtn_8(findViewById(R.id.btn_8))
                .withBtn_9(findViewById(R.id.btn_9))
                .withBtn_AC(findViewById(R.id.btn_AC))
                .withBtn_DEL(findViewById(R.id.btn_DEL))
                .withBtn_division(findViewById(R.id.btn_division))
                .withBtn_multi(findViewById(R.id.btn_multi))
                .withBtn_percent(findViewById(R.id.btn_percent))
                .withBtn_plus(findViewById(R.id.btn_plus))
                .withBtn_point(findViewById(R.id.btn_point))
                .withBtn_sub(findViewById(R.id.btn_minus))
                .withTextView(findViewById(R.id.tx_result))
                .withBtn_equal(findViewById(R.id.btn_equal))
                .withClickListener(this)
                .build();
    }

    @Override
    public void onClick(View v) {
        TextView tx_reslut = findViewById(R.id.tx_result);
        String s = tx_reslut.getText().toString();

        //?????????????????????????????????+-??????????
        boolean operEnd = s.endsWith("+") || s.endsWith("-") || s.endsWith("??") || s.endsWith("??");

        //???????????????????????????
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?$");
        Matcher matcher = pattern.matcher(s);
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                if (s.equals("0"))
                    tx_reslut.setText(s.substring(0, s.length() - 1) + ((Button) v).getText());
                else tx_reslut.setText(s + ((Button) v).getText());
                break;

            case R.id.btn_point:
                //???????????????????????????????????????????????????????????????
                if (matcher.find()) {
                    if (matcher.group().contains(".")) {
                        break;
                    }
                    tx_reslut.setText(s + ((Button) v).getText());
                }
                break;

            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multi:
            case R.id.btn_division:

                //?????????????????????????????????????????????????????????????????????????????????
                if (matcher.find()) {
                    if (operEnd)
                        tx_reslut.setText(s.substring(0, s.length() - 1) + ((Button) v).getText());
                    else tx_reslut.setText(s + ((Button) v).getText());
                }
                break;
            case R.id.btn_DEL:
                if (s != null) {
                    if (s.equals("")) {
                        tx_reslut.setText("0");
                    } else tx_reslut.setText(s.substring(0, s.length() - 1));
                }
                break;
            case R.id.btn_AC:
                tx_reslut.setText("0");
                break;
            case R.id.btn_percent:

                //????????????????????????????????????????????????
                if (matcher.find()) {
                    tx_reslut.setText(s.substring(0, s.length() - matcher.group().length()) + (Double.valueOf(matcher.group()) / 100));
                }
                break;
            case R.id.btn_equal:
                getResult();
                break;
        }
    }

    public void getResult() {

        //????????????????????????
        TextView tx_reslut = findViewById(R.id.tx_result);
        String tx_result = tx_reslut.getText().toString();

        //???????????????????????????
        if (tx_result == null || tx_result.equals("") || tx_result.equals("0")) {
            return;
        }

        //??????????????????????????????????????????????????????????????????????????????
        if (tx_result.endsWith("+") || tx_result.endsWith("-") || tx_result.endsWith("??") || tx_result.endsWith("??") || tx_result.endsWith(".")) {
            tx_result = tx_result.substring(0, tx_result.length() - 1);
        }
        //???????????????????????????????????????
        Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?");

        int index = 0;
        int length = tx_result.length();

        //????????????????????????????????????????????????
        String result = "0";

        //???????????????????????????
        Deque<BigDecimal> numStack = new LinkedList();
        Deque<Character> operStack = new LinkedList();
        while (true) {
            Matcher matcher = pattern.matcher(tx_result.substring(index, length));

            //??????????????????????????????????????????
            if (matcher.find()) {
                String num = matcher.group();
                int numLength = num.length();
                numStack.push(new BigDecimal(num));
                index += numLength;
            }

            //???????????????????????????????????????
            if (index >= length)
                break;

            //???????????????????????????????????????????????????????????????????????????????????????
            char oper = tx_result.charAt(index);
            if (!operStack.isEmpty()) {
                if ((priority(oper) <= priority(operStack.peek()))) {
                    result = cal(numStack.pop(), numStack.pop(), operStack.pop());
                    numStack.push(new BigDecimal(result));
                }
                operStack.push(oper);
                index++;

            } else {
                operStack.push(oper);
                index++;
            }

            //???????????????????????????????????????
            if (index >= length) {
                break;
            }
        }
        while (true) {

            //?????????????????????????????????
            if (operStack.isEmpty()) {
                break;
            }
            result = cal(numStack.pop(), numStack.pop(), operStack.pop());
            numStack.push(new BigDecimal(result));
        }
        tx_reslut.setText(String.valueOf(numStack.pop()));
    }

    public int priority(int oper) {
        if (oper == '??' || oper == '??') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public String cal(BigDecimal num1, BigDecimal num2, Character oper) {
        BigDecimal res = new BigDecimal("0");
        switch (oper) {
            case '+':
                res = num1.add(num2);
                break;
            case '-':
                res = num2.subtract(num1);
                break;
            case '??':
                res = num1.multiply(num2);
                break;
            case '??':
                if (num1.equals(new BigDecimal("0")))
                    break;
                res = num2.divide(num1, 5, RoundingMode.HALF_UP);
                break;
        }
        return res.toString();
    }
}