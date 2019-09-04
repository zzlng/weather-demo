package com.zzl.weather_demo.ui.activities

import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.zzl.weather_demo.R
import com.zzl.weather_demo.extensions.ctx
import com.zzl.weather_demo.extensions.slideEnter
import com.zzl.weather_demo.extensions.slideExit
import com.zzl.weather_demo.ui.App
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

interface ToolbarManager {

    val toolbar: Toolbar

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar() {
        toolbar.inflateMenu((R.menu.menu_main))
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
//                R.id.action_settings -> App.instance.toast("Setting")
                R.id.action_settings -> toolbar.ctx.startActivity<SettingsActivity>()
                else -> App.instance.toast("Unknown option")
            }
            true
        }
    }

    fun enableHomeAsUp(up: () -> Unit) {
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }

//    private fun createUpDrawable() = with(DrawerArrowDrawable(toolbar.ctx)) {
//        progress = 1f
//        this
//    }

    private fun createUpDrawable() = DrawerArrowDrawable(toolbar.ctx).apply { progress = 1f }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
    }
}