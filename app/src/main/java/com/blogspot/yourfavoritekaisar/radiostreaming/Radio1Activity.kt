package com.blogspot.yourfavoritekaisar.radiostreaming

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_radio1.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class Radio1Activity : AppCompatActivity() {

    lateinit var player: MediaPlayer
    var url : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio1)

        url = intent.getStringExtra("urlRadio1")

        progressBar.isIndeterminate = false
        progressBar.visibility = View.INVISIBLE
        progressBar.max = 100

        setPlaying()

        btnPlay.isEnabled = true
        btnStop.isEnabled = true

        btnPlay.onClick {
            progressBar.isIndeterminate = true
            progressBar.visibility = View.VISIBLE
            player.prepareAsync()
            player.setOnPreparedListener{
                player -> player.start()
                progressBar.isIndeterminate = false
            }

            btnPlay.isEnabled = false
            btnStop.isEnabled = true
        }
    }

    private fun setPlaying() {
        player = MediaPlayer()
        player.setDataSource(url)
        player.setOnBufferingUpdateListener { mediaPlayer, i ->
            progressBar.isIndeterminate = true
            progressBar.secondaryProgress = 100
        }
    }
}
