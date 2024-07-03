package io.hexlet.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        var name = request.getQueryString().split("=");
        for (int i = 0; i < name.length - 1; i += 2) {
            if (name[i].equals("name")) {
                response.getWriter().write("Hello, " + name[i + 1] + "!");
                return;
            }
        }
        response.getWriter().write("Hello, Guest!");
    }
    // END
}
