package interfaces;

import java.util.List;

import application.VehiculoService;
import domain.Vehiculo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/vehiculos")
public class VehiculoResource {

    @Inject
    private VehiculoService vehiculoService;

    @GET
    @Path("/todos")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return this.vehiculoService.buscarTodosLosVehiculos();
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Vehiculo obtenerVehiculoPorId(@jakarta.ws.rs.PathParam("id") Integer id) {
        return this.vehiculoService.buscarVehiculoPorId(id);
    }

    @POST
    @Path("/guardar")
    @Consumes(MediaType.APPLICATION_JSON)
    public void guardarVehiculo(Vehiculo vehiculo) {
        this.vehiculoService.guardarVehiculo(vehiculo);
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void eliminarVehiculoPorId(@jakarta.ws.rs.PathParam("id") Integer id) {
        this.vehiculoService.eliminarVehiculoPorId(id);
    }

}
