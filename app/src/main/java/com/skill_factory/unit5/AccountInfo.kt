package com.skill_factory.unit5

import androidx.annotation.DrawableRes

data class AccountInfo(@DrawableRes val iconId: Int, val posts: Int, val followers: Int, val following: Int)