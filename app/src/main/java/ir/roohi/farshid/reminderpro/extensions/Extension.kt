package ir.roohi.farshid.reminderpro.extensions

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.text.format.DateUtils
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import ir.roohi.farshid.reminderpro.R
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Farshid Roohi.
 * ReminderPro | Copyrights 1/4/19.
 */

fun Date.toAgoTime(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    sdf.timeZone = TimeZone.getTimeZone("GMT")
    val currentTime = System.currentTimeMillis()
    DateUtils.getRelativeTimeSpanString(this.time, currentTime, DateUtils.SECOND_IN_MILLIS)
    if ((currentTime - this.time) < 60000) {
        return "just now"
    }
    return DateUtils.getRelativeTimeSpanString(this.time, currentTime, DateUtils.SECOND_IN_MILLIS).toString()
}


fun ConstraintLayout.animatedColorBackgroundSelected(isSelected: Boolean = true) {
    val colorFrom: Int
    val colorTo: Int

    if (!isSelected) {
        colorFrom = ContextCompat.getColor(
            context, R.color.color_background_select_item_recycler_view
        )
        colorTo = ContextCompat.getColor(context, R.color.color1)
    } else {
        colorFrom = ContextCompat.getColor(context, R.color.color1)
        colorTo = ContextCompat.getColor(context, R.color.color_background_select_item_recycler_view)
    }

    val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
    colorAnimation.duration = 250 // milliseconds
    colorAnimation.addUpdateListener { animator -> this.setBackgroundColor(animator.animatedValue as Int) }
    colorAnimation.start()
}