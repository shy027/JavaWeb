package com.example.weddemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo2")
public class demo2 extends HelloServlet{
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.返回网页
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<h1>测试返回网页</h1>");
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
