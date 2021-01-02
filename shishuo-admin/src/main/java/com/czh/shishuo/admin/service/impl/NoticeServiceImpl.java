package com.czh.shishuo.admin.service.impl;

import com.czh.shishuo.admin.dao.NoticeMapper;
import com.czh.shishuo.admin.service.NoticeService;
import com.czh.shishuo.model.Notice;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import com.czh.shishuo.vo.ResultVO;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
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
