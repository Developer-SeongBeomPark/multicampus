package com.example.sample;

import java.util.Map;

public interface UserMapper {

  int loginCheck(Map map);

  UserDTO read(String id);


}
