package kr.co.fastcampus.eatgo.domain;

public class Restaurant {
    private final String name;
    private final String address;
    private final Long id;

    public Restaurant(Long id, String name, String address) {
        this.name = name;
        this.address = address;
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return name+" in " +address;
    }

    public Object getAddress() {
        return address;
    }


}
