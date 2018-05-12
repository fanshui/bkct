package com.bkct.viewResolver;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

public class HtmlResourceView extends InternalResourceView {
    @Override
    public boolean checkResource(Locale locale) throws Exception {
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
//        System.out.println("****"+this.getServletContext().getRealPath("/") + getUrl());
//        System.out.println(file.exists());
        return file.exists();// 判断该页面是否存在
    }
}
