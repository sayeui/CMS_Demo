package com.briup.cms;

import com.briup.cms.bean.Article;
import com.briup.cms.service.impl.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CmsTestApplicationTests {

    @Test
    void contextLoads() {
        findByCategoryTest();
    }

    public void findByCategoryTest() {
        ArticleServiceImpl service = new ArticleServiceImpl();
        List<Article> list = service.findByCategory(1l);
        list.forEach(System.out::println);
    }
}
