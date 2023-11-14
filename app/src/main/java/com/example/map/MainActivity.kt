package com.example.map
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private fun displayTrack(sSource: String, sDestination: String) {
        try {
            val uri = Uri.parse("https://www.google.co.in/maps/dir/$sSource/$sDestination")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.`package` = "com.google.android.apps.maps"
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            val uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var et_source=findViewById<EditText>(R.id.et_source)
        var et_destination=findViewById<EditText>(R.id.et_destination)
        var bt_track=findViewById<Button>(R.id.bt_track)

        bt_track.setOnClickListener {
            var sSource: String = et_source.text.toString().trim()
            var sDestination: String = et_destination.text.toString().trim()

            if (sSource.isEmpty() && sDestination.isEmpty()) {
                Toast.makeText(applicationContext, "Enter Both Location", Toast.LENGTH_SHORT).show()
            } else {
                displayTrack(sSource, sDestination)
            }
        }

    }
}