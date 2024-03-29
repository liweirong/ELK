package com.iris.elasticsearch.controller;

import com.iris.elasticsearch.model.BookBean;
import com.iris.elasticsearch.service.BookService;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author iris
 * @date 2019/6/24
 */
@RestController
public class ElasticController {
    @Autowired
    private BookService bookService;

 /*   @RequestMapping("/book/{id}")
    @ResponseBody
    public BookBean getBookById(@PathVariable String id) {
        Optional<BookBean> opt = bookService.findById(id);
        BookBean book = opt.get();
        System.out.println(book);
        return book;
    }

    @RequestMapping("/save")
    @ResponseBody
    public void Save() {
        BookBean book = new BookBean("1", "ES入门教程", "程裕强", "2018-10-01");
        System.out.println(book);
        bookService.save(book);
    }
*/

    @RequestMapping("/")
    @ResponseBody
    public Object search() {
        return bookService.search();
    }
}
