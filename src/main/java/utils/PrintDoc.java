//package utils;
//
//import com.jacob.activeX.ActiveXComponent;
//import com.jacob.com.ComThread;
//import com.jacob.com.Dispatch;
//import com.jacob.com.Variant;
//
//
//
///**
// * Created by Administrator on 2017/4/2.
// */
//public class PrintDoc {
//    public static void main(String[] args) {
//        String path="C:\\test\\simple.docx";
//        System.out.println("开始打印");
//        try{
//            ComThread.InitSTA();
//            ActiveXComponent word=new ActiveXComponent("Word.Application");
//            Dispatch doc=null;
//            Dispatch.put(word, "Visible", new Variant(false));
//            Dispatch docs=word.getProperty("Documents").toDispatch();
//            doc=Dispatch.call(docs, "Open", path).toDispatch();
//            try {
//                Dispatch.call(doc, "PrintOut");//打印
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("打印失败");
//            }finally{
//                try {
//                    if(doc!=null){
//                        Dispatch.call(doc, "Close",new Variant(0));
//                    }
//                } catch (Exception e2) {
//                    e2.printStackTrace();
//                }
//                //释放资源
//                ComThread.Release();
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//
//    }
//}
