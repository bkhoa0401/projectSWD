package khoa.example.com.project_swd_managerfootfield;

import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.se.omapi.Session;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.net.PasswordAuthentication;
import java.util.Properties;

public class ForgetPasswordActivity extends AppCompatActivity {

    EditText edtEmail, edtUser;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        edtEmail = findViewById(R.id.edtEmailForget);
        edtUser = findViewById(R.id.edtNameForget);
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterVM forget = null;
//                if(forget==null){
//                    Toast.makeText(ForgetPasswordActivity.this,"Don't find username or email!",Toast.LENGTH_SHORT).show();
                //}else{
            }
        });
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }
}

