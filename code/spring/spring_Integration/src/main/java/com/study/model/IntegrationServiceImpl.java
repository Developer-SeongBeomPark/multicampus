package com.study.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.study.model.IntegrationServiceImpl")
public class IntegrationServiceImpl implements IntegrationService {

  @Autowired
  private IntegrationMapper mapper;
  
  
  // =============== bbs ================
  @Override
  public List<DTO> list(Map map) {
    // TODO Auto-generated method stub
    return mapper.list(map);
  }

  @Override
  public int total(Map map) {
    // TODO Auto-generated method stub
    return mapper.total(map);
  }

  @Override
  public void upViewcnt(int bbsno) {
    // TODO Auto-generated method stub
    mapper.upViewcnt(bbsno);
  }

  @Override
  public DTO read(int bbsno) {
    // TODO Auto-generated method stub
    return mapper.read(bbsno);
  }

  @Override
  public int create(DTO dto) {
    // TODO Auto-generated method stub
    return mapper.create(dto);
  }

  @Override
  public int update(DTO dto) {
    // TODO Auto-generated method stub
    return mapper.update(dto);
  }

  @Override
  public int passCheck(Map map) {
    // TODO Auto-generated method stub
    return mapper.passCheck(map);
  }

  @Override
  public int delete(int bbsno) {
    // TODO Auto-generated method stub
    return mapper.delete(bbsno);
  }

  @Override
  public DTO readReply(int bbsno) {
    // TODO Auto-generated method stub
    return mapper.readReply(bbsno);
  }

  @Override
  public void upAnsnum(Map map) {
    // TODO Auto-generated method stub
    mapper.upAnsnum(map);
  }

  @Override
  public int createReply(DTO dto) {
    // TODO Auto-generated method stub
    return mapper.createReply(dto);
  }

  
  // ============ addr  ================
  
  @Override
  public List<DTO> a_list(Map map) {
    // TODO Auto-generated method stub
    return mapper.a_list(map);
  }

  @Override
  public int a_total(Map map) {
    // TODO Auto-generated method stub
    return mapper.a_total(map);
  }

  @Override
  public DTO a_read(int addressnum) {
    // TODO Auto-generated method stub
    return mapper.a_read(addressnum);
  }

  @Override
  public int a_create(DTO dto) {
    // TODO Auto-generated method stub
    return mapper.a_create(dto);
  }

  @Override
  public int a_update(DTO dto) {
    // TODO Auto-generated method stub
    return mapper.a_update(dto);
  }

  @Override
  public int a_delete(int addressnum) {
    // TODO Auto-generated method stub
    return mapper.a_delete(addressnum);
  }

  
  //============ memo  ================
  
  
  @Override
  public List<DTO> m_list(Map map) {
    // TODO Auto-generated method stub
    return mapper.m_list(map);
  }

  @Override
  public int m_total(Map map) {
    // TODO Auto-generated method stub
    return mapper.m_total(map);
  }

  @Override
  public int m_create(DTO dto) {
    // TODO Auto-generated method stub
    return mapper.m_create(dto);
  }

  @Override
  public DTO m_read(int memono) {
    // TODO Auto-generated method stub
    return mapper.m_read(memono);
  }

  @Override
  public int m_passCheck(Map map) {
    // TODO Auto-generated method stub
    return mapper.m_passCheck(map);
  }

  @Override
  public int m_update(DTO dto) {
    // TODO Auto-generated method stub
    return mapper.m_update(dto);
  }

  @Override
  public int m_delete(Map map) {
    // TODO Auto-generated method stub
    return mapper.m_delete(map);
  }

  @Override
  public DTO m_readReply(int memono) {
    // TODO Auto-generated method stub
    return mapper.m_readReply(memono);
  }

  @Override
  public void m_upAnsnum(Map map) {
    // TODO Auto-generated method stub
    mapper.m_upAnsnum(map);
  }

  @Override
  public int m_createReply(DTO dto) {
    // TODO Auto-generated method stub
    return mapper.m_createReply(dto);
  }

  @Override
  public void m_upViewcnt(int memono) {
    // TODO Auto-generated method stub
    mapper.m_upViewcnt(memono);
  }

}
