package com.example.sample;

import java.util.Map;

public interface UserService {

  int loginCheck(Map map);

  UserDTO read(String id);

}
