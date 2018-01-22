package online.qsx.model;

import java.util.List;

import com.google.common.collect.Lists;

public class Page<T> {
	// -- �������� --//
	public static final String ASC = "asc";
	public static final String DESC = "desc";

	// -- ��ҳ���� --//
	protected int pageNo = 1;
	protected int pageSize = 10;

	protected List<String> orders = Lists.newArrayList();
	protected List<String> orderBys = Lists.newArrayList();

	protected boolean autoCount = true;

	protected List<T> result = Lists.newArrayList();
	
	protected long totalCount = -1;

	public Page() {
	}

	public Page(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ��õ�ǰҳ��ҳ��,��Ŵ�1��ʼ,Ĭ��Ϊ1.
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * ���õ�ǰҳ��ҳ��,��Ŵ�1��ʼ,����1ʱ�Զ�����Ϊ1.
	 */
	public void setPageNo(final int pageNo) {
		this.pageNo = pageNo;

		if (pageNo < 1) {
			this.pageNo = 1;
		}
	}

	public Page<T> pageNo(final int thePageNo) {
		setPageNo(thePageNo);
		return this;
	}

	/**
	 * ���ÿҳ�ļ�¼����,Ĭ��Ϊ1.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * ����ÿҳ�ļ�¼����,����1ʱ�Զ�����Ϊ1.
	 */
	public void setPageSize(final int pageSize) {
		this.pageSize = pageSize;

		if (pageSize < 1) {
			this.pageSize = 1;
		}
	}

	public Page<T> pageSize(final int thePageSize) {
		setPageSize(thePageSize);
		return this;
	}

	/**
	 * ����pageNo��pageSize���㵱ǰҳ��һ����¼���ܽ�����е�λ��,��Ŵ�1��ʼ.
	 */
	public int getFirst() {
		return ((pageNo - 1) * pageSize) + 1;
	}

	/**
	 * �Ƿ������������ֶ�,��Ĭ��ֵ.
	 */
	public boolean isOrderBySetted() {
		return (getOrders().size() > 0 && getOrderBys().size() > 0);
	}

	public List<String> getOrders() {
		return orders;
	}

	public void setOrders(List<String> orders) {
		this.orders = orders;
	}

	public List<String> getOrderBys() {
		return orderBys;
	}

	public void setOrderBys(List<String> orderBys) {
		this.orderBys = orderBys;
	}

	public void addOrder(String order) {
		getOrders().add(order);
	}

	public void addOrderBy(String orderBy) {
		getOrderBys().add(orderBy);
	}

	/**
	 * ��ѯ����ʱ�Ƿ��Զ�����ִ��count��ѯ��ȡ�ܼ�¼��, Ĭ��Ϊfalse.
	 */
	public boolean isAutoCount() {
		return autoCount;
	}

	/**
	 * ��ѯ����ʱ�Ƿ��Զ�����ִ��count��ѯ��ȡ�ܼ�¼��.
	 */
	public void setAutoCount(final boolean autoCount) {
		this.autoCount = autoCount;
	}

	public Page<T> autoCount(final boolean theAutoCount) {
		setAutoCount(theAutoCount);
		return this;
	}

	// -- ���ʲ�ѯ������� --//

	/**
	 * ȡ��ҳ�ڵļ�¼�б�.
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * ����ҳ�ڵļ�¼�б�.
	 */
	public void setResult(final List<T> result) {
		this.result = result;
	}

	/**
	 * ȡ���ܼ�¼��, Ĭ��ֵΪ-1.
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * �����ܼ�¼��.
	 */
	public void setTotalCount(final long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * ����pageSize��totalCount������ҳ��, Ĭ��ֵΪ-1.
	 */
	public long getTotalPages() {
		if (totalCount < 0) {
			return -1;
		}

		long count = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			count++;
		}
		return count;
	}

	/**
	 * �Ƿ�����һҳ.
	 */
	public boolean isHasNext() {
		return (pageNo + 1 <= getTotalPages());
	}

	/**
	 * ȡ����ҳ��ҳ��, ��Ŵ�1��ʼ. ��ǰҳΪβҳʱ�Է���βҳ���.
	 */
	public int getNextPage() {
		if (isHasNext()) {
			return pageNo + 1;
		} else {
			return pageNo;
		}
	}

	/**
	 * �Ƿ�����һҳ.
	 */
	public boolean isHasPre() {
		return (pageNo - 1 >= 1);
	}

	/**
	 * ȡ����ҳ��ҳ��, ��Ŵ�1��ʼ. ��ǰҳΪ��ҳʱ������ҳ���.
	 */
	public int getPrePage() {
		if (isHasPre()) {
			return pageNo - 1;
		} else {
			return pageNo;
		}
	}
}

