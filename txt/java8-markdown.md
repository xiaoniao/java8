Java8（函数式编程，Lambda）
========

目的
---
函数式编程的特性，能够让我们花更少的时间写出更清晰，更简洁的代码。

Lambda
---
将方法（函数）作为参数

流
---
1. 和集合(collection)差不多
2. 新的编程风格，代码更简洁
3. 流被设计成无需同时将所有的数据调入内存（甚至根本无需计算），这样就可以处理无法装入计算机内存的流数据
4. 对同一个流的若干操作组合起来，但是只需遍历一次集合，而不是多次遍历它
5. 自动将流操作并行化

其他功能
---
1. 默认方法
2. Optional
3. CompletableFuture
4. 日期时间API



第一章 什么是java8
===
>- Lambda表达式
>- 方法引用
>- 流
>- 接口中的默认方法
>- 行为参数化


什么是函数式编程
---
    函数的排列组合。
    比如写两个只有几行代码不同的方法，那现在只需要把不同的那部分代码作为参数传递进去就可以了。
    一言以蔽之，这种被函数式编程界称为函数的代码，可以被来回传递并加以组合，以产生强大的编程语汇。


为什么需要流（多线程）
---
        程序员越来越多的要处理所谓的大数据（数百万兆甚至更多字节的数据集），并希望利用多核计算机或计算集权来有效地处理。这意味着需要使用并行处理 -- java以前对此并不支持


-

        但是在java8之前，使用多个内核必须使用线程。问题是线程用起来很难，也容易出现错误。从java的演变路径来看，它一直致力于让并发编程更容易、出错更少。java 1.0 里面有线程和锁，甚至有一个内存模型 - 这是当时的最佳做法，但事实证明，不具备专门知识的项目团队很难可靠地使用这些基本模型（ps. 的确基本很少使用，一般依赖框架来实现多线程）。java 5 添加了工业级的构建模块，如线程池和并发集合。java 7 添加了分支/合并 fork/join 框架，使得并行变得更使用，但仍然很困难。而java 8 对并行有了一个更简单的思路，不过需要遵循一些规则。（ps. 相当于由语言内部实现多线程并行，不需要用户干预了）

    
流
---
cat a b | tr "[A-Z]" "[a-z]" | sort | tail -3

行为参数化
---
TODO
建模

并行于共享的可变数据
---

java中的函数
---
        java中新增了函数-值的另一个新形式（也就是匿名内部类）

        一等公民，二等公民

将方法（方法引用ClassName::methodName）和Lambda作为一等公民

<pre>
<code>
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

</code>
</pre>


默认方法
---
