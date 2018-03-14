package com.example.ZadatakVaadin;

import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import com.example.ZadatakVaadin.Employee;
import com.example.ZadatakVaadin.EmployeeService;
import com.example.ZadatakVaadin.City;
import com.example.ZadatakVaadin.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@SpringUI
public class VaadinUI extends UI {

    @Autowired
    private EmployeeService service;   
    private Employee employee;
    private Binder<Employee> binder = new Binder<>(Employee.class);
    
    private CityService serviceCity;   
   
    
    private TextField filterText = new TextField(); 
    
    private NativeSelect<String> select = new NativeSelect<>();
    
	Button btnFind = new Button("Traži");

    private Grid<Employee> grid = new Grid(Employee.class);
    
    private Button btnNew = new Button("Novi");
    private Button btnEdit = new Button("Izmjeni");
    private Button btnDel = new Button("Obriši");
    
    private TextField firstName = new TextField("FirstName");
    private TextField lastName = new TextField("LastName");
    private Button save = new Button("Save", e -> saveEmployee());

    @Override
    protected void init(VaadinRequest request) {
    	
    	filterText.setPlaceholder("Zaposlenik ..."); 
    	
    	updateListCities();
    	
    	
    	HorizontalLayout filtering = new HorizontalLayout(filterText, select, btnFind);
    		
    	VerticalLayout layout2 = new VerticalLayout(btnNew, btnEdit, btnDel);
    	setSizeUndefined();
    	//layout2.setSpacing(true);
        
        updateGrid();
        grid.setColumns("firstName", "lastName");
        grid.addSelectionListener(e -> updateForm());

        binder.bindInstanceFields(this);

        HorizontalLayout gridAndBtn = new HorizontalLayout();
        gridAndBtn.addComponents(grid, layout2);
        
        VerticalLayout layout = new VerticalLayout(filtering, gridAndBtn, firstName, lastName, save);
        setContent(layout);
    }
    
    public void updateList() {
		List<Employee> employees = service.findAll();
        grid.setItems(employees);
	}
    
    public void updateListCities() {
    	//ListDataProvider<City> allCities = new ListDataProvider<>(city);
    	select.setItems("Vukovar", "Vinkovci", "zg");
        //(serviceCity.findAllCities()); 
	}

    private void updateGrid() {
        List<Employee> employee = service.findAll();
        grid.setItems(employee);
        setFormVisible(false);
    }

    private void updateForm() {
        if (grid.asSingleSelect().isEmpty()) {
            setFormVisible(false);
        } else {
        	employee = grid.asSingleSelect().getValue();
            binder.setBean(employee);
            setFormVisible(true);
        }
    }

    private void setFormVisible(boolean visible) {
        firstName.setVisible(visible);
        lastName.setVisible(visible);
        save.setVisible(visible);
    }

    private void saveEmployee() {
        service.update(employee);
        updateGrid();
    }
}