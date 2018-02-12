package com.tekmeda123.android.stockistfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FormActivity extends AppCompatActivity {

    @BindView(R.id.stAddress)
    EditText Staddress;
    @BindView(R.id.stCity)
    EditText Stcity;
    @BindView(R.id.stemail)
    EditText Stemail;
    @BindView(R.id.stEntName)
    EditText Stenterprisename;
    @BindView(R.id.stdelev)
    EditText Stno_of_deleivery_people;
    @BindView(R.id.stLicense)
    EditText Stlicense;
    @BindView(R.id.stName)
    EditText Stname;
    @BindView(R.id.stnor)
    EditText Stno_of_retailers;
    @BindView(R.id.stnoc)
    EditText Stno_of_companies;
    @BindView(R.id.stPhone)
    EditText Stphone;
    @BindView(R.id.stPincode)
    EditText Stpin;
    @BindView(R.id.stState)
    EditText Ststate;

    @BindView(R.id.btnSubmit)
    Button submit;

    Stockist stockist = new Stockist();

    static FirebaseDatabase database;
    static DatabaseReference myRef;

    static HashMap<String, Stockist> allStockists = new HashMap<String, Stockist>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("stockists");

    }

    public void submitForm(View view) {
        stockist.name=Stname.getText().toString();
        stockist.address=Staddress.getText().toString();
        stockist.city=Stcity.getText().toString();
        stockist.email=Stemail.getText().toString();
        stockist.enterprise_Name=Stenterprisename.getText().toString();
        stockist.no_of_companies=Stno_of_companies.getText().toString();
        stockist.no_of_delievery_people=Stno_of_deleivery_people.getText().toString();
        stockist.no_of_retailers=Stno_of_retailers.getText().toString();
        stockist.state=Ststate.getText().toString();
        stockist.pincode=Stpin.getText().toString();
        stockist.phone=Stphone.getText().toString();
        stockist.license=Stlicense.getText().toString();
        String key=myRef.push().getKey();
        myRef.child(key).setValue(stockist);


    }
}
