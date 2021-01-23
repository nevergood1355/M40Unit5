package com.skill_factory.unit5

import android.accounts.Account
import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import javax.inject.Inject

@ScreenScope
interface ScreenView {
    fun setIcon(@DrawableRes idIcon: Int)
    fun setPosts(text: String)
    fun setFollowers(text: String)
    fun setFollowing(text: String)
}

@ScreenScope
class Screen1View @Inject constructor(val f: MyFragment): ScreenView {

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