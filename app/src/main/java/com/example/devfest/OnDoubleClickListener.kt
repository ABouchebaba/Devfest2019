package com.example.devfest

import android.view.View
import android.os.Handler


class OnDoubleClickListener : View.OnClickListener {

    private var doubleClick = false
    private lateinit var handler : Handler

    override fun onClick(p0: View?) {
        if (doubleClick){
            // do job
        }
        else {
            doubleClick = true
            handler = Handler()
            handler.postDelayed({doubleClick = false}, 500)
        }
    }

}