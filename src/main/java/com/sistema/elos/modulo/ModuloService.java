package com.sistema.elos.modulo;

import com.sistema.elos.modulo.dto.CriarNovoModuloRequest;
import com.sistema.elos.modulo.dto.CriarNovoModuloResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class ModuloService {


    private ModuloRepository moduloRepository;
    private ModuloMapper mapper;


    public CriarNovoModuloResponse criarNovoModulo( CriarNovoModuloRequest request){

        Modulo modulo = mapper.toEntity(request);

        Modulo moduloSalvo = moduloRepository.save(modulo);

        return mapper.toDTO(moduloSalvo);
    }


    public List<CriarNovoModuloResponse> listarModulo(){
        List<Modulo> moduloList = moduloRepository.findAll();

        return moduloList.stream().map(modulo -> new CriarNovoModuloResponse(
                modulo.getId(),
                modulo.getNome(),
                modulo.getAulas()
        )).toList();

    }
}
