package com.liuzhuang.java8.optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Created by liuzhuang on 2017/9/4.
 */
public class OptionalUse {

    private static Logger log = LoggerFactory.getLogger(OptionalUse.class);

    public static void main(String[] args) {
        Insurance insurance = new Insurance();
        insurance.setName("JC");
        log.info("{}", getInsuranceName(insurance));
    }

    public static String getInsuranceName(Insurance insurance) {
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        return optInsurance.map(Insurance::getName).orElse("Unknown");
    }

    public static String getCarInsuranceName(Optional<PersonNew> person) {
        return person.flatMap(PersonNew::getCarNew)
                     .flatMap(CarNew::getInsurance)
                     .map(Insurance::getName)
                     .orElse("Unknown");
    }
}
