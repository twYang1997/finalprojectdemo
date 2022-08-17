package com.finaldemo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FollowRepository extends JpaRepository<Follow, Integer> {
	
	@Query(value = "delete from Follow where fk_user_fans_id = :fansId and fk_user_follow_id = :followId", nativeQuery = true)
	@Modifying
	public void deleteFollowByFansIdAndFollowsId(@Param("fansId") Integer fansId, @Param("followId") Integer followId);
}
