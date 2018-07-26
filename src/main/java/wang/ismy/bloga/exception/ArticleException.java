package wang.ismy.bloga.exception;

import wang.ismy.bloga.constant.ArticleEnum;

public class ArticleException extends RuntimeException {

    public ArticleException(ArticleEnum articleEnum) {
        super(articleEnum.getMsg());
    }
}
