package com.example.nawkhabar.Adapter

object colorPicker {
    val colors = arrayOf("#1abc9c", "#2ecc71", "#3498db", "#9b59b6", "#34495e",
        "#f1c40f", "#e67e22", "#e74c3c", "#95a5a6", "#16a085",
        "#27ae60", "#2980b9", "#8e44ad", "#2c3e50", "#f39c12",
        "#d35400", "#c0392b", "#7f8c8d", "#2f2f2f", "#f7dc6f")

    var colorIndex = 1
    fun getColor() :String {
        return colors[colorIndex++ % colors.size]
    }




}