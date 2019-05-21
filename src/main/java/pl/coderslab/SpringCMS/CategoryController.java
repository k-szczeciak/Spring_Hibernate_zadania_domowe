package pl.coderslab.SpringCMS;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @GetMapping("/allCategories")
    public String allCategory(Model model){
        List<Category> categories = categoryDao.returnAllCategories();
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
    public String addCategory(@ModelAttribute Category category, Model model){
        categoryDao.addCategory(category);
        model.addAttribute("categories", categoryDao.returnAllCategories());
        return "redirect: ../allCategories";
    }

    @GetMapping("/removeCategory/{id}")
    public String removeCategory(@PathVariable (name = "id") Long id , Model model){
        categoryDao.removeCategory(id);
        model.addAttribute("categories", categoryDao.returnAllCategories());
        return "redirect: ../allCategories";
    }

    @GetMapping("/editCategory/{id}")
    public String editCategory(@PathVariable (name = "id") Long id , Model model){
        Category category = categoryDao.findCategoryById(id);
        model.addAttribute("category", category);
        return "editCategory";
    }

    @PostMapping("/editCategory/{id}")
    public String editCategory(@ModelAttribute Category category, Model model){
        categoryDao.editCategory(category);
        model.addAttribute("categories", categoryDao.returnAllCategories());
        return "redirect: ../allCategories";
    }
}
