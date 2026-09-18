package com.example.demo.GenericsDemo;

/**
 * ClassName: Demo
 * Package: com.example.demo.GenericsDemo
 * Description:
 *      创建一个简单的泛型类
 * @Author zxf
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        Demo1<String> demo = new Demo1<>();
        demo.setVar("1");
        System.out.println(demo.getVriable().length());
        System.out.println("----------------------------------------");
        NodePad<String,Integer> t = null ;        // 定义两个泛型类型的对象
        t = new NodePad<String,Integer>() ;       // 里面的key为String，value为Integer
        t.setKey("汤姆") ;        // 设置第一个内容
        t.setValue(20) ;            // 设置第二个内容
        System.out.print("姓名；" + t.getKey()) ;      // 取得信息
        System.out.print("，年龄；" + t.getValue()) ;       // 取得信息
        System.out.println();

        System.out.println("----------------------------------------");
        NoteDemo<String> i = null;        // 声明接口对象
        i = new NodeDemoImpl<String>("汤姆") ;  // 通过子类实例化对象
        System.out.println("内容：" + i.get()) ;

    }


}

class Demo1<T> {
    private T var;

    public T getVriable() {
        return var;
    }
    public void setVar(T var){  // 设置的类型也由外部决定
        this.var = var ;
    }
}
