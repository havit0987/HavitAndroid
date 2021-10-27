package org.techtown.havit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SignInActivity extends Activity {
    EditText editID,editPW;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        editID = findViewById(R.id.editID);
        editPW = findViewById(R.id.editPW);


    }
    public void SignupPage(View v){
        String idd = editID.getText().toString();
        String pww = editPW.getText().toString();
        Intent intent = new Intent(this, SignUpActivity.class);
        intent.putExtra("idd",idd);
        intent.putExtra("pww",pww);

        startActivity(intent);
    }
    public void MainPage(View v){

        String id = editID.getText().toString();
        String pw = editPW.getText().toString();

        Intent m1intent = new Intent(this,MainActivity.class);
        m1intent.putExtra("id",id);
        m1intent.putExtra("pw",pw);
        startActivity(m1intent);


    }

}