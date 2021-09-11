package bogdandonduk.appbartoolboxandroidlib.appbar

import android.view.View
import android.widget.ImageButton
import androidx.appcompat.widget.ActionMenuView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.children
import kotlinx.coroutines.delay

object AppBarToolbox {
    fun getHomeAsUpIndicatorAsView(toolbar: Toolbar) : View? =
        if(toolbar.childCount > 0) {
            toolbar.children.forEach {
                if(it.toString().contains("imagebutton", true)) {
                    return it
                }
            }

            null
        } else null

    fun getHomeAsUpIndicatorIconDrawable(toolbar: Toolbar) = (getHomeAsUpIndicatorAsView(toolbar) as? ImageButton)?.drawable

    fun getOverflowMenuIconAsView(toolbar: Toolbar) : View? =
        if(toolbar.childCount > 0) {
            toolbar.children.forEach {
                if(it is ActionMenuView)
                    it.children.forEach { menuItemChild ->
                        if(menuItemChild.toString().contains("overflowmenu", true)) return menuItemChild
                    }
            }

            null
        } else null

    suspend fun getOptionsMenuItemAsViewAsync(menuItemIdString: String, toolbar: Toolbar) : View? {
        var view: View? = null

        val timeout = System.currentTimeMillis() + 3000

        do {
            if(toolbar.childCount > 0) {
                toolbar.children.forEach {
                    if(it is ActionMenuView)
                        it.children.forEach { menuItemChild ->
                            if(menuItemChild.toString().contains(menuItemIdString, true)) view = menuItemChild
                        }
                }
            }

            if(view == null) delay(10)
        } while(view == null && System.currentTimeMillis() < timeout)

        return view
    }

    fun getOptionsMenuItemAsView(menuItemIdString: String, toolbar: Toolbar) : View? =
        if(toolbar.childCount > 0) {
            toolbar.children.forEach {
                if(it is ActionMenuView)
                    it.children.forEach { menuItemChild ->
                        if(menuItemChild.toString().contains(menuItemIdString, true))
                            return menuItemChild
                    }
            }

            null
        } else null

    suspend fun manageOptionsMenuItemAsView(menuItemIdString: String, toolbar: Toolbar, managementAction: (view: View?) -> Unit) : View? {
        val view = getOptionsMenuItemAsViewAsync(menuItemIdString, toolbar)

        managementAction.invoke(view)

        return view
    }
}