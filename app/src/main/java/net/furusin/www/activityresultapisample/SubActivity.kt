package net.furusin.www.activityresultapisample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import net.furusin.www.activityresultapisample.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub)
    }

    companion object {
        const val KEY_VALUE = "KEY_VALUE"

        fun createIntent(context: Context) = Intent(context, SubActivity::class.java)
    }
}
