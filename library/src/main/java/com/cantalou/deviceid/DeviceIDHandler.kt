package com.cantalou.deviceid

import android.content.Context
import android.text.TextUtils
import com.cantalou.deviceid.impl.FileHandler
import com.cantalou.deviceid.impl.ImageHandler
import com.cantalou.deviceid.impl.PreferencesHandler

/**
 *
 * @author  cantalou
 * @date    2020年05月10日 20:46
 *
 */
object DeviceIDHandler {

    var id: String? = null

    lateinit var handlers: MutableList<Handler>

    fun getHandlers(context: Context): List<Handler> {
        if (handlers == null) {
            handlers = mutableListOf()
            handlers.add(PreferencesHandler(context))
            handlers.add(FileHandler(context))
            handlers.add(ImageHandler(context))
        }
        return handlers
    }

    fun get(context: Context): String? {
        if (id != null) {
            return id
        }
        for (handler in getHandlers(context)) {
            id = handler.get()
            if (!TextUtils.isEmpty(id)) {
                save(context, id!!)
                break
            }
        }
        return id
    }

    fun save(context: Context, id: String) {
        for (handler in getHandlers(context)) {
            handler.save(id)
        }
    }
}