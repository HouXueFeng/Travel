package com.xapi.Servlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.xapi.service.UserServiceimp;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	static Map buffers = new HashMap<String, Object>();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int width = 120;
		int height = 35;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D gra = (Graphics2D) image.getGraphics();
		// 3.画布设置颜色
		gra.setBackground(Color.white);
		gra.fillRect(0, 0, width, height);
		// 4.设置边框
		gra.setColor(Color.blue);
		gra.drawRect(0, 0, width - 1, height - 1);
		for (int i = 0; i < 5; i++) {
			gra.setColor(Color.RED);
			gra.drawLine(randomNum(0, width), randomNum(0, height), randomNum(
					0, width), randomNum(0, height));
		}
		StringBuffer buffer=new StringBuffer();
		String base = "侯雪枫侯雪枫侯雪枫侯雪枫";
		for (int i = 0; i < 4; i++) {
			gra.setColor(new Color(randomNum(0, 255), randomNum(0, 255),
					randomNum(0, 255)));
			gra.setFont(new Font("黑体", Font.BOLD, 20));
			// 字体旋转
			int r = randomNum(-45,45);
			gra.rotate(1.0*Math.PI*r/180,30 * i, 22);
			String str=base.charAt(randomNum(0,base.length()-1))+"";
			gra.drawString(str, 30 * i, 22);
			gra.rotate(-1.0*Math.PI*r/180,30 * i, 22);
			buffer.append(str);
			
		}	
		
		System.out.println(buffer);
		ImageIO.write(image, "jpg", response.getOutputStream());
	
		buffers.put("yanzhengma",buffer.toString());
		
	}
	
	  public static String buffers2(){
	      return (String) buffers.get("yanzhengma");
	    }
	//随机返回
	private int randomNum(int start, int end) {
		Random random = new Random();
		int r = random.nextInt(end - start) + start;
		return r;
	}
	
	
}
