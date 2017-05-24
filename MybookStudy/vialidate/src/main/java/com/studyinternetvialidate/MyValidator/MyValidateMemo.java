package com.studyinternetvialidate.MyValidator;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Description
 * Created by HealerJean
 * DATE   2017/5/23 11:22.
 */

    @Retention(RUNTIME)
    @Target({ FIELD, METHOD })
    @Constraint(validatedBy=MemoValidator.class)
    public @interface MyValidateMemo {

        String message() default "请输入正确的备注";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }
