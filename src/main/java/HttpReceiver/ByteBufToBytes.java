package HttpReceiver;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @ClassName ByteBufToBytes
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/18 11:42
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class ByteBufToBytes {
    private ByteBuf temp;

    private boolean end = true;

    public ByteBufToBytes(int length) {
        temp = Unpooled.buffer(length);
    }

    public void reading(ByteBuf datas) {
        datas.readBytes(temp, datas.readableBytes());
        if (this.temp.writableBytes() != 0) {
            end = false;
        } else {
            end = true;
        }
    }

    public boolean isEnd() {
        return end;
    }

    public byte[] readFull() {
        if (end) {
            byte[] contentByte = new byte[this.temp.readableBytes()];
            this.temp.readBytes(contentByte);
            this.temp.release();
            return contentByte;
        } else {
            return null;
        }
    }

    public byte[] read(ByteBuf datas) {
        byte[] bytes = new byte[datas.readableBytes()];
        datas.readBytes(bytes);
        return bytes;
    }
}
