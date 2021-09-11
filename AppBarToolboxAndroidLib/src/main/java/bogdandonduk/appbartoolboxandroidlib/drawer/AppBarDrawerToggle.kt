package bogdandonduk.appbartoolboxandroidlib.drawer

import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class AppBarDrawerToggle(
    activity: AppCompatActivity,
    drawerLayout: DrawerLayout,
    navView: NavigationView,
    toolbar: Toolbar,
    @StringRes openDrawerContentDescRes: Int,
    @StringRes closeDrawerContentDescRes: Int,
    onDrawerOpenedAction: ((drawerView: View) -> Unit)? = null,
    onDrawerClosedAction: ((drawerView: View) -> Unit)? = null
) {
    var drawerToggle = object : ActionBarDrawerToggle(
        activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes
    ) {
        override fun onDrawerOpened(drawerView: View) {
            OpenDrawersRegistry.openNavViewsIdsList.add(navView.id)
            onDrawerOpenedAction?.invoke(drawerView)
        }

        override fun onDrawerClosed(drawerView: View) {
            OpenDrawersRegistry.openNavViewsIdsList.remove(navView.id)
            onDrawerClosedAction?.invoke(drawerView)
        }
    }

    init {
        drawerLayout.addDrawerListener(drawerToggle)

        drawerToggle.syncState()

        if(OpenDrawersRegistry.openNavViewsIdsList.contains(navView.id)) drawerLayout.openDrawer(activity.findViewById(navView.id))
    }

    inline fun modify(modification: (appBarDrawerToggle: ActionBarDrawerToggle) -> Unit) = this.apply {
        modification.invoke(drawerToggle)
    }
}