package model.dao;

public class DaoFactory {
    
    public static ContatoDaoJpa novoHospedeDAO() throws Exception {
        return new ContatoDaoJpa();
    }
    
}
