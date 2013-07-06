package com.icode.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-5
 * Time: 下午11:53
 */
public class Main {

    public static void main(String[] args) {
        Map<Key, Value> model = new HashMap<Key, Value>();
        model.put(new Key(), new Value());
        model.put(new Key(), new Value());
        model.put(new Key(), new Value());
        model.put(new Key(), new Value());

        Set<Map.Entry<Key, Value>> entries = model.entrySet();
        for (Map.Entry<Key, Value> next : entries) {
            Key key = next.getKey();
            Value value = next.getValue();
            System.out.println(key.hashCode() + "  ---  " + value.toString());
        }

        Value value = model.get(new Key());
        System.out.println("Value is " + value);


        Key key = new Key();


        for (int i = 0; i < 1000; i++) {
            int h = 0;
            h ^= i;

            h ^= (h >>> 20) ^ (h >>> 12);
            h = h ^ (h >>> 7) ^ (h >>> 4);

            System.out.println(h);
        }
    }
}
