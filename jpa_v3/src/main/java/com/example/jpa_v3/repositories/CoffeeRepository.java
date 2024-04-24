package com.example.jpa_v3.repositories;

import com.example.jpa_v3.entitites.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long>{
//    // Dễ
//    // version rút gọn
//    Coffee findByName(String name);
//    // vesion đầy đủ
//    Coffee findCoffeeByName(String name);
//
//    Coffee findAllByName(String name);
//
//    // Trung bình
//    // findDistinct là tìm kiếm loại bỏ đi các đối tượng trùng nhay
//    List<Coffee> findDistinctByName(String name);
//    List<Coffee> findCoffeeDistinctByName(String name);
//
//    // IgnoreCase là tìm kiếm không phân biệt hoa-thường
//    List<Coffee> findByNameIgnoreCase(String name);
//
//    // AllIgnoreCase là không phân biệt hoa thường cho tất cả thuộc tính
//    List<Coffee> findByNameAllIgnoreCase(String name);
//
//    // OrderBy là cách sắp xếp thứ tự trả về
//    // Sắp xếp theo name ASC
//    List<Coffee> findByNameOrderByNameAsc(String name);
//    // Sắp xếp theo name Desc
//    List<Coffee> findByNameOrderByNameDesc(String name);

    // TEST THẬT
    List<Coffee> findAllByName(String name);

    List<Coffee> findAllByPriceBetween(int start, int end);

    @Query("SELECT c FROM Coffee c WHERE c.price IN :price")
    Coffee findCoffeeByPrice(@Param("price") Integer price);

    List<Coffee> findAllByPriceGreaterThan(int price);
}
