package com.mballem.curso.boot.service;

import java.util.List;

import com.mballem.curso.boot.dao.CargoDao;
import com.mballem.curso.boot.domain.Cargo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class CargoServiceImpl implements CargoService{

    @Autowired
    private CargoDao dao;

    @Override @Transactional(readOnly = false)
    public void salvar(Cargo cargo) {
        dao.save(cargo);
        
    }

    @Override @Transactional(readOnly = false)
    public void editar(Cargo cargo) {
        dao.update(cargo);
        
    }

    @Override @Transactional(readOnly = false)
    public void excluir(Long id) {
        dao.delete(id);
        
    }

    @Override @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {        
        return dao.findAll();
    }

    @Override
    public boolean cargoTemFuncionarios(Long id) {
        if(buscarPorId(id).getFuncionarios().isEmpty()){
        return true;
    }
    return false;
}
}
