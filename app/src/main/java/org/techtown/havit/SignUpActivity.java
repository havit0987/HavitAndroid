package org.techtown.havit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    EditText id,pw;
    Button signbtn;
    private long backKeyPressedTime = 0;
    private Toast toast;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, R.string.button_back, Toast.LENGTH_SHORT);
            toast.show();
            return;

        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            Intent intent = new Intent(this, MainActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);  // 지나온 액티비티 삭제
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);     // 지나온액티비티 삭제 후 갱신
            startActivity(intent);
            toast.cancel();
        }
    }

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
/*
        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                AlertDialog dialog = builder.setMessage("가입이 완료되었습니다.")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent registerIntent = new Intent(SignUpActivity.this, MainActivity.class);
                                registerIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);  // 지나온 액티비티 삭제
                                registerIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                SignUpActivity.this.startActivity(registerIntent);
                            }
                        })
                        .create();
                dialog.show();
            }
        });
*/

        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);

                builder.setTitle("HAVIT").setMessage(R.string.signUp_msg_continue);


                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
                        AlertDialog adialog = builder.setMessage(R.string.signUp_msg)
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent registerIntent = new Intent(SignUpActivity.this, MainActivity.class);
                                        registerIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);  // 지나온 액티비티 삭제
                                        registerIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        SignUpActivity.this.startActivity(registerIntent);
                                    }
                                })
                                .create();
                        adialog.show();

                    }
                });

                builder.setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {

                    }
                });


                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }


        });

    }


}
