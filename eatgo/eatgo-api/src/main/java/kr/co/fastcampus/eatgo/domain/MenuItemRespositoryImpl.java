package kr.co.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemRespositoryImpl implements MenuItemRepository{
    private List<MenuItem> menuItems = new ArrayList<>();

    public MenuItemRespositoryImpl(){
        menuItems.add(new MenuItem("Kimchi"));
    }

    public List<MenuItem> findAllByRestaurantId(Long restaurantId) {
        return menuItems;
    }
}
