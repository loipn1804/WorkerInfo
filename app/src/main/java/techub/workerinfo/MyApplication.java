package techub.workerinfo;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;

import com.splunk.mint.Mint;

import greendao.DaoMaster;
import greendao.DaoSession;

/**
 * Created by USER on 12/16/2015.
 */
public class MyApplication extends Application {
    public DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

//        Mint.initAndStartSession(getApplicationContext(), "96836188");

        int current_version = getAppVersion();

        SharedPreferences preferences = getSharedPreferences("versioncode", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int previous_version = preferences.getInt("version", current_version);
        if (previous_version == current_version) {
//            Toast.makeText(AntidoteApplication.this, "old_version", Toast.LENGTH_LONG).show();
            editor.putInt("version", current_version);
        } else {
//            Toast.makeText(AntidoteApplication.this, "deleteDatabase", Toast.LENGTH_LONG).show();
            deleteDatabase();
            editor.putInt("version", current_version);
        }
        editor.commit();

        setupDatabase();

    }

    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "diblydb", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

        // initTestGEOfenceData();
//        initAllPermanentData();
    }

    public DaoSession getDaoSession() {
        if (daoSession != null) {
            return daoSession;
        } else {
            setupDatabase();
            return daoSession;
        }
    }

    private void deleteDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "diblydb", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoMaster.dropAllTables(db, true);
        daoMaster.createAllTables(db, true);
    }

    public int getAppVersion() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    public void clearDaoSession() {
        daoSession = null;
    }
}
