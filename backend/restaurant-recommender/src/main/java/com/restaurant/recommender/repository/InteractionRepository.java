package com.restaurant.recommender.repository;

import com.restaurant.recommender.model.Interaction;
import com.restaurant.recommender.model.Restaurant;
import com.restaurant.recommender.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, UUID> {

    List<Interaction> findByUser(User user);

    List<Interaction> findByUserId(UUID userId);

    List<Interaction> findByUserAndRestaurant(User user, Restaurant restaurant);

    List<Interaction> findByRestaurant(Restaurant restaurant);

    List<Interaction> findByInteractionType(String interactionType);

    @Query("SELECT i FROM Interaction i WHERE i.user.id = :userId AND i.interactionType = :type")
    List<Interaction> findByUserAndInteractionType(@Param("userId") UUID userId, @Param("type") String interactionType);

    @Query("SELECT COUNT(i) FROM Interaction i WHERE i.user.id = :userId AND i.restaurant.id = :restaurantId")
    long countByUserAndRestaurant(@Param("userId") UUID userId, @Param("restaurantId") UUID restaurantId);
}