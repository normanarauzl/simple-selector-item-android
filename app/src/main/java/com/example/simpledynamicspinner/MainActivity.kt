package com.example.simpledynamicspinner

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import org.w3c.dom.Text

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
        setContentView(R.layout.activity_main)

        spinner = findViewById( R.id.spinner)
        arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.select_dialog_item, listItem)
        spinner?.adapter = arrayAdapter
        spinner?.onItemSelectedListener = this
        textResult = findViewById(R.id.resultText)

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading..")
        progressDialog.setCancelable(false)
        progressDialog.show()

        Handler().postDelayed({progressDialog.dismiss()}, 5000)

        val dialogLauncher = findViewById<Button>(R.id.dialogLauncher)
        // dialogLauncher.setOnClickListener()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(applicationContext, "Nothing selected", Toast.LENGTH_LONG).show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item: String = parent?.getItemAtPosition(position) as String

        textResult?.text = item
    }
}
