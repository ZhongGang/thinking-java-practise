package com.icode.enums;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-14
 * Time: 下午6:05
 */
public enum Status {

    START {
        @Override
        String display() {
            return "Start~~~~~";
        }
    },

    MIDDLE {
        @Override
        String display() {
            return "Middle~~~~~";
        }
    },

    END {
        @Override
        String display() {
            return "End~~~~~~~~";
        }
    };

    abstract String display();


    public static void main(String[] args) {
        EnumSet<Status> statuses = EnumSet.allOf(Status.class);
        System.out.println(statuses.size());
        Iterator<Status> iterator = statuses.iterator();
        while (iterator.hasNext()) {
            Status next = iterator.next();
            System.out.println(next.display());
        }
    }
}
