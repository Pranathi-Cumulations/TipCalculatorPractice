package com.example.tipcalci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class SecondActivity : AppCompatActivity() {

    private lateinit var imageView : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        imageView = findViewById(R.id.imageView)
        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView);

    }
}