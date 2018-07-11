package com.kelvingabe.kelvinoguno.easypos;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {


    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(getString(R.string.EasyPOS_NameSpace), MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, RegisterCompanyActivity.class);
        if (prefs.getBoolean(getString(R.string.Shared_Pref_First_Run), true)) {
            Log.d(getString(R.string.EasyPOS_NameSpace),"First Run worked");
            // Do first run stuff here then set 'firstrun' as false
            // using the following line to edit/commit prefs
            prefs.edit().putBoolean(getString(R.string.Shared_Pref_First_Run), false).apply();
            startActivity(intent);
            finish();
        }else {
            startActivity(intent);
            finish();
        }
    }
}
