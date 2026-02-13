package application;

import java.util.List;

import domain.Vehiculo;
import infraestructure.VehiculoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class VehiculoService {

    @Inject
    private VehiculoRepository vehiculoRepository;

    public Vehiculo buscarVehiculoPorId(Integer id) {
        return this.vehiculoRepository.findById(id.longValue());
    }

    public List<Vehiculo> buscarTodosLosVehiculos() {
        return this.vehiculoRepository.listAll();
    }

    public void eliminarVehiculoPorId(Integer id) {
        this.vehiculoRepository.deleteById(id.longValue());
    }

    public void guardarVehiculo(Vehiculo vehiculo) {
        this.vehiculoRepository.persist(vehiculo);
    }

}
