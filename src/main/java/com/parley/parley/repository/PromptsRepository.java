package com.parley.parley.repository;


import com.parley.parley.models.Prompts;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@EnableScan
public interface PromptsRepository extends CrudRepository<Prompts, UUID> {
    Optional<Prompts> findByTitle(String title);

    List<Prompts> findByCategory(String category);
}
