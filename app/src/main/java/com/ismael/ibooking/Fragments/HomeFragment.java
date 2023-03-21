package com.ismael.ibooking.Fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ismael.ibooking.R;

public class HomeFragment extends Fragment {

    private Button btnReserve;
    private TextView tvWelcomeMessage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnReserve = view.findViewById(R.id.btn_reserve);
        tvWelcomeMessage = view.findViewById(R.id.tv_welcome_message);

        // Obtener nombre de usuario del usuario actual y mostrar un mensaje de bienvenida personalizado
        String username = getCurrentUsername();
        tvWelcomeMessage.setText("¡Bienvenido, " + username + "!");

        // Navegar al fragmento de Reservación al hacer clic en el botón "Reservar"
        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReservationFragment reservationFragment = new ReservationFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, reservationFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }

    // Obtener el nombre de usuario del usuario actual (se supone que ya ha iniciado sesión)
    private String getCurrentUsername() {
        // Código para obtener el nombre de usuario actual
        return "Ismael Blanquez"; // Solo para fines de demostración
    }

}
