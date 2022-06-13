package com.study.model;

import java.util.List;
import java.util.Map;

public interface IntegrationMapper {

  List<DTO> list(Map map);

  int total(Map map);

  void upViewcnt(int bbsno);

  DTO read(int bbsno);

  int create(DTO dto);

  int update(DTO dto);

  int passCheck(Map map);

  int delete(int bbsno);

  DTO readReply(int bbsno);

  void upAnsnum(Map map);

  int createReply(DTO dto);
  
  // ============ addr =================

  List<DTO> a_list(Map map);

  int a_total(Map map);

  DTO a_read(int addressnum);

  int a_create(DTO dto);

  int a_update(DTO dto);

  int a_delete(int addressnum);
  
  //============ memo =================

  List<DTO> m_list(Map map);

  int m_total(Map map);

  int m_create(DTO dto);

  DTO m_read(int memono);

  int m_passCheck(Map map);

  int m_update(DTO dto);

  int m_delete(Map map);

  DTO m_readReply(int memono);

  void m_upAnsnum(Map map);

  int m_createReply(DTO dto);

  void m_upViewcnt(int memono);

}
