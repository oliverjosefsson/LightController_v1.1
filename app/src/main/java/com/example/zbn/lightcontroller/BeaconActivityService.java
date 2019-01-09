package com.example.zbn.lightcontroller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;
import android.view.View;

import mobi.inthepocket.android.beacons.ibeaconscanner.Beacon;
import mobi.inthepocket.android.beacons.ibeaconscanner.BluetoothScanBroadcastReceiver;

public class BeaconActivityService extends JobIntentService
{
    public MainActivity mainActivity;
    protected void onHandleWork(@NonNull final Intent intent)
    {

        mainActivity.tv_test.setText("on handle");
        // This is the beacon object containing UUID, major and minor info
        final Beacon beacon = intent.getParcelableExtra(BluetoothScanBroadcastReceiver.IBEACON_SCAN_BEACON_DETECTION);

        // This flag will be true if it is an enter event that triggered this service
        final boolean enteredBeacon = intent.getBooleanExtra(BluetoothScanBroadcastReceiver.IBEACON_SCAN_BEACON_ENTERED, false);

        // This flag will be true if it is an exit event that triggered this service
        final boolean exitedBeacon = intent.getBooleanExtra(BluetoothScanBroadcastReceiver.IBEACON_SCAN_BEACON_EXITED, false);

        // Here you can do something with the beacon trigger
        if (beacon != null)
        {
            String logMessage = "";
            if (enteredBeacon)
            {
                Log.d("testing", "entered beacon " + beacon.getUUID());
                mainActivity.tv_test.setText("FUNKAR");
                //Log.d(TAG, "entered beacon " + beacon.getUUID());
                //logMessage = getString(R.string.notification_enter, beacon.getUUID(), beacon.getMajor(), beacon.getMinor());
            }
            else if (exitedBeacon)
            {
                mainActivity.tv_test.setText("DEN STACK");
            }

            // Create notification channel if required
           }
        else
        {
            mainActivity.tv_test.setText("INTE HITTAD");
        }
    }
}