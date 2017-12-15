package queue;

public class PriorityBlockingQueue {


    public static void main(String args []){

        java.util.concurrent.PriorityBlockingQueue<Task> queue = new java.util.concurrent.PriorityBlockingQueue<Task>();
        queue.add(new Task("xiaoming1",3));
        queue.add(new Task("xiaoming2",4));
        queue.add(new Task("xiaoming3",1));

        System.out.println("容器：" + queue);
        try {
            System.out.println(queue.take().getId());
        } catch (InterruptedException e) {

        }
        System.out.println("容器：" + queue);


    }

}
