package com.example.mybaidu.ui.home


import com.example.mybaidu.databinding.FragmentHomeBinding
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mybaidu.AddNewsActivity
import com.example.mybaidu.R
import com.example.mybaidu.SearchActivity
import com.example.mybaidu.WeatherActivity
import com.example.mybaidu.data.MyNewsAdapter
import com.example.mybaidu.data.News

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var context: Context
    private lateinit var newsData:ArrayList<News>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        recyclerView = root.findViewById(R.id.recyclerview)
        context = root.context
        initData()
        val adapter = MyNewsAdapter(newsData,context,this.requireActivity())
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val weatherView:TextView = root.findViewById(R.id.weather)
        weatherView.setOnClickListener {
            val intent = Intent(this.activity,WeatherActivity::class.java)
            startActivity(intent)
        }

        val addBtn: ImageButton = root.findViewById(R.id.add_news_btn)
        addBtn.setOnClickListener {
            val intent = Intent(this.activity, AddNewsActivity::class.java)
            startActivity(intent)
        }

        val searchBtn:Button = root.findViewById(R.id.search_btn_main)
        searchBtn.setOnClickListener {
            val intent = Intent(this.activity,SearchActivity::class.java)
            startActivity(intent)
        }
        return root
    }

    fun initData(){
        newsData = ArrayList<News>()
        newsData.add(News("Morning News !!!!!! !!!!!!! !!!!!!!!!!!","xinhua",""))
        newsData.add(News("Good morning America: welcome Taylor Swift","BBC","https://images.unsplash.com/photo-1548778052-311f4bc2b502?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1740&q=80"))
        newsData.add(News("Biden fell down","White House","https://images.unsplash.com/photo-1593047614267-378b863c98c5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1734&q=80"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}