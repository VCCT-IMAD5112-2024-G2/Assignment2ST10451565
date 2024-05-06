package com.example.digitalpetapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView

import android.widget.VideoView

class SecondPage : AppCompatActivity() {



    private var happyCounter = 50
    private var cleanCounter = 50
    private var hungerCounter = 50 // New hunger counter
    private lateinit var happyCounterTextView: TextView
    private lateinit var cleanCounterTextView: TextView
    private lateinit var hungerCounterTextView: TextView // TextView for hunger counter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        val feedBtn = findViewById<Button>(R.id.feedbtn)
        val cleanBtn = findViewById<Button>(R.id.cleanBtn)
        val playBtn = findViewById<Button>(R.id.playBtn)
        val videoView2 = findViewById<VideoView>(R.id.videoView2)
        val videoView3 = findViewById<VideoView>(R.id.videoView3)
        val videoView4 = findViewById<VideoView>(R.id.videoView4)

        happyCounterTextView = findViewById(R.id.happyCounterTextView)
        cleanCounterTextView = findViewById(R.id.cleanCounterTextView)
        hungerCounterTextView = findViewById(R.id.hungerCounterTextView) // Initialize hunger counter TextView
        updateHappyCounterText()
        updateCleanCounterText()
        updateHungerCounterText() // Update hunger counter TextView

        val videoPath = "android.resource://" + packageName + "/" + R.raw.dance
        videoView2.setVideoPath(videoPath)

        val videoPath2 = "android.resource://" + packageName + "/" + R.raw.washing
        videoView3.setVideoPath(videoPath2)

        val videoPath3 = "android.resource://" + packageName + "/" + R.raw.food
        videoView4.setVideoPath(videoPath3)

        playBtn.setOnClickListener {
            incrementHappyCounter()
            videoView2.visibility = View.VISIBLE
            videoView2.start()
            Handler().postDelayed({
                videoView2.visibility = View.GONE
            }, 5000)
        }

        cleanBtn.setOnClickListener {
            cleanCounter += 5
            if (cleanCounter > 50) {
                cleanCounter = 50
            }
            updateCleanCounterText()
            videoView3.visibility = View.VISIBLE
            videoView3.start()
            Handler().postDelayed({
                videoView3.visibility = View.GONE
            }, 5000)
        }

        feedBtn.setOnClickListener {
            hungerCounter += 5 // Add 5 to the hunger counter when fed
            if (hungerCounter > 50) {
                hungerCounter = 50
            }
            updateHungerCounterText() // Update hunger counter TextView
            videoView4.visibility = View.VISIBLE
            videoView4.start()
            Handler().postDelayed({
                videoView4.visibility = View.GONE
            }, 5000)
        }

        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                decrementHappyCounter()
                decrementCleanCounter()
                decrementHungerCounter() // Decrement hunger counter
                handler.postDelayed(this, 30000)
            }
        }
        handler.postDelayed(runnable, 30000)
    }

    private fun decrementHappyCounter() {
        if (happyCounter > 0) {
            happyCounter -= 5
            updateHappyCounterText()
        }
    }

    private fun incrementHappyCounter() {
        if (happyCounter < 50) {
            happyCounter += 5
            updateHappyCounterText()
        }
    }

    private fun decrementCleanCounter() {
        if (cleanCounter > 0) {
            cleanCounter -= 5
            updateCleanCounterText()
        }
    }

    private fun decrementHungerCounter() {
        if (hungerCounter > 0) {
            hungerCounter -= 5
            updateHungerCounterText()
        }
    }

    private fun updateHappyCounterText() {
        happyCounterTextView.text = "Happy: $happyCounter / 50"
    }

    private fun updateCleanCounterText() {
        cleanCounterTextView.text = "Clean: $cleanCounter / 50"
    }

    private fun updateHungerCounterText() {
        hungerCounterTextView.text = "Hunger: $hungerCounter / 50" // Update hunger counter TextView
    }
}


