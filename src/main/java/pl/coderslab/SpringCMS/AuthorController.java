package pl.coderslab.SpringCMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorDao authorDao;

    @GetMapping("/allAuthors")
    public String allCategory(Model model){
        List<Author> authors = authorDao.returnAllAuthors();
        model.addAttribute("authors", authors);
        return "allAuthors";
    }

    @GetMapping("/addAuthor")
    public String addCategory(Model model){
        Author author = new Author();
        model.addAttribute("author", author);
        return "addAuthor";
    }

    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute Author author, Model model){
        authorDao.addAuthor(author);
        model.addAttribute("authors", authorDao.returnAllAuthors());
        return "redirect: ../allAuthors";
    }

    @GetMapping("/removeAuthor/{id}")
    public String removeCategory(@PathVariable(name = "id") Long id , Model model){
        authorDao.removeAuthor(id);
        model.addAttribute("authors", authorDao.returnAllAuthors());
        return "redirect: ../allAuthors";
    }

    @GetMapping("/editAuthor/{id}")
    public String editAuthor(@PathVariable (name = "id") Long id , Model model){
        Author author = authorDao.findAuthorById(id);
        model.addAttribute("author", author);
        return "editAuthor";
    }

    @PostMapping("/editAuthor/{id}")
    public String editCategory(@ModelAttribute Author author, Model model){
        authorDao.editAuthor(author);
        model.addAttribute("authors", authorDao.returnAllAuthors());
        return "redirect: ../allAuthors";
    }
}
