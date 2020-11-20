package com.feng.controller;
import com.feng.domain.Books;
import com.feng.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
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
    //跳转到添加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    @RequestMapping("/addBook")
    public String addBook(Books books){
        booksService.addBook(books);
        return "redirect:allBook";
    }
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        booksService.deleteBook(id);
        return "redirect:allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model,int id){
        Books book = booksService.getBookById(id);
        model.addAttribute("book",book);
        return "updateBook";
    }
    @RequestMapping("/updateBook")
    public String upDateBook(Books books){
        booksService.updateBook(books);
        return "redirect:allBook";
    }

    @RequestMapping("/queryBookByName")
        public String queryBookByName(String bookName,Model model){
        Books books = booksService.queryBookByName(bookName);
        System.err.println("queryBookByName查询出来的books==>"+books);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        if (books==null){
            model.addAttribute("msg","未填写书籍名称");
            list = booksService.getBooksList();
        }
        model.addAttribute("booksList",list);
        return "allBook";
    }
}
