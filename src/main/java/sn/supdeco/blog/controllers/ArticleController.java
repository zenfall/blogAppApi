package sn.supdeco.blog.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sn.supdeco.blog.models.Article;
import sn.supdeco.blog.services.ArticleService;
import sn.supdeco.blog.services.dtos.ArticleCreationDto;

@RestController
@RequestMapping("/api/v1/articles")
@AllArgsConstructor
public class ArticleController {
    
    private final ArticleService articleService;

    @PostMapping("")
    public ResponseEntity<Article> createArticle(@RequestBody ArticleCreationDto articleDto){
        Article article = new Article();
        article.setContent(articleDto.getContent());
        article.setTitle(articleDto.getTitle());

        return ResponseEntity.ok(articleService.create(article));
    }

    @GetMapping("")
    public ResponseEntity<List<Article>> getAllArticle() {
        return ResponseEntity.ok(articleService.getAll());
    }

}
