package com.example.nawkhabar.news

data class NewsClass(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)