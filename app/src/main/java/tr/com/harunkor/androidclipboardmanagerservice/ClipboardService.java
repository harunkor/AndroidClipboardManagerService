package tr.com.harunkor.androidclipboardmanagerservice;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by harunkor on 06.10.2017.
 */

public class ClipboardService extends Service {
    private ClipboardManager mClipboardManager;

    @Override
    public void onCreate() {
        super.onCreate();

        mClipboardManager =
                (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        mClipboardManager.addPrimaryClipChangedListener(
                mOnPrimaryClipChangedListener);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private ClipboardManager.OnPrimaryClipChangedListener mOnPrimaryClipChangedListener =
            new ClipboardManager.OnPrimaryClipChangedListener() {
                @Override
                public void onPrimaryClipChanged() {
                    //Log.d(TAG, "onPrimaryClipChanged");
                    ClipData clip = mClipboardManager.getPrimaryClip();
                    String copying= clip.getItemAt(0).getText().toString();
                    if(!copying.isEmpty())
                    {
                        Toast.makeText(ClipboardService.this, "this : "+clip.getItemAt(0).getText().toString(), Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(ClipboardService.this, "Please select the area you want to copy...", Toast.LENGTH_SHORT).show();
                    }


                }
            };


}
