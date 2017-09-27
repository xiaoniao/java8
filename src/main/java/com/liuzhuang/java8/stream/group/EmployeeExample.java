package com.liuzhuang.java8.stream.group;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by liuzz on 2017/9/27.
 * <p>
 * http://www.importnew.com/17313.html
 */
public class EmployeeExample {
    private static Logger log = LoggerFactory.getLogger(EmployeeExample.class);

    public static void main(String[] args) {

//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(new Employee("Alice", "London", 200));
//        employeeList.add(new Employee("Bob", "London", 150));
//        employeeList.add(new Employee("Charles", "New York", 160));
//        employeeList.add(new Employee("Dorothy", "Hong Kong", 190));
//
//        Map<String, List<Employee>> employeesByCity = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity));
//        employeesByCity.forEach((k, v) -> log.info("k:{},v:{}", k, v));
//
//        Map<String, Long> numEmployeesByCity = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
//        numEmployeesByCity.forEach((k, v) -> log.info("k:{},v:{}", k, v));
//
//        Map<String, Double> avgSalesByCity = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.averagingInt(Employee::getSales)));
//        avgSalesByCity.forEach((k, v) -> log.info("k:{},v:{}", k, v));
//
//
////        employeeList.stream().collect(Collectors.partitioningBy(e->e.get));
//
//
//        List<Employee> pageEmployee = employeeList.stream().skip(10).limit(1).collect(Collectors.toList());
//        pageEmployee.forEach(e -> log.info("e:{},", e));
//
//
        // page(studentNoList, 10, 10);

        List<String> studentNoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            studentNoList.add(String.valueOf(i));
        }

        List<Employee> result = batchQuery(studentNoList).stream()
                .map(s-> queryFromDataSource(s))
                .flatMap(s->s.stream()).collect(Collectors.toList());
        result.forEach(e -> log.info("e:{}", e.getCity()));
    }

    private static List<Employee> queryFromDataSource(List<String> queryList) {
        List<Employee> list = new ArrayList<>();
        queryList.forEach(s->list.add(new Employee(s, s, 100)));
        return list;
    }

    private static List<List<String>> batchQuery(List<String> studentNoList) {
        List<List<String>> result = new ArrayList<>();
        Integer pageSize = 10;
        Integer totalPage = totalPage(studentNoList, pageSize);
        for (Integer currentPage = 1; currentPage <= totalPage; currentPage++) {
            result.add(page(studentNoList, currentPage, pageSize));
        }
        return result;
    }

    private static List<String> page(List<String> studentNoList, Integer currentPage, Integer pageSize) {
        return studentNoList.stream().skip((currentPage - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    private static Integer totalPage(List<String> studentNoList, Integer pageSize) {
        return studentNoList.size() / pageSize + (studentNoList.size() % pageSize > 0 ? 1 : 0);
    }

    /**
     if (currentPage <= 0) {
     currentPage = 1;
     }
     if (pageSize <= 0) {
     pageSize = 10;
     }
     if (currentPage > (totalPage = totalPage(studentNoList, pageSize))) {
     currentPage = totalPage;
     }
     */
}
