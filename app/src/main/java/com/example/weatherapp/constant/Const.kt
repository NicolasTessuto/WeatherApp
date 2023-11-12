package com.example.weatherapp.constant

class Const {
    companion object{
        val permissions = arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
        const val openWeatherMapApiKey = "fa44067ef51a83cee04d093b8331f705";
        const val colorBg1 = 0xff08203e;
        const val colorBg2 = 0xff557c93;
        const val cardColor = 0xff333639;

        const val LOADING = "Carregando..."
        const val NA = "N/A"
    }
}