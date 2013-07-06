package com.icode.file;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-6
 * Time: 下午2:39
 */
public class FileReaderCreator {
    private static List<FileCreatable> creatables = new ArrayList<FileCreatable>();

    static {
        creatables.add(new FileNameFileReaderCreator());
        creatables.add(new FileFileReaderCreator());
        creatables.add(new FileDescriptorFileReaderCreator());
    }

    public static FileReader create(Object object) throws FileNotFoundException {
        for (FileCreatable creatable : creatables) {
            if (creatable.support(object)) {
                return creatable.create(object);
            }
        }
        throw new UnsupportedOperationException("Does not support the object type: " + object.getClass().getName());
    }

    private interface FileCreatable {

        boolean support(Object object);

        FileReader create(Object object) throws FileNotFoundException;
    }

    private static class FileNameFileReaderCreator implements FileCreatable {

        @Override
        public boolean support(Object object) {
            return object instanceof String;
        }

        @Override
        public FileReader create(Object object) throws FileNotFoundException {
            String fileName = (String) object;
            return new FileReader(fileName);
        }
    }

    private static class FileFileReaderCreator implements FileCreatable {

        @Override
        public boolean support(Object object) {
            return object instanceof File;
        }

        @Override
        public FileReader create(Object object) throws FileNotFoundException {
            File file = (File) object;
            return new FileReader(file);
        }
    }

    private static class FileDescriptorFileReaderCreator implements FileCreatable {

        @Override
        public boolean support(Object object) {
            return object instanceof FileDescriptor;
        }

        @Override
        public FileReader create(Object object) {
            FileDescriptor fileDescriptor = (FileDescriptor) object;
            return new FileReader(fileDescriptor);
        }
    }
}
