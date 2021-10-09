package crypto.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Controller
@SwaggerDefinition(tags = {
        @Tag(name = "PortfolioApp Controller", description = "Maps all the views and content needed for said views.")
})
public class MainController {
    

    @ApiOperation(value = "View of the signup page.", response = String.class)
    @GetMapping(value = "/signup")
    public String signup() {
        return "hello";
    }
}
