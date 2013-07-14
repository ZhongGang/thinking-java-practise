package com.icode.enums;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-14
 * Time: 下午6:07
 */
public class Main {

    public static void main(String[] args) {
        EnumSet<Status> statuses = EnumSet.allOf(Status.class);
        System.out.println(statuses.size());
        Iterator<Status> iterator = statuses.iterator();
        while (iterator.hasNext()) {
            Status next = iterator.next();
            System.out.println(next.name());
        }

        EnumMap<Status, String> model = new EnumMap<Status, String>(Status.class);

    }
}
