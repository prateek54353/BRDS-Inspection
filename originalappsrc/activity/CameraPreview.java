package bih.p003in.forestdept.activity;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.IOException;

/* loaded from: classes4.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private Camera mCamera;
    private SurfaceHolder mHolder;

    public CameraPreview(Context context, Camera camera) {
        super(context);
        this.mCamera = camera;
        SurfaceHolder holder = getHolder();
        this.mHolder = holder;
        holder.addCallback(this);
        this.mHolder.setType(3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (this.mHolder.getSurface() == null) {
            return;
        }
        try {
            this.mCamera.stopPreview();
        } catch (Exception e) {
        }
        try {
            this.mCamera.setPreviewDisplay(this.mHolder);
            this.mCamera.startPreview();
        } catch (Exception e2) {
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            Camera camera = this.mCamera;
            if (camera != null) {
                camera.setPreviewDisplay(holder);
                this.mCamera.startPreview();
            }
        } catch (IOException e) {
            Log.e("Error in camera preview", "Error setting camera preview: " + e.getMessage());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.stopPreview();
            this.mCamera.setPreviewCallback(null);
            this.mCamera.release();
            this.mCamera = null;
        }
    }
}