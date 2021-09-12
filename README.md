# AppBarToolbox  
  
A simple utility library containing wrappers around common tasks associated with Android's **App Bar** UI element. For instance, it is able to fetch app bar's options' menu's items as views for further treating them as views, provides convenient wrappers around **ActionBarDrawerToggle** for easier initialization, control over their behavior, etc.  
  
## Include in your project  
**Gradle dependency**  
  
Add this in your **app**-level **build.gradle** file:  
```groovy  
dependencies {  
	...  
  
	def latest_version_tag = 2.1.4  
	implementation "com.github.bogdandonduk:AppBarToolbox:$latest_version_tag"  
  
	...  
}  
```  
You can always find the **latest_version_tag** [here]([https://github.com/bogdandonduk/AppBarToolbox/releases](https://vk.com/away.php?utf=1&to=https%3A%2F%2Fgithub.com%2Fbogdandonduk%2FAppBarToolbox%2Freleases)).  
  
Also make sure you have this repository this in your **project**-level **build.gradle** file:  
```groovy  
allprojects {  
	repositories {  
		...  
  
		maven { url 'https://jitpack.io' }  
	}  
}  
```  
  
## Dependencies  
[**Slidr**]([https://github.com/r0adkll/Slidr](https://vk.com/away.php?utf=1&to=https%3A%2F%2Fgithub.com%2Fr0adkll%2FSlidr))  
  
Gradle dependency:  
  
```groovy  
dependencies {  
...  
  
def latest_version_tag = 2.1.0  
implementation "com.r0adkll:slidableactivity:$latest_version_tag"  
  
...  
}  
```  
You can find the **latest_version_tag** [here]([https://github.com/r0adkll/Slidr/releases](https://vk.com/away.php?utf=1&to=https%3A%2F%2Fgithub.com%2Fr0adkll%2FSlidr%2Freleases)).

# Examples of usage
```kotlin 
// obtain any option item's view.
var searchOptionItemView = AppBarToolbox.getOptionsMenuItemAsView(
		menuItemIdString = "searchOptionItem" /* full menuItemId of the item or its any uniquely identifying substring */, 
		toolbar = findViewById(R.id.myToolbar)
	)

// now you may manipulate it in any way you can manipulate a view, for instance: 
searchOptionItemView.setOnLongClickListener {
	// you may override standard Android's tooltip popups
	true
}

// You can similarly obtain homeAsUpIndicator, overflowMenuItem as views via corresponding static methods in the AppBarToolbox object.
```
