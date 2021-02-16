package com.ajin.deep.in.java.io.filesystem.traditional.filechange;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * 文件监听器
 *
 * @author ajin
 */
public class FileMonitor {
    /**
     * Key : 被监视 File 对象
     */
    private Map<File, Long> lastModifiedSnapshot = new LinkedHashMap<>();

    /**
     * 定时任务 线程池
     */
    @SuppressWarnings("all")
    private ScheduledExecutorService poolingWatchingService = Executors.newScheduledThreadPool(1);

    /**
     * 事件发布器
     */
    private FileChangedEventPublisher eventPublisher = new FileChangedEventPublisher();

    private void addListeners(FileChangedListener fileChangedListener, FileChangedListener... otherListeners) {
        eventPublisher.addFileChangedListener(fileChangedListener);
        Stream.of(otherListeners).forEach(eventPublisher::addFileChangedListener);
    }

    /**
     * 将文件监视起来
     *
     * @param monitoredFile 被监视的文件
     */
    public void monitor(File monitoredFile) {
        updateLastModifiedSnapshot(monitoredFile);

        poolingWatchingService.scheduleAtFixedRate(() -> {
            // 当前文件 最后被修改的时间戳
            long currentLastModified = monitoredFile.lastModified();
            // 当前文件 在 lastModifiedSnapshot Map中记录的 最后被修改的时间戳
            Long previousLastModified = lastModifiedSnapshot.putIfAbsent(monitoredFile, currentLastModified);
            // 证明 文件修改过了
            if (previousLastModified != null && currentLastModified > previousLastModified) {
                // 发布事件
                eventPublisher.publish(monitoredFile);
                // 修改Map的value： lastModified
                updateLastModifiedSnapshot(monitoredFile);
            }

        }, 0L, 5L, TimeUnit.SECONDS);

    }

    private void updateLastModifiedSnapshot(File monitoredFile) {
        lastModifiedSnapshot.put(monitoredFile, monitoredFile.lastModified());
    }

    public static void main(String[] args) {
        FileMonitor fileMonitor = new FileMonitor();

        fileMonitor.addListeners(event -> System.out.println("处理文件变化事件：" + event));

        fileMonitor.monitor(new File("D:\\gitRepository\\小马哥\\segmentfault-lessons\\「一入 Java 深似海 」\\代码\\segmentfault\\deep-in-java\\stage-8\\stage-8-lesson-2\\src\\main\\java\\com\\segmentfault\\deep\\in\\java\\filesystem"));
    }

}
