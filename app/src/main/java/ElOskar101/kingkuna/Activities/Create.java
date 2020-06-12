package ElOskar101.kingkuna.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import ElOskar101.kingkuna.Api.Connection;
import ElOskar101.kingkuna.MainActivity;
import ElOskar101.kingkuna.Models.Client;
import ElOskar101.kingkuna.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Create extends AppCompatActivity {

    SeekBar seekBar;
    Button create;
    TextView days;
    TextView daysText;
    Client client;
    EditText createName;
    EditText createPhone;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        InitViews();
        InitActions();
    }

    private void InitViews (){
        seekBar = findViewById(R.id.seek_bar);
        create = findViewById(R.id.create_client);
        days = findViewById(R.id.demo_days);
        daysText = findViewById(R.id.text_days);
        createName = findViewById(R.id.create_name);
        createPhone = findViewById(R.id.create_phone);

        SharedPreferences sharedpreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        token = sharedpreferences.getString("token", "");

        client = new Client();
    }

    private void PostNewClient (){
        Call<Client> call = Connection.instance().postClient(client, token);
        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if(response.body() != null){
                    System.out.println(response.body().getClientID());
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    System.out.println("ÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑÑ "+response.message());
                }
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                System.out.println("Error de conexión: "+t.getMessage());
            }
        });
    }

    private void CreateObject (){
        client.setName(createName.getText().toString());
        client.setPhone(createPhone.getText().toString());
        client.setDemoDays(days.getText().toString());
        PostNewClient();

    }

    private boolean ValidateFields (){
        boolean isOK = false;

        if (createName.getText().toString().isEmpty() ||
            createPhone.getText().toString().isEmpty())
            Toast.makeText(getApplicationContext(), "Campos por completar", Toast.LENGTH_SHORT).show();
        else isOK = true;

        return isOK;
    }

    private void InitActions (){
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ValidateFields())
                    CreateObject();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(i == 1)
                    daysText.setText("Día de prueba");
                else
                    daysText.setText("Días de prueba");

                String iParsed = ""+i;
                days.setText(iParsed);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

    }
}
