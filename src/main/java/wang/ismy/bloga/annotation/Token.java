package wang.ismy.bloga.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//该注解的作用是添加了该注解的类，会被webserviceAspect所捕获，判断token，进而决定是否放行
@Retention(RetentionPolicy.RUNTIME)
public @interface Token{

}
