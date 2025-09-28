package interfaces;

import java.util.List;

public interface Repositorio<Producto> {
    public List<Producto> listar();
    public Producto porId(Integer id);
    public entity.Producto crear(Producto pr);
    public boolean editar(Producto pr);
    public boolean eliminar(Integer id);

}
