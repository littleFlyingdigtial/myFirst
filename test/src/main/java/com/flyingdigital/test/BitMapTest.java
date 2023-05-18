package com.flyingdigital.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitMapTest {
    public static void main(String[] args) {
        Map<String, List<Integer>> schemaToTableName = new HashMap<>();

        List<Integer> tableNameList1 = new ArrayList<>();
        System.out.println("a_sheet1".hashCode());
        tableNameList1.add("a_sheet1".hashCode());
        tableNameList1.add("a_sheet2".hashCode());
        tableNameList1.add("a_sheet3".hashCode());
        tableNameList1.add("b_sheet".hashCode());
        schemaToTableName.put("LSQ", tableNameList1);



        List<Integer> tableNameList2 = new ArrayList<>();
        tableNameList2.add("a_sheet1".hashCode());
        tableNameList2.add("a_sheet21".hashCode());
        tableNameList2.add("a_sheet31".hashCode());
        tableNameList2.add("b_sheet1".hashCode());
        schemaToTableName.put("SCOTT", tableNameList2);


    }
}
