package helper;


import java.util.List;

import constant.PermissionConstants;
import utils.LogUtils;
import utils.PermissionUtils;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2018/01/06
 *     desc  : helper about permission
 * </pre>
 */
public class PermissionHelper {

    /**
     * 请求相机权限
     *
     * @param listener 回调
     */
    public static void requestCamera(final OnPermissionGrantedListener listener) {
        request(listener, PermissionConstants.CAMERA);
    }

    /**
     * 请求存储设备权限
     *
     * @param listener 回调
     */
    public static void requestStorage(final OnPermissionGrantedListener listener) {
        request(listener, PermissionConstants.STORAGE);
    }

    /**
     * 请求打电话权限
     *
     * @param listener 回调
     */
    public static void requestPhone(final OnPermissionGrantedListener listener) {
        request(listener, PermissionConstants.PHONE);
    }

    /**
     * 请求打电话权限
     *
     * @param grantedListener 授权回调
     * @param deniedListener  拒绝回调
     */
    public static void requestPhone(final OnPermissionGrantedListener grantedListener,
                                    final OnPermissionDeniedListener deniedListener) {
        request(grantedListener, deniedListener, PermissionConstants.PHONE);
    }

    /**
     * 请求发短信权限
     *
     * @param listener 回调
     */
    public static void requestSms(final OnPermissionGrantedListener listener) {
        request(listener, PermissionConstants.SMS);
    }

    /**
     * 请求位置权限
     *
     * @param listener 回调
     */
    public static void requestLocation(final OnPermissionGrantedListener listener) {
        request(listener, PermissionConstants.LOCATION);
    }

    /**
     * 请求多个权限
     *
     * @param grantedListener 授权回调
     * @param permissions     权限名称
     */
    private static void request(final OnPermissionGrantedListener grantedListener,
                                final @PermissionConstants.Permission String... permissions) {
        request(grantedListener, null, permissions);
    }

    /**
     * 请求多个权限
     *
     * @param grantedListener 授权回调
     * @param deniedListener  拒绝回调
     * @param permissions     权限名称
     */
    private static void request(final OnPermissionGrantedListener grantedListener,
                                final OnPermissionDeniedListener deniedListener,
                                final @PermissionConstants.Permission String... permissions) {
        PermissionUtils.permission(permissions)
                .rationale(new PermissionUtils.OnRationaleListener() {
                    @Override
                    public void rationale(ShouldRequest shouldRequest) {
                        DialogHelper.showRationaleDialog(shouldRequest);
                    }
                })
                .callback(new PermissionUtils.FullCallback() {
                    @Override
                    public void onGranted(List<String> permissionsGranted) {
                        if (grantedListener != null) {
                            grantedListener.onPermissionGranted();
                        }
                        LogUtils.d(permissionsGranted);
                    }

                    @Override
                    public void onDenied(List<String> permissionsDeniedForever, List<String> permissionsDenied) {
                        if (!permissionsDeniedForever.isEmpty()) {
                            DialogHelper.showOpenAppSettingDialog();
                        }
                        if (deniedListener != null) {
                            deniedListener.onPermissionDenied();
                        }
                        LogUtils.d(permissionsDeniedForever, permissionsDenied);
                    }
                })
                .request();
    }

    public interface OnPermissionGrantedListener {
        void onPermissionGranted();
    }

    public interface OnPermissionDeniedListener {
        void onPermissionDenied();
    }
}
