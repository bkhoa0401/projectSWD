package khoa.example.com.project_swd_managerfootfield;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edtName, edtEmail, edtPhone, edtPass, edtConfirmPass;

    Button btnRegisterForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtPass = findViewById(R.id.edtPass);
        edtConfirmPass = findViewById(R.id.edtConfirmPass);

        btnRegisterForm = findViewById(R.id.btnRegisterForm);
        btnRegisterForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidInfor();
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }


    public boolean checkValidName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkValidEmail(String email) {
        String pattern = "\\w+@\\w+[.]\\w+";
        if (!email.matches(pattern)) {
            return false;
        }
        return true;
    }

    public boolean checkValidPhone(String phone) {
        String pattern = "\\d{10}";
        if (!phone.matches(pattern)) {
            return false;
        }
        return true;
    }

    public boolean checkValidPass(String pass) {
        String pattern = "\\w{6,15}";
        if (!pass.matches(pattern)) {
            return false;
        }
        return true;
    }

    public boolean checkValidConformPass(String pass, String confirmPass) {
        if (!pass.equals(confirmPass)) {
            return false;
        }
        return true;
    }

    public void checkValidInfor() {
        boolean checkName = checkValidName(edtName.getText().toString());
        boolean checkEmail = checkValidEmail(edtEmail.getText().toString());
        boolean checkPhone = checkValidPhone(edtPhone.getText().toString());
        boolean checkPass = checkValidPass(edtPass.getText().toString());
        boolean checkConfirmPass = checkValidConformPass(edtPass.getText().toString(), edtConfirmPass.getText().toString());
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(RegisterActivity.this);
        if (checkName == false) {
            dlgAlert.setMessage("Name cann't null!!!");
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //dismiss the dialog
                        }
                    });
            dlgAlert.create().show();
            edtName.requestFocus();
        } else {
            if (checkEmail == false) {
                dlgAlert.setMessage("Email must like abc@gmail.com!!!");
                dlgAlert.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //dismiss the dialog
                            }
                        });
                dlgAlert.create().show();
                edtEmail.requestFocus();
                return;
            } else {
                if (checkPhone == false) {
                    dlgAlert.setMessage("Phone must 10 numbers!!!");
                    dlgAlert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //dismiss the dialog
                                }
                            });
                    dlgAlert.create().show();
                    edtPhone.requestFocus();
                    return;
                } else {
                    if (checkPass == false) {
                        dlgAlert.setMessage("Password must 6-15 character!!!");
                        dlgAlert.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        //dismiss the dialog
                                    }
                                });
                        dlgAlert.create().show();
                        edtPass.requestFocus();
                        return;
                    } else {
                        if (checkConfirmPass == false) {
                            dlgAlert.setMessage("Password not matched!!!");
                            dlgAlert.setPositiveButton("Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            //dismiss the dialog
                                        }
                                    });
                            dlgAlert.create().show();
                            edtConfirmPass.requestFocus();
                            return;
                        } else {
                            RegisterVM register=new RegisterVM(edtName.getText().toString(),edtPass.getText().toString(),
                                    null, null,edtEmail.getText().toString(),null,edtPhone.getText().toString());
                            Toast.makeText(RegisterActivity.this, "OK", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        }
    }

}
