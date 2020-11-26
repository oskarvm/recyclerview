package com.example.recyclerviewbeta;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ElementosViewModel extends AndroidViewModel {

    ElementosRepositorio elementosRepositorio;

    MutableLiveData<List<Elemento>> listElementosMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Elemento> elementoSeleccionado = new MutableLiveData<>();

    public ElementosViewModel(@NonNull Application application) {
        super(application);

        elementosRepositorio = new ElementosRepositorio();

        listElementosMutableLiveData.setValue(elementosRepositorio.obtener());
    }


    MutableLiveData<List<Elemento>> obtener(){
        return listElementosMutableLiveData;
    }



    void seleccionar(Elemento elemento){
        elementoSeleccionado.setValue(elemento);
    }

    MutableLiveData<Elemento> seleccionado(){
        return elementoSeleccionado;
    }
}
