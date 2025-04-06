package souza.isaac.barbershopui.service.impl;

import souza.isaac.barbershopui.entity.ScheduleEntity;
import souza.isaac.barbershopui.repository.IScheduleRepository;
import souza.isaac.barbershopui.service.IScheduleService;
import souza.isaac.barbershopui.service.query.IScheduleQueryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService {

    private final IScheduleRepository repository;
    private final IScheduleQueryService queryService;

    @Override
    public ScheduleEntity save(final ScheduleEntity entity) {
        queryService.verifyIfScheduleExists(entity.getStartAt(), entity.getEndAt());

        return repository.save(entity);
    }

    @Override
    public void delete(final long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
}