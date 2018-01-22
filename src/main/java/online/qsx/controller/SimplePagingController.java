package online.qsx.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import online.qsx.model.Page;


/**
 * ��ҳ������� Controller ��
 * 
 */
public abstract class SimplePagingController {
	protected Logger log = LoggerFactory.getLogger(getClass());

	public void handlePaging(HttpServletRequest request, Model model) throws Exception {
		//��ȡָ��ҳ�����ڼ�ҳ��
		String page = request.getParameter("page");

		//pageΪ�գ�Ĭ�ϲ�ѯ��1ҳ����
		int pageNo = StringUtils.isEmpty(page) ? 1 : Integer.valueOf(page);

		//��ѯ����
		Page<?> pageInfo = getPageInfo(request, pageNo);

		//����ҳ���ݷŵ�request�У��� jsp ҳ���н��н�������ʾ
		model.addAttribute("pageInfo", pageInfo);
	}

	protected abstract Page<?> getPageInfo(HttpServletRequest request, int pageNo);

}