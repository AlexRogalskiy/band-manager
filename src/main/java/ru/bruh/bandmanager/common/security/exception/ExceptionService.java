package ru.bruh.bandmanager.common.security.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bruh.bandmanager.common.security.dto.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Service
@RequiredArgsConstructor
public class ExceptionService {
    public void securityResponse(HttpServletResponse httpServletResponse) throws IOException {
        String message = "Не найден header Authorization: Bearer <токен> у запроса";
        Response response = new Response().setMessage(message);

        httpServletResponse.setStatus(401);
        OutputStream out = httpServletResponse.getOutputStream();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out, response);
        out.flush();
    }
}
