package com.bkct.comets;

import org.apache.catalina.comet.CometEvent;
import org.apache.catalina.comet.CometProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用commet向客户端发送 helloword
 */
@WebServlet(urlPatterns = "/cometServlet")
public class CometServlet extends HttpServlet implements CometProcessor {
    @Override
    public void event(CometEvent event) throws IOException, ServletException {
        if (event.getEventType() == CometEvent.EventType.BEGIN) {
            HttpServletResponse response = event.getHttpServletResponse();
            PrintWriter out = response.getWriter();
            out.write("Hello World!");
            out.flush();
            System.out.println("message sent");
        }
        if (event.getEventType() == CometEvent.EventType.READ) {

        }
    }
}
