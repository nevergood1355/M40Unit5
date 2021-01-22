package com.skill_factory.unit5

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.*
import javax.inject.Inject
import javax.inject.Scope
import javax.inject.Singleton

class MyApp : Application() {
    val root = DaggerRootComponent.factory().create(this)
    val screen1 = MyFragment().apply { retainInstance = true }
    val screen1Component by lazy { root.screen1Component.fragment(screen1).build() }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = (application as MyApp)
        app.screen1Component.inject(app.screen1)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.root,app.screen1).commit()
    }
}
