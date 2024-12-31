package com.mirrorfly_rn

import android.os.Bundle
import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
import com.facebook.react.defaults.DefaultReactActivityDelegate

class MainActivity : ReactActivity() {

    /**
     * for fixing crash issue https://stackoverflow.com/a/57712204
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(null)
    }

    override fun onPause() {
        if (ActivityManager.instance!!.hasActivity(CallScreenActivity::class.java)) {
            reactInstanceManager.onHostResume(this)
        }
        super.onPause()
    }

    /**
     * Returns the name of the main component registered from JavaScript. This is used to schedule
     * rendering of the component.
     */
    override fun getMainComponentName(): String = "mirrorfly_rn"

    /**
     * Returns the instance of the [ReactActivityDelegate]. We use [DefaultReactActivityDelegate]
     * which allows you to enable New Architecture with a single boolean flags [fabricEnabled]
     */
    override fun createReactActivityDelegate(): ReactActivityDelegate =
        DefaultReactActivityDelegate(this, mainComponentName, fabricEnabled)
}