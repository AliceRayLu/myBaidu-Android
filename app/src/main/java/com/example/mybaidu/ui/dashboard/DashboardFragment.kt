package com.example.mybaidu.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mybaidu.R
import com.example.mybaidu.data.MyVideoAdapter
import com.example.mybaidu.data.VideoInfo
import com.example.mybaidu.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var videoData:ArrayList<VideoInfo> = ArrayList<VideoInfo>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var recyclerView:RecyclerView = root.findViewById(R.id.video_recyclerview)
        initData()
        val adapter = MyVideoAdapter(videoData,root.context,this.requireActivity())
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(root.context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        return root
    }

    fun initData(){
        videoData.add(VideoInfo("Go into Zootopia with me!",1234,
            "https://images.unsplash.com/photo-1624118231722-6806cc408c2c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1740&q=80",
            "Judy is a rabbit","https://images.unsplash.com/photo-1641302109117-46d2af1271f3?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=888&q=80",
            132,15))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}