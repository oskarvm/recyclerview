package com.example.recyclerviewbeta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewbeta.databinding.FragmentRecyclerElementosBinding;
import com.example.recyclerviewbeta.databinding.ViewholderElementoBinding;

import java.util.List;


public class RecyclerElementosFragment extends Fragment {

    private FragmentRecyclerElementosBinding binding;
    private ElementosViewModel elementosViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentRecyclerElementosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        elementosViewModel = new ViewModelProvider(requireActivity()).get(ElementosViewModel.class);
        navController = Navigation.findNavController(view);


        final ElementosAdapter elementosAdapter = new ElementosAdapter();

        binding.recyclerView.setAdapter(elementosAdapter);

        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));



        elementosViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Elemento>>() {
            @Override
            public void onChanged(List<Elemento> elementos) {
                elementosAdapter.establecerLista(elementos);
            }
        });
    }

    class ElementosAdapter extends RecyclerView.Adapter<ElementoViewHolder> {

        List<Elemento> elementos;

        @NonNull
        @Override
        public ElementoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ElementoViewHolder(ViewholderElementoBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ElementoViewHolder holder, int position) {

            final Elemento elemento = elementos.get(position);

            holder.binding.nombre.setText(elemento.nombre);
            holder.binding.valoracion.setRating(elemento.valoracion);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    elementosViewModel.seleccionar(elemento);
                    navController.navigate(R.id.action_recyclerElementosFragment_to_mostrarElementoFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return elementos != null ? elementos.size() : 0;
        }

        public void establecerLista(List<Elemento> elementos){
            this.elementos = elementos;
            notifyDataSetChanged();
        }

        public Elemento obtenerElemento(int posicion){
            return elementos.get(posicion);
        }
    }

    static class ElementoViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderElementoBinding binding;

        public ElementoViewHolder(ViewholderElementoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
