package com.study.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.study.model.BbsServiceImpl")
public class BbsServiceImpl implements BbsService{
  @Autowired
  private BbsMapper mapper;
  
  public List<BbsDTO> list(Map map) {
    // TODO Auto-generated method stub
    return mapper.list(map);
  }
  
  public int total(Map map) {
    return mapper.total(map);
  }

  public void upViewcnt(int bbsno) {
    mapper.upViewcnt(bbsno);
  }
  
  public BbsDTO read(int bbsno) {
    return mapper.read(bbsno);
  }
  
  public int create(BbsDTO dto) {
    return mapper.create(dto);
  }

  @Override
  public int update(BbsDTO dto) {
    // TODO Auto-generated method stub
    return mapper.update(dto);
  }
  
  public int passCheck(Map map) {
    return mapper.passCheck(map);
  }
  
  public int delete(int bbsno) {
    return mapper.delete(bbsno);
  }

  @Override
  public BbsDTO readreply(int bbsno) {
    // TODO Auto-generated method stub
    return mapper.readreply(bbsno);
  }

  @Override
  public void upAnsnum(Map map) {
    // TODO Auto-generated method stub
    mapper.upAnsnum(map);
  }

  @Override
  public int createReply(BbsDTO dto) {
    // TODO Auto-generated method stub
    return mapper.createReply(dto);
  }

  @Override
  public int checkRefnum(int bbsno) {
    // TODO Auto-generated method stub
    return mapper.checkRefnum(bbsno);
  }
}
