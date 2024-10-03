package uz.ksan.backend.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.ksan.backend.shop.model.ShopEntity;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {
    Optional<ShopEntity> findAllByShopName(String shopName);
    List<ShopEntity> findAll();

    @Query("select param from ShopEntity param where " +
            "(:country is null or param.country = :country) and " +
            "(:city is null or param.city = :city) or " +
            "(:rating is null or param.rating >= :rating) " )
    List<ShopEntity> findShopsByFilter(@Param("country") String country,
                                       @Param("city") String city,
                                       @Param("rating") Integer rating);

}
