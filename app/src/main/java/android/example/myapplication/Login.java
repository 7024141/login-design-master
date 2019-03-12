package android.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
    }

    public void btnLogin(View view){
        new compareUserInfo().execute();
    }

    private class compareUserInfo extends AsyncTask<String, Void, String[]>{

        @Override
        protected String[] doInBackground(String... strings) {
            SharedPreferences myPreference = getSharedPreferences("myPreference", Context.MODE_PRIVATE);
            String name = myPreference.getString("email", "defaultname");
            String pwd = myPreference.getString("password", "000000");

            String str[] = new String[2];
            str[0] = name;
            str[1] = pwd;

            return str;
        }

        @Override
        protected void onPostExecute(String[] strings) {
            EditText edtMail = (EditText)findViewById(R.id.loginemail);
            EditText edtPwd = (EditText) findViewById(R.id.loginpassword);

            String strMail = edtMail.getText().toString();
            String strPwd = edtPwd.getText().toString();

            if(strMail.equals(strings[0])&&strPwd.equals(strings[1])){
                edtPwd.setText("");
                Intent intent = new Intent(Login.this, Enter.class);
                startActivity(intent);
            }
            else
                Toast.makeText(Login.this,"Fail!", Toast.LENGTH_LONG).show();
        }
    }

    public void btnRegister(View view){
        finish();
    }
}
