package org.techtown.havit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SignInActivity extends Activity {
    EditText editID,editPW;
    private long backKeyPressedTime = 0;
    private Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        editID = findViewById(R.id.editID);
        editPW = findViewById(R.id.editPW);


    }

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