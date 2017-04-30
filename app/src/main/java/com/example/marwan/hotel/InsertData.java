package com.example.marwan.hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertData extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText editName, editDescr, editType, editCity, editPrice, editLng;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        mydb = new DatabaseHelper(this);

         editName = (EditText)findViewById(R.id.placeName);
         editDescr = (EditText)findViewById(R.id.pDescription);
         editType = (EditText)findViewById(R.id.pType);
         editCity = (EditText)findViewById(R.id.pCity);
         editPrice = (EditText)findViewById(R.id.pPrice);
         editLng = (EditText)findViewById(R.id.pLong);
        btnAdd = (Button)findViewById(R.id.btnInsert);

        AddData();
    }

    public void AddData(){
        btnAdd.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                       boolean isInserted = mydb.insertPlace(editName.getText().toString(),
                                editDescr.getText().toString(),
                                editType.getText().toString(),
                                editCity.getText().toString(),
                                editPrice.getText().toString(),
                                editLng.getText().toString());


                        if(isInserted = true){
                            Toast.makeText(InsertData.this,"Data Inserted", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(InsertData.this,"Failed To Insert Data", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }

}
