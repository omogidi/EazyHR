package activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.eazyhr.R;

import java.util.List;

import model.LoginResponse;
import rest.ApiClient;
import interfaces.DataServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private final static String API_KEY = "";
    private EditText username, password;
    private Button login;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.enterEmail);
        password = findViewById(R.id.enterPassword);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.loginButton:
                attemptlogin();
                break;
        }
    }

    private void attemptlogin()
    {
        String user = username.getText().toString().trim();
        String passw = password.getText().toString().trim();

        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(passw)) {
            Toast.makeText(this, "Are you blind. Cant you see it is incorrect", Toast.LENGTH_SHORT).show();
        } else {
            fromServer(this, user, passw);
        }
    }

    private void fromServer(final Context context, final String username, final String password)
    {
        //pushID = getPushID.getDevicePushID();
        progressDialog = ProgressDialog.show(context, "", "Please wait while we save your profile...");

        DataServices service = ApiClient.getRetrofitInstance(30, 60).create(DataServices.class);
        Call<List<LoginResponse>> call = service.userLogin(username, password);
        call.enqueue(new Callback<List<LoginResponse>>() {
            @Override
            public void onResponse(Call<List<LoginResponse>> call, Response<List<LoginResponse>> response) {

                List<LoginResponse> data = response.body();
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    String statuscode = String.valueOf(data.get(0).getResponse_code());
                    String status = String.valueOf(data.get(0).getResponse_status());
                    //String employeeID = String.valueOf(data.get(0).getEmployee_id());
                    if (statuscode.equals("1")) {
                        //storeUserEntity.StoreUserRecord(context, user_id, username);
                        //showAlert(context, status, "Ok", "1");
                        Toast.makeText(context, "Successful!" + status, Toast.LENGTH_SHORT).show();
                    } else if (statuscode.equals("0")) {
                        //showAlert(context, status, "Retry", "0");
                        Toast.makeText(context, "Failed!" + status, Toast.LENGTH_SHORT).show();

                    } else {

                    }


                } else {
                    progressDialog.dismiss();
                    //showAlert(context, "Something went wrong, please try again!", "Retry", "0");
                    Toast.makeText(context, "Something went wrong, please try again!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<LoginResponse>> call, Throwable t) {
                progressDialog.dismiss();
               // showAlert(context, "Something went wrong, please check your internet connection!", "Retry", "0");
                Toast.makeText(context, "Something went wrong, please check your internet connection!", Toast.LENGTH_LONG).show();
            }
        });



    }
}
