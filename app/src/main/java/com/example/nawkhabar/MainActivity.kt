package com.example.nawkhabar

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.nawkhabar.Adapter.NewsAdapter
import com.example.nawkhabar.Adapter.colorPicker
import com.example.nawkhabar.api.RetrofitInstance
import com.example.nawkhabar.databinding.ActivityMainBinding
import com.example.nawkhabar.news.Article
import com.example.nawkhabar.news.NewsClass
import com.littlemango.stacklayoutmanager.StackLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: NewsAdapter
    private lateinit var binding: ActivityMainBinding
    private var articles = mutableListOf<Article>()
    var pageNum = 1
    var totalResult = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = NewsAdapter(this@MainActivity, articles)
        binding.rcMain.adapter = adapter


        val layout = StackLayoutManager(StackLayoutManager.ScrollOrientation.BOTTOM_TO_TOP)
        layout.setPagerMode(true)
        layout.getPagerFlingVelocity()

        layout.setItemChangedListener(object : StackLayoutManager.ItemChangedListener {
            override fun onItemChanged(position: Int) {
                binding.container.setBackgroundColor(Color.parseColor(colorPicker.getColor()))

                if (totalResult > layout.itemCount && layout.getFirstVisibleItemPosition() >= layout.itemCount - 5) {
                    pageNum++
                    getNews()
                }
            }

        })


        binding.rcMain.layoutManager = layout

        getNews()

    }

    private fun getNews() {
        val news = RetrofitInstance.apiInterface.getData("in",pageNum)
        news.enqueue(object : Callback<NewsClass> {
            override fun onResponse(call: Call<NewsClass>, response: Response<NewsClass>) {
                val news = response.body()
                articles.addAll(news!!.articles)
                binding.progressBar.isVisible = false
                adapter.notifyDataSetChanged()

                totalResult = response.body()!!.totalResults


            }

            override fun onFailure(call: Call<NewsClass>, t: Throwable) {
               Toast.makeText(this@MainActivity,"Error Occurred $t",Toast.LENGTH_SHORT).show()
            }
        })
    }
}