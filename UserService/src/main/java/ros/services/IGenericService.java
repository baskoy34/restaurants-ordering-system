package ros.services;

import ros.helpers.ErrorHandling;

import java.util.List;

public interface IGenericService <T> {
	
	T findById(Long id) throws ErrorHandling;
	
	void deleteById(Long id) throws ErrorHandling;
	
	T Update(T entity) throws ErrorHandling;
	
	List<T> findAll(Long id) throws ErrorHandling;
	
	T Add(T entity) throws Exception;
	
}
