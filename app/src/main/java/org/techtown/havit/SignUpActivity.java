package org.techtown.havit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SignUpActivity extends Activity {
    EditText id,pw;
    Button signbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        id = findViewById(R.id.editTextTextPersonName5);
        pw = findViewById(R.id.editTextTextPersonName4);
        signbtn = findViewById(R.id.SignupBtn);
/*
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String idd = bundle.getString("idd");
        String pww = bundle.getString("pww");

        id.setText(idd);
        pw.setText(pww);

 */

        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                AlertDialog dialog = builder.setMessage("가입이 완료되었습니다.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent registerIntent = new Intent(SignUpActivity.this, MainActivity.class);
                                SignUpActivity.this.startActivity(registerIntent);
                            }
                        })
                        .create();
                dialog.show();
            }
        });

    }


}
