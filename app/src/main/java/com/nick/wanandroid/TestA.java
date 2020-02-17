package com.nick.wanandroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/19 0019.
 *
 * @author Administrator
 */
public class TestA {
    public static void main(String[] args) {
        List<? super Baby> list = new ArrayList<>();
        list.add(new Baby());
        list.add(new C());
    }



}
class A {
}
class C  extends  Baby{
}

class Baby extends A{
}