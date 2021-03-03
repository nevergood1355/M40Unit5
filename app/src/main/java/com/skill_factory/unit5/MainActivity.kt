package com.skill_factory.unit5

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.skill_factory.unit5.ComponentSingleton.root
import com.skill_factory.unit5.ComponentSingleton.screen1
import com.skill_factory.unit5.ComponentSingleton.screen1Component
import dagger.*
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        root =  DaggerRootComponent.factory().create(this)
        screen1Component = root?.screen1Component?.build()
    }
}

object ComponentSingleton{
    var root : RootComponent? = null
    var screen1Component : Screen1Component? = null

    var screen1 = MyFragment()
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screen1Component?.inject(screen1)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.root, screen1).commit()
    }
}
