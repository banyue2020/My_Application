package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Fragment fragment_first=new Fragment_chat();
    private Fragment fragment_second=new Fragment_contact();
    private Fragment fragment_third=new Fragment_find();
    private Fragment fragment_fourth=new Fragment_me();

    private FragmentManager fragmentManager;

    private LinearLayout linear_first;
    private LinearLayout linear_second;
    private LinearLayout linear_third;
    private LinearLayout linear_fourth;

    private ImageView imageView_first;
    private ImageView imageView_second;
    private ImageView imageView_third;
    private ImageView imageView_fourth;

    private TextView textView_first;
    private TextView textView_second;
    private TextView textView_third;
    private TextView textView_fourth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE );
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
        initEvent();

        selectFragment(0);
        imageView_first.setColorFilter(Color.CYAN);
        textView_first.setTextColor(Color.CYAN);
    }

    @Override
    public void onClick(View view) {
        restartButton();

        switch(view.getId())
        {
            case R.id.chat:
                selectFragment(0);
                imageView_first.setColorFilter(Color.CYAN);
                textView_first.setTextColor(Color.CYAN);
                break;
            case R.id.contact:
                selectFragment(1);
                imageView_second.setColorFilter(Color.CYAN);
                textView_second.setTextColor(Color.CYAN);
                break;
            case R.id.find:
                selectFragment(2);
                imageView_third.setColorFilter(Color.CYAN);
                textView_third.setTextColor(Color.CYAN);
                break;
            case R.id.me:
                selectFragment(3);
                imageView_fourth.setColorFilter(Color.CYAN);
                textView_fourth.setTextColor(Color.CYAN);
                break;
            default:
                break;
        }
    }
    private void restartButton() {
        imageView_first.setColorFilter(0);
        textView_first.setTextColor(Color.GRAY);
        imageView_second.setColorFilter(0);
        textView_second.setTextColor(Color.GRAY);
        imageView_third.setColorFilter(0);
        textView_third.setTextColor(Color.GRAY);
        imageView_fourth.setColorFilter(0);
        textView_fourth.setTextColor(Color.GRAY);
    }
    private void initFragment(){
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.frame_content,fragment_first);
        transaction.add(R.id.frame_content,fragment_second);
        transaction.add(R.id.frame_content,fragment_third);
        transaction.add(R.id.frame_content,fragment_fourth);
        transaction.commit();
    }

    private  void initView(){
        linear_first=findViewById(R.id.chat);
        linear_second=findViewById(R.id.contact);
        linear_third=findViewById(R.id.find);
        linear_fourth=findViewById(R.id.me);

        imageView_first=findViewById(R.id.imageView1);
        imageView_second=findViewById(R.id.imageView2);
        imageView_third=findViewById(R.id.imageView3);
        imageView_fourth=findViewById(R.id.imageView4);

        textView_first=findViewById(R.id.textView1);
        textView_second=findViewById(R.id.textView2);
        textView_third=findViewById(R.id.textView3);
        textView_fourth=findViewById(R.id.textView4);

    }
    private void initEvent(){
        linear_first.setOnClickListener(this);
        linear_second.setOnClickListener(this);
        linear_third.setOnClickListener(this);
        linear_fourth.setOnClickListener(this);
    }
    private void hideView(FragmentTransaction transaction){
        transaction.hide(fragment_first);
        transaction.hide(fragment_second);
        transaction.hide(fragment_third);
        transaction.hide(fragment_fourth);
    }
    private void selectFragment(int i){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideView(transaction);
        switch (i){
            case 0:
                transaction.show(fragment_first);

                break;
            case 1:
                transaction.show(fragment_second);

                break;
            case 2:
                transaction.show(fragment_third);

                break;
            case 3:
                transaction.show(fragment_fourth);

                break;
            default:
                break;
        }
        transaction.commit();
    }

}
