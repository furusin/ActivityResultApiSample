package net.furusin.www.activityresultapisample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import net.furusin.www.activityresultapisample.databinding.ActivityMainBinding

private const val REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.navigationButton.setOnClickListener {
            startActivityForResult(SubActivity.createIntent(this), REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE -> {
                    Toast.makeText(
                        this,
                        "result value = ${data?.getIntExtra(SubActivity.KEY_VALUE, 0)}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> Unit // do nothing
            }
        }
    }
}
