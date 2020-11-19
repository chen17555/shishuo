package com.chenzhiheng.service.impl;

import com.chenzhiheng.mapper.NoticeMapper;
import com.chenzhiheng.model.Notice;
import com.chenzhiheng.service.NoticeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chenzhiheng.vo.ResultVO;

import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> showAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return noticeMapper.selectAll();
    }

    @Override
    public ResultVO saveNotice(Integer userId,String title, String content) {
        Notice notice = new Notice();
        notice.setNoticeTitle(title);
        notice.setNoticeContent(content);
        notice.setCreateTime(new Date());
        noticeMapper.insert(notice);
        return null;
    }

    @Override
    public Notice showNoticeById(Integer noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }
}
