package com.micronautdatapractice.controller;

import com.micronautdatapractice.model.User;
import com.micronautdatapractice.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import java.util.List;
//I am practicing the video of Amit Bhave for Git Practice
@Controller("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
// Second comment is added on Post request
    @Post
    public HttpResponse<User>createUser(@Body @Valid User user){
        return HttpResponse.created(userService.createUser(user));
    }

    @Get
    public HttpResponse<List<User>> getAllUsers(){
        return HttpResponse.ok(userService.getAllUsers());
    }
    @Get("/{id}")
    public HttpResponse<User> getUser(@PathVariable int id){
        return HttpResponse.ok(userService.getUser(id));
    }
    @Put("/{id}")
    public HttpResponse<User> updateUser(@PathVariable int id,@Body User user){
        return HttpResponse.ok(userService.updateUser(id,user));
    }
// comment added on delete request
    @Delete("/{id}")
    public HttpResponse<Void> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return HttpResponse.ok();
    }
}
