package cn.nancy.service;

import java.io.IOException;
import java.util.List;

import cn.nancy.pojo.People;

public interface PeopleService {
   List<People> show()throws IOException;
}
