package com.ale.controller;

import com.ale.dto.InscriptionDTO;
import com.ale.dto.StudentDTO;
import com.ale.model.Inscription;
import com.ale.model.InscriptionDetail;
import com.ale.model.Student;
import com.ale.repo.IInscriptionRepo;
import com.ale.service.IInscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inscription")
@RequiredArgsConstructor
public class InscriptionController {
    private final IInscriptionService service;
    @Qualifier("courseMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<InscriptionDTO>> readAll() throws Exception{
        List<InscriptionDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionDTO> readById(@PathVariable("id") Integer id) throws Exception{
        InscriptionDTO dto = convertToDto(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InscriptionDTO> create(@Valid @RequestBody InscriptionDTO dto) throws Exception {
        Inscription obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InscriptionDTO> update(@Valid @RequestBody InscriptionDTO dto, @PathVariable("id") Integer id) throws Exception {
        Inscription obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<InscriptionDTO>> findPage(Pageable pageable){
        Page<InscriptionDTO> pageStudent = service.findPage(pageable).map(this::convertToDto);
        return new ResponseEntity<>(pageStudent, HttpStatus.OK);
    }

    @GetMapping("/groupby")
    public ResponseEntity<Map<String, List<String>>> getGroupBy(){
        Map<String, List<String>>user = service.getGroupBy();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    private InscriptionDTO convertToDto(Inscription obj){
        return mapper.map(obj, InscriptionDTO.class);
    }

    private Inscription convertToEntity(InscriptionDTO dto){
        return mapper.map(dto, Inscription.class);
    }
}
