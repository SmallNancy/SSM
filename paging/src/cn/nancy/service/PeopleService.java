package cn.nancy.service;

import java.io.IOException;
import java.util.List;

import cn.nancy.pojo.PageInfo;
import cn.nancy.pojo.People;
/**
 * ��ҳ��ʾ
 * @author Nancy
 *
 */
public interface PeopleService {
	PageInfo show(int pageSize,int pageNumber) throws IOException;

}
