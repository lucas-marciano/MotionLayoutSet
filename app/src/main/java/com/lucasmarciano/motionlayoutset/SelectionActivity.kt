package com.lucasmarciano.motionlayoutset

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_selection.*

class SelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        btScene1.setOnClickListener{
            val intent = Intent(this, SceneOneActivity::class.java)
            startActivity(intent)
        }

        btScene2.setOnClickListener{
            val intent = Intent(this, SceneTwoActivity::class.java)
            startActivity(intent)
        }

        btScene3.setOnClickListener{
            val intent = Intent(this, SceneThreeActivity::class.java)
            startActivity(intent)
        }
    }
}
