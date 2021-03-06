package com.skill_factory.unit5

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import dagger.Component
import dagger.Module
import javax.inject.Inject

class MyFragment() : Fragment(), ScreenView {
    @Inject
    lateinit var screen1Presenter: Screen1Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.screen, container, false)
    }

    override fun onResume() {
        super.onResume()
        screen1Presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        screen1Presenter.detach()
    }

    override fun setIcon(idIcon: Int) {
        requireView().findViewById<ImageView>(R.id.icon).setImageResource(idIcon)
    }

    override fun setPosts(text: String) {
        requireView().findViewById<TextView>(R.id.text_posts).text = text
    }

    override fun setFollowers(text: String) {
        requireView().findViewById<TextView>(R.id.text_followers).text = text
    }

    override fun setFollowing(text: String) {
        requireView().findViewById<TextView>(R.id.text_following).text = text
    }
}
