package com.cantalou.deviceid

import android.content.Context

/**
 *
 * @author  cantalou
 * @date    2020年05月10日 20:37
 *
 */
abstract class Handler(val context: Context) {

    /**
     * get device id
     */
    abstract fun get(): String?

    /**
     * save device id
     */
    abstract fun save(id: String)
}