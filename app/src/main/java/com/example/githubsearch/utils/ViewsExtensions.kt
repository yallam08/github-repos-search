package com.example.githubsearch.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.onStart

fun AppCompatImageView.loadImageFromUrl(url: String) {
    Glide.with(this).load(url).centerCrop().into(this)
}

@ExperimentalCoroutinesApi
fun EditText.textChanges(): Flow<CharSequence?> {
    return callbackFlow {
        val listener = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = Unit
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) =
                Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                trySend(s)
            }
        }
        addTextChangedListener(listener)
        awaitClose { removeTextChangedListener(listener) }
    }.onStart { emit(text) }
}