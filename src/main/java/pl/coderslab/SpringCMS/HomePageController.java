package pl.coderslab.SpringCMS;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
//@Transactional
public class HomePageController {

    @Autowired
    private ArticleDao articleDao;

    @GetMapping(name = "/HomePage")
    public String displayLastArticles(Model model){
        List<Article> articles = articleDao.findAllArticles();
        model.addAttribute("articles", articles);
        return "HomePage";
    }

    @GetMapping("/allArticles/{category_id}")
    public String displayAllArticlesByCat(@PathVariable String category_id, Model model){

        Long id = Long.parseLong(category_id);

        List<Article> articles = articleDao.allArticlesByCategory(id);

        model.addAttribute("articles", articles);

        return "HomePage";
    }
}
