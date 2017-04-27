package utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lixiang on 27/04/2017.
 */
public class GenerateQrcode {

    public static BufferedImage createQRCode(final String url) throws WriterException, IOException {
        BufferedImage image = null;
        //二维码图片输出流
        OutputStream out = null;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Map hints = new HashMap();
        // 设置编码方式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
        /*hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);*/
        BitMatrix bitMatrix = multiFormatWriter.encode(url, BarcodeFormat.QR_CODE, 400, 400,hints);
        bitMatrix = updateBit(bitMatrix,10);
        image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        return image;
    }

    /**
     * 自定义白边边框宽度
     *
     * @param matrix
     * @param margin
     * @return
     */
    private static BitMatrix updateBit(final BitMatrix matrix, final int margin) {
        int tempM = margin * 2;
        //获取二维码图案的属性
        int[] rec = matrix.getEnclosingRectangle();
        int resWidth = rec[2] + tempM;
        int resHeight = rec[3] + tempM;
        // 按照自定义边框生成新的BitMatrix
        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        //循环，将二维码图案绘制到新的bitMatrix中
        for (int i = margin; i < resWidth - margin; i++) {
            for (int j = margin; j < resHeight - margin; j++) {
                if (matrix.get(i - margin + rec[0], j - margin + rec[1])) {
                    resMatrix.set(i, j);
                }
            }
        }
        return resMatrix;
    }

    public static void main(String[] args) {

        //二维码图片输出流
        try{
            BufferedImage image = GenerateQrcode.createQRCode("http://www.bbgkh.shop");
            //实例化输出流对象
            //画图
            ImageIO.write(image, "png", new File("1.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
