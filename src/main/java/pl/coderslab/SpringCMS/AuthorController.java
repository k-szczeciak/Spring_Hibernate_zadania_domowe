package pl.coderslab.SpringCMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/allAuthors")
    public String allCategory(Model model){
        List<Author> authors = authorRepository.findAll();
//        List<Author> authors = authorDao.returnAllAuthors();
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
    public String addAuthor(@ModelAttribute @Valid Author author, Model model, BindingResult result){
        if (result.hasErrors()) {
            return "addAuthor";
        }
//        authorDao.addAuthor(author);
        authorRepository.save(author);
        model.addAttribute("authors", authorRepository.findAll());
//        model.addAttribute("authors", authorDao.returnAllAuthors());
        return "redirect: ../allAuthors";
    }

    @GetMapping("/removeAuthor/{id}")
    public String removeCategory(@PathVariable(name = "id") Long id , Model model){
//        authorDao.removeAuthor(id);
        authorRepository.delete(id);
//        model.addAttribute("authors", authorDao.returnAllAuthors());
        model.addAttribute("authors", authorRepository.findAll());
        return "redirect: ../allAuthors";
    }

    @GetMapping("/editAuthor/{id}")
    public String editAuthor(@PathVariable (name = "id") Long id , Model model){
        Author author = authorRepository.findOne(id);
//        Author author = authorDao.findAuthorById(id);
        model.addAttribute("author", author);
        return "editAuthor";
    }

    @PostMapping("/editAuthor/{id}")
    public String editCategory(@ModelAttribute Author author, Model model){
//        authorDao.editAuthor(author);
        authorRepository.save(author);
        model.addAttribute("authors", authorRepository.findAll());
//        model.addAttribute("authors", authorDao.returnAllAuthors());
        return "redirect: ../allAuthors";
    }
}
