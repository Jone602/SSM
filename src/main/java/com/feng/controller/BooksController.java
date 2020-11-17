package com.feng.controller;
import com.feng.domain.Books;
import com.feng.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BooksController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BooksService booksService;
    //查询全部书籍，并返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String getList(Model model){
        List<Books> booksList = booksService.getBooksList();
        model.addAttribute("booksList",booksList);
        return "allBook";
    }
}
