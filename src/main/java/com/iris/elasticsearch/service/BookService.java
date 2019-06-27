package com.iris.elasticsearch.service;

/**
 * @author iris
 * @date 2019/6/24
 */

import com.iris.elasticsearch.model.BookBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Object search();

}

