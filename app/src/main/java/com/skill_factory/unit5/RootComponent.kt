package com.skill_factory.unit5

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope
import javax.inject.Singleton


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ScreenScope

interface Screen1Injector {
    val screen1Component: Screen1Component.Builder
}

@Singleton
@Component(modules = [RootModule::class])
interface RootComponent : Screen1Injector {
    fun inject(a: MainActivity);

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): RootComponent
    }
}