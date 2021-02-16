package com.ajin.deep.in.java.io.filesystem.traditional.filechange;

import java.io.File;
import java.util.EventObject;

/**
 * 文件{@link File}变化事件
 *
 * @author ajin
 */

public class FileChangedEvent extends EventObject {

    public FileChangedEvent(File source) {
        super(source);
    }

    @Override
    public File getSource() {
        return (File)super.getSource();
    }
}
