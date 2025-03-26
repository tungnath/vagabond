package com.ravi.vagabond.base

import org.slf4j.Logger
import org.slf4j.LoggerFactory


object VGUtils {

    private val logger: Logger = LoggerFactory.getLogger(VGUtils::class.java)

    fun log(message: String): Unit {
        logger.info(message)
    }

}