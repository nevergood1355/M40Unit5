package com.skill_factory.unit5

import javax.inject.Inject


@ScreenScope
interface BasePresenter

@ScreenScope
class Screen1Presenter @Inject constructor(val f: MyFragment, val m: AccountInfo)  : BasePresenter {

}