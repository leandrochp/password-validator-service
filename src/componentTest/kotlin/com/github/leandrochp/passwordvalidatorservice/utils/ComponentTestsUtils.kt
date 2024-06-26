package com.github.leandrochp.passwordvalidatorservice.utils

import java.io.File
import java.net.URI

object ComponentTestsUtils {

    fun readFile(fileName: String): String {
        val uri = fileUri(fileName)
        return File(uri).readText(Charsets.UTF_8)
    }

    private fun fileUri(fileName: String): URI {
        val fullPath = "/samples/$fileName.json"
        return ComponentTestsUtils::class.java.getResource(fullPath)!!.toURI()
    }
}