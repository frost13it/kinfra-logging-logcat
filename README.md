kinfra-logging-logcat
=====================

Straightforward integration of [kinfra-logging](https://github.com/kinfra/kinfra-logging) with Android Logcat. 

## Installation

Build script:
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation("com.github.frost13it:kinfra-logging-logcat:0.1")
}
```

Application class:
```kotlin
class MyApplication : Application {
    override fun onCreate() {
        super.onCreate()
        // Should be performed as early as possible
        DefaultLoggerFactory.delegate = LogcatLoggerFactory()
    }
}
```

## Usage

After the installation, just use `kinfra-logging` as usual:

```kotlin
class MyActivity : Activity() {
    override fun onCreate() {
        ...
        logger.info { "Created" }
    }
    
    companion object {
        private val logger = Logger.currentClass()
    }
}
```

Execution of this code puts the following message into Logcat:
```
I/MyActivity: Created
```

## Configuration

A message will be logged only if it is allowed by `Log.isLoggable(tag, level)`.

By default, minimum log level on Android is `INFO`.
To change it, set the property `log.tag` to the desired level's abbreviation:

```shell
adb shell setprop log.tag D
```

Level of a particular tag can be set via a property `log.tag.<tag>`, for example:

```shell
adb shell setprop log.tag.MyActivity D
```

Beware that these properties affect all the applications on the device.
