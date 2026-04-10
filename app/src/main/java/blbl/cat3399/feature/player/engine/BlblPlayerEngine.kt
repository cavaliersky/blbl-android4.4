package blbl.cat3399.feature.player.engine

import android.view.Surface
import blbl.cat3399.feature.player.Playable

internal data class EngineCapabilities(
    val subtitlesSupported: Boolean,
)

internal sealed interface PlaybackSource {
    data class Vod(
        val playable: Playable,
        val subtitle: Any?, // MediaItem.SubtitleConfiguration not used in IjkPlayer
        val durationMs: Long? = null,
    ) : PlaybackSource

    data class Live(
        val url: String,
    ) : PlaybackSource
}

internal interface BlblPlayerEngine {
    val kind: PlayerEngineKind
    val capabilities: EngineCapabilities

    val playbackState: Int
    val isPlaying: Boolean
    var playWhenReady: Boolean

    val duration: Long
    val currentPosition: Long
    val bufferedPosition: Long

    fun setVideoSurface(surface: Surface?)

    fun seekTo(positionMs: Long)

    val playbackSpeed: Float
    fun setPlaybackSpeed(speed: Float)

    var repeatMode: Int

    fun setSource(source: PlaybackSource)
    fun prepare()
    fun play()
    fun pause()
    fun stop()
    fun release()

    fun addListener(listener: Listener)
    fun removeListener(listener: Listener)

    interface Listener {
        fun onPlayerError(error: Throwable) {}

        fun onIsPlayingChanged(isPlaying: Boolean) {}

        fun onPlaybackStateChanged(playbackState: Int) {}

        fun onPositionDiscontinuity(newPositionMs: Long) {}

        fun onVideoSizeChanged(width: Int, height: Int) {}

        fun onRenderedFirstFrame() {}
    }
}
