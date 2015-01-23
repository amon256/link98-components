/**
 *  AbstractService.java
 */
package me.link98.core.service.impl;

import java.util.List;

import me.link98.core.dao.BaseDao;
import me.link98.core.domains.AbstractBean;
import me.link98.core.service.BaseService;
import me.link98.core.utils.Pagination;

/**
 * @author fengmengyue
 * @since 2014年6月23日
 */
public abstract class AbstractService<T extends AbstractBean> implements BaseService<T> {

	/**
	 * dao
	 * @return
	 */
	protected abstract BaseDao<T> getDao(); 
	
	@Override
	public void insert(T entity) {
		getDao().insert(entity);
	}

	@Override
	public int update(T entity) {
		return getDao().update(entity);
	}

	@Override
	public int delete(T entity) {
		return getDao().delete(entity);
	}

	@Override
	public T getById(Integer id) {
		return getDao().select(id);
	}

	@Override
	public List<T> queryByEntity(T entity) {
		return getDao().queryByEntity(entity);
	}
	
	@Override
	public Pagination<T> queryByEntity(T entity, Pagination<T> pagination) {
		return getDao().queryByEntity(entity, pagination);
	}
}
