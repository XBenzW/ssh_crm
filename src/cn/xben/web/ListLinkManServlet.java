package cn.xben.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.xben.domain.LinkMan;
import cn.xben.service.LinkManService;
import cn.xben.service.impl.LinkManServiceImpl;

/**
 * Servlet implementation class ListLinkManServlet
 */
@WebServlet("/ListLinkManServlet")
public class ListLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListLinkManServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LinkManService ls = new LinkManServiceImpl();
		// 1、获取数据
		String lkm_name = request.getParameter("lkm_name");
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		// 2.判断修改SQL语句
		if (lkm_name != null && !"".equals(lkm_name)) {
			dc.add(Restrictions.like("lkm_name", "%"+lkm_name+"%"));
		}
		
		List<LinkMan> list = ls.getAll(dc);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
