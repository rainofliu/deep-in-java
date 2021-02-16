package com.ajin.deep.in.java.io.filesystem.traditional.filechange;

import java.io.File;
import java.util.Observable;

/**
 * 文件变化事件 {@link FileChangedEvent} 发布器
 *
 * @author ajin
 */

public class FileChangedEventPublisher extends Observable {

    public void publish(File changedFile) {
        publish(new FileChangedEvent(changedFile));
    }

    public void publish(FileChangedEvent event) {
        // 标识状态已经改变
        super.setChanged();
        super.notifyObservers(event);
    }

    /**
     * 添加监听器
     *
     * @param fileChangedListener 监听器
     */
    public void addFileChangedListener(FileChangedListener fileChangedListener) {
        addObserver(fileChangedListener);
    }

    public static void main(String[] args) {
        // 创建 文件变化事件 发布器对象
        FileChangedEventPublisher publisher = new FileChangedEventPublisher();
        // 添加 文件变化 监听器
        publisher.addFileChangedListener(event -> System.out.println("处理文件变化事件:" + event));

        publisher.publish(new File("d:/test/test.log"));

    }

}
