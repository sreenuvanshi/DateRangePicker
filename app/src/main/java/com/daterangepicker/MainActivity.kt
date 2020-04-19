package com.daterangepicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.date.dateranagepicker.CalendarPickerView
import com.date.dateranagepicker.CalendarPickerView.SelectionMode.RANGE
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calendar: CalendarPickerView = findViewById(R.id.calendar_view)
        val nextYear = Calendar.getInstance()
        nextYear.add(Calendar.YEAR, 1)
        val today = Date()
        calendar.init(today, nextYear.time)
                .withSelectedDate(today)
        calendar.init(today, nextYear.time)
                .inMode(RANGE)
    }
}
