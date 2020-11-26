package com.example.recyclerviewbeta;

import java.util.ArrayList;
import java.util.List;

public class ElementosRepositorio {

    List<Elemento> elementos = new ArrayList<>();


    ElementosRepositorio(){
        elementos.add(new Elemento("Bulbasaur", "Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo. "));
        elementos.add(new Elemento("Charmander", "Prefiere las cosas calientes. Dicen que cuando llueve le sale vapor de la punta de la cola. "));
        elementos.add(new Elemento("Squirtle", "Cuando retrae su largo cuello en el caparazón, dispara agua a una presión increíble. "));
        elementos.add(new Elemento("Pikachu", "Cuanto más potente es la energía eléctrica que genera este Pokémon, más suaves y elásticas se vuelven las bolsas de sus mejillas. "));
        elementos.add(new Elemento("Snorlax","No se encuentra satisfecho hasta haber ingerido 400 kg de comida cada día. Cuando acaba de comer, se queda dormido. "));
        elementos.add(new Elemento("Mewtwo","Su ADN es casi el mismo que el de Mew. Sin embargo, su tamaño y carácter son muy diferentes."));
    }

    List<Elemento> obtener() {
        return elementos;
    }

}
