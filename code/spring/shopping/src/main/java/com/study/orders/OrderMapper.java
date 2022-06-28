package com.study.orders;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

  int createOrder(OrdersDTO dto);//orderno가 리턴되도록 구현
  
  void createDetail(OrderdetailDTO odto);

  List<OrdersDTO> list(Map map);

  int total(Map map);

  int updateState(Map map);
}
