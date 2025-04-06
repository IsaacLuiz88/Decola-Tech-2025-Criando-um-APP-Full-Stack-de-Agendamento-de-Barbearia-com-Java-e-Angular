package souza.isaac.barbershopui.mapper;

import souza.isaac.barbershopui.controller.request.SaveClientRequest;
import souza.isaac.barbershopui.controller.request.UpdateClientRequest;
import souza.isaac.barbershopui.controller.response.ClientDetailResponse;
import souza.isaac.barbershopui.controller.response.ListClientResponse;
import souza.isaac.barbershopui.controller.response.SaveClientResponse;
import souza.isaac.barbershopui.controller.response.UpdateClientResponse;
import souza.isaac.barbershopui.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedules", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);

}