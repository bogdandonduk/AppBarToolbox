package bogdandonduk.appbartoolboxandroidlib.appbar

import android.view.MenuItem
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import bogdandonduk.appbartoolboxandroidlib.drawer.AppBarDrawerToggle
import com.google.android.material.navigation.NavigationView

interface AppBarHandler {
    /**
     * Mark following properties as 'lateinit' and initialize them not earlier than in onCreate() of owner activity or fragment
    */
    var appBar: AppBar?

    var appBarDrawerToggle: AppBarDrawerToggle?

    var showOptionsMenu: Boolean

    var homeAsUpIndicatorView: View?

    fun getInitializedAppBar(
        activity: AppCompatActivity, toolbar: Toolbar
    ) = if(appBar == null)
        AppBar(activity, toolbar).apply {
            appBar = this
        }
    else appBar!!

    fun getInitializedDrawerToggle(
        activity: AppCompatActivity,
        drawerLayout: DrawerLayout,
        navView: NavigationView,
        toolbar: Toolbar,
        @StringRes openDrawerContentDescRes: Int,
        @StringRes closeDrawerContentDescRes: Int,
        onDrawerOpenedAction: ((drawerView: View) -> Unit)? = null,
        onDrawerClosedAction: ((drawerView: View) -> Unit)? = null
    ) = if(appBarDrawerToggle == null)
        AppBarDrawerToggle(
            activity,
            drawerLayout,
            navView,
            toolbar,
            openDrawerContentDescRes,
            closeDrawerContentDescRes,
            onDrawerOpenedAction,
            onDrawerClosedAction
        ).also {
            appBarDrawerToggle = it
        }
    else appBarDrawerToggle

    fun initBackNavigation(activity: AppCompatActivity) {
        appBar?.modifyAsActionBar {
            it.setDisplayHomeAsUpEnabled(true)
        }?.modifyAsToolbar {
            it.setNavigationOnClickListener {
                activity.onBackPressed()
            }
        }
    }

    fun drawerToggleOnOptionsItemSelected(item: MenuItem) = appBarDrawerToggle != null && appBarDrawerToggle!!.drawerToggle.onOptionsItemSelected(item)
}