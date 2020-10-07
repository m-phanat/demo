package com.m.phanat.demo.extension

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.widget.Toast
import com.m.phanat.demo.R
import com.muddzdev.styleabletoast.StyleableToast


inline fun Context.alert(func: AlertDialog.Builder.() -> AlertDialog.Builder) {
    AlertDialog.Builder(this).func().show()
}

fun Context.toastShort(text: CharSequence) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

fun Context.toastShort(resId: Int) = Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()

fun Context.toastLong(text: CharSequence) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()

fun Context.toastLong(resId: Int) = Toast.makeText(this, resId, Toast.LENGTH_LONG).show()

fun Context.toast(text: String) = run {
    StyleableToast.makeText(this, text, Toast.LENGTH_LONG, R.style.toast_default).show();
}