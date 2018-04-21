package com.example.kyleskelly.searchbarapp;

/**
 * -
 */
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    DatabaseHelper myDB;
    Button btnAdd;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        ListView listView = (ListView) findViewById(R.id.listView);
        myDB = new DatabaseHelper(this);

        //populate an ArrayList<String> from the database and then view it
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
                
                /* set new activity from listview */
                listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        if (position == 0) {
                            Intent myIntent = new Intent (view.getContext (), Main2ActivityList.class);
                            startActivityForResult (myIntent, 0);
                        }
                        if (position == 1) {
                            Intent myIntent = new Intent (view.getContext (), Main2ActivityList.class);
                            startActivityForResult (myIntent, 1);
                        }
                        if (position == 2) {
                            Intent myIntent = new Intent (view.getContext (), Main2ActivityList.class);
                            startActivityForResult (myIntent, 2);
                        }
                        if (position == 3) {
                            Intent myIntent = new Intent (view.getContext (), Main2ActivityList.class);
                            startActivityForResult (myIntent, 3);
                        }
                        if (position == 4) {
                            Intent myIntent = new Intent (view.getContext (), Main2ActivityList.class);
                            startActivityForResult (myIntent, 4);
                        }
                        if (position == 5) {
                            Intent myIntent = new Intent (view.getContext (), Main2ActivityList.class);
                            startActivityForResult (myIntent, 5);
                        }
                        if (position == 6) {
                            Intent myIntent = new Intent (view.getContext (), Main2ActivityList.class);
                            startActivityForResult (myIntent, 6);
                        }
                        if (position == 7) {
                            Intent myIntent = new Intent (view.getContext (), Main2ActivityList.class);
                            startActivityForResult (myIntent, 7);
                        }




                    }
                });
            }
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length() !=0) {
                    AddData(newEntry);
                    editText.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this,"Please put something in the field.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData(String newEntry) {
        boolean insertData = myDB.addData(newEntry);

        if (insertData==true) {
            Toast.makeText(MainActivity.this, "Successfully Entered Medication", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }


}
