# Projekt Android: Wyświetlanie Obrazów w GridLayout

## Opis
Aplikacja Android wyświetlająca obrazy w siatce (GridLayout). Po kliknięciu w obraz, otwierany jest fragment z pełnym widokiem obrazu oraz jego opisem.

## Funkcjonalności
- Wyświetlanie siatki obrazów.
- Kliknięcie na obraz otwiera fragment z jego pełnym widokiem oraz opisem.
- Obsługa krawędzi ekranu (EdgeToEdge).

## Struktura kodu

### MainActivity
- Odpowiada za inicjalizację interfejsu użytkownika.
- Wyświetla obrazy w siatce (GridLayout).
- Obsługuje kliknięcia obrazów, otwierając nowy fragment.

### ImageFragment
- Wyświetla pełny widok wybranego obrazu oraz jego opis.

## Instalacja i Uruchamianie
1. Skopiuj kod do swojego projektu Android Studio.
2. Dodaj obrazy do folderu `res/drawable`.
3. Utwórz odpowiednie pliki układu:
   - `activity_main.xml` dla układu głównego.
   - `fragment_image.xml` dla układu fragmentu obrazu.
4. Uruchom aplikację na emulatorze lub urządzeniu fizycznym.

## Struktura XML

### activity_main.xml
```xml
<GridLayout
    android:id="@+id/gridLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:columnCount="2"
    android:padding="16dp">
</GridLayout>
```

### fragment_image.xml
```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <ImageView
        android:id="@+id/fullImageView"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:scaleType="centerCrop" />

    <TextView
        android:id="@+id/imageTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="16dp"
        android:textSize="16sp" />
</LinearLayout>
```

## Jak używać
1. Wybierz obraz z siatki, klikając na niego.
2. Zobacz pełny obraz i jego opis w nowym oknie.

## Wymagania
- Android 10.0 (API 29) lub nowszy.

## Uwagi
- Rozmiary obrazów w siatce są ustalone na 450x450 dp.
- Odstępy między obrazami wynoszą 16 dp.

## Autor
Tomasz Frankiewicz
