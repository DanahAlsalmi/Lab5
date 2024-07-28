package com.example.lab5trackersystem.Controller;

import com.example.lab5trackersystem.Api.ApiResponse;
import com.example.lab5trackersystem.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {
    ArrayList<Project> projects = new ArrayList<>();

    //Read - display all project
    @GetMapping("/get")
    public ArrayList<Project> getProjects() {
        return projects;
    }

    //Add
    @PostMapping("/add")
    public ApiResponse createProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("Project created :" + project.getTitle());
    }

    //Update
    @PutMapping("/update/{id}")
    public ApiResponse updateProject(@RequestBody Project project, @PathVariable int id) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId() == id) {
                projects.set(i, project);
                return new ApiResponse("Project updated :" + project.getTitle());
            }
        }
        return new ApiResponse("Project not found");
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteProject(@PathVariable int id) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getId() == id) {
                projects.remove(i);
                return new ApiResponse("Project deleted successfully");
            }
        }
        return new ApiResponse("Project not found");
    }

    //Change status
    @PutMapping("/change-status/{id}")
    public ApiResponse changeStatus(@PathVariable int id) {
        for (Project project : projects) {
            if (project.getId() == id) {
                if ("not done".equals(project.getStatus())) {
                    project.setStatus("done");
                    return new ApiResponse("Project status changed to done: " + project.getTitle());
                } else {
                    return new ApiResponse("Project is already done.");
                }
            }
        }
        return new ApiResponse("Project with ID " + id + " not found.");
    }

    //Search
    @GetMapping("/search/{title}")
    public ApiResponse searchProjectByTitle(@PathVariable String title) {
        for (Project project : projects) {
            if (project.getTitle().equalsIgnoreCase(title)) {
                return new ApiResponse("Project found: " + project.getTitle());
            }
        }
        return new ApiResponse("Project with title " + title + " not found.");
    }

    //Search by company name
    @GetMapping("/company/{companyName}")
    public List<Project> getProjectsByCompanyName(@PathVariable String companyName) {
        List<Project> companyProjects = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCompanyName().equalsIgnoreCase(companyName)) {
                companyProjects.add(project);
            }
        }
        return companyProjects;
    }


}
