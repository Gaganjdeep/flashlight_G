package androidsmart.blog.gagan.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;

import androidsmart.blog.gagan.utillG.FlashLightHelper;

/**
 * Created by gagandeep on 01 Mar 2016.
 */

public class UserPresentBroadcastReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {

        /*Sent when the user is present after
         * device wakes up (e.g when the keyguard is gone)
         * */
        if (intent.getAction().equals(Intent.ACTION_USER_PRESENT))
        {

        }
        /*Device is shutting down. This is broadcast when the device
         * is being shut down (completely turned off, not sleeping)
         * */
        else if (intent.getAction().equals(Intent.ACTION_SHUTDOWN))
        {

        }


        final FlashLightHelper flashLightHelper = new FlashLightHelper();



        lightOn = false;


        if (flashLightHelper.isFlashLightExist(context))
        {
            for (int i = 0; i < 10; i++)
            {
                if (lightOn)
                {
                    flashLightHelper.flashOff();
                    lightOn = false;
                }
                else
                {
                    flashLightHelper.flashOn();
                    lightOn = true;
                }
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

            if (lightOn)
            {
                flashLightHelper.flashOff();
                lightOn = false;
            }

            flashLightHelper.releaseCamera();

        }

       /* new CountDownTimer(4000, 100)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                if (lightOn)
                {
                    flashLightHelper.flashOff();
                    lightOn = false;
                }
                else
                {
                    flashLightHelper.flashOn();
                    lightOn = true;
                }
            }

            @Override
            public void onFinish()
            {
                if (lightOn)
                {
                    flashLightHelper.flashOff();
                    lightOn = false;
                }

                flashLightHelper.releaseCamera();
            }
        }.start();*/


    }

    boolean lightOn;
}