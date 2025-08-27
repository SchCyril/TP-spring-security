package fr.diginamic.tpuserspringsecurity.repositories;

import fr.diginamic.tpuserspringsecurity.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
