package com.example.restApi.service.impl;

import com.example.restApi.entity.Client;
import com.example.restApi.exception.EntityNotFoundException;
import com.example.restApi.repository.DatabaseClientRepository;
import com.example.restApi.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final DatabaseClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(()->new EntityNotFoundException(MessageFormat.format("Клиент с Id {0} не найден",id)));
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        Optional<Client> existedClient = clientRepository.findById(client.getId());
        BeanUtils.copyProperties(client,existedClient);
        return clientRepository.save(client);
    }

    @Override
    public void deleteById(Long id) {

        clientRepository.deleteById(id);
    }
}
