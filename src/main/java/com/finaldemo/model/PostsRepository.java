/**
 * 
 */
package com.finaldemo.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostsRepository extends JpaRepository<Posts, Integer> {
	
	@Query(value="Select * from Posts where fk_user_id = :id", nativeQuery = true)
	public List<Posts> findPostsByUserId(@Param("id") Integer userId);

	@Transactional
	@Modifying
	@Query(value = "update Posts set whoCanSeeIt = :whoCanSeeIt where postId = :postId", nativeQuery = true)
	public void changeWhoCanSeeItById(@Param("whoCanSeeIt") Integer whoCanSeeIt, @Param("postId") Integer postId);
}
