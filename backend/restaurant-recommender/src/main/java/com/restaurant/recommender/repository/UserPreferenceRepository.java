package com.restaurant.recommender.repository;

import com.restaurant.recommender.model.User;
import com.restaurant.recommender.model.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, UUID> {

    List<UserPreference> findByUser(User user);

    List<UserPreference> findByUserId(UUID userId);

    List<UserPreference> findByUserAndPreferenceType(User user, String preferenceType);

    List<UserPreference> findByUserAndPreferenceValue(User user, String preferenceValue);

    void deleteByUser(User user);
}