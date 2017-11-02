package com.voidrealms.app4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private static String tag = "voidrealms";

    private Button btnOrder;
    private ToggleButton btnToggle;
    private CheckBox chkBox1;
    private RadioButton rdoDog;
    private RadioButton rdoCat;
    private RadioButton rdoFish;
    private EditText txtName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOrder = (Button)findViewById(R.id.btnOrder);
        btnToggle = (ToggleButton)findViewById(R.id.btnToggle);
        chkBox1 = (CheckBox) findViewById(R.id.chkBox1);
        rdoDog = (RadioButton)findViewById(R.id.rdoDog);
        rdoCat = (RadioButton)findViewById(R.id.rdoCat);
        rdoFish = (RadioButton)findViewById(R.id.rdoFish);
        txtName = (EditText) findViewById(R.id.txtName);

        btnToggle.setTextOn("Store is open");
        btnToggle.setTextOff("Store is closed");

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOrder();
            }
        });

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doToggle();
            }
        });

    }

    private void doToggle()
    {
        Log.d(tag,btnToggle.getText().toString());
    }

    private void doOrder()
    {
        Log.d(tag,"Beginning order");

        if(!btnToggle.isChecked())
        {
            Log.d(tag,"Sorry we are closed");
            return;
        }

        if(!chkBox1.isChecked())
        {
            Log.d(tag,"Sorry we dont sell dead pets!");
            return;
        }

        if(rdoCat.isChecked()) Log.d(tag,"Ordering a cat");
        if(rdoDog.isChecked()) Log.d(tag,"Ordering a dog");
        if(rdoFish.isChecked()) Log.d(tag,"Ordering a fish");

        Log.d(tag,"Named: " + txtName.getText().toString());

        Log.d(tag,"Order complete");

    }
}
