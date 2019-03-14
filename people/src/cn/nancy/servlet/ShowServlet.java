package cn.nancy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nancy.pojo.People;
import cn.nancy.service.PeopleService;
import cn.nancy.service.impl.PeopleServiceImpl;

@WebServlet("/show")
public class ShowServlet extends HttpServlet{
	private PeopleService peopleService = new PeopleServiceImpl();
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<People> list = peopleService.show();
    req.setAttribute("list", list);
    req.getRequestDispatcher("index.jsp").forward(req, resp);
  }

}
