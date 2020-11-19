package com.chenzhiheng.service;

import com.chenzhiheng.model.Notice;
import com.chenzhiheng.vo.ResultVO;

import java.util.List;

public interface NoticeService {

    List<Notice> showAll(int pageNum, int pageSize);

    ResultVO saveNotice(Integer userId,String title,String content);

    Notice showNoticeById(Integer noticeId);
}
