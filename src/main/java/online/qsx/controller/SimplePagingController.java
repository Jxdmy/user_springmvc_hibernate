package online.qsx.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import online.qsx.model.Page;


/**
 * 分页处理抽象 Controller 类
 * 
 */
public abstract class SimplePagingController {
	protected Logger log = LoggerFactory.getLogger(getClass());

	public void handlePaging(HttpServletRequest request, Model model) throws Exception {
		//获取指定页数（第几页）
		String page = request.getParameter("page");

		//page为空，默认查询第1页数据
		int pageNo = StringUtils.isEmpty(page) ? 1 : Integer.valueOf(page);

		//查询数据
		Page<?> pageInfo = getPageInfo(request, pageNo);

		//将分页数据放到request中，在 jsp 页面中进行解析和显示
		model.addAttribute("pageInfo", pageInfo);
	}

	protected abstract Page<?> getPageInfo(HttpServletRequest request, int pageNo);

}