package com.saika.quickflick.utils

import android.content.Context
import android.content.Intent
import com.saika.quickflick.R
import java.text.SimpleDateFormat
import java.util.Locale


fun formatDate(dateString: String): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
        val date = inputFormat.parse(dateString)
        outputFormat.format(date!!)
    } catch (e: Exception) {
        "Unknown Date"
    }
}

fun shareImage(
    context: Context,
    imageUrl: String,
    title: String,
    author: String,
    publishedDate: String
) {
    val shareText =
        context.getString(
            R.string.check_out_this_image_title_author_published,
            title,
            author,
            publishedDate,
            imageUrl
        )

    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, shareText)
    }

    context.startActivity(Intent.createChooser(intent, "Share via"))
}
