package uz.ksan.backend.shop.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.ksan.backend.shop.model.ShopEntity;
import uz.ksan.backend.shop.repository.ShopRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Primary
public class ShopServiceImpl implements uz.ksan.backend.shop.service.ShopService {

    private final ShopRepository shopRepository;

    @Override
    public void saveShop(ShopEntity shop) {
        shopRepository.save(shop);
    }

    @Override
    public ShopEntity updateShop(ShopEntity shop) {
        return shopRepository.save(shop);
    }

    public void deleteShopByShopName(String shopName) {
        var foundShop = findShopByShopName(shopName)
                .orElseThrow(() -> new NoSuchElementException("No shop found with name: " + shopName));
        shopRepository.delete(foundShop);
    }

    public Optional<ShopEntity> findShopByShopName(String shopName) {
        return Optional.ofNullable(shopRepository.findAllByShopName(shopName)
                .orElseThrow(() -> new NoSuchElementException("No shop found with name: " + shopName)));
    }

    public List<ShopEntity> findShopsByFilter(String country, String city, Integer rating) {
        return shopRepository.findShopsByFilter(country, city, rating);
    }
}
