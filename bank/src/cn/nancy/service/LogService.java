package cn.nancy.service;

import java.io.IOException;

import cn.nancy.pojo.PageInfo;

public interface LogService {
  PageInfo  showPage(int pageSize,int pageNumber)throws IOException;
}
