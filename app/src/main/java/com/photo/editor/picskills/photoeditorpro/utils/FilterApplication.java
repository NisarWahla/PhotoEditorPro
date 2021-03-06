package com.photo.editor.picskills.photoeditorpro.utils;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;

public class FilterApplication extends Application {
    public static Context context;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        FilterApplication.context = context;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setContext(getApplicationContext());
        MobileAds.initialize(this);
/*        List<String> testDevices = new ArrayList<>();
        testDevices.add(AdRequest.DEVICE_ID_EMULATOR);
        testDevices.add("7BCD9CF420BB02B0F1B252AFAC067BE3");
        testDevices.add("16805B774118DE1F6B1BE6F37825F291");*/

        FirebaseApp.initializeApp(this);
//        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);

/*        RequestConfiguration requestConfiguration
                = new RequestConfiguration.Builder()
                .setTestDeviceIds(testDevices)
                .build();
        MobileAds.setRequestConfiguration(requestConfiguration);*/
    }
}
