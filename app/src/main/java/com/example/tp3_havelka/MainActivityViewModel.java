package com.example.tp3_havelka;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<String> resultadoMutable;

    public MutableLiveData<String> getResultadoMutable() {
        if(resultadoMutable == null){
            resultadoMutable = new MutableLiveData<>();
        }
        return resultadoMutable;
    }

    public void DolaresAEuros(String n1){


        try {

            double dolares = Double.parseDouble(n1);

            double res = (dolares * 0.85);

            resultadoMutable.setValue(res+"");
        }catch (Exception ex){
            resultadoMutable.setValue("Ingrese dolares");
        }

    }

    public void EurosADolares(String n1){

        try {
            double euros = Double.parseDouble(n1);

            double res = (euros * 1.18);

            resultadoMutable.setValue(res+"");
        }catch (Exception ex){
            resultadoMutable.setValue("Ingrese Euros");
        }

    }
}
