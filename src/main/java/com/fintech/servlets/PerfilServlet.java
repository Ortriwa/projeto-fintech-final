package com.fintech.servlets;

import com.fintech.model.Transacao;
import com.fintech.model.Usuario;
import com.fintech.service.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
@WebServlet("/restrito/perfil")
public class PerfilServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession(true);
        String emailUsuarioLogado = (String) sessao.getAttribute("usuarioLogado");

        UsuarioService usuarioService = new UsuarioService();
        Usuario usuario = usuarioService.buscarPorEmail(emailUsuarioLogado);

        request.setAttribute("usuario", usuario);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/perfil.jsp");
        dispatcher.forward(request, response);
    }
}
