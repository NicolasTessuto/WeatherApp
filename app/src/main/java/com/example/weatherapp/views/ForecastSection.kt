package com.example.weatherapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.constant.Const
import com.example.weatherapp.model.forecast.ForecastResult
import com.example.weatherapp.utils.Utils.Companion.buildIcon
import com.example.weatherapp.utils.Utils.Companion.timeStampToHumanDate

@Composable
fun ForecastSection(forecastResponse: ForecastResult) {
    return Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        forecastResponse.list?.let { listForecast ->
            if (listForecast!!.size > 0) {
                LazyRow(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(listForecast!!) { currentItem ->
                        currentItem.let { item ->
                            var temp = ""
                            var icon = ""
                            var time = ""

                            item.main.let { main ->
                                temp = if (main == null) Const.NA else "${main.temp} ºC"
                            }

                            item.weather.let { weather ->
                                icon = if (weather == null) Const.NA else weather[0].icon?.let {
                                    buildIcon(
                                        it, false
                                    )
                                }.toString()
                            }

                            item.dt.let { dateTime ->
                                time = if (dateTime == null) Const.NA else timeStampToHumanDate(
                                    dateTime.toLong(), "EEE HH:mm"
                                )
                            }

                            ForecastTitle(temp = temp, image = icon, time = time)
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun ForecastTitle(temp: String, image: String, time: String) {
    Card(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(Const.cardColor).copy(alpha = 0.7f),
            contentColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(60.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = temp.ifEmpty { Const.NA }, color = Color.White, fontSize = 20.sp)
            AsyncImage(
                model = image,
                contentDescription = image,
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .align(Alignment.CenterHorizontally),
            )
            Text(
                text = time.ifEmpty { Const.NA },
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}
