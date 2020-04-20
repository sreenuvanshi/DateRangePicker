package com.daterangepicker

import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.date.dateranagepicker.CalendarPickerView
import com.date.dateranagepicker.CalendarPickerView.MonthCellWithMonthIndex
import com.date.dateranagepicker.CalendarPickerView.SelectionMode.RANGE
import java.text.SimpleDateFormat
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
        val face = Typeface.createFromAsset(
            assets,
            "titilliumweb_semibold.ttf"
        )
        calendar.setTitleTypeface(face)
        calendar.setTypeface(face)


        val spf =
            SimpleDateFormat("MMM dd, hh:mm:ss aaa yyyy")
        val fromDate: Date = spf.parse("Apr 20, 6:30:00 PM 2020")
        var toDate: Date = spf.parse("Apr 20, 6:30:00 PM 2020")


        calendar.setOnDateSelectedListener(object : CalendarPickerView.OnDateSelectedListener {
            override fun onDateSelected(date: Date?) {
                var c = Calendar.getInstance()
                c.time = date
                c.add(Calendar.DATE, 6)
                val newDate = c.time
                calendar.selectDate(newDate, true)
            }

            override fun onDateUnselected(date: Date?) {
            }

        })
        val monthCellWithMonthIndex = calendar.getMonthCellWithIndexByDate(fromDate)
        calendar.handleClick(monthCellWithMonthIndex?.cell)

    }
}
