package com.oman.forward

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Instrumentation
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.oman.forward.study.dynamicLoad.InstrumentationProxy
import com.oman.forward.databinding.ActivityMainBinding

/**

 * @author:ZhouJiang
 * @date:2019/11/25 12:39
 * @email:zhoujiang2012@163.com

 */
class DashboardActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var appbarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        drawerLayout = binding.drawerLayout
        navController = findNavController(R.id.apps_nav_fragment)
        appbarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appbarConfiguration)
        binding.navigationView.setupWithNavController(navController)
        replaceActivityInstrument(this)
        replaceContextInstrument()
//        startActivity(Intent(this, TargetActivity::class.java))
        getSharedPreferences("first", Context.MODE_PRIVATE).modify {
            putString("name", "value")
        }

        getSharedPreferences("second", Context.MODE_PRIVATE).test {
            putString("name3", "value2")
        }
    }

    @SuppressLint("ApplySharedPref")
    fun SharedPreferences.modify(
            commit: Boolean = false,
            action: SharedPreferences.Editor.() -> Unit
    ) {
        val editor = edit()
        action(editor)
        if (commit) editor.commit() else editor.apply()
    }

    fun SharedPreferences.test(block: SharedPreferences.Editor.() -> Unit) {
        val editor = edit()
        editor.block()
//        block(editor)
        editor.apply()
    }


    private fun replaceActivityInstrument(activity: Activity) {
        val field = Activity::class.java.getDeclaredField("mInstrumentation")
        field.isAccessible = true
        val instrumentation = field.get(activity) as Instrumentation
        val proxy = InstrumentationProxy(instrumentation)
        field.set(activity, proxy)
    }

    private fun replaceContextInstrument() {
        val activityThread = Class.forName("android.app.ActivityThread")
        val fieldCurrentActivityThread = activityThread.getDeclaredField("sCurrentActivityThread")
        fieldCurrentActivityThread.isAccessible = true
        val objActivityThread = fieldCurrentActivityThread.get(null)

        val fieldInstrument = activityThread.getDeclaredField("mInstrumentation")
        fieldInstrument.isAccessible = true
        val instrument = fieldInstrument.get(objActivityThread) as Instrumentation
        val proxy = InstrumentationProxy(instrument)
        fieldInstrument.set(objActivityThread, proxy)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appbarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers()
        } else {
            super.onBackPressed()
        }
    }
}