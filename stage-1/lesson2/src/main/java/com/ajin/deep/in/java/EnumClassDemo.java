package com.ajin.deep.in.java;

/**
 * 枚举Demo
 *
 * @author ajin
 */

public class EnumClassDemo {
    public static void main(String[] args) {
        System.out.println(CountingEnum.FIVE.valueAsString());
    }

}

/**
 * @author ajin
 */
enum CountingEnum implements Cloneable {

    ONE(1) {
        @Override
        public String valueAsString() {
            return String.valueOf(getValue());
        }
    },
    TWO(2) {
        @Override
        public String valueAsString() {
            return String.valueOf(getValue());
        }
    },
    THREE(3) {
        @Override
        public String valueAsString() {
            return String.valueOf(getValue());
        }
    },
    FOUR(4) {
        @Override
        public String valueAsString() {
            return String.valueOf(getValue());
        }
    },
    FIVE(5) {
        @Override
        public String valueAsString() {
            return String.valueOf(getValue());
        }
    };

    private int value;

    CountingEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public abstract String valueAsString();
}

/**
 * 枚举类：计数
 * 强类型约束
 *
 * @author ajin
 */
final class Counting {
    public static final Counting ONE = new Counting();
    public static final Counting TWO = new Counting();
    public static final Counting THREE = new Counting();
    public static final Counting FOUR = new Counting();
    public static final Counting FIVE = new Counting();


    private Counting() {

    }

}

