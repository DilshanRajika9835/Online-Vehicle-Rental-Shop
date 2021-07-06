package lk.car.rental.controller;

import lk.car.rental.dto.CustomerDTO;
import lk.car.rental.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @Project_Name:BackEnd
 * @Date:2021-06-15
 * @Date_Name:Tuesday
 * @Time:8:23 AM
 * @Author:DILSHAN_RAJIKA
 * @Since:1.0.0
 **/

@RestController
@CrossOrigin
@RequestMapping("/customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "/register")
    public String registerCustomer(@RequestPart String nic, @RequestPart String username, @RequestPart String password,
                                   @RequestPart String address, @RequestPart String phone_number, @RequestPart String email, @RequestPart String city, @RequestPart String province,
                                   @RequestPart("profile") MultipartFile myFile1, @RequestPart("font_identity") MultipartFile myFile2, @RequestPart("back_identity") MultipartFile myFile3, @RequestPart("font_license") MultipartFile myFile4,
                                   @RequestPart("back_license") MultipartFile myFile5) {
        try {
            // Let's get the project location
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            // Let's create a folder there for uploading purposes, if not exists
            File profileFolder = new File(projectPath + "/CustomerProfile");
            profileFolder.mkdir();
            File idFolder = new File(projectPath + "/IdentityCards");
            idFolder.mkdir();
            File lichenFolder = new File(projectPath + "/LichenCards");
            lichenFolder.mkdir();

            String profile = profileFolder.getPath() + File.separator + myFile1.getOriginalFilename();
            String font_identity = idFolder.getPath() + File.separator + myFile2.getOriginalFilename();
            String back_identity = idFolder.getPath() + File.separator + myFile3.getOriginalFilename();
            String font_license = lichenFolder.getPath() + File.separator + myFile4.getOriginalFilename();
            String back_license = lichenFolder.getPath() + File.separator + myFile5.getOriginalFilename();

            myFile1.transferTo(new File(profile));
            myFile2.transferTo(new File(font_identity));
            myFile3.transferTo(new File(back_identity));
            myFile4.transferTo(new File(font_license));
            myFile5.transferTo(new File(back_license));
            final boolean ok = customerService.addCustomer(new CustomerDTO(nic, username, password, address, phone_number, email, city, province, profile, font_identity, back_identity, font_license, back_license));
            return "true";
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();

        }
        return "false";
    }


    @PostMapping("/login")
    public boolean getCustomer(String nic, String password) {
        return customerService.findCustomer(nic, password);
    }
    @PostMapping(path ={"/find"})
    public CustomerDTO findUser(String nic, String password) {
        return customerService.findUser(nic, password);


    }



}
