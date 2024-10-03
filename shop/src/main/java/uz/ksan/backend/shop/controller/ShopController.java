package uz.ksan.backend.shop.controller;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.ksan.backend.shop.model.ShopEntity;
import uz.ksan.backend.shop.repository.ShopRepository;
import uz.ksan.backend.shop.service.ShopService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Transactional
@RequestMapping("/api/v1/shop/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ShopController {

    @Autowired
    ShopService shopService;
    @Autowired
    ShopRepository shopRepository;

    @PostMapping
    public String saveShop(@RequestBody ShopEntity shop) {
        shopService.saveShop(shop);
        return "Shop added";
    }

    @DeleteMapping("{shopName}")
    public String deleteShop(@PathVariable String shopName) {
        shopService.deleteShopByShopName(shopName);
        return "Shop deleted";
    }

    @PutMapping
    public String updateShop(@RequestBody ShopEntity shop) {
        shopService.updateShop(shop);
        return "Shop updated";
    }

    @GetMapping
    public List<ShopEntity> findAllShops() {
        return shopRepository.findAll();
    }

    @GetMapping("filter/")
    public List<ShopEntity> findShopsByFilter(@RequestParam (required = false)String country,
                                              @RequestParam (required = false)String city,
                                              @RequestParam (required = false)Integer rating) {
        return shopRepository.findShopsByFilter(country,city,rating);
    }
}
