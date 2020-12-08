import android.app.Application
import com.example.rickandmortycharacters.BuildConfig
import di.common.AppModule
import di.common.ApplicationGraph
import timber.log.Timber

class App : Application() {
    companion object {
        lateinit var appComponent: ApplicationGraph
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
