/**
 *  AbstractDao.java
 */
package me.link98.core.dao.impl;

import java.util.Date;
import java.util.List;

import me.link98.core.dao.BaseDao;
import me.link98.core.domains.AbstractBean;
import me.link98.core.domains.AbstractRecordBean;
import me.link98.core.utils.Pagination;
import me.link98.core.utils.mybatis.page.CountParameter;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @author fengmengyue
 * @since 2014年6月23日
 */
public abstract class AbstractDao<T extends AbstractBean> extends SqlSessionDaoSupport implements BaseDao<T> {

	private static final String INSERT = ".insert";
	private static final String UPDATE = ".update";
	private static final String DELETE = ".delete";
	private static final String SELECTBYID = ".selectById";
	private static final String SELECT = ".select";
	
	protected abstract String getNameSapce();
	
	@Override
	public void insert(T entity) {
		if(entity instanceof AbstractRecordBean){
			AbstractRecordBean et = (AbstractRecordBean)entity;
			et.setCreateTime(new Date());
			et.setLastUpdateTime(new Date());
		}
		getSqlSession().insert(getNameSapce() + INSERT , entity);
	}
	
	@Override
	public int insertBatch(List<T> entitys) {
		for(T entity : entitys){
			insert(entity);
		}
		return entitys.size();
	}

	@Override
	public int update(T entity) {
		if(entity instanceof AbstractRecordBean){
			AbstractRecordBean et = (AbstractRecordBean)entity;
			et.setLastUpdateTime(new Date());
		}
		return getSqlSession().update(getNameSapce() + UPDATE , entity);
	}
	
	@Override
	public int updateBatch(List<T> entitys) {
		for(T entity : entitys){
			update(entity);
		}
		return entitys.size();
	}

	@Override
	public int delete(T entity) {
		return delete(entity.getId());
	}
	
	@Override
	public int delete(String id) {
		return getSqlSession().delete(getNameSapce() + DELETE , id);
	}

	@Override
	public T select(Integer id) {
		List<T> listData = getSqlSession().selectList(getNameSapce() + SELECTBYID, id); 
		return listData.size() > 0? listData.get(0) : null;
	}
	
	@Override
	public List<T> queryByEntity(T entity) {
		return getSqlSession().selectList(getNameSapce() + SELECT, entity);
	}

	@Override
	public Pagination<T> queryByEntity(T entity, Pagination<T> pagination) {
		return queryPagination(getNameSapce() + SELECT, entity, pagination);
	}
	
	/**
	 * 查询结果集数量
	 * @param mapper
	 * @param param
	 * @return
	 */
	protected Integer queryCount(String mapper,Object param){
		if(StringUtils.isEmpty(mapper)){
			throw new IllegalArgumentException("mapper could not to be empty");
		}
		String countMapper = mapper + "Count";
		MappedStatement mappered = null;
		try{
			mappered = getSqlSession().getConfiguration().getMappedStatement(countMapper);
		}catch(Exception e){
			//undo
		}
		int count = 0;
		if(mappered != null){
			//有统计sql
			count = (Integer) getSqlSession().selectOne(countMapper, param);
		}else{
			//无统计sql
			count = (Integer) getSqlSession().selectOne(mapper, new CountParameter(param));
		}
		return count;
	}
	
	/**
	 * 分页查询
	 * @param mapper
	 * @param param
	 * @param pagination
	 * @param clazz
	 * @return
	 */
	protected <K> Pagination<K> queryPagination(String mapper,Object param,Pagination<K> pagination){
		if(StringUtils.isEmpty(mapper)){
			throw new IllegalArgumentException("mapper could not to be empty");
		}
		int count = queryCount(mapper, param);
		pagination.setRecordCount(count);
		if(count > 0){
			List<K> list = getSqlSession().selectList(mapper, param, new RowBounds((pagination.getCurrentPage() - 1) * pagination.getPageSize(), pagination.getPageSize()));
			pagination.setItems(list);
		}
		return pagination;
	}
}
