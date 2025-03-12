package com.example.demo.repository;

// import java.util.List;
// import java.util.Optional;
import com.example.demo.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {

}
