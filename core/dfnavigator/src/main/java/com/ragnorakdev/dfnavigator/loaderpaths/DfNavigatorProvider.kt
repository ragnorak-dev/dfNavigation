package com.ragnorakdev.dfnavigator.loaderpaths

import android.content.ContentProvider
import android.content.ContentValues
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.util.Log

class DfNavigatorProvider : ContentProvider() {

    override fun onCreate(): Boolean {
        val context = context
        if (context != null) {
            val applicationContext = context.applicationContext
            if (applicationContext != null) {
                try {
                    DfNavigatorLoader.getInstance(context)?.discoverAndInitialize()
                } catch (exception: PackageManager.NameNotFoundException) {
                   // Ignored to allow add loader of dynamic feature not installed
                }
            } else {
                Log.w("ROUTER_UI_PROVIDER", "Deferring initialization because `applicationContext` is null.")
            }
        } else {
            throw Exception("Context cannot be null")
        }
        return true
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        throw IllegalStateException("Not allowed.")
    }

    override fun getType(p0: Uri): String? {
        throw IllegalStateException("Not allowed.")
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        throw IllegalStateException("Not allowed.")
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        throw IllegalStateException("Not allowed.")
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        throw IllegalStateException("Not allowed.")
    }
}