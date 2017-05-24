package com.studyinternetvialidate.MyValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

/**
 * Description
 * Created by HealerJean
 * DATE   2017/5/23 11:23.
 */
public class MemoValidator implements ConstraintValidator<MyValidateMemo, String> {

    @Override
    public void initialize(MyValidateMemo arg0) {
    }

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        HashSet<String> memoSet = new HashSet<String>();
        memoSet.add("圈养");
        memoSet.add("散养");
        return memoSet.contains(arg0);
    }

}