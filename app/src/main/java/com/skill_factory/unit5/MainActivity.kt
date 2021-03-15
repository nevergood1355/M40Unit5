package com.skill_factory.unit5

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.*


open class App : Application() {

    companion object {
        private var rootComponent: RootComponent? = null
        private var screen1Component : Screen1Component? = null
    }

    open fun getRootComponent(): RootComponent {
        return rootComponent ?: DaggerRootComponent.factory().create(this).also {
            rootComponent = it
        }
    }

    open fun getScreen1Component(): Screen1Component {
        return screen1Component ?: getRootComponent().screen1Component.build().also {
            screen1Component = it
        }
    }

}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val screen1 = MyFragment()
        (application as App).getScreen1Component().inject(screen1)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.root, screen1).commit()
    }
}
