package net.brilliant.framework.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import net.brilliant.common.CommonConstants;
import net.brilliant.framework.entity.RepoEntity;
import net.brilliant.framework.repository.BaseRepository;


public abstract class BaseServiceImpl<T extends RepoEntity, PK extends Serializable> extends ServiceImpl <T, PK>{
	private static final long serialVersionUID = -1326030262778654331L;

	protected abstract BaseRepository<T, PK> getRepository();

	protected Page<T> performSearch(String keyword, Pageable pageable){
		return DUMMY_PAGEABLE;
	}

	protected Page<T> getPaginatedObjects(Integer page, Integer size){
    PageRequest pageRequest = PageRequest.of(page-1, size, Sort.Direction.ASC, "id");
    return getRepository().findAll(pageRequest);
	}

	public Page<T> getList(Integer pageNumber) {
		return getPaginatedObjects(pageNumber, CommonConstants.DEFAULT_PAGE_SIZE);
	}

	public Page<T> getList(Integer pageNumber, Integer size) {
		return getPaginatedObjects(pageNumber, size);
	}

	public T save(T entity) {
		return getRepository().save(entity);
	}

	public List<T> saveObjects(List<T> objects) {
		return getRepository().saveAll(objects);
	}

	public T create(T entity) {
		return getRepository().save(entity);
	}

	public T get(PK id) {
		return getRepository().findById(id).orElse(null);
	}

	public T getById(PK id) {
		return get(id);
	}

	public void delete(PK id) {
		getRepository().deleteById(id);
	}

	public void delete(T entity) {
		getRepository().delete(entity);
	}

	public void deleteAll() {
		getRepository().deleteAll();
	}

	public T update(T entity) {
		return getRepository().saveAndFlush(entity);
	}

	public Long count() {
		return getRepository().count();
	}

	@Transactional(readOnly = true)
	public List<T> getAll() {
		List<T> results = new ArrayList<>();
		getRepository().findAll().forEach(results::add);
		return results;
	}
}