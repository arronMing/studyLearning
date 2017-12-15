package queue;

public class Task implements Comparable {

    private String name;

    private int id;

    public Task(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int compareTo(Object o) {
        Task task = (Task) o;
        return this.id > task.getId() ? 1 : (this.id < task.getId() ? -1 : 0);
    }
}
