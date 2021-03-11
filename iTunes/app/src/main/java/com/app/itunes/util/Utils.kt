package com.app.itunes.util

import android.content.Context
import android.widget.Toast

fun Context.showToastMsg(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}