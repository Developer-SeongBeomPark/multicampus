package com.study.cart;

import java.util.List;

public interface CartMapper {

  int create(CartDTO dto);

  List<CartDTO> list(String id);

  int delete(int cartno);

  void deleteAll(String id);

}
