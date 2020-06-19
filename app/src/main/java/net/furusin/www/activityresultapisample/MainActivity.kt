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
                    if (result?.resultCode == Activity.RESULT_OK) {
                        result.data?.let { data: Intent ->
                            val value = data.getIntExtra(SubActivity.KEY_VALUE, 0)
                            Toast.makeText(
                                this,
                                "result value = ${data.getIntExtra(SubActivity.KEY_VALUE, 0)}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            startForResult.launch(SubActivity.createIntent(this))
        }

    }
}
