package com.blogspot.yourfavoritekaisar.radiostreaming

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRadio1.onClick {
            startActivity<Radio1Activity>("urlRadio1" to "http://stream.radioreklama.bg:80/radio1rock128")
        }
    }
}
