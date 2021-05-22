package tk.frostbit.logging.logcat

import android.util.Log
import ru.kontur.kinfra.logging.LogLevel
import ru.kontur.kinfra.logging.backend.LoggerBackend
import ru.kontur.kinfra.logging.backend.LoggingRequest

internal class LogcatLoggerBackend(
    private val tag: String,
) : LoggerBackend {

    override fun isEnabled(level: LogLevel): Boolean {
        return Log.isLoggable(tag, convertLevel(level))
    }

    override fun log(request: LoggingRequest) {
        val level = convertLevel(request.level)
        val message = request.decoratedMessage
        val throwable = request.additionalData.throwable
        if (throwable == null) {
            Log.println(level, tag, message)
        } else {
            Log.println(level, tag, message + '\n' + Log.getStackTraceString(throwable))
        }
    }

    private fun convertLevel(level: LogLevel): Int {
        return when (level) {
            LogLevel.DEBUG -> Log.DEBUG
            LogLevel.INFO -> Log.INFO
            LogLevel.WARN -> Log.WARN
            LogLevel.ERROR -> Log.ERROR
        }
    }

}
