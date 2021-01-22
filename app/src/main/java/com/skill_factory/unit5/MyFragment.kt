package com.skill_factory.unit5

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import javax.inject.Inject

class MyFragment() : Fragment() {
    @Inject
    lateinit var screen1Presenter: Screen1Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ava = view.findViewById<ImageView>(R.id.icon)
        val textPosts = view.findViewById<TextView>(R.id.text_posts)
        val textFollowers = view.findViewById<TextView>(R.id.text_followers)
        val textFollowing = view.findViewById<TextView>(R.id.text_following)
        ava.setImageResource(screen1Presenter.m.iconId)
        textPosts.text = "${screen1Presenter.m.posts}"
        textFollowers.text = "${screen1Presenter.m.followers}"
        textFollowing.text = "${screen1Presenter.m.following}"
    }
}