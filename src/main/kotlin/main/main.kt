package main

import com.github.kevinsawicki.http.HttpRequest
import net.sf.json.JSONObject
import java.awt.Toolkit
import java.util.*

fun main() {
    val product = "MLUU3J/A"
    while (true) {
        val response = HttpRequest
            .get("https://www.apple.com/jp/shop/pickup-message-recommendations?mt=compact&searchNearby=true&store=R718&product=$product")
            .body()
        val stores = JSONObject.fromObject(response)
            .getJSONObject("body")
            .getJSONObject("PickupMessage")
            .getJSONArray("stores")
        var hasStore = false
        var message = ""
        for (i in 0..(stores.size - 1)) {
            val store = stores.getJSONObject(i)
            val partsAvailability = store.getJSONObject("partsAvailability")
            if (!partsAvailability.toString().equals("{}")) {
                hasStore = true
                message += "${store.getString("storeName")}${partsAvailability}\n"
            }
        }
        println("Check at ${Date().toString()}")
        if (hasStore) {
            println(message)
            alert()
            break
        }
        Thread.sleep(20000)
    }
}

fun alert() {
    while (true) {
        Toolkit.getDefaultToolkit().beep()
        Thread.sleep(300)
    }
}