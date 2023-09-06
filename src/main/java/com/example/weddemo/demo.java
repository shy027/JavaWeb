package com.example.weddemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/demo")
public class demo extends HelloServlet{
    @Override
    public void init() {
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //返回一个验证码
        int len = 4;
        int fontsize = 40;
        int width = len * fontsize + 10;
        int height = fontsize + 15;
        String code = getCode();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = bufferedImage.getGraphics();
        //背景色
        g.setColor(Color.WHITE);
        //填充矩形
        g.fillRect(0,0,width,height);
        //画线和圆
        Random r = new Random();
        for (int i = 0 ; i < 50;i++){
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            int x1 = r.nextInt(width);
            int x2 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int y2 = r.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
            int x = r.nextInt(width);
            int y =r.nextInt(height);
            g.drawOval(x,y,1,1);
        }
        //验证码
        g.setFont(new Font("宋体",Font.BOLD,fontsize));
        for (int i =0; i < len; i++){
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            char c = code.charAt(i);
            g.drawString(c + "", i * fontsize + 5,fontsize);
        }
        //输出
        ImageIO.write(bufferedImage,"jpg", response.getOutputStream());

    }
    //4位随机数字和字母
    private String getCode(){
        String all = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        sb.append("");
        for (int i =0 ; i < 4 ;i++){
            sb.append(all.charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
