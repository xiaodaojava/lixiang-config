package red.lixiang.se.model;

/**
 * @Author lixiang
 * @CreateTime 2018/9/21
 **/
public class LX_FilePart {
    //文件名称
    private String fileName;
    //总共有多少块
    private Integer totalPart;
    //总共的长度
    private Long totalLength;
    //当前是哪一块
    private Integer currentPart;
    //当前块的字节
    private byte[] currentBytes;
    //每一块的大小
    private Integer partSize;

    public String getFileName() {
        return fileName;
    }

    public LX_FilePart setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public Integer getTotalPart() {
        return totalPart;
    }

    public LX_FilePart setTotalPart(Integer totalPart) {
        this.totalPart = totalPart;
        return this;
    }

    public Long getTotalLength() {
        return totalLength;
    }

    public LX_FilePart setTotalLength(Long totalLength) {
        this.totalLength = totalLength;
        return this;
    }

    public Integer getCurrentPart() {
        return currentPart;
    }

    public LX_FilePart setCurrentPart(Integer currentPart) {
        this.currentPart = currentPart;
        return this;
    }

    public byte[] getCurrentBytes() {
        return currentBytes;
    }

    public LX_FilePart setCurrentBytes(byte[] currentBytes) {
        this.currentBytes = currentBytes;
        return this;
    }

    public Integer getPartSize() {
        return this.currentBytes.length;
    }

    public LX_FilePart setPartSize(Integer partSize) {
        this.partSize = partSize;
        return this;
    }
}
