package io.netty.serail;

import java.io.Serializable;

public class Resp implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String responseMessege;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponseMessege() {
        return responseMessege;
    }

    public void setResponseMessege(String responseMessege) {
        this.responseMessege = responseMessege;
    }
}
