package uz.ksan.backend.shop.service;

import uz.ksan.backend.shop.model.ShopEntity;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    void saveShop(ShopEntity shop);
    void deleteShopByShopName(String shopName);
    ShopEntity updateShop(ShopEntity shop);
}
