package com.cantalou.deviceid.impl

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.cantalou.deviceid.Handler

/**
 * Handle device id with SharePreferences
 *
 * @author  cantalou
 * @date    2020年05月10日 20:40
 *
 */
class PreferencesHandler(context: Context) : Handler(context) {

    private val preferences: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(context)
    }

    override fun get(): String? {
        return preferences.getString("_device_id", "");
    }

    override fun save(id: String) {
        preferences.edit().putString("_device_id", id).apply();
    }
}