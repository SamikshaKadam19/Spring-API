package com.example.farmerGateway;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


interface FarmerRepository extends JpaRepository<Farmer, Long> {
    Optional<Farmer> findByUsername(String username);

    @Query("SELECT f FROM Farmer f")
    List<Farmer> getAllFarmers();
	Optional<Farmer> findById(Long group_id);     
    }

interface AdminRepository extends JpaRepository<Admin, Long> {

	Optional<Admin> findByAdminname(String adminname);
    
    }

interface StoreManagerRepository extends JpaRepository<StoreManager, Long> {

	Optional<StoreManager> findByStorename(String storename);

    
    }

 interface CultivationRepository extends CrudRepository<Cultivation, Long> {
}
