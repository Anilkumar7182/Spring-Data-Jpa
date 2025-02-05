package com.p1.repo;

import org.springframework.data.repository.CrudRepository;
import com.p1.entity.Student;
import java.util.List;


public interface StudentRepo extends CrudRepository<Student, Integer>{
	
//	SELECT * FROM Student WHERE name = ?;
	
	public List<Student> findByName(String name);
	
	public List<Student> findByEmail(String email);
	
	public List<Student> findByAge(Integer age);
	
	// And Or
	
//	SELECT * FROM Student WHERE name = ? AND age = ?;
//	SELECT * FROM Student WHERE name = ? OR age = ?;

	
	public List<Student> findByNameAndEmail(String name,String email);

	public List<Student> findByNameOrEmail(String name,String email);
	
	// LessThan, GreaterThan, Between
	
//	SELECT * FROM Student WHERE age > ?;
//	SELECT * FROM Student WHERE age < ?;
//	SELECT * FROM Student WHERE age BETWEEN ? AND ?;

	
	public List<Student> findByAgeGreaterThan(Integer id);
	
	public List<Student> findByAgeLessThan(Integer id);
	
	public List<Student> findByAgeBetween(Integer start, Integer end);
	
	
	// Like, StartsWith, EndsWith, Contains
	
//	SELECT * FROM Student WHERE name LIKE ?;
//	SELECT * FROM Student WHERE name LIKE 'prefix%';
//	SELECT * FROM Student WHERE name LIKE '%suffix';
//	SELECT * FROM Student WHERE name LIKE '%keyword%';
	
	public List<Student> findByNameLike(String name);
	public List<Student> findByNameStartingWith(String prefix);
	public List<Student> findByNameEndingWith(String suffix);
	public List<Student> findByNameContaining(String keyword);
	
	// OrderBy for Sorting
	
//	SELECT * FROM Student WHERE name = ? ORDER BY age ASC;
//	SELECT * FROM Student WHERE name = ? ORDER BY age DESC;
	
	public List<Student> findByNameOrderByAgeAsc(String name);
	public List<Student> findByNameOrderByAgeDesc(String name);
	
	// Top & First to Limit Results
	
//	SELECT * FROM Student ORDER BY age ASC LIMIT 1;
//	SELECT * FROM Student ORDER BY salary DESC LIMIT 1;
	
//	public Student findFirstByNameAsc();
//	public Student findTopByOrderByNameDesc();
	
	// Boolean Columns
	
//	SELECT * FROM Student WHERE is_active = TRUE;
//	SELECT * FROM Student WHERE is_active = FALSE;
	
//	List<Student> findByIsActiveTrue();  // Get all active users
//	List<Student> findByIsActiveFalse(); // Get all inactive users
	
	// In for Lists
	
	//SELECT * FROM Student WHERE id IN (?,?,?);
	
	List<Student> findByIdIn(List<Long> id);
	
}
