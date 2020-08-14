package com.hwc.speech.listener;

/**
 * 选择场景语音识别回调
 *
 * @author hwc
 * @date 2018/08/09
 */

public interface OnSelectSceneListener {

    /**
     * 识别状态回调
     *
     * @param state 识别状态
     * @param position            选择的位置（从0开始）
     */
    void onStateCall(String state, int position);

}
