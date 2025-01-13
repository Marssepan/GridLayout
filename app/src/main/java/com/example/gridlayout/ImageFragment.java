package com.example.gridlayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

// Klasa reprezentująca fragment wyświetlający obraz i opis
public class ImageFragment extends Fragment {

    private static final String ARG_IMAGE_RES = "image_res"; // Klucz dla zasobu obrazu
    private static final String ARG_IMAGE_TEXT = "image_text"; // Klucz dla tekstu opisu

    // Statyczna metoda tworzenia nowej instancji fragmentu
    public static ImageFragment newInstance(int imageRes, String imageText) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_RES, imageRes); // Dodanie zasobu obrazu do argumentów
        args.putString(ARG_IMAGE_TEXT, imageText); // Dodanie opisu do argumentów
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflacja widoku fragmentu
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        // Pobranie zasobu obrazu i tekstu opisu z argumentów
        int imageRes = getArguments().getInt(ARG_IMAGE_RES);
        String imageText = getArguments().getString(ARG_IMAGE_TEXT);

        // Inicjalizacja widoków obrazu i tekstu
        ImageView fullImageView = view.findViewById(R.id.fullImageView);
        TextView imageTextView = view.findViewById(R.id.imageTextView);

        fullImageView.setImageResource(imageRes); // Ustawienie obrazu
        imageTextView.setText(imageText); // Ustawienie opisu

        return view; // Zwrócenie widoku fragmentu
    }
}