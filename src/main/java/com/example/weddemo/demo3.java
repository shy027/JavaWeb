package com.example.weddemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo3")
public class demo3 extends HelloServlet{
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //返回一段JSON数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String jsonString = """
    {
    "shy":"shy",
    "age":19
    }
    """;
        out.print(jsonString);
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
