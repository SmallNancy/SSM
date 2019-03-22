package cn.nancy.sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nancy.service.LogService;
import cn.nancy.service.impl.LogServiceImpl;
@WebServlet("/show")
public class ShowSevlet extends HttpServlet{
	private LogService logService = new LogServiceImpl();
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  	req.setCharacterEncoding("utf-8");
    int pageSize = 2;
    String pageSizeStr = req.getParameter("pageSize");
    if(pageSizeStr != null && !pageSizeStr.equals("")) {
    	pageSize = Integer.parseInt(pageSizeStr);
    }
    int pageNumber = 1;
    String pageNumStr = req.getParameter("pageNumber");
    if(pageNumStr != null && !pageNumStr.equals("")) {
    	pageNumber = Integer.parseInt(pageNumStr);
    }
    req.setAttribute("pageinfo",logService.showPage(pageSize, pageNumber));
    req.getRequestDispatcher("/log.jsp").forward(req, resp);
  }
}
