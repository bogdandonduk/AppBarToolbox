# AppBarToolbox

A simple utility library containing wrappers around common tasks associated with Android's **App Bar** UI element. For instance, it is able to fetch app bar's options' menu's items as views for further treating them as views, provides convenient wrappers around **ActionBarDrawerToggle** for easier initialization, control over their behavior, etc.  

## Include in your project
**Gradle dependency**

Add this in your **app**-level **build.gradle** file:
```groovy
dependencies {
	...
	
	def latest_version_tag = 2.1.5
	implementation "com.github.bogdandonduk:AppBarToolbox:$latest_version_tag"

	...
}
```
You can always find the **latest_version_tag** [here](https://github.com/bogdandonduk/AppBarToolbox/releases).

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
[**Slidr**](https://github.com/r0adkll/Slidr)

Gradle dependency: 

```groovy
dependencies {
	...
	
	def latest_version_tag = 2.1.0
	implementation "com.r0adkll:slidableactivity:$latest_version_tag"

	...
}
```
You can find the **latest_version_tag** [here](https://github.com/r0adkll/Slidr/releases).
