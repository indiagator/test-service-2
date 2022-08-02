package com.code22.testservice2;

import com.code22.testservice2.model.Kitchen;
import com.code22.testservice2.model.KitchenRepository;
import com.code22.testservice2.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/0.1/test-service-2")
public class TestService2Application {

    @Autowired
    public TestService2Config config;

    @Autowired
    public KitchenRepository kitchenRepository;

    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(TestService2Application.class, args);
    }

    @GetMapping(value = "/health", produces = "application/json")
    public Message getResponse() {
        Message testMsg = new Message();
        testMsg.setMsgString("Everything A.OK! with Service 2");
        return  testMsg;
    }

    @PostMapping(value = "/save")
    public Message saveKitchen(@RequestBody Kitchen kitchen)
    {
        kitchenRepository.save(kitchen);
        Message saveKitchenrMsg = new Message();
        saveKitchenrMsg.setMsgString("New Customer Info Saved "+kitchen.getName());
        return saveKitchenrMsg;
    }

    @GetMapping(value = "/kitchen/{name}")
    public Kitchen getKitchenById(@PathVariable("name") String name)
    {
        return (kitchenRepository.findById(name)).get();
    }

    @GetMapping(value = "/getAll")
    public List<Kitchen> getAllKitchens ()
    {
        //try
        {
            return (List<Kitchen>) kitchenRepository.findAll();
        }
       // catch (NullPointerException e)
       // {
        //    System.out.println(e.getMessage());
       // }
       // finally {
       //     Kitchen kitchen = new Kitchen();
       //     kitchen.setName("NULL");
       //     kitchen.setLocation("NULL");
        //    kitchen.setMenu("NULL");
        //    kitchen.setReviews("NULL");
        //    List<Kitchen> errorList = new ArrayList<>();
        //    errorList.add(kitchen);
         //   return errorList;
        //}
    }


}
