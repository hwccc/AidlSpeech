package com.didi365.speech.manager.bean;

import java.io.Serializable;

/**
 * hwc 保持包名跟主程序一致
 */

public class VoiceExtraBean implements Serializable {

    /**
     * 消息类型
     */
    protected int type;


    /**
     * 返回说话音量
     */
    private String volume;

    /**
     * 用户说话的结果
     */
    private String result;

    /**
     * 识别结果Id
     * 讯飞没有该字段
     */
    private String resultId;

    /**
     * 错误标识码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorMsg;

    /**
     * 语义
     */
    private String semantics;

    /**
     * 是否处于识别结束状态
     */
    private boolean islast;

    /**
     * 识别事件
     */
    private String speechAction;

    /**
     * 语义返回数据
     */
    private String semanticResult;


    public final static int TYPE_VOICE_VOLUME = 1;

    /**
     * 语音返回的结果
     */
    public final static int TYPE_VOICE_IDENTIFYING_CONTENT = 2;

    /**
     * 语音识别的语义
     */
    public final static int TYPE_VOICE_IDENTIFYING_SEMANTICS = 3;

    /**
     * 语音打开、关闭使用状态
     */
    public final static int TYPE_VOICE_MIC_OPEN_STATE = 4;

    /**
     * 语音确认指令
     */
    public final static int TYPE_VOICE_CONFIRM = 5;

    /**
     * 语音识别异常回调
     */
    public final static int TYPE_VOICE_SPEECH_ERROR = 6;

    private String wechatText;
    private String wechatUrl;
    private String wechatReply;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getSemantics() {
        return semantics;
    }

    public void setSemantics(String semantics) {
        this.semantics = semantics;
    }

    public boolean isIslast() {
        return islast;
    }

    public void setIslast(boolean islast) {
        this.islast = islast;
    }

    public String getSpeechAction() {
        return speechAction;
    }

    public void setSpeechAction(String speechAction) {
        this.speechAction = speechAction;
    }

    public String getWechatText() {
        return wechatText;
    }

    public void setWechatText(String wechatText) {
        this.wechatText = wechatText;
    }

    public String getWechatUrl() {
        return wechatUrl;
    }

    public void setWechatUrl(String wechatUrl) {
        this.wechatUrl = wechatUrl;
    }

    public String getWechatReply() {
        return wechatReply;
    }

    public void setWechatReply(String wechatReply) {
        this.wechatReply = wechatReply;
    }

    public String getSemanticResult() {
        return semanticResult;
    }

    public void setSemanticResult(String semanticResult) {
        this.semanticResult = semanticResult;
    }

    public VoiceExtraBean(Builder builder) {
        this.type = builder.type;
        this.volume = builder.volume;
        this.result = builder.result;
        this.resultId = builder.resultId;
        this.errorCode = builder.errorCode;
        this.errorMsg = builder.errorMsg;
        this.semantics = builder.semantics;
        this.islast = builder.islast;
        this.speechAction = builder.speechAction;
        this.wechatText = builder.wechatText;
        this.wechatUrl = builder.wechatUrl;
        this.wechatReply = builder.wechatReply;
        this.semanticResult = builder.semanticResult;
    }

    @Override
    public String toString() {
        return "VoiceExtraBean{" +
                "type=" + type +
                ", volume='" + volume + '\'' +
                ", result='" + result + '\'' +
                ", resultId='" + resultId + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", semantics='" + semantics + '\'' +
                ", islast=" + islast +
                ", speechAction='" + speechAction + '\'' +
                ", semanticResult='" + semanticResult + '\'' +
                ", wechatText='" + wechatText + '\'' +
                ", wechatUrl='" + wechatUrl + '\'' +
                ", wechatReply='" + wechatReply + '\'' +
                '}';
    }

    public static class Builder implements Serializable {
        private int type;
        private String volume;
        private String result;
        private String resultId;
        private String errorCode;
        private String errorMsg;
        private String semantics;
        private boolean islast;
        private String speechAction;
        private String wechatText;
        private String wechatUrl;
        private String wechatReply;
        private String semanticResult;

        public Builder type(int type) {
            this.type = type;
            return this;
        }

        public Builder volume(String volume) {
            this.volume = volume;
            return this;
        }

        public Builder result(String result) {
            this.result = result;
            return this;
        }

        public Builder resultId(String resultId) {
            this.resultId = resultId;
            return this;
        }

        public Builder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder errorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public Builder semantics(String semantics) {
            this.semantics = semantics;
            return this;
        }


        public Builder islast(boolean islast) {
            this.islast = islast;
            return this;
        }

        public Builder speechAction(String speechAction) {
            this.speechAction = speechAction;
            return this;
        }

        public Builder wechatText(String wechatText) {
            this.wechatText = wechatText;
            return this;
        }

        public Builder wechatUrl(String wechatUrl) {
            this.wechatUrl = wechatUrl;
            return this;
        }

        public Builder wechatReply(String wechatReply) {
            this.wechatReply = wechatReply;
            return this;
        }

        public Builder semanticResult(String semanticResult) {
            this.semanticResult = semanticResult;
            return this;
        }

        public VoiceExtraBean build() {
            return new VoiceExtraBean(this);
        }
    }
}
