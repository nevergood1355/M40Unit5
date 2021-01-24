package com.skill_factory.unit5

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes

interface ScreenView {
    fun setIcon(@DrawableRes idIcon: Int)
    fun setPosts(text: String)
    fun setFollowers(text: String)
    fun setFollowing(text: String)
}

class Screen1View (val f: MyFragment): ScreenView {

    override fun setIcon(idIcon: Int) {
        f.requireView().findViewById<ImageView>(R.id.icon).setImageResource(idIcon)
    }

    private fun getTextViewById(@IdRes id: Int): TextView {
        return f.requireView().findViewById<TextView>(id)
    }

    override fun setPosts(text: String) {
        getTextViewById(R.id.text_posts).text= text
    }

    override fun setFollowers(text: String) {
        getTextViewById(R.id.text_followers).text= text
    }

    override fun setFollowing(text: String) {
        getTextViewById(R.id.text_following).text= text
    }

}