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

After the installation just use `kinfra-logging` as usual:

```kotlin
class MyActivity : Activity {
    
    override fun onCreate() {
        ...
        logger.info { "Created" }
    }
    
    companion object {
        private val logger = Logger.currentClass()
    }
}
```
