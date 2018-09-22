package red.lixiang.se.utils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author lixiang
 * @CreateTime 2018/9/21
 **/
public class LX_ThreadUtils {

    public static void main(String[] args) {

        List<byte[]> a  = Arrays.asList(new byte[1]);
    }

    public static void sleep(Long seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {

        }
    }
}
