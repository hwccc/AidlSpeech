package com.hwc.speech.listener;

import com.didi365.speech.manager.bean.VoiceExtraBean;

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
     * @param speechCallBackState 识别状态：开始识别、识别中、识别异常、识别结束
     * @param state 识别结果状态（选项、翻页、取消）
     * @param position            选择的位置（从0开始）
     */
    void onStateCall(int speechCallBackState, VoiceExtraBean voiceExtraBean, String state, int position);

}
