package online.qsx.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import online.qsx.model.Page;

/**
 * ����Spring JdbcTemplateʵ�ֵķ�ҳ����Helper
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
public class JdbcPaginationHelper<T> {

    // Ĭ��ÿҳ��ʾ��������
    private static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * ����Ĭ�ϵ�page size��ȡ��ҳ����
     * 
     * @param jdbcTemplate
     * @param countSql
     * @param dataSql
     * @param args
     * @param pageNo
     * @param rowMapper
     * @return
     */
    public Page<T> fetchPage(final JdbcTemplate jdbcTemplate, final String countSql, final String dataSql, final Object args[], final int pageNo, final RowMapper<T> rowMapper) {
        return fetchPage(jdbcTemplate, countSql, dataSql, args, pageNo, DEFAULT_PAGE_SIZE, rowMapper);
    }

    /**
     * ����ָ����page size��ȡ��ҳ����
     * 
     * @param jdbcTemplate
     * @param countSql
     * @param dataSql
     * @param args
     * @param pageNo
     * @param pageSize
     * @param rowMapper
     * @return
     */
    public Page<T> fetchPage(final JdbcTemplate jdbcTemplate, final String countSql, final String dataSql, final Object args[], final int pageNo, final int pageSize, final RowMapper<T> rowMapper) {
        // �ܼ�¼����
        final int rowCount = jdbcTemplate.queryForObject(countSql, args, Integer.class);

        // ������ҳ��
        int pageCount = rowCount / pageSize;
        if (rowCount > pageSize * pageCount) {
            pageCount++;
        }

        //��ҳ����
        final Page<T> page = new Page<T>();
        //ҳ�����ڼ�ҳ��
        page.setPageNo(pageNo);
        //�ܼ�¼��
        page.setTotalCount(rowCount);
        //ÿҳ��ʾ�ļ�¼����
        page.setPageSize(pageSize);

        //����pageNoȡһҳ����
        final int startRow = (pageNo - 1) * pageSize;

        //���ݷ�ҳ��Ϣ����ѯ����
        jdbcTemplate.query(dataSql, args, new ResultSetExtractor<Page<T>>() {

            public Page<T> extractData(ResultSet rs) throws SQLException, DataAccessException {
                final List<T> pageItems = page.getResult();
                int currentRow = 0;

                //����rowMapper������ݶ���
                while (rs.next() && currentRow < startRow + pageSize) {
                    if (currentRow >= startRow) {
                        pageItems.add(rowMapper.mapRow(rs, currentRow));
                    }
                    currentRow++;
                }
                return page;
            }
        });
        return page;
    }
}

