package com.restaurant.recommender.repository;

import com.restaurant.recommender.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, UUID> {

    List<ChatMessage> findBySessionIdOrderByCreatedAtAsc(UUID sessionId);

    List<ChatMessage> findByUserIdOrderByCreatedAtDesc(UUID userId);

    @Query("SELECT DISTINCT cm.sessionId FROM ChatMessage cm WHERE cm.user.id = :userId ORDER BY cm.createdAt DESC")
    List<UUID> findDistinctSessionIdsByUserId(@Param("userId") UUID userId);

    @Query("SELECT cm FROM ChatMessage cm WHERE cm.user.id = :userId AND cm.sessionId = :sessionId ORDER BY cm.createdAt ASC")
    List<ChatMessage> findByUserIdAndSessionIdOrderByCreatedAtAsc(
            @Param("userId") UUID userId, 
            @Param("sessionId") UUID sessionId);

    void deleteBySessionId(UUID sessionId);
}