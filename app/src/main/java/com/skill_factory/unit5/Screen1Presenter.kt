package com.skill_factory.unit5

import javax.inject.Inject


@ScreenScope
interface BasePresenter {
    fun attachView(f: MyFragment)
    fun detach()
}

@ScreenScope
class Screen1Presenter @Inject constructor(private val m: AccountInfo) : BasePresenter {
    private var f: MyFragment? = null

    override fun attachView(f: MyFragment) {
        this.f = f
        val view = Screen1View(f)
        view.setIcon(m.iconId)
        view.setPosts("${m.posts}")
        view.setFollowing("${m.followers}")
        view.setFollowing("${m.following}")
    }

    override fun detach() {
        this.f = null
    }
}