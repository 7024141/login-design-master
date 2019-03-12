package android.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        //setContentView(R.layout.layout_login);
        //setContentView(R.layout.activity_main);
    }

    public void btnRegist(View view){
        EditText edtName = (EditText) findViewById(R.id.name);
        EditText edtMail = (EditText)findViewById(R.id.email);
        EditText edtPwd = (EditText) findViewById(R.id.password);

        String strName = edtName.getText().toString();
        String strMail = edtMail.getText().toString();
        String strPwd = edtPwd.getText().toString();

        if(strName.length()>0 && strMail.length()>0 && strPwd.length()>0){
            SharedPreferences myPreference=getSharedPreferences("myPreference", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = myPreference.edit();

            editor.putString("name", strName);
            editor.putString("email", strMail);
            editor.putString("password", strPwd);

            editor.apply();

            edtName.setText("");
            edtMail.setText("");
            edtPwd.setText("");

//            Intent intent = new Intent("com.example.myapplication.ACTION_LOGIN");
//            MainActivity.this.startActivity(intent);


            Log.d("tips",myPreference.getString("name", "no content"));
        }
        else return;
    }

    public void btnToLogin(View view){
        Intent intent = new Intent("com.example.myapplication.ACTION_LOGIN");
        MainActivity.this.startActivity(intent);

    }
}
