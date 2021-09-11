package bogdandonduk.appbartoolboxandroidlib.drawer

object OnDrawerSlideBehaviour {
    sealed class MainContentOffset {
        companion object {
            const val DEFAULT_MAIN_CONTENT_PARTIAL_OFFSET_X_MULTIPLIER = 0.1f
            const val DEFAULT_MAIN_CONTENT_PARTIAL_OFFSET_Y_MULTIPLIER = 0.1f
        }

        class MainContentFullOffset

        class MainContentPartialOffset(var xMultiplier: Float = DEFAULT_MAIN_CONTENT_PARTIAL_OFFSET_X_MULTIPLIER, var yMultiplier: Float = DEFAULT_MAIN_CONTENT_PARTIAL_OFFSET_Y_MULTIPLIER)

        class MainContentNoOffset
    }
}