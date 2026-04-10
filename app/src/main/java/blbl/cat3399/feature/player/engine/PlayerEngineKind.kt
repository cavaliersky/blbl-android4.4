package blbl.cat3399.feature.player.engine

import blbl.cat3399.core.prefs.AppPrefs

internal enum class PlayerEngineKind(
    val prefValue: String,
) {
    IjkPlayer(AppPrefs.PLAYER_ENGINE_IJK),
    ;

    companion object {
        fun fromPrefValue(value: String): PlayerEngineKind {
            return IjkPlayer
        }
    }
}
