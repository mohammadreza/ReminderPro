package ir.farshid_roohi.reminderpro.views.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import ir.farshid_roohi.reminderpro.R

/**
 * Created by Farshid Roohi.
 * ReminderPro | Copyrights 2018.
 */
class SoundRecorderActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SoundRecorderActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound_recorder)
    }
}