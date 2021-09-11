package bogdandonduk.appbartoolboxandroidlib.appbar

import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout

class AppBar internal constructor(@PublishedApi internal var activity: AppCompatActivity, @PublishedApi internal var toolbar: Toolbar) {
    private var parentAppBarLayout: AppBarLayout? = null

    init {
        activity.setSupportActionBar(toolbar)

        findParentAppBarLayout()
    }

    private fun findParentAppBarLayout() {
        if(parentAppBarLayout == null) {
            var parent = toolbar.parent as? View

            while(parent != null && parent !is AppBarLayout) {
                parent = parent.parent as? View
            }

            parentAppBarLayout = parent as? AppBarLayout
        }
    }

    inline fun modifyAsToolbar(modification: (toolbar: Toolbar) -> Unit) = this.apply {
        modification.invoke(toolbar)
    }

    inline fun modifyAsActionBar(modification: (actionBar: ActionBar) -> Unit) = this.apply {
        modification.invoke(activity.supportActionBar!!)
    }

    fun modifyParentAppBarLayout(modification: (parentAppBarLayout: AppBarLayout?) -> Unit) = this.apply {
        modification.invoke(parentAppBarLayout)
    }
}