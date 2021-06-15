package utils;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
public class CheckCode {
   private static int WIDTH=60;
   private static int HEIGHT=20;
   public void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        		HttpSession session = request.getSession();
        		response.setContentType("image/jpeg");
        		ServletOutputStream sos = response.getOutputStream();
        		response.setHeader("pragma","No-cache");
        		response.setHeader("Cache-Control","No-cache");
        		response.setDateHeader("Expires",0);
        		BufferedImage image=
        				new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        		Graphics g = image.getGraphics();
        		char[] rands = generateCheckCode();
        		drawBackgound(g);
        		drawRands(g,rands);
                g.dispose();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(image, "JPEG", bos);
                byte[] buf = bos.toByteArray();
                response.setContentLength(buf.length);
                bos.writeTo(sos);
                session.setAttribute("check_code",new String(rands));
                      }
     
            private char[]  generateCheckCode()
            {
            	String chars="0123456789abcdefghjklmopqrstuvwxyz";
            	char [] rands = new char[4];
            	for(int i=0;i<4;i++)
            	{
            		int rand=(int)(Math.random()*36);
            		rands[i]=chars.charAt(rand);
            	}
            	return rands;	
            }
        		private void drawRands(Graphics g, char[] rands)
        		{
        			g.setColor(Color.BLACK);
        			g.setFont(new Font(null,Font.ITALIC,18));
        			g.drawString(""+ rands[0],1,17);
        			g.drawString(""+ rands[1],16,15);
        			g.drawString(""+ rands[2],31,18);
        			g.drawString(""+ rands[3],46,16);
        			System.out.print(rands);
        		}
        		private void drawBackgound(Graphics g) {
        			
        			g.setColor(new Color(0xDCDCDC));
        			g.fillRect(0,0,WIDTH,HEIGHT);
        			for(int i =0;i<120; i++) {
        				int x =(int) (Math.random()*WIDTH);
        				int y =(int) (Math.random()*HEIGHT);
        				int red =(int) (Math.random()*255);
        				int green =(int) (Math.random()*255);
        				int blue =(int) (Math.random()*255);
        				g.setColor(new Color(red,green,blue));
        				g.drawOval(x, y, 1, 0);
        			}
        			
        		}
        		

}
