package com.example.marwan.hotel;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ViewData extends AppCompatActivity {

    // grabs set of data from database and displays in a listview

    private SQLiteDatabase db;
    private Cursor cursor;
    public static final String EXTRA_MESSAGE = "message";
    ListView dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);


        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);


        dataList = (ListView) findViewById(R.id.dataList);

        try {

            SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
            db = databaseHelper.getReadableDatabase();
            <!-- Fetch all the data record from the database -->
            cursor = db.rawQuery("SELECT * FROM booking WHERE TYPE='" + message + "'", null);


            while(cursor.isAfterLast() == false){
                cursor.moveToNext();
            }

            ListAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[] {"NAME"},
                    new int[] {android.R.id.text1},0);


            dataList.setAdapter(listAdapter);


        } catch (SQLiteException e) {

            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }


        db.close();


        dataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                String item = ((TextView)view).getText().toString();
                Intent intent = new Intent(ViewData.this, ViewPlace.class);
                intent.putExtra("place", item);
                startActivity(intent);
            }
        });

    }
}
