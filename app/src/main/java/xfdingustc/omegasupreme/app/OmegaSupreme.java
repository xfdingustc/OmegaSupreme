package xfdingustc.omegasupreme.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Xiaofei on 2016/5/25.
 */
public class OmegaSupreme extends Application {
    private static Context mSharedContext = null;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        mSharedContext = getApplicationContext();
    }

    public static Context getContext() {
        return mSharedContext;
    }
}
