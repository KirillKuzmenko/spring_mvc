package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Car {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) String count, ModelMap modelMap){

        if (count == null || Integer.parseInt(count) >= 5) {
            modelMap.addAttribute("cars", carService.listCars(5));
        } else {
            modelMap.addAttribute("cars", carService.listCars(Integer.parseInt(count)));
        }
        return "cars";
    }
}
