package net.furusin.www.activityresultapisample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import net.furusin.www.activityresultapisample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.navigationButton.setOnClickListener {
            val startForResult =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
                    when (result?.resultCode) {
                        Activity.RESULT_OK -> {}// do something
                        else -> {}// do something
                    }
                }
            startForResult.launch(SubActivity.createIntent(this))
        }

    }
}
