package com.czh.shishuo.vo;


import java.util.List;

public class PageVO {
    private Integer code ;

    private Long count;

    private List data;

    private String msg;

    private PageVO (){}

    public static PageVO success(List data,Long count){
        PageVO page = new PageVO();
        page.setCode(0);
        page.setCount(count);
        page.setData(data);
        page.setMsg("");
        return page;
    }

    public static PageVO error(String msg){
        PageVO page = new PageVO();
        page.setCode(-1);
        page.setMsg(msg);
        return page;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "code=" + code +
                ", count=" + count +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
