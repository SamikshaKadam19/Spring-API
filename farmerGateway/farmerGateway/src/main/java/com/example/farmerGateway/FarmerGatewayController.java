package com.example.farmerGateway;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/farmers")
 class FarmerController {
    @Autowired
    private FarmerRepository farmerRepository;

    
    @PostMapping("/signup")
    public ResponseEntity<Farmer> signUp(@RequestBody Farmer farmer) {
        Farmer createdFarmer = farmerRepository.save(farmer);
        if (createdFarmer != null) {
            return new ResponseEntity<>(createdFarmer, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Farmer loginUser) {
        Optional<Farmer> userOptional = farmerRepository.findByUsername(loginUser.getUsername());
        if (userOptional.isPresent()) {
            Farmer user = userOptional.get();
            if (user.getPassword().equals(loginUser.getPassword())) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }
    }
    
    @GetMapping("/{group_id}")
    public ResponseEntity<Farmer> getGroupById(@PathVariable Long group_id) {
        Optional<Farmer> propertyOptional = farmerRepository.findById(group_id);
        return propertyOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Farmer> getAllFarmers() {
        return farmerRepository.getAllFarmers();
    }
    
}


@RestController
@RequestMapping("/crops")
 class CultivationController {
    @Autowired
    private CultivationRepository cultivationRepository;

    
    @PostMapping("/addcrop")
    public ResponseEntity<Cultivation> addCrop(@RequestBody Cultivation cultivation) {
        Cultivation createdCrop = cultivationRepository.save(cultivation);
        if (createdCrop != null) {
            return new ResponseEntity<>(createdCrop, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

@RestController
@RequestMapping("/admin")
 class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    
    @PostMapping("/signup")
    public ResponseEntity<Admin> signUp(@RequestBody Admin admin) {
        Admin createdAdmin = adminRepository.save(admin);
        if (createdAdmin != null) {
            return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Admin loginUser) {
        Optional<Admin> userOptional = adminRepository.findByAdminname(loginUser.getAdminname());

        if (!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        Admin user = userOptional.get();

        if (loginUser.getAdpassword().equals(user.getAdpassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    
  
}

@RestController
@RequestMapping("/store")
 class StoreManagerController {
    @Autowired
    private StoreManagerRepository storemanagerRepository;

    
    @PostMapping("/signup")
    public ResponseEntity<StoreManager> signUp(@RequestBody StoreManager store) {
        StoreManager createdManager = storemanagerRepository.save(store);
        if (createdManager != null) {
            return new ResponseEntity<>(createdManager, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody StoreManager loginUser) {
        Optional<StoreManager> userOptional = storemanagerRepository.findByStorename(loginUser.getStorename());

        if (!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        StoreManager store = userOptional.get();

        if (loginUser.getStorepassword().equals(store.getStorepassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    
  
}
