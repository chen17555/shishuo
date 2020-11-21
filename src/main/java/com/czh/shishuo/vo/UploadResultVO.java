package com.czh.shishuo.vo;

public class UploadResultVO {

    private Integer success;

    private String message;

    private String url;

    private UploadResultVO(){}

    public static UploadResultVO success(String msg,String url){
        UploadResultVO uploadResultVO = new UploadResultVO();
        uploadResultVO.setMessage(msg);
        uploadResultVO.setUrl(url);
        uploadResultVO.setSuccess(1);
        return uploadResultVO;
    }

    public static UploadResultVO success(String url){
        return success(null,url);
    }

    public static UploadResultVO error(String msg){
        UploadResultVO uploadResultVO = new UploadResultVO();
        uploadResultVO.setMessage(msg);
        uploadResultVO.setSuccess(0);
        return uploadResultVO;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UploadResultVO{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
