package com.example.githubsearch.utils

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadImageFromUrl(url: String) {
    Glide.with(this).load(url).centerCrop().into(this)
}