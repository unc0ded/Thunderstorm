package com.tec9ers.thunderstorm.utils

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class RecyclerTouchListener(
    context: Context,
    recyclerView: RecyclerView,
    clickListener: ClickListener
) : RecyclerView.OnItemTouchListener {

    private val clickListener: ClickListener
    private val gestureDetector: GestureDetector

    init {
        recyclerView.addOnItemTouchListener(this)
        this.clickListener = clickListener
        gestureDetector = GestureDetector(
            context,
            object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(motionEvent: MotionEvent): Boolean {
                    return true
                }

                override fun onLongPress(motionEvent: MotionEvent) {
                    val child = recyclerView.findChildViewUnder(motionEvent.x, motionEvent.y)
                    if (child != null) {
                        clickListener.onLongPress(child, recyclerView.getChildAdapterPosition(child))
                    }
                }
            }
        )
    }

    override fun onInterceptTouchEvent(
        recyclerView: RecyclerView,
        motionEvent: MotionEvent
    ): Boolean {
        val child = recyclerView.findChildViewUnder(motionEvent.x, motionEvent.y)
        if (child != null && gestureDetector.onTouchEvent(motionEvent)) {
            clickListener.onClick(child, recyclerView.getChildAdapterPosition(child))
        }
        return false
    }

    override fun onTouchEvent(recyclerView: RecyclerView, motionEvent: MotionEvent) {}

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
}
