package com.ajin.deep.in.java.io.filesystem.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static com.ajin.deep.in.java.io.filesystem.nio.PathDemo.USER_DIR_LOCATION;

/**
 * 基于{@link ByteChannel}的文件操作
 *
 * @author ajin
 * @see ByteChannel
 * @see ByteBuffer
 */
public class FileOperationsUsingByteChannelDemo {


    public static void main(String[] args) {
        Charset charset        = Charset.forName("UTF-8");
        Path    pomXmlPath     = Paths.get(USER_DIR_LOCATION, "deep-in-java.ipr");
        Path    pomXmlCopyPath = Paths.get(USER_DIR_LOCATION, "deep-in-java-copy.ipr");

        try (SeekableByteChannel sourceByteChannel = Files.newByteChannel(pomXmlPath);
            SeekableByteChannel targetByteChannel = Files.newByteChannel(pomXmlCopyPath, StandardOpenOption.CREATE_NEW,
                StandardOpenOption.WRITE)) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(16);

            while (sourceByteChannel.read(byteBuffer) > 0) {

                byteBuffer.rewind();

                // System.out.print(charset.decode(byteBuffer));

                targetByteChannel.write(byteBuffer);

                byteBuffer.flip();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.format("IOException ： %s \n", e.getMessage());
        }

    }

    // public static void main(String[] args) {
    //     Charset charset = Charset.forName("UTF-8");
    //     Path pomXmlPath = Paths.get(USER_DIR_LOCATION, "pom.xml");
    //     Path pomCopyXmlPath = Paths.get(USER_DIR_LOCATION, "pom-copy.xml");
    //     try (SeekableByteChannel sourceByteChannel = Files.newByteChannel(pomXmlPath);
    //         SeekableByteChannel targetByteChannel = Files.newByteChannel(pomCopyXmlPath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
    //     ) {
    //         ByteBuffer byteBuffer = ByteBuffer.allocate(16);
    //         while (sourceByteChannel.read(byteBuffer) > 0) {
    //             byteBuffer.rewind();
    //             //                System.out.print(charset.decode(byteBuffer));
    //             targetByteChannel.write(byteBuffer);
    //             byteBuffer.flip();
    //         }
    //     } catch (IOException e) {
    //
    //     }
    // }
}
