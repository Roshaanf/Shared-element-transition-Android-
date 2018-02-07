package com.example.roshaan.sharedelementtransition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roshaan on 2/6/2018.
 */

public class DataRepository {

    public static List<Model> getItems(){

        List<Model> list=new ArrayList<>();
        list.add(new Model(R.drawable.st,"Ali"));
        list.add(new Model(R.drawable.st3,"John"));
        list.add(new Model(R.drawable.st4,"Akbar"));
        list.add(new Model(R.drawable.st5,"Noman"));
        list.add(new Model(R.drawable.st6,"Osama"));
        list.add(new Model(R.drawable.st7,"Jack"));
        list.add(new Model(R.drawable.st8,"Hall"));

        return list;
    }
}

