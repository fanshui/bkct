package com.bkct.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/stringreturn")
public class StringReturnController {

    @RequestMapping(value = "/logicViewNameResolverTest", method = {RequestMethod.GET})
    public String logicViewNameResolver() {
        return "logicview";
    }


    /**
     * redirect 方式相当于“response.sendRedirect()”，转发后浏览器的地址栏变为转发后的地址
     * 因为转发即执行了一个新的 request 和 response。
     由于新发起一个 request 原来的参数在转发时就不能传递到下一个 url，如果要传参数可以
     /item/queryItem.action 后边加参数，如下：
     /item/queryItem?...&
     * @return
     */
    @RequestMapping(value = "/redirectViewTest", method = {RequestMethod.GET, RequestMethod.POST})
    public String redirectView() {
//        return "redirect:/html/redirecthtm.html";
        return "redirect:logicViewNameResolverTest";
    }

    /**
     * controller 方法执行后继续执行另一个 controller 方法forward 方式相当于“request.getRequestDispatcher().forward(request,response)”，转发后浏
     览器地址栏还是原来的地址。转发并没有执行新的 request 和 response，而是和转发前的请
     求共用一个 request 和 response。所以转发前请求的参数在转发后仍然可以读取到
     * @return
     */
    @RequestMapping(value = "/forwardViewTest", method = {RequestMethod.GET, RequestMethod.POST})
    public String forwardView(String nickname, Model model) {
        model.addAttribute("nickname", nickname);
//        return "forward:/WEB-INF/jsp/requestDispatcherTest.jsp";
//        return "forward:/aj";
        return "redirect:/aj";
    }

}
