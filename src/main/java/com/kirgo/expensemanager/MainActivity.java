package com.kirgo.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;



import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    private ImageSwitcher imageSwitcher;
    private int[] galeria = {R.drawable.portada, R.drawable.portada2, R.drawable.portada3};
    private int position;
    private static final int DURATION = 9000;
    private Timer timer = null;

    EditText txt_amount;
    EditText txt_date;
    EditText txt_description;
    Button btnAddPayer;
    ArrayList<UserInfo> payers = new ArrayList<UserInfo>();
    PayerLaistAdapter adapter;
    int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_amount = findViewById(R.id.txtf_amount);
        txt_date = findViewById(R.id.txtf_date);
        txt_description = findViewById(R.id.txtf_description);
        btnAddPayer = findViewById(R.id.btn_add_payer);
        btnAddPayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfo user = users.get(index);
                index = (index +1) % users.size();
                PayerInfo newPayer = new PayerInfo("", user.name,"", 0);
                payers.add(newPayer);
                adapter.notifyItemInserted(payers.size()-1);
            }
        });

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        imageSwitcher.setInAnimation(fadeIn);
        imageSwitcher.setInAnimation(fadeOut);

        imageSwitcher = findViewById(R.id.mainSwitcher);
        imageSwitcher.setFactory(() -> {
            ImageView imageView = new ImageView(MainActivity.this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        });
    }
}