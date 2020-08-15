package com.example.simpledynamicspinner

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.mbass.examples.app.analytics.DistributeListener
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.microsoft.appcenter.distribute.Distribute


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    private var spinner: Spinner? = null
    private var arrayAdapter: ArrayAdapter<String> ? = null
    private var textResult: TextView? = null
    private var listItem = arrayOf(
        "item 1",
        "item 2",
        "item 3",
        "item 4",
        "item 5",
        "item 6",
        "item 7",
        "item 8",
        "item 9",
        "item 10",
        "item 11",
        "item 12")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Distribute.checkForUpdate()
        // Distribute.setListener(DistributeListener())
        AppCenter.start(
            application, "3edb7e7c-cca8-40a9-bbc5-46d073ba4755",
            Analytics::class.java, Crashes::class.java, Distribute::class.java
        )


        setContentView(R.layout.activity_main)

        spinner = findViewById( R.id.spinner)
        arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.select_dialog_item, listItem)
        spinner?.adapter = arrayAdapter
        spinner?.onItemSelectedListener = this
        textResult = findViewById(R.id.resultText)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(applicationContext, "Nothing selected", Toast.LENGTH_LONG).show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item: String = parent?.getItemAtPosition(position) as String

        textResult?.text = item
    }
}
