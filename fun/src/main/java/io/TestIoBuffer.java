package io;

import java.nio.IntBuffer;

public class TestIoBuffer {


    public static void main(String args[]) {


        IntBuffer intBuffer = IntBuffer.allocate(10);
        intBuffer.put(13);
        intBuffer.put(14);
        intBuffer.put(15);
        intBuffer.flip();
        System.out.println("使用flip复位：" + intBuffer);
        System.out.println("容量为: " + intBuffer.capacity());      //容量一旦初始化后不允许改变（warp方法包裹数组除外）
        System.out.println("限制为: " + intBuffer.limit());            //由于只装载了三个元素,所以可读取或者操作的元素为3 则limit=3

        System.out.println("获取下标为1的元素：" + intBuffer.get(1));
        System.out.println("get(index)方法，position位置不改变：" + intBuffer);

        for (int i = 0; i < intBuffer.limit(); i++) {
            System.out.println(intBuffer.get());
        }
        System.out.println("buf对象遍历之后为: " + intBuffer);


    }

}
