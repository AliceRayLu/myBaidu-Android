package com.example.mybaidu.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mybaidu.R
import com.example.mybaidu.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var imageView:ImageView = root.findViewById(R.id.user_avatar)
        val option:RequestOptions = RequestOptions().circleCrop()
        Glide.with(imageView.context).load("https://images.unsplash.com/photo-1602459599126-6cb8d0d80193?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1740&q=80").
        apply(option).placeholder(R.drawable.baseline_replay_circle_filled_24).into(imageView)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}