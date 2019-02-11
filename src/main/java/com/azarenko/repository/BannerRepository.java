package com.azarenko.repository;

import com.azarenko.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BannerRepository extends JpaRepository<Banner, Long> {

    List<Banner> getBannersByUser_Id(Long id);

    Banner getById(Long id);

    Banner getByName(String name);
}
