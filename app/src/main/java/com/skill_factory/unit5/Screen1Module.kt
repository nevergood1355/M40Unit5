package com.skill_factory.unit5

import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlin.random.Random

@Module
interface Screen1Module {

    @ScreenScope
    @Binds
    fun bindScreen1Presenter(p: Screen1Presenter) : BasePresenter

    @Module companion object{
        @ScreenScope
        @Provides
        fun screen1Presenter(accountsInfo: Array<AccountInfo>) : AccountInfo {
            return accountsInfo.random()
        }
    }
}