package com.saika.quickflick.data.model

data class FlickerResponse(
    val items: List<FlickerImage>
)

data class FlickerImage(
    val title: String,
    //val link: String,
    val media: FlickerMedia,
    //val date_taken: String,
    val description: String,
    val published: String,
    val author: String,
    //val author_id: String,
    //val tags: String

)

data class FlickerMedia(
    val m: String
)
