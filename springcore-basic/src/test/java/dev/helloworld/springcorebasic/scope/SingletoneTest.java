package dev.helloworld.springcorebasic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletoneTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingleoneBean.class);
        SingleoneBean singletonBean1 = ac.getBean(SingleoneBean.class);
        SingleoneBean singletonBean2 = ac.getBean(SingleoneBean.class);

        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);

        Assertions.assertSame(singletonBean1, singletonBean2);
        ac.close();
    }


    @Scope("singleton")
    static class SingleoneBean {

        @PostConstruct
        public void init() {
            System.out.println("SingleoneBean.init");
        }
        @PreDestroy
        public void destroy() {
            System.out.println("SingleoneBean.destroy");
        }
    }
}
