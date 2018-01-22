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
 * 基于Spring JdbcTemplate实现的分页处理Helper
 * 
 * @author QingShiXun
 * 
 * @version 1.0
 */
public class JdbcPaginationHelper<T> {

    // 默认每页显示数据条数
    private static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 根据默认的page size获取分页数据
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
     * 根据指定的page size获取分页数据
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
        // 总记录数据
        final int rowCount = jdbcTemplate.queryForObject(countSql, args, Integer.class);

        // 计算总页数
        int pageCount = rowCount / pageSize;
        if (rowCount > pageSize * pageCount) {
            pageCount++;
        }

        //分页对象
        final Page<T> page = new Page<T>();
        //页数（第几页）
        page.setPageNo(pageNo);
        //总记录数
        page.setTotalCount(rowCount);
        //每页显示的记录条数
        page.setPageSize(pageSize);

        //根据pageNo取一页数据
        final int startRow = (pageNo - 1) * pageSize;

        //根据分页信息，查询数据
        jdbcTemplate.query(dataSql, args, new ResultSetExtractor<Page<T>>() {

            public Page<T> extractData(ResultSet rs) throws SQLException, DataAccessException {
                final List<T> pageItems = page.getResult();
                int currentRow = 0;

                //根据rowMapper填充数据对象
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

