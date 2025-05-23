package com.ufpr.frotas.domain.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ufpr.frotas.domain.model.UserModel;
import com.ufpr.frotas.domain.model.enums.PerfilEnum;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    
    Optional<UserModel> findByEmail(String email);
    Optional<UserModel> findByCnh(String cnh);
    Optional<UserModel> findById(Long id);

    List<UserModel> findByAtivoTrue();
    List<UserModel> findByPerfil(PerfilEnum perfil); // ADMIN ou MOTORISTA
    
}

