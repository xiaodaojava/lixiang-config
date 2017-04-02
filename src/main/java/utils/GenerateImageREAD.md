#GenerateImage说明

##业务功能
输入一张图片

##技术点
 1. BufferedImage
 2. Graphics，Graphics2D
 3. ImageIO.write
 
 BufferedImage 创建一个画布
 Graphics = BufferedImage.getGraphics()
 拿到这个画布的画纸，对这个画笔进行定义，然后进行绘画  
 定义完成之后，通过ImageIO.write 输出到文件
 
 Graphics2D是Graphics的子类。如果需要更高级的操作，则选用Graphics。
