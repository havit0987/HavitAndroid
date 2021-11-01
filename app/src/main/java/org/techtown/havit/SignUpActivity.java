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

public class SignUpActivity extends Activity {
    EditText id,pw;
    Button signbtn;
    private long backKeyPressedTime = 0;
    private Toast toast;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 홈으로 이동됩니다.", Toast.LENGTH_SHORT);
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
