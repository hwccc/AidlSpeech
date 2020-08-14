package com.hwc.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SpeechServiceUtil {

    private static final String TAG = SpeechServiceUtil.class.getSimpleName();

    private final String VOICE_PACKAGE_NAME = "com.miudrive.voice";

    private volatile static SpeechServiceUtil instance;

    public static SpeechServiceUtil getInstance() {
        if (instance == null) {
            synchronized (SpeechServiceUtil.class) {
                if (instance == null) {
                    instance = new SpeechServiceUtil();
                }
            }
        }
        return instance;
    }

    private SpeechServiceUtil() {

    }


    /**
     * 启动服务
     *
     * @return
     */
    public void startService(Context context) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_INSERT);
        intent.setData(Uri.parse("miudrive_voice://service"));
        intent.setPackage(VOICE_PACKAGE_NAME);
        context.startService(intent);
    }

    /**
     * 启动识别
     *
     * @return
     */
    public void start(Context context) {
        start(context, null);
    }

    /**
     * 启动识别
     *
     * @return
     */
    public void start(Context context, String result) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_INSERT);
        String s = "miudrive_voice://service?action=start";
        if (!TextUtils.isEmpty(result)) {
            try {
                result = URLEncoder.encode(result, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            s.concat("&result=").concat(result);
        }
        intent.setData(Uri.parse(s));
        intent.setPackage(VOICE_PACKAGE_NAME);
        context.startService(intent);
    }

    /**
     * 停止识别
     *
     * @return
     */
    public void stop(Context context) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_INSERT);
        intent.setData(Uri.parse("miudrive_voice://service?action=stop"));
        intent.setPackage(VOICE_PACKAGE_NAME);
        context.startService(intent);
    }

    /**
     * 显示语音使用帮助弹窗
     *
     * @return
     */
    public void showHelpDialog(Context context) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_INSERT);
        intent.setData(Uri.parse("miudrive_voice://service?action=showHelpDialog"));
        intent.setPackage(VOICE_PACKAGE_NAME);
        context.startService(intent);
    }

}
