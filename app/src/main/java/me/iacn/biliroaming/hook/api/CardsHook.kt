package me.iacn.biliroaming.hook.api

import me.iacn.biliroaming.utils.sPrefs
import org.json.JSONArray
import org.json.JSONObject

object CardsHook : ApiHook {
    private const val cardsApi = "https://api.bilibili.com/pgc/season/player/cards"

    override val enabled: Boolean
        get() = sPrefs.getBoolean("hidden", false)
                && sPrefs.getBoolean("block_up_rcmd_ads", false)

    override fun canHandler(api: String) = api.startsWith(cardsApi)

    override fun hook(response: String): String {
        return JSONObject().apply {
            put("code", 0)
            put("data", JSONArray())
        }.toString()
    }
}
