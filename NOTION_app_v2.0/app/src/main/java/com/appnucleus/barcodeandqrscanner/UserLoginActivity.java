package com.appnucleus.barcodeandqrscanner;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

public class UserLoginActivity extends AppCompatActivity {

    EditText Email, Password;
    Button LogIn ;
    String PasswordHolder, EmailHolder;
    String finalResult ;
        String HttpURL = "http://app-1517372969.000webhostapp.com/android/attend.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    public static final String UserEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        Bundle bundle = getIntent().getExtras();


        final String id_no = bundle.getString("id_no");
        final String email=bundle.getString("email");
        UserActivity obj1=new UserActivity();
        final String email1=obj1.getemailname();
        /*Email = (EditText)findViewById(R.id.email);

        Password = (EditText)findViewById(R.id.password);*/
        LogIn = (Button)findViewById(R.id.Login);
        UserLoginFunction(id_no,email1);
        /*LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    UserLoginFunction(id_no);
            }
        });*/
    }


    public void UserLoginFunction(final String id,final String mail){

        class UserLoginClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(UserLoginActivity.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();
                //Toast.makeText(UserLoginActivity.this,httpResponseMsg+"Fuck",Toast.LENGTH_LONG).show();
                if(httpResponseMsg.equalsIgnoreCase("ok")){

                    finish();
                    Toast.makeText(UserLoginActivity.this,"hello",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(UserLoginActivity.this, Activity_Main.class);



                    startActivity(intent);

                }
                else{
                    Toast.makeText(UserLoginActivity.this,"Result",Toast.LENGTH_LONG).show();
                    //Toast.makeText(UserLoginActivity.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                    /*Intent intent = new Intent(UserLoginActivity.this, Activity_Main.class);



                    startActivity(intent);*/
                    Intent intent = new Intent(UserLoginActivity.this, TryActivity.class);
                    intent.putExtra("txt1",id);//passes text to next page
                    startActivity(intent);
                }

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("id",params[0]);
                hashMap.put("mail",params[1]);

                //hashMap.put("password",params[1]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserLoginClass userLoginClass = new UserLoginClass();

        userLoginClass.execute(id,mail);
    }

}