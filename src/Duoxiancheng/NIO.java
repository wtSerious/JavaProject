package Duoxiancheng;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

public class NIO {
    public static void main(String[] args) throws IOException {
        ByteBuffer buff = ByteBuffer.allocate(48);
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        int read = inChannel.read(buff);
        inChannel.write(buff);
    }
}
