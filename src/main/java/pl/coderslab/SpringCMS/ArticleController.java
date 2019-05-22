package pl.coderslab.SpringCMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    ArticleDao articleDao;

    @Autowired
    AuthorDao authorDao;

    @GetMapping("/allArticles")
    public String allArticles(Model model){
        List<Article> articles = articleDao.returnAllArticles();
        model.addAttribute("articles", articles);
        return "allArticles";
    }

    @GetMapping("/addArticle")
    public String addArticle(Model model){
        Article article = new Article();
        model.addAttribute("article", article);
        model.addAttribute("authors", authorDao.returnAllAuthors());
        return "addArticle";
    }

    @PostMapping("/addArticle")
    public String addArticle(@ModelAttribute @Valid Article article, @ModelAttribute Author author, Model model, BindingResult result){

        if (result.hasErrors()) {
            return "addArticle";
        }

        articleDao.addArticle(article);
        model.addAttribute("articles", articleDao.returnAllArticles());
        return "redirect: ../allArticles";
    }

    @GetMapping("/removeArticle/{id}")
    public String removeCategory(@PathVariable(name = "id") Long id , Model model){
        articleDao.removeArticle(id);
        model.addAttribute("articles", articleDao.returnAllArticles());
        return "redirect: ../allArticles";
    }

    @GetMapping("/editArticle/{id}")
    public String editAuthor(@PathVariable (name = "id") Long id , Model model){
        Article article = articleDao.findArticleById(id);
        model.addAttribute("article", article);
        return "editArticle";
    }

    @PostMapping("/editArticle/{id}")
    public String editCategory(@ModelAttribute Article article, Model model){
        articleDao.editArticle(article);
        model.addAttribute("article", articleDao.returnAllArticles());
        return "redirect: ../allArticles";
    }
}
