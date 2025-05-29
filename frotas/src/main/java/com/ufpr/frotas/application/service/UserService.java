package com.ufpr.frotas.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ufpr.frotas.application.dto.UserRequestDTO;
import com.ufpr.frotas.application.dto.UserResponseDTO;
import com.ufpr.frotas.domain.model.UserModel;

import com.ufpr.frotas.domain.repository.UserRepository;

import com.ufpr.frotas.web.mapper.UserMapper;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
            user.getNome(),
            user.getSenha(),
            new ArrayList<>()
        );
    }
    
     public UserResponseDTO criarUser(UserRequestDTO dto) {

        UserModel user = userMapper.toEntity(dto);
        
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(encriptar(dto.getSenha()));
        user.setPerfil(dto.getPerfil());
        user.setAtivo(dto.getAtivo());
        user.setTelefone(dto.getTelefone());
        user.setCnh(dto.getCnh());
        user.setValidadeCnh(dto.getValidadeCnh());

        user.getEndereco().setCep(dto.getEndereco().getCep());

        user.getEndereco().setLogradouro(dto.getEndereco().getLogradouro());

        user.getEndereco().setBairro(dto.getEndereco().getBairro());

        user.getEndereco().setCidade(dto.getEndereco().getCidade());

        user.getEndereco().setEstado(dto.getEndereco().getEstado());

        user.getEndereco().setComplemento(dto.getEndereco().getComplemento());

        user.getEndereco().setNumero(dto.getEndereco().getNumero());

        UserModel salvo = userRepository.save(user);

        return userMapper.toDTO(salvo);
    }

    public UserResponseDTO buscarPorId(Long id) {
        UserModel user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return userMapper.toDTO(user);
    }

    public List<UserResponseDTO> listarMotoristasAtivos() {
        return userRepository.findByAtivoTrue().stream()
            .map(userMapper::toDTO)
            .toList();
    }

    public UserResponseDTO buscarPorCnh(String cnh) {
        UserModel user = userRepository.findByCnh(cnh).
        orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return userMapper.toDTO(user);
    }

    public UserResponseDTO putUser(Long id, UserRequestDTO dto) {
      Optional<UserModel> userBd = Optional.of(userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado")));

      UserModel user = userBd.get();

       user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(encriptar(dto.getSenha()));
        user.setPerfil(dto.getPerfil());
        user.setAtivo(dto.getAtivo());
        user.setTelefone(dto.getTelefone());
        user.setCnh(dto.getCnh());
        user.setValidadeCnh(dto.getValidadeCnh());

        user.getEndereco().setCep(dto.getEndereco().getCep());

        user.getEndereco().setLogradouro(dto.getEndereco().getLogradouro());

        user.getEndereco().setBairro(dto.getEndereco().getBairro());

        user.getEndereco().setCidade(dto.getEndereco().getCidade());

        user.getEndereco().setEstado(dto.getEndereco().getEstado());

        user.getEndereco().setComplemento(dto.getEndereco().getComplemento());

        user.getEndereco().setNumero(dto.getEndereco().getNumero());

        userRepository.save(user);

        return  userMapper.toDTO(user);
    
    }

     private String encriptar(String senha) {
        
        return passwordEncoder.encode(senha);
    }

     public UserResponseDTO inativar(Long id) {
         UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

         user.setAtivo(false);

         userRepository.save(user);

         return userMapper.toDTO(user);
     }

     public UserDetails buscarPorEmail(String email) {
        UserDetails user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
            return user;
    }
    
}
