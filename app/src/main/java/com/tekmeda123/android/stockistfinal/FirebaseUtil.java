package com.tekmeda123.android.stockistfinal;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

/**
 * Created by thealgo on 2/1/18.
 */

public class FirebaseUtil {

    static FirebaseDatabase database;
    static DatabaseReference myRef;

    static HashMap<String, Stockist> allStockists = new HashMap<String, Stockist>();

    public FirebaseUtil(){
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.child("stockists");

        Log.d("firebase","Attaching listender");
        myRef.child("stockists").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                allStockists.clear();
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    allStockists.put(child.getKey(), child.getValue(Stockist.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



    public static void addstockist(Stockist stockist){
        myRef.child("stockists").child(stockist.name).setValue(stockist);
    }

}
