package com.liuzhuang.java8.stream.group;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liuzz on 2017/9/27.
 *
 *
 * Caused by: com.mysql.jdbc.PacketTooBigException: Packet for query is too large (5517669 > 4194304).
 * You can change this value on the server by setting the max_allowed_packet' variable.
 *
 * 分批查询，确保一次的数据量不超过packet大小
 */
public class BatchQueryUtils {
    private static Logger log = LoggerFactory.getLogger(BatchQueryUtils.class);

    public static void main(String[] args) {
        List<String> studentNoList = new ArrayList<>();
        for (int i = 0; i < 12; i++) studentNoList.add(String.valueOf(i));

        List<Employee> result = split(studentNoList, 10).stream().map(s -> queryFromDataSource(s)).flatMap(s -> s.stream()).collect(Collectors.toList());
        result.forEach(e -> log.info("e:{}", e.getCity()));
    }

    /**
     * 模拟数据库操作
     */
    private static List<Employee> queryFromDataSource(List<String> queryList) {
        List<Employee> list = new ArrayList<>();
        queryList.forEach(s -> list.add(new Employee(s, s, 100)));
        return list;
    }

    /**
     * 大集合切割成小集合，每份大小为size
     */
    private static <T> List<List<T>> split(List<T> studentNoList, Integer size) {
        List<List<T>> result = new ArrayList<>();
        Integer totalPage = totalPage(studentNoList, size);
        for (Integer currentPage = 1; currentPage <= totalPage; currentPage++) {
            result.add(page(studentNoList, currentPage, size));
        }
        return result;
    }

    private static <T> List<T> page(List<T> studentNoList, Integer currentPage, Integer pageSize) {
        return studentNoList.stream().skip((currentPage - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    private static <T> Integer totalPage(List<T> studentNoList, Integer pageSize) {
        return studentNoList.size() / pageSize + (studentNoList.size() % pageSize > 0 ? 1 : 0);
    }
}
