package com.studyinternetvialidate.ValidateAnimalForm;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.studyinternetvialidate.MyValidator.MyValidateMemo;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
/*

@NotEmpty：这个注解表示检查oname字段是不是为空字符串""或者是不是为null，如果是则给出提示信息："动物名：不能为空"。
        它支持的类型包括：字符序列CharSequence(CharBuffer, Segment, String, StringBuffer, StringBuilder)；集合Collection(ArrayList, HashSet, Stack, Vector等，很多)；Map以及数组arrays。它将检查所给对象的是不是为empty或者null，empty也就是长度为0，对于字符串来说就是""。
@NotNull：检查所标注元素ocount不能为null，如果是则给出提示信息：“数量：不能为空”。
        它支持任意类型，检查标注对象是否为null。注意和@NotEmpty的区别，她不检查对象是不是为empty。empty对于字符串来说是空字符串，对于集合以及map或数组来说就是所含元素数量为0。
@Range(min=, max=)：表示ocount元素的最小值是1，如果小于1,则给出信息：“数量：必须大于0”。
        支持类型：BigDecimal, BigInteger, CharSequence, byte, short, int, long 以及这些原始类型对应的wrapper（包装类）。它将检查所给对象的值是不是大于等于min且小于等于max。
@Size(min=, max=)：检查memo对象的长度不能超过10, 否则提示：“备注：长度不能超过10个字符”。
        适用于CharSequence, Collection, Map 以及数组，检查标注对象的size是大于等于min并且小于等于max。
        注意这么做验证是有问题的，比如oname输入几个空格它会验证通过，而对于ocount，在输入整数的情况下这完全没有问题，但是如果我们输入带小数点的数字或者输入非数字，或者空字符串的时候程序就会出现exception，这不是我们所希望的，具体的改进代码我们在篇末说明。
*/
/**
 * Description
 * Created by HealerJean
 * DATE   2017/5/23 9:54.
 */
public class AnimalForm {

    private long id;

    @NotEmpty(message="动物名: 不能为空")
    private String oname;

/*  第一种
    @Range(min = 1, message="数量: 必须大于0")
    @NotNull(message="数量: 不能为空")
    private int ocount;
*/
    // 加强第二种
    @NotBlank(message="数量: 不能为空")
    @Pattern(regexp="[1-9]{1,3}", message="数量X: 必须为正整数，并且0<X<1000")
    private String ocount;

/* 第一种
    @Size(max = 10, message="备注: 长度不能超过10个字符")
    private String memo;
*/
    @MyValidateMemo(message = "备注不能为空，且只能填写\"圈养\"，或者\"散养\"")
    private String memo;

    @DateTimeFormat( pattern = "yyyy-MM-dd")
//    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date date;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

/*
    public int getOcount() {
        return ocount;
    }

    public void setOcount(int ocount) {
        this.ocount = ocount;
    }
*/

    public String getOcount() {
        return ocount;
    }

    public void setOcount(String ocount) {
        this.ocount = ocount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

