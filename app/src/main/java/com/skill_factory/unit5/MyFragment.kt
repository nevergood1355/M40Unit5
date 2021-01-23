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
        screen1Presenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        screen1Presenter.detach()
    }
}