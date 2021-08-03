package com.example.android_calculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculate {

    private TextView textView;
    //数字1-9
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;

    //运算符
    private Button btn_point;
    private Button btn_plus;
    private Button btn_sub;
    private Button btn_multi;
    private Button btn_division;
    //小数点
    private Button btn_percent;
    //等号
    private Button btn_equal;
    //清除
    private Button btn_DEL;
    private Button btn_AC;

    private View.OnClickListener clickListener;

    public static final class CalculateBuilder {

        private TextView textView;
        //数字1-9
        private Button btn_0;
        private Button btn_1;
        private Button btn_2;
        private Button btn_3;
        private Button btn_4;
        private Button btn_5;
        private Button btn_6;
        private Button btn_7;
        private Button btn_8;
        private Button btn_9;
        //运算符
        private Button btn_point;
        private Button btn_plus;
        private Button btn_sub;
        private Button btn_multi;
        private Button btn_division;
        //小数点
        private Button btn_percent;
        //等号
        private Button btn_equal;
        //清除
        private Button btn_DEL;
        private Button btn_AC;
        private View.OnClickListener clickListener;

        private CalculateBuilder() {
        }

        public static CalculateBuilder aCalculate() {
            return new CalculateBuilder();
        }

        public CalculateBuilder withTextView(TextView textView) {
            this.textView = textView;
            return this;
        }

        public CalculateBuilder withBtn_0(Button btn_0) {
            this.btn_0 = btn_0;
            return this;
        }

        public CalculateBuilder withBtn_1(Button btn_1) {
            this.btn_1 = btn_1;
            return this;
        }

        public CalculateBuilder withBtn_2(Button btn_2) {
            this.btn_2 = btn_2;
            return this;
        }

        public CalculateBuilder withBtn_3(Button btn_3) {
            this.btn_3 = btn_3;
            return this;
        }

        public CalculateBuilder withBtn_4(Button btn_4) {
            this.btn_4 = btn_4;
            return this;
        }

        public CalculateBuilder withBtn_5(Button btn_5) {
            this.btn_5 = btn_5;
            return this;
        }

        public CalculateBuilder withBtn_6(Button btn_6) {
            this.btn_6 = btn_6;
            return this;
        }

        public CalculateBuilder withBtn_7(Button btn_7) {
            this.btn_7 = btn_7;
            return this;
        }

        public CalculateBuilder withBtn_8(Button btn_8) {
            this.btn_8 = btn_8;
            return this;
        }

        public CalculateBuilder withBtn_9(Button btn_9) {
            this.btn_9 = btn_9;
            return this;
        }

        public CalculateBuilder withBtn_point(Button btn_point) {
            this.btn_point = btn_point;
            return this;
        }

        public CalculateBuilder withBtn_plus(Button btn_plus) {
            this.btn_plus = btn_plus;
            return this;
        }

        public CalculateBuilder withBtn_sub(Button btn_sub) {
            this.btn_sub = btn_sub;
            return this;
        }

        public CalculateBuilder withBtn_multi(Button btn_multi) {
            this.btn_multi = btn_multi;
            return this;
        }

        public CalculateBuilder withBtn_division(Button btn_division) {
            this.btn_division = btn_division;
            return this;
        }

        public CalculateBuilder withBtn_percent(Button btn_percent) {
            this.btn_percent = btn_percent;
            return this;
        }

        public CalculateBuilder withBtn_DEL(Button btn_DEL) {
            this.btn_DEL = btn_DEL;
            return this;
        }

        public CalculateBuilder withBtn_AC(Button btn_AC) {
            this.btn_AC = btn_AC;
            return this;
        }

        public CalculateBuilder withBtn_equal(Button btn_equal) {
            this.btn_equal = btn_equal;
            return this;
        }

        public CalculateBuilder withClickListener(View.OnClickListener clickListener) {
            this.clickListener = clickListener;
            return this;
        }


        public Calculate build() {
            Calculate calculate = new Calculate();
            calculate.btn_DEL = this.btn_DEL;
            calculate.btn_3 = this.btn_3;
            calculate.textView = this.textView;
            calculate.btn_7 = this.btn_7;
            calculate.btn_point = this.btn_point;
            calculate.btn_multi = this.btn_multi;
            calculate.btn_percent = this.btn_percent;
            calculate.btn_2 = this.btn_2;
            calculate.btn_9 = this.btn_9;
            calculate.clickListener = this.clickListener;
            calculate.btn_0 = this.btn_0;
            calculate.btn_5 = this.btn_5;
            calculate.btn_8 = this.btn_8;
            calculate.btn_sub = this.btn_sub;
            calculate.btn_4 = this.btn_4;
            calculate.btn_division = this.btn_division;
            calculate.btn_6 = this.btn_6;
            calculate.btn_1 = this.btn_1;
            calculate.btn_plus = this.btn_plus;
            calculate.btn_AC = this.btn_AC;
            calculate.btn_equal=this.btn_equal;

            calculate.btn_0.setOnClickListener(clickListener);
            calculate.btn_1.setOnClickListener(clickListener);
            calculate.btn_2.setOnClickListener(clickListener);
            calculate.btn_3.setOnClickListener(clickListener);
            calculate.btn_4.setOnClickListener(clickListener);
            calculate.btn_5.setOnClickListener(clickListener);
            calculate.btn_6.setOnClickListener(clickListener);
            calculate.btn_7.setOnClickListener(clickListener);
            calculate.btn_8.setOnClickListener(clickListener);
            calculate.btn_9.setOnClickListener(clickListener);
            calculate.btn_AC.setOnClickListener(clickListener);
            calculate.btn_DEL.setOnClickListener(clickListener);
            calculate.btn_division.setOnClickListener(clickListener);
            calculate.btn_point.setOnClickListener(clickListener);
            calculate.btn_plus.setOnClickListener(clickListener);
            calculate.btn_sub.setOnClickListener(clickListener);
            calculate.btn_multi.setOnClickListener(clickListener);
            calculate.btn_percent.setOnClickListener(clickListener);
            calculate.btn_equal.setOnClickListener(clickListener);
            return calculate;

        }
    }
}
