package ElOskar101.kingkuna.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ElOskar101.kingkuna.Api.Connection;
import ElOskar101.kingkuna.Models.User;
import ElOskar101.kingkuna.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText password;
    EditText username;
    Button singIn;
    User user;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InitViews();
        InitActions();
    }

    private void InitViews() {
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
        singIn = findViewById(R.id.sign_in);
        user = new User();

    }

    private boolean ValidateFields() {

        boolean isOK = true;

        if (password.getText().toString().isEmpty() ||
            username.getText().toString().isEmpty()){
            isOK = false;
        }else {
            user.setUsername(username.getText().toString());
            user.setPdw(password.getText().toString());
        }

        return isOK;
    }

    private void InitActions() {
        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ValidateFields())
                    getToken();
                else
                    Toast.makeText(getApplicationContext(), "Debe rellenar todos los campos", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getToken() {
        Call<User> call = Connection.instance().getToken(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body()!= null){
                    token = response.body().getToken();
                    SaveToken();
                }else {
                    System.out.println("MESSAGE: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Unable to connect", Toast.LENGTH_LONG).show();
                System.out.println("ERROR: "+t.getMessage());
            }
        });
    }

    private void SaveToken(){
        SharedPreferences sharedpreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("token", token);
        editor.apply();
    }
}
