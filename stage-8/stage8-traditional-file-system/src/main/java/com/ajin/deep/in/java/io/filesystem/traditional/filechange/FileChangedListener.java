package com.ajin.deep.in.java.io.filesystem.traditional.filechange;

import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Consumer;

/**
 * 文件变化事件 {@link FileChangedEvent} 监听器
 *
 * @author ajin
 */
@FunctionalInterface
public interface FileChangedListener extends EventListener, Observer, Consumer<FileChangedEvent> {

    void onChanged(FileChangedEvent event);

    @Override
    default void accept(FileChangedEvent event) {
        this.onChanged(event);
    }

    @Override
    default void update(Observable o, Object event) {
        if (event instanceof FileChangedEvent) {
            this.onChanged((FileChangedEvent)event);
        }
    }

}
