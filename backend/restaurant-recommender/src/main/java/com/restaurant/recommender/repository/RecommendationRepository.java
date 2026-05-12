package com.restaurant.recommender.repository;

import com.restaurant.recommender.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, UUID> {

    List<Recommendation> findByUserIdOrderByScoreDesc(UUID userId);

    List<Recommendation> findByUserIdOrderByCreatedAtDesc(UUID userId);

    @Query("SELECT r FROM Recommendation r WHERE r.user.id = :userId ORDER BY r.score DESC")
    List<Recommendation> findTopRecommendationsByUserId(@Param("userId") UUID userId);

    @Query("SELECT r FROM Recommendation r WHERE r.user.id = :userId AND r.restaurant.id = :restaurantId")
    Recommendation findByUserIdAndRestaurantId(@Param("userId") UUID userId, @Param("restaurantId") UUID restaurantId);

    @Query("SELECT r FROM Recommendation r WHERE r.user.id = :userId ORDER BY r.score DESC LIMIT :limit")
    List<Recommendation> findTopNRecommendationsByUserId(@Param("userId") UUID userId, @Param("limit") int limit);

    void deleteByUserId(UUID userId);
}