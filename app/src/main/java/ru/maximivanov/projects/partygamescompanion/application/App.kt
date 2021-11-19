package ru.maximivanov.projects.partygamescompanion.application

import android.app.Application
import android.content.Context
import android.content.res.Resources

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
        Companion.resources = super.getResources()
    }

    companion object {
        private var application: Application? = null
        private var resources: Resources? = null
        val context: Context
            get() = application!!.applicationContext

        fun getStrRes(resID: Int): String {
            return resources!!.getString(resID)
        }
    }
}