package com.codepath.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String sEditText = getIntent().getStringExtra("EditText");
        EditText etList = (EditText) findViewById(R.id.editTextToDoList);
        etList.setText(sEditText);
        etList.setSelection(etList.getText().length());
        setTitle("Edit Item");
    }

    public void onSaveItem(View view) {
        EditText etText = (EditText) findViewById(R.id.editTextToDoList);
        int iPosition = getIntent().getIntExtra("Position", 0);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("TextSendBack", etText.getText().toString());
        data.putExtra("positionSendBack", iPosition);
        data.putExtra("code", 200); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response

        this.finish();
    }
}
