package com.example.notifireapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("user");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ref.setValue("Halo Dunia!");
        //String nama = "", password = "";
        final EditText userName = (EditText) findViewById(R.id.inputUserName);
        final EditText fullName = (EditText) findViewById(R.id.inputNamaLengkap);
        final EditText password = (EditText) findViewById(R.id.inputPassword);
        final EditText device = (EditText) findViewById(R.id.inputDevice);
        Button register = (Button) findViewById(R.id.registerButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pindah dari edit text ke variabel lokal
                String namaUser = userName.getText().toString();
                String namaLengkap = fullName.getText().toString();
                String passswordUser = password.getText().toString();
                String namaDevice = device.getText().toString();

                //Tambah data user baru
                ref = ref.child(namaUser);
                ref.child("nama").setValue(namaLengkap);
                ref.child("password").setValue(passswordUser);
                ref.child("level").setValue(2);

                //tambah data device
                ref = ref.child("device");
                ref.child("device_1").setValue(namaDevice);
                ref.child("jumlah").setValue(1);
                Log.i("pesan","blalalala");
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("username",namaUser);
                startActivity(intent);

            }
        });

        /*
        ref = ref.child("abc");
        ref.child("nama").setValue("Abc");
        ref.child("password").setValue("123");
        */
    }
}
