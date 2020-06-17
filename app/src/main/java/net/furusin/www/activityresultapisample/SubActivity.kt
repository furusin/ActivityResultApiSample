package net.furusin.www.activityresultapisample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.furusin.www.activityresultapisample.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
    }
}
