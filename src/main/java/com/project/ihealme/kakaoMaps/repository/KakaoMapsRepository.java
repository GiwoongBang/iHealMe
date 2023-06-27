package com.project.ihealme.kakaoMaps.repository;

import com.project.ihealme.kakaoMaps.entity.KakaoMapsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KakaoMapsRepository extends JpaRepository<KakaoMapsEntity, Long> {

    @Query("insert into USERRESERVATION ()")
    private

}
