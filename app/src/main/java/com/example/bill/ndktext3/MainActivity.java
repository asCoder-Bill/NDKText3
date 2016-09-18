package com.example.bill.ndktext3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   private Load load;
    EditText editText1;
    EditText editText2;
    TextView textView;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load = new Load();

        editText1 = (EditText) findViewById(R.id.editText1); //左边的文字输入框，以下简称“左框”
        editText2 = (EditText) findViewById(R.id.editText2); //右边的文字输入框，以下简称“右框”
        textView = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮“addInt”用来计算左框里的整数和右框里的整数相加
                //你要是不输入整数，它就当你输入了“0”
                int a = 0;
                try {
                    a = Integer.parseInt(String.valueOf(editText1.getText()));
                } catch (NumberFormatException e) {
                }
                int b = 0;
                try {
                    b = Integer.parseInt(String.valueOf(editText2.getText()));
                } catch (NumberFormatException e) {
                }
                int r = load.addInt(a, b);
                textView.setText("C++库计算" + a + "+" + b + "的结果是：" + r);
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮“mulDouble”用来计算左框里的实数和右框里的实数相乘
                //你要是不输入数字，它就当你输入了“0”
                double a = 0;
                try {
                    a = Double.parseDouble(String.valueOf(editText1.getText()));
                } catch (NumberFormatException e) {
                }
                double b = 0;
                try {
                    b = Double.parseDouble(String.valueOf(editText2.getText()));
                } catch (NumberFormatException e) {
                }
                double r = load.mulDouble(a, b);
                textView.setText("C++库计算" + a + "*" + b + "的结果是：" + r);
            }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮“intArray”用来计算左框里的整数数组每个元素加10会变成什么，结果放在右框里
                //输入数组时，元素之间用英文逗号隔开，比如“1,2,3”
                //对于每个元素，你要是不输入整数，它就当你输入了“0”
                //注意不要用中文逗号，不然它无法识别
                String str = String.valueOf(editText1.getText());
                String[] strArray;
                if (str.contains(",")) strArray = str.split(",");
                else strArray = new String[]{str};
                int N = strArray.length;
                int[] array = new int[N];
                for (int i = 0; i < N; i++) {
                    int t = 0;
                    try {
                        t = Integer.parseInt(strArray[i]);
                    } catch (NumberFormatException e) {
                    }
                    array[i] = t;
                }
                int[] newArray = load.intArray(array);
                str = "";
                for (int i = 0; i < N; i++) {
                    if (i < N - 1) str += String.valueOf(newArray) + ",";
                    else str += String.valueOf(newArray);
                }
                editText2.setText(str);
                textView.setText("C++库用左边的数组计算，结果在右边");
            }
        });
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮“doubleArray”用来计算左框里的实数数组每个元素乘2会变成什么，结果放在右框里
                //输入数组时，元素之间用英文逗号隔开，比如“2.5,3.14,8”
                //对于每个元素，你要是不输入数字，它就当你输入了“0”
                //注意不要用中文逗号，不然它无法识别
                String str = String.valueOf(editText1.getText());
                String[] strArray;
                if (str.contains(",")) strArray = str.split(",");
                else strArray = new String[]{str};
                int N = strArray.length;
                double[] array = new double[N];
                for (int i = 0; i < N; i++) {
                    double t = 0;
                    try {
                        t = Double.parseDouble(strArray[i]);
                    } catch (NumberFormatException e) {
                    }
                    array[i] = t;
                }
                double[] newArray = load.doubleArray(array);
                str = "";
                for (int i = 0; i < N; i++) {
                    if (i < N - 1) str += String.valueOf(newArray) + ",";
                    else str += String.valueOf(newArray);
                }
                editText2.setText(str);
                textView.setText("C++库用左边的数组计算，结果在右边");
            }
        });
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮“stringArray”用来把左框里的字符串数组颠倒顺序，结果放在右框里
                //输入数组时，元素之间用英文逗号隔开，比如“China,USA,England”
                //注意不要用中文逗号，不然它把这个逗号当成一个字符，与左右字符串相连成为数组中的一个元素
                String str = String.valueOf(editText1.getText());
                String[] strArray;
                if (str.contains(",")) strArray = str.split(",");
                else strArray = new String[]{str};
                int N = strArray.length;
                String[] newArray = load.stringArray(strArray);
                str = "";
                for (int i = 0; i < N; i++) {
                    if (i < N - 1) str += newArray + ",";
                    else str += newArray;
                }
                editText2.setText(str);
                textView.setText("C++库颠倒了左边数组的顺序，结果在右边");
            }
        });
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮“addString”用来把左框里的字符串与右框里的字符串相加
                String a = String.valueOf(editText1.getText());
                String b = String.valueOf(editText2.getText());
                String r = load.addString(a, b);
                textView.setText("C++库计算" + a + "+" + b + "的结果是：" + r);
            }
        });
    }
}
