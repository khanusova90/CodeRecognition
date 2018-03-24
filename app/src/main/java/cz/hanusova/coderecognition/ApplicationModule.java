package cz.hanusova.coderecognition;

import cz.hanusova.coderecognition.start.StartActivity;
import cz.hanusova.coderecognition.start.StartActivityPresenter;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by KHanusova on 24.03.2018.
 */
@Module
public abstract class ApplicationModule {

    @ContributesAndroidInjector
    abstract StartActivity contributeActivityInjector();

    @Provides
    static StartActivityPresenter providesStartActivityPresenter(){
        return new StartActivityPresenter();
    }
}
