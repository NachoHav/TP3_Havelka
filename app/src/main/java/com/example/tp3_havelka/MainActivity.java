package com.example.tp3_havelka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel vm;
    private Button btCalcular;
    private EditText etDolares, etEuros, etResultado;
    private RadioButton rbDolaresAEuros, rbEurosADolares;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        inicializarVista();

        vm.getResultadoMutable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                etResultado.setText(s);
            }
        });
    }

    private void inicializarVista(){
        etDolares = findViewById(R.id.etDolares);
        etEuros = findViewById(R.id.etEuros);
        etResultado = findViewById(R.id.etResultado);
        rbDolaresAEuros = findViewById(R.id.rbDolares);
        rbEurosADolares = findViewById(R.id.rbEuros);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        btCalcular = findViewById(R.id.btConvertir);

        rbEurosADolares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDolares.setEnabled(false);
                etEuros.setEnabled(true);
            }
        });

        rbDolaresAEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDolares.setEnabled(true);
                etEuros.setEnabled(false);
            }
        });

        btCalcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v) {

                if(rbDolaresAEuros.isChecked())

                    vm.DolaresAEuros(etDolares.getText().toString());


                if(rbEurosADolares.isChecked())

                    vm.EurosADolares(etEuros.getText().toString());
            }
        });

    }
}