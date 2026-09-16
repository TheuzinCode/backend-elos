package com.sistema.elos.usuario;

import com.sistema.elos.configuracao.BusinessException;
import com.sistema.elos.unidade.Unidade;
import com.sistema.elos.unidade.UnidadeRepository;
import com.sistema.elos.usuario.dto.CriarUsuarioRequest;
import com.sistema.elos.usuario.dto.UsuarioResponse;
import com.sistema.elos.usuario.dto.ListarUsuarioResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRespositoy usuarioRespositoy;
    private UsuarioMapper usuarioMapper;
    private UnidadeRepository unidadeRepository;


    public UsuarioResponse criarNovoUsuario(CriarUsuarioRequest request){

        Unidade unidade = unidadeRepository.findById(request.unidadeId())
                .orElseThrow(() -> new BusinessException("UNIDADE NÃO ENCONTRADA"));

        char letra = (char) ThreadLocalRandom.current().nextInt('A', 'Z' + 1);
        int numero = ThreadLocalRandom.current().nextInt(10000, 100000);
        String codigo = letra + String.valueOf(numero);

        Usuario usuario = usuarioMapper.toEntity(request);

        usuario.setLogin(codigo);
        usuario.setUnidade(unidade);

        Usuario usuarioSalvo = usuarioRespositoy.save(usuario);

        return usuarioMapper.toUsuarioResponse(usuarioSalvo);

    }

    public List<ListarUsuarioResponse> listarTodosUsuarios(){
        List<Usuario> usuarios = usuarioRespositoy.findAll();

        return usuarios.stream().map(users -> new ListarUsuarioResponse(
                users.getId(),
                users.getNome(),
                users.getCargo(),
                users.getTelefone1(),
                users.getEmail(),
                users.getDataAdmissao()
        )).toList();
    }

    public UsuarioResponse detalhesUsuario(UUID id){
        Usuario usuario = usuarioRespositoy.findById(id)
                .orElseThrow(() -> new BusinessException("USUARIO NÃO ENCONTRADO"));

        return usuarioMapper.toUsuarioResponse(usuario);
    }

}
