package com.study.notice;

import java.util.List;
import java.util.Map;

public interface NoticeService {
  int create(NoticeDTO dto);
  List<NoticeDTO> list(Map map);
  int total(Map map);
  int passwd(Map map); 
  int update(NoticeDTO noticeDTO); 
  int delete(int noticeno);
  void upCnt(int noticeno);
  NoticeDTO read(int noticeno);
}
