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

    override fun onResume() {
        super.onResume()
        screen1Presenter.attachView(object : ScreenView{
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
        })
    }

    override fun onPause() {
        super.onPause()
        screen1Presenter.detach()
    }
}