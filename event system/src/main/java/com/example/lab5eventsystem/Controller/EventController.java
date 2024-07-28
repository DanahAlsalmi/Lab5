package com.example.lab5eventsystem.Controller;

import com.example.lab5eventsystem.Api.ApiResponse;
import com.example.lab5eventsystem.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    ArrayList<Event> events=new ArrayList<>();

    //Read
    @GetMapping("/events")
    public ArrayList<Event> getEvents(){
        return events;
    }

    //Add
    @PostMapping("/add")
    public ApiResponse createEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Event created");
    }

    //Update
    @PutMapping("/update/{id}")
    public ApiResponse updateEvent(@RequestBody Event event, @PathVariable int id){
        for(int i=0; i<events.size(); i++){
            if(events.get(i).getId()==id){
                events.set(i, event);
                return new ApiResponse("Event updated");
            }
        }
        return new ApiResponse("Event not found");
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteEvent(@PathVariable int id){
        for(int i=0; i<events.size(); i++){
            if(events.get(i).getId()==id){
                events.remove(i);
                return new ApiResponse("Event deleted");
            }
        }
        return new ApiResponse("Event not found");
    }

    //Change Capacity
    @PutMapping("/change-capacity/{id}/{capacity}")
    public ApiResponse changeEventCapacity(@PathVariable int id,@PathVariable int capacity){
        for(int i=0; i<events.size(); i++){
            if(events.get(i).getId()==id){
                events.get(i).setCapacity(capacity);
                return new ApiResponse("Event updated");
            }
        }
        return new ApiResponse("Event not found");
    }

    //Search by given id
    @GetMapping("/search/{id}")
    public ApiResponse searchEvent(@PathVariable int id){
        for(int i=0; i<events.size(); i++){
            if(events.get(i).getId()==id){
                return new ApiResponse("Event found :"+events.get(i).getDescription());
            }
        }
        return new ApiResponse("Event not found");
    }



}
