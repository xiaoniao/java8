package com.liuzhuang.java8.optional;

import java.util.Optional;

/**
 * Created by liuzhuang on 2017/9/4.
 *
 * 引入Optional
 * 类的意图并非要消除每一个null引用。与此相反，它的目标是帮助你更好地设计出普适的API，
 * 让程序员看到方法签名，就能了解它是否接受一个Optional的值。这种强制会让你更积极地将
 * 变量从Optional中解包出来，直面缺失的变量值。
 */
public class PersonNew {

    private Optional<CarNew> carNew;

    public Optional<CarNew> getCarNew() {
        return carNew;
    }
}
