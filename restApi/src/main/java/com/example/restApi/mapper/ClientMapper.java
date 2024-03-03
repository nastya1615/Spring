package com.example.restApi.mapper;

import com.example.restApi.entity.Client;
import com.example.restApi.web.model.ClientListResponse;
import com.example.restApi.web.model.ClientRequest;
import com.example.restApi.web.model.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = {NewsMapperDelegate.class, CommentMapperDelegate.class})
public interface ClientMapper {


    Client requestToClient(ClientRequest request);

    @Mapping(source = "clientId", target = "id")
    Client requestToClient(Long clientId, ClientRequest request);

    ClientResponse clientToResponse(Client client);

    default ClientListResponse clientListToResponseList(List<Client> clients){
        ClientListResponse response = new ClientListResponse();
        response.setClient(clients.stream().map(this::clientToResponse).collect(Collectors.toList()));
        return response;
    }

}
