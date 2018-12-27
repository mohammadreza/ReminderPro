package ir.roohi.farshid.reminderpro.views.activities

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import ir.roohi.farshid.reminderpro.R
import ir.roohi.farshid.reminderpro.model.VoiceEntity
import ir.roohi.farshid.reminderpro.viewModel.VoiceViewModel
import ir.roohi.farshid.reminderpro.views.adapter.VoiceAdapter
import kotlinx.android.synthetic.main.activity_sound_list.*
import java.util.ArrayList

/**
 * Created by Farshid Roohi.
 * ReminderPro | Copyrights 12/23/18.
 */

class SoundListActivity : BaseActivity(), View.OnClickListener, Observer<List<VoiceEntity>>, VoiceAdapter.OnClickItemListener {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SoundListActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound_list)

        val viewModel = ViewModelProviders.of(this).get(VoiceViewModel::class.java)

        viewModel.mutableList!!.observe(this, this)

        fabAdd.setOnClickListener(this)
        toolbar.setIconLeftListener(View.OnClickListener {
            finish()
        })
    }

    override fun onChanged(list: List<VoiceEntity>?) {
        this.progressBar.visibility = View.GONE
        if (list == null || list.isEmpty()) {
            layoutEmptyState.visibility = View.VISIBLE
            return
        }
        list.let {
            recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
            val adapter = VoiceAdapter()
            recycler.adapter = adapter
            adapter.swapData(ArrayList(list))
            adapter.listener = this
            return
        }


    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.fabAdd -> RecordSoundActivity.start(this)
        }
    }

    override fun onClickItem(item: VoiceEntity) {
        showMsg("click item : ${item.title}")
    }

}