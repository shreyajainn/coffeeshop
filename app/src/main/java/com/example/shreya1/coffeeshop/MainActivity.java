package com.example.shreya1.coffeeshop;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }
    int number=0;
    boolean whippedcream;
    boolean whippedcream2;
    int price =0;
    public void submit_order(View view) {
        EditText name1 =(EditText)findViewById (R.id.e1);
        String name = name1.getText ().toString ();
        CheckBox cream = (CheckBox)findViewById (R.id.c1);
        whippedcream = cream.isChecked ();
        CheckBox cream2= (CheckBox)findViewById (R.id.c2);
        whippedcream2 = cream2.isChecked ();

        int price1 = calculateprice(whippedcream,whippedcream2);
        String m = summary(name,price,whippedcream,whippedcream2 );


        try {
            Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "your_subject");
            intent.putExtra(Intent.EXTRA_TEXT, m);
            startActivity(intent);
        } catch(Exception e) {
            e.printStackTrace();
        }


    }

    private String summary(String name,int price,boolean h,boolean h2) {
        String p = "Good Name: "+name;
        p+="\n Quantity: "+number;
        p+="\n Have Chocolate? "+h;
        p+="\n Have Whpped Cream? "+h2;
        p+="\n Total: $"+price;
        p+="\n Thank you!!!!";
        return p;
    }

    private int calculateprice(boolean m,boolean n) {
        int k=0,l=0;
        if(m) {
            k = number*3;
            price =k+ number * 10;
        }
        if(n)
        {
            l=number*4;
            price = l+number*10;
        }

        return price;
    }

    private void display(int number) {
        TextView k  = (TextView)findViewById(R.id.order);
        k.setText (" "+number);
    }

    public void decc(View view) {
        if(number>0) {
            number = number - 1;
            display (number);
        }
    }

    public void inc(View view) {
        number = number+1;
        display(number);
    }


}
