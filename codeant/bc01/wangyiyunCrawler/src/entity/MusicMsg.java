package entity;

/**
 * @author Li
 * @date 2019/3/19-18:51
 */
public class MusicMsg {
    public String id;
    public String name;

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

    public MusicMsg(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
