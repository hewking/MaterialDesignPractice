package com.example.designpartterns.templatemethod;

/**
 * Created by hewking on 2016/11/3.
 * 模板方法模式是父类与之类之间得关系，在父类中提供一个主方法，不可继承。再实现1...n 个方法或者抽象方法，子类实现、、
 * 。通过父类控制子类方法实现。
 */

public class TemplateMethodTest {
    public static void main(String[] args){
        AbrstractCalculatro calculatro = new Plus();
        System.out.println(calculatro.calculate(4,5));
    }
}
