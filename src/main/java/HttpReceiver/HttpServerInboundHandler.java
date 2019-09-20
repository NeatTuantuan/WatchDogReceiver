package HttpReceiver;

import com.mysql.jdbc.Util;
import entity.*;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import net.sf.json.JSONObject;

/**
 * @ClassName HttpServerInboundHandler
 * @Description TODO
 * @Auther tuantuan
 * @Date 2019/9/18 11:38
 * @Version 1.0
 * @Attention Copyright (C)，2004-2019，BDILab，XiDian University
 **/
public class HttpServerInboundHandler extends ChannelInboundHandlerAdapter{
    private ByteBufToBytes reader;
    private String messageType = null;
    private String resultStr = null;
    private JSONObject jsonObject = null;
    private Message message = null;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof HttpRequest) {
            HttpRequest request = (HttpRequest) msg;
            messageType = request.headers().get("messageType");
            System.out.println("messageType:" + request.headers().get("messageType"));
            if (HttpHeaders.isContentLengthSet(request)) {
                reader = new ByteBufToBytes((int) HttpHeaders.getContentLength(request));
            }
        }

        if (msg instanceof HttpContent) {
            HttpContent httpContent = (HttpContent) msg;
            ByteBuf content = httpContent.content();
            reader.reading(content);
            content.release();
            if (reader.isEnd()) {
                resultStr = new String(reader.readFull());
            }

            jsonObject = JSONObject.fromObject(resultStr);


            if (messageType == "Status"){
                Status status = (Status) JSONObject.toBean(jsonObject, Status.class);
                //入hbase
            }
            if (messageType.equals("Record")){
                Record record = (Record) JSONObject.toBean(jsonObject, Record.class);
                System.out.println(record);
                //入hbase
            }
            if(messageType == "PhotoUpload"){
                PhotoUpload photoUpload = (PhotoUpload) JSONObject.toBean(jsonObject, PhotoUpload.class);
                //入hbase
            }
            if (messageType.equals("HeartBeat"))
            {
                HeartBeat heartBeat1 = (HeartBeat)JSONObject.toBean(jsonObject, HeartBeat.class);
                System.out.println(heartBeat1);
                //入redis
            }

        }

    }
}
