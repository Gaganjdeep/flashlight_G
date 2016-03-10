package androidsmart.blog.gagan.utillG;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;

/**
 * Created by gagandeep on 01 Mar 2016.
 */
public class FlashLightHelper
{

    private Camera camera;
    Camera.Parameters parametros;


    public boolean isFlashLightExist(Context context)
    {
        return context.getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }


    private void getCamera()
    {
        if (camera == null)
        {
            try
            {
                camera = Camera.open();
                parametros = camera.getParameters();
            }
            catch (RuntimeException e)
            {
            }
        }
    }

    public void flashOn()
    {

        if (camera == null || parametros == null)
        {
            getCamera();
        }
        if (camera == null || parametros == null)
        {
            return;
        }

        parametros = camera.getParameters();
        parametros.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parametros);
        camera.startPreview();

    }

    public void flashOff()
    {

        if (camera == null || parametros == null)
        {
            getCamera();
        }

        if (camera == null || parametros == null)
        {
            return;
        }


        parametros = camera.getParameters();
        parametros.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parametros);
        camera.stopPreview();

    }


    public void releaseCamera()
    {
        if (camera != null) {
            camera.release();
            camera = null;
        }
    }





}
