package com.springmvc.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springmvc.dao.EmpDao;
import com.springmvc.model.Emp;

/** documentation:
here the files used are a model class(pojo for employee), a controller which takes requests mapping and calls Dao for functionalities, 
all crud operations have been implemented.
 */

@Controller  
public class EmpController {  
    @Autowired  
    EmpDao dao;
    @GetMapping("/empform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Emp());
    	return "empform"; 
    }  
    @PostMapping(value="/save")  
    public String save(@ModelAttribute("emp") Emp emp){  
        dao.save(emp);  
        return "redirect:/view";  
    }  
    @GetMapping("/view")  
    public String view(Model m){  
        List<Emp> list=dao.getEmployees();  
        m.addAttribute("list",list);
        
        return "view";  
    }  
    @RequestMapping(value="/editemp/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Emp emp=dao.getEmpById(id);  
        m.addAttribute("command",emp);
        return "empeditform";  
    }  
    @PostMapping(value="/editsave")  
    public String editsave(@ModelAttribute("emp") Emp emp){  
        dao.update(emp);  
        return "redirect:/view";  
    }  
    @GetMapping(value="/deleteemp/{id}")  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/view";  
    }
   
   
   
}  