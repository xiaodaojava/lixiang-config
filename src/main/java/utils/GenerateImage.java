package utils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by lixiang on 02/04/2017.
 */
public class GenerateImage {

    private BufferedImage image;

    //图片的宽度
    private static final int imageWidth = 215;

    //图片的高度
    private static final int imageHeight = 132;

    public void graphicsGeneration(String name, String id, String classname) throws IOException {



        image = new BufferedImage(imageWidth, imageHeight,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("宋体",Font.BOLD,20));
        graphics.drawString("步步高裤行欢迎您", 50, 75);

        graphics.drawString("货号 : " + name, 50, 75);
        graphics.drawString("颜色 : " + id, 50, 150);
        graphics.drawString("尺码 : " + classname, 50, 225);

        ImageIO.write(image,"PNG",new File("2.png"));
        graphics.dispose();



    }

    public static void main(String[] args) {
        GenerateImage cg = new GenerateImage();
        try {
            cg.graphicsGeneration("ewew", "1", "12");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
