package com.iris.elasticsearch.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author iris
 * @date 2019/6/24
 */
@Document(indexName = "book", type = "_doc")
public class BookBean {
        @Id
        private String id;
        private String title;
        private String author;
        private String postDate;

        public BookBean(){}

        public BookBean(String id, String title, String author, String postDate){
            this.id=id;
            this.title=title;
            this.author=author;
            this.postDate=postDate;
        }



        @Override
        public String toString() {
            return "BookBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", postDate='" + postDate + '\'' +
                    '}';
        }

}
