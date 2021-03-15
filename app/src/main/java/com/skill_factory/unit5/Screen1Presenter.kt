package com.skill_factory.unit5

import androidx.annotation.DrawableRes
import javax.inject.Inject


interface BasePresenter {
    fun attachView(view: ScreenView)
    fun detach()
}

interface ScreenView {
    fun setIcon(@DrawableRes idIcon: Int)
    fun setPosts(text: String)
    fun setFollowers(text: String)
    fun setFollowing(text: String)
}


class Screen1Presenter @Inject constructor(private val m: AccountInfo) : BasePresenter {
    var view: ScreenView? = null

    override fun attachView(view: ScreenView) {
        this.view = view
        view.setIcon(m.iconId)
        view.setPosts("${m.posts}")
        view.setFollowing("${m.followers}")
        view.setFollowing("${m.following}")
    }

    override fun detach() {
        view = null
    }
}