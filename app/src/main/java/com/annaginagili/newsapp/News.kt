package com.annaginagili.newsapp

data class News(val title: String, val link: String, val keyWords: List<String>, val creator: List<String>,
val video_url: String, val description: String, val content: String, val pubDate: String, val ull_description: String,
val image_url: String, val source_id: String, val country: List<String>, val category: List<String>, val language: String) {

}