package com.cantalou.deviceid.impl

import android.content.Context
import com.cantalou.deviceid.Handler
import java.io.File

/**
 * Handle device id with File
 *
 * @author  cantalou
 * @date    2020年05月10日 20:51
 *
 */
class FileHandler(context: Context) : Handler(context) {

    val idFile: File by lazy {
        val result: File = context.getExternalFilesDir(null)
        result
    }

    override fun get(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}