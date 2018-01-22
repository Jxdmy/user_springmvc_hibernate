package online.qsx.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.qsx.model.Page;


/**
 * �Զ����ҳ����Tag
 * 
 */
public class PagingTag extends BodyTagSupport {

    private static final long serialVersionUID = -3113884142868478454L;

    protected Logger log = LoggerFactory.getLogger(getClass());

    private String url;

    private String previousText = "��һҳ";

    private String nextText = "��һҳ";

    //Ĭ�Ϸ�ҳ��ʽ��light-theme������������ʽ��dark-theme��compact-theme
    private String cssStyle = "light-theme";

    private String pageNo = "";

    private String pageSize = "";

    private String totalCount = "";

    private String id = "qsxPagingBar";

    public int doStartTag() throws JspException {
        //���� tag ����
        url = evaluateString("url", url, pageContext);
        previousText = evaluateString("previousText", previousText, pageContext);
        nextText = evaluateString("nextText", nextText, pageContext);
        cssStyle = evaluateString("cssStyle", cssStyle, pageContext);

        pageNo = evaluateString("pageNo", pageNo, pageContext);
        pageSize = evaluateString("pageSize", pageSize, pageContext);
        totalCount = evaluateString("totalCount", totalCount, pageContext);

        return TagSupport.SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        String rootPath = ((HttpServletRequest) pageContext.getRequest()).getContextPath();
        // ��Request�л�ȡ��ҳ��Ϣ
        Page page = (Page) pageContext.getRequest().getAttribute("pageInfo");

        //���÷�ҳ��Ϣ
        if (page != null) {
            pageNo = String.valueOf(page.getPageNo());
            pageSize = String.valueOf(page.getPageSize());
            totalCount = String.valueOf(page.getTotalCount());
        }

        //���ݷ�ҳ��Ϣ����ʼ��pagination��ҳ���
        StringBuffer pagingingHtml = new StringBuffer("<div id='" + id + "' style='width:100%;text-align: center;margin:auto;'></div>");
        pagingingHtml.append("<script>$(function() {");
        pagingingHtml.append("$('#").append(id).append("').pagination({");
        pagingingHtml.append("items: ").append(totalCount).append(",");
        pagingingHtml.append("itemsOnPage: ").append(pageSize).append(",");
        pagingingHtml.append("currentPage:").append(pageNo).append(",");
        pagingingHtml.append("prevText:'").append(previousText).append("',");
        pagingingHtml.append("nextText:'").append(nextText).append("',");
        pagingingHtml.append("hrefTextPrefix:'").append(rootPath).append(url).append("',");
        pagingingHtml.append("cssStyle:'").append(cssStyle).append("'");
        pagingingHtml.append("});");
        pagingingHtml.append("});</script>");

        try {
            pageContext.getOut().println(pagingingHtml.toString());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new JspException(e);
        }
        return EVAL_PAGE;
    }

    /**
     * 
     * @param attributeName
     * @param expression
     * @param pageContext
     * @return
     * @throws JspException
     */
    public static String evaluateString(String attributeName, String expression, PageContext pageContext) throws JspException {
        return String.valueOf(ExpressionEvaluatorManager.evaluate(attributeName, expression, Object.class, pageContext));
    }

    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPreviousText() {
        return previousText;
    }

    public void setPreviousText(String previousText) {
        this.previousText = previousText;
    }

    public String getNextText() {
        return nextText;
    }

    public void setNextText(String nextText) {
        this.nextText = nextText;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


