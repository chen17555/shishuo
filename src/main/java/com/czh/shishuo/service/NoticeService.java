package com.czh.shishuo.service;

import com.czh.shishuo.model.Notice;
import com.czh.shishuo.vo.ResultVO;

import java.util.List;

public interface NoticeService {

    List<Notice> showAll(int pageNum, int pageSize);

    ResultVO saveNotice(Integer userId,String title,String content);

    Notice showNoticeById(Integer noticeId);
}
