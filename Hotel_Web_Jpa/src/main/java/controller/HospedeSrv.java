package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Hospede;
import model.dao.ContatoDaoJpa;
import model.dao.InterfaceDao;

public class HospedeSrv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String acao = request.getParameter("acao");

            String id = request.getParameter("id");
            String cpf = request.getParameter("cpf");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            InterfaceDao dao = new ContatoDaoJpa();
            RequestDispatcher rd;
            Hospede c = null;

            switch (acao) {
                case "inclusao":
                    c = new Hospede(nome, cpf, email, telefone);
                    try {
                        dao.incluir(c);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "pre-edicao":
                    c = (Hospede) dao.pesquisarPorId(Integer.parseInt(id));
                    rd = request.getRequestDispatcher("Formulario.jsp?acao=edicao"
                            + "&id=" + c.getId()
                            + "&cpf=" + c.getCpf()
                            + "&nome=" + c.getNome()
                            + "&email=" + c.getEmail()
                            + "&telefone=" + c.getTelefone());
                    rd.forward(request, response);
                    break;

                case "edicao":
                    c = new Hospede(nome, cpf, email, telefone);
                    c.setId(Integer.parseInt(id));
                    try {
                        dao.editar(c);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "exclusao":
                    try {
                        c = new Hospede();
                        c.setId(Integer.parseInt(id));
                        dao.excluir(c);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "listagem":
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;

                case "pesquisarPorNome":
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagemFiltrada(nome));
                    rd.forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(HospedeSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    private String srvAutenticacao(String nome, String cpf){
//        if(nome==null && cpf==null){
//            
//        }
//        return null;
//    }

    private String listagem() {
        InterfaceDao dao = new ContatoDaoJpa();
        List<Hospede> lista = null;
        try {
            lista = dao.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        for (Hospede contato : lista) {
            listaHTML += "<tr>"
                    + "<td>" + contato.getNome() + "</td>"
                    + "<td>" + contato.getCpf() + "</td>"
                    + "<td>" + contato.getEmail() + "</td>"
                    + "<td>" + contato.getTelefone() + "</td>"
                    + "<td><form action=HospedeSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + contato.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    + "<form action=HospedeSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden' name='id' value="
                    + contato.getId() + "><input type='submit' value=excluir></td>"
                    + "</form>"
                    + "</tr>";
        }
        return listaHTML;
    }

    private String listagemFiltrada(String nome) {
        InterfaceDao dao = new ContatoDaoJpa();
        List<Hospede> lista = null;
        try {
            lista = dao.filtrarPorNome(nome);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        for (Hospede contato : lista) {
            listaHTML += "<tr>"
                    + "<td>" + contato.getNome() + "</td>"
                    + "<td>" + contato.getCpf() + "</td>"
                    + "<td>" + contato.getEmail() + "</td>"
                    + "<td>" + contato.getTelefone() + "</td>"
                    + "<td><form action=HospedeSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + contato.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    + "<form action=HospedeSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden' name='id' value="
                    + contato.getId() + "><input type='submit' value=excluir></td>"
                    + "</form>"
                    + "</tr>";
        }
        return listaHTML;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
