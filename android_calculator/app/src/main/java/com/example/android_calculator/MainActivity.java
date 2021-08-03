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

        //判断字符串是否以操作符+-×÷结束
        boolean operEnd = s.endsWith("+") || s.endsWith("-") || s.endsWith("×") || s.endsWith("÷");

        //正则匹配非负浮点数
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
                //若字符串尾部数字已经包含小数点，则不再添加
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

                //操作符紧跟数字后面，若此时字符串尾部无数字，则不做反应
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

                //直接算出字符串尾部数字的百分之一
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

        //获取文本框的内容
        TextView tx_reslut = findViewById(R.id.tx_result);
        String tx_result = tx_reslut.getText().toString();

        //日常判断字符串非空
        if (tx_result == null || tx_result.equals("") || tx_result.equals("0")) {
            return;
        }

        //字符串尾部若有未完成的操作符，忽略，只计算前面的部分
        if (tx_result.endsWith("+") || tx_result.endsWith("-") || tx_result.endsWith("×") || tx_result.endsWith("÷") || tx_result.endsWith(".")) {
            tx_result = tx_result.substring(0, tx_result.length() - 1);
        }
        //正则匹配字符串头部的浮点数
        Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?");

        int index = 0;
        int length = tx_result.length();

        //以字符串来保存结果，避免精度丢失
        String result = "0";

        //创建数字栈和符号栈
        Deque<BigDecimal> numStack = new LinkedList();
        Deque<Character> operStack = new LinkedList();
        while (true) {
            Matcher matcher = pattern.matcher(tx_result.substring(index, length));

            //如果找到了浮点数，则入数字栈
            if (matcher.find()) {
                String num = matcher.group();
                int numLength = num.length();
                numStack.push(new BigDecimal(num));
                index += numLength;
            }

            //判断字符串是否已经全部扫描
            if (index >= length)
                break;

            //获取操作符，以操作符的优先级来选择直接入符号栈或者执行计算
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

            //判断字符串是否已经扫描完成
            if (index >= length) {
                break;
            }
        }
        while (true) {

            //符号栈空，得到最后结果
            if (operStack.isEmpty()) {
                break;
            }
            result = cal(numStack.pop(), numStack.pop(), operStack.pop());
            numStack.push(new BigDecimal(result));
        }
        tx_reslut.setText(String.valueOf(numStack.pop()));
    }

    public int priority(int oper) {
        if (oper == '×' || oper == '÷') {
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
            case '×':
                res = num1.multiply(num2);
                break;
            case '÷':
                if (num1.equals(new BigDecimal("0")))
                    break;
                res = num2.divide(num1, 5, RoundingMode.HALF_UP);
                break;
        }
        return res.toString();
    }
}