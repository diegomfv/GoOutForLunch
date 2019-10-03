package com.diegomfv.gooutforlunch.viewviewmodel.mainactivity

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.diegomfv.gooutforlunch.viewviewmodel.base.BaseActivityModule
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.LoginFragment
import com.diegomfv.gooutforlunch.viewviewmodel.mainactivity.loginfragment.LoginFragmentModule
import com.diegomfv.refractaticket.di.scope.PerActivity
import com.diegomfv.refractaticket.di.scope.PerFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class])
abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract fun appCompatActivity(mainActivity: MainActivity): AppCompatActivity

    @PerFragment
    @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
    abstract fun loginFragmentInjector(): LoginFragment

    @Module
    companion object {

        @PerActivity
        @Provides
        @JvmStatic
        fun provideViewModelFactory(app: Application): MainActivityViewModel.Factory {
            return MainActivityViewModel.Factory(app)
        }
    }

}
