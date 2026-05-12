package com.restaurant.recommender.repository;

import com.restaurant.recommender.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

    List<Restaurant> findByCuisineType(String cuisineType);

    List<Restaurant> findByCity(String city);

    List<Restaurant> findByPriceRange(String priceRange);

    @Query("SELECT r FROM Restaurant r WHERE r.cuisineType IN :cuisineTypes")
    List<Restaurant> findByCuisineTypes(@Param("cuisineTypes") List<String> cuisineTypes);

    @Query("SELECT DISTINCT r.cuisineType FROM Restaurant r ORDER BY r.cuisineType")
    List<String> findAllCuisineTypes();

    @Query("SELECT DISTINCT r.city FROM Restaurant r ORDER BY r.city")
    List<String> findAllCities();
}