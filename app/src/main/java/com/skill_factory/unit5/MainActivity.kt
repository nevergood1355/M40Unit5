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
    val root by lazy { DaggerRootComponent.builder().application(this).build() }
    val feature by lazy { root.featureBuilder().setText("Ref").build() }

    override fun onCreate() {
        super.onCreate()
        root
        feature
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val root = (application as MyApp).root
        val feature = (application as MyApp).feature
        val f = feature.getScreen()
        feature.inject(f)
        supportFragmentManager.beginTransaction().replace(R.id.root,f).commit()
    }
}


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ScreenScope

@Module
class RootModule

@Module
class FeatureSubModule {

    @Provides
    @ScreenScope
    fun fragment(s: String): MyFragment {
        val f = MyFragment()
        f.retainInstance = true
        return f
    }
}

@Singleton
@Component(modules = [RootModule::class])
interface RootComponent {
    fun inject(a: MainActivity);

    fun featureBuilder(): FeatureSubComponent.Builder

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder
        fun build(): RootComponent
    }
}

@ScreenScope
@Subcomponent(modules = [FeatureSubModule::class])
interface FeatureSubComponent {
    fun getScreen(): MyFragment
    fun inject(f: MyFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun setText(s: String): Builder
        fun build(): FeatureSubComponent
    }
}