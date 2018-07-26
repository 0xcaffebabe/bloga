package wang.ismy.bloga.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//该注解的作用是添加了该注解的方法，会被aspect所捕获，自动加入博客右侧的那些信息
@Retention(RetentionPolicy.RUNTIME)
public @interface BlogEdge {
}
