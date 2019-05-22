package pl.coderslab.SpringCMS;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/allCategories")
    public String allCategory(Model model){
//        List<Category> categories = categoryDao.returnAllCategories();
        List<Category> categories = categoryRepository.findAll();

        model.addAttribute("categories", categories);
        return "allCategories";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute @Valid Category category, Model model, BindingResult result){
        if (result.hasErrors()) {
            return "addCategory";
        }
//        categoryDao.addCategory(category);
        categoryRepository.save(category);
//        model.addAttribute("categories", categoryDao.returnAllCategories());
        model.addAttribute("categories", categoryRepository.findAll());
        return "redirect: ../allCategories";
    }

    @GetMapping("/removeCategory/{id}")
    public String removeCategory(@PathVariable (name = "id") Long id , Model model){
//        categoryDao.removeCategory(id);
         categoryRepository.delete(id);
//        model.addAttribute("categories", categoryDao.returnAllCategories());
        model.addAttribute("categories", categoryRepository.findAll());
        return "redirect: ../allCategories";
    }

    @GetMapping("/editCategory/{id}")
    public String editCategory(@PathVariable (name = "id") Long id , Model model){
//        Category category = categoryDao.findCategoryById(id);
        Category category = categoryRepository.findOne(id);
        model.addAttribute("category", category);
        return "editCategory";
    }

    @PostMapping("/editCategory/{id}")
    public String editCategory(@ModelAttribute Category category, Model model){
//        categoryDao.editCategory(category);
        categoryRepository.save(category);
//        model.addAttribute("categories", categoryDao.returnAllCategories());
        model.addAttribute("categories", categoryRepository.findAll());
        return "redirect: ../allCategories";
    }
}
