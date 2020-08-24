package ru.studio.kotlinfishbook

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.android.synthetic.main.item_layout.tvContent
import kotlinx.android.synthetic.main.item_layout.tvTitle

// активити для запуска content_layout
class contentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)
        tvTitle.text = intent.getStringExtra("title")
        tvContent.text = intent.getStringExtra("content")
        imgV.setImageResource(intent.getIntExtra("image", R.drawable.som))
    }
}