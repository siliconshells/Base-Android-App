package com.pixelresolve.pixa;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;

import com.pixelresolve.pixa.sharedmodels.PixaUser;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button mLoginButton;
    Button mExitButton;
    EditText mUsername;
    EditText mPassword;

    //Get https
    //Get spring boot security and use tokens
    //Let them do secret questions in case password is forgotten


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(XXXXX)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RepositoryInterface service = retrofit.create(RepositoryInterface.class);

    @Override
    public void onResume()
    {
        super.onResume();
        mUsername.requestFocus();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //necessary to prevent network problems when calling execute below
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);

        mLoginButton = findViewById(R.id.btnLogin);
        mExitButton = findViewById(R.id.btnExit);
        mUsername = findViewById(R.id.editText3);
        mPassword = findViewById(R.id.editText2);


        mLoginButton.setOnClickListener(v -> {
            Call<PixaUser> userCall = service.getUser(mUsername.getText().toString());
            Response<PixaUser> response = null;

            try {
                response = userCall.execute();

                if (!response.isSuccessful()) {
                    throw new IOException(response.errorBody() != null
                            ? response.errorBody().string() : "Unknown error");
                }


                if(response.body().getPassword().equals(mPassword.getText().toString())) {
                    mUsername.setText("");
                    mPassword.setText("");
                    Intent newIntent = new Intent(this, EntranceActivity.class);
                    newIntent.putExtra("fullname",response.body().getRealname());
                    startActivity(newIntent);
                }
            } catch (IOException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
