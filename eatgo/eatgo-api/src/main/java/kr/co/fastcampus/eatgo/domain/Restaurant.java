package kr.co.fastcampus.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String name;
    private final String address;
    private final Long id;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

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

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems){
            addMenuItem(menuItem);
        }
    }
}
