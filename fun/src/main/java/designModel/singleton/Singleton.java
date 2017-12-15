package designModel.singleton;

public class Singleton {


    private static Singleton instance = null;

    private Singleton() {
        System.out.println("初始化");
    }

    public static Singleton getInstance(){

        if (null == instance) {
            instance = new Singleton();
        }

        return instance;
    }


    public static void main(String args []){

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        if(singleton1 == singleton2){
            System.out.println("equal");
        }

    }


}
