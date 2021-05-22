package tk.frostbit.logging.logcat

import ru.kontur.kinfra.logging.LoggerFactory
import ru.kontur.kinfra.logging.backend.LoggerBackend
import ru.kontur.kinfra.logging.decor.DefaultMessageDecor
import ru.kontur.kinfra.logging.decor.MessageDecor

class LogcatLoggerFactory : LoggerFactory() {

    override fun getLoggerBackend(name: String): LoggerBackend {
        val tag = name.substringAfterLast('.').substringBefore('$')
        return LogcatLoggerBackend(tag)
    }

    override fun getEmptyDecor(): MessageDecor {
        return DefaultMessageDecor.EMPTY
    }

}
