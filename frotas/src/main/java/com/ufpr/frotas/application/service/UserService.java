package com.ufpr.frotas.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ufpr.frotas.domain.model.EnderecoModel;
import com.ufpr.frotas.domain.model.enums.PerfilEnum;
import com.ufpr.frotas.domain.repository.EnderecoRepository;
import com.ufpr.frotas.web.mapper.EnderecoMapper;
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
    private final EnderecoRepository enderecoRepository;


    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       UserMapper mapper,
                       EnderecoRepository enderecoRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = mapper;
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        System.out.println(">> Usuario autenticado: " + user.getEmail());
        System.out.println(">> Autoridades: " + user.getAuthorities());

        return user;
    }

    public UserResponseDTO criarUser(UserRequestDTO dto) {

        UserModel user = userMapper.toEntity(dto);
        
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getSenha() != null ? encriptar(dto.getSenha()) : "123456");
        user.setPerfil(dto.getPerfil() != null ? dto.getPerfil() : PerfilEnum.MOTORISTA);
        user.setAtivo(dto.getAtivo() != null ? dto.getAtivo() : true);
        user.setTelefone(dto.getTelefone());
        user.setCnh(dto.getCnh());
        user.setCpf(dto.getCpf());
        user.setValidadeCnh(dto.getValidadeCnh());

        EnderecoModel endereco = new EnderecoModel();
        endereco.setCep(dto.getEndereco().getCep());
        endereco.setLogradouro(dto.getEndereco().getLogradouro());
        endereco.setBairro(dto.getEndereco().getBairro());
        endereco.setCidade(dto.getEndereco().getCidade());
        endereco.setEstado(dto.getEndereco().getEstado());
        endereco.setComplemento(dto.getEndereco().getComplemento());
        endereco.setNumero(dto.getEndereco().getNumero());

        user.setEndereco(endereco);

        UserModel salvo = userRepository.save(user);

        endereco.setUsuario(salvo);

        EnderecoModel enderecoSalvo = enderecoRepository.save(endereco);

        salvo.setEndereco(enderecoSalvo);

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

        user.setPerfil(dto.getPerfil() != null ? dto.getPerfil() : PerfilEnum.MOTORISTA);
        user.setAtivo(dto.getAtivo() != null ? dto.getAtivo() : true);
        user.setTelefone(dto.getTelefone());
        user.setCnh(dto.getCnh());
        user.setCpf(dto.getCpf());
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
