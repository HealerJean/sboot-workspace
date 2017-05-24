package com.studyinternetvialidate.AnimalController;

import com.studyinternetvialidate.ValidateAnimalForm.AnimalForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/*方法中Model参数，用于存放任意数据以便传递到页面，
注意Model仅仅是一个接口，spring框架会帮我们实例化具体的类并设置到该方法当中；上例我们在该model里放了一个key为“MSG”的attribute，页面上通过表达式就可以取得其值。

@Valid AnimalForm form，@Valid表示要对该form进行验证，具体验证规则就是根据上面【一】里提到；
spring框架会根据字段名称将页面传递过来的值绑定到animalForm中。
BindingResult result，spring框架会将验证结果设置到该参数，并将该参数放到model传递给页面。
        springMVC是非常灵活的，以下几种写法可以达到同样的效果：
 */
/**
 * Description
 * Created by HealerJean
 * DATE   2017/5/23 10:00.
 */
@Controller
public class AnimalController {

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public String doAdd(Model model,  @Valid AnimalForm form, BindingResult result){
        System.out.println("动物名：" + form.getOname());
        System.out.println("数量：" + form.getOcount());
        System.out.println("备注：" + form.getMemo());
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
                for (ObjectError error : list) {
                 System.out.println(error.getDefaultMessage());
                 }
            model.addAttribute("MSG", "出错啦！");
        }else{
            model.addAttribute("MSG", "提交成功！");
        }
        return "vialidate";
    }

}
