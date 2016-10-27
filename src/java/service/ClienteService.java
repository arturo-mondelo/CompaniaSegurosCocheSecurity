/*
 * cliente 
 */
package service;

import dao.ClienteDao;
import java.util.List;
import modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amondelo
 */
@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteDao clienteDao;

    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }
    
      public List<Cliente> getClientes(){
        return clienteDao.getListCliente();
    }
      public List<Cliente> getListaClientePolizas(){
       return clienteDao.getClienteConPolizas();
   }
    
    public Cliente getClienteById( long id){
        return clienteDao.getClienteById(id);
    }
    
    public void darClienteBaja(Cliente cliente){
        clienteDao.borrarCliente(cliente);
    }
    
    
    public void darClienteBajaPorId(long id){
        Cliente c = clienteDao.getClienteById(id);
        clienteDao.borrarCliente(c);
    }
   
    public void altaCliente(Cliente cliente){
        clienteDao.altaCliente(cliente);
    }
    
    public void modificarCliente(Cliente cliente){
        clienteDao.modificarCliente(cliente);
    }
    
}
