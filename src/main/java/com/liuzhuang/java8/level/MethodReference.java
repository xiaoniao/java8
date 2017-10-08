package com.liuzhuang.java8.level;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by liuzhuang on 2017/10/8.
 */
public class MethodReference {

    public static void main(String[] args) {

        /**
         * java8 之前用法
         */
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        printList(hiddenFiles);

        /**
         * java8 Lambda
         */
        hiddenFiles = new File(".").listFiles((File pathname) -> pathname.isHidden());
        printList(hiddenFiles);

        /**
         * java8 方法引用 (把方法作为参数传递进去，方法是一等公民)
         */
        hiddenFiles = new File(".").listFiles(File::isHidden);
        printList(hiddenFiles);
    }

    private static void printList(File[] hiddenFiles) {
        for (int i = 0; i < hiddenFiles.length; i++) {
            System.out.println(hiddenFiles[i]);
        }
    }

}
