package com.example.gridlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    // GridLayout używany do wyświetlania obrazów
    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Umożliwia wsparcie dla krawędzi ekranu (EdgeToEdge)
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ustawienie wypełnienia (padding) widoku głównego zgodnie z paskami systemowymi
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicjalizacja GridLayout
        gridLayout = findViewById(R.id.gridLayout);

        // Tablica zasobów obrazów
        int[] zdjecia = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6};
        // Tablica opisów obrazów
        String[] imageTexts = {
                "Opis do zdjęcia 1",
                "Opis do zdjęcia 2",
                "Opis do zdjęcia 3",
                "Opis do zdjęcia 4",
                "Opis do zdjęcia 5",
                "Śnieżne cycki"
        };

        // Pętla dodająca obrazy do GridLayout
        for (int i = 0; i < zdjecia.length; i++) {
            final int index = i; // Indeks obrazu

            // Tworzenie ImageView dla obrazu
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(zdjecia[i]); // Ustawienie obrazu
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // Ustawienie skali obrazu

            // Konfiguracja parametrów układu dla ImageView
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 450; // Szerokość obrazu
            params.height = 450; // Wysokość obrazu
            params.setMargins(16, 16, 16, 16); // Odstępy pomiędzy obrazami

            imageView.setLayoutParams(params);

            // Ustawienie akcji po kliknięciu obrazu
            imageView.setOnClickListener(v -> {
                openImageFragment(zdjecia[index], imageTexts[index]); // Otwarcie fragmentu z obrazem i opisem
            });

            // Dodanie ImageView do GridLayout
            gridLayout.addView(imageView);
        }
    }

    // Metoda otwierająca fragment z wybranym obrazem i opisem
    private void openImageFragment(int imageRes, String imageText) {
        ImageFragment fragment = ImageFragment.newInstance(imageRes, imageText); // Tworzenie instancji fragmentu
        FragmentManager fragmentManager = getSupportFragmentManager(); // Menadżer fragmentów
        FragmentTransaction transaction = fragmentManager.beginTransaction(); // Rozpoczęcie transakcji fragmentów

        transaction.replace(android.R.id.content, fragment); // Zastąpienie obecnego widoku fragmentem
        transaction.addToBackStack(null); // Dodanie transakcji do stosu powrotów
        transaction.commit(); // Zatwierdzenie transakcji
    }
}