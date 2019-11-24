package blog.com.controller;

import blog.com.model.Blog;
import blog.com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("/")
    public ModelAndView home(){
        List<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blogs", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public String saveBlog(@ModelAttribute("blogs") Blog  blog){
        blogService.save(blog);

        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blogs", blog);
        modelAndView.addObject("message", "New blog created successfully");
        return "redirect:/";
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("blog1", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("blogs", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }
    @PostMapping("/delete-blog")
    public String remove(@ModelAttribute("blog") Blog blog){
        blogService.remove(blog.getId());
        return "redirect:/";
    }


    @GetMapping("/view-blog/{id}")
    public ModelAndView showDetail(@PathVariable Long id){
        Blog blog = blogService.findById(id);

        if(blog != null) {
            ModelAndView modelAndView = new ModelAndView("/detail");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }
}
