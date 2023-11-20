package tech.csm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import tech.csm.model.Country;
import tech.csm.model.Department;
import tech.csm.model.District;
import tech.csm.model.Employee;
import tech.csm.model.State;
import tech.csm.service.CountryService;
import tech.csm.service.DepartmentService;
import tech.csm.service.DistrictService;
import tech.csm.service.EmployeeService;
import tech.csm.service.StateService;
import tech.csm.util.FileUpload;

/***
 *
 * @author akshaykirti.muduli
 *
 */
@Controller
@Slf4j
@RequestMapping({ "/employee", "/" })
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	CountryService countryService;
	@Autowired
	StateService stateService;
	@Autowired
	DistrictService districtService;

	// Home page
	@GetMapping({ "/", "/homepage" })
	public String homepage() {
		return "HomePage";
	}

	// Show ALl Employee Page
	@GetMapping("/view")
	public String view(Model model) {
		List<Employee> employeeList = employeeService.getAllEmp();
		model.addAttribute("empList", employeeList);
		return "View";
	}

	// Registration Page
	@GetMapping("/register")
	public String register(Model model, @ModelAttribute Employee employee) {
		List<Country> countryList = countryService.getAllCountry();
		List<Department> departmentList = departmentService.getAllDepartments();

		model.addAttribute("countryList", countryList);
		model.addAttribute("departmentList", departmentList);

//		Send StateList and District List While Update
		if (employee.getCountry() != null && employee.getState() != null) {

			List<State> stateList = stateService.getAllState(employee.getCountry().countryId);
			List<District> districtList = districtService.getAllDistricts(employee.getState().stateId);
			model.addAttribute("stateList", stateList);
			model.addAttribute("districtList", districtList);
		}

		return "Registration";
	}

	// Save Employee
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee employee, @RequestParam MultipartFile photo,
			RedirectAttributes redirectAttributes) {

		if (photo == null || photo.isEmpty()) {
			Employee e = employeeService.getEmployeeById(employee.getEmpId());
			employee.setPhotoPath(e.getPhotoPath());
		} else {
			employee.setPhotoPath(FileUpload.uploadFile(photo));
		}
		employee.setIsActive("yes");
		Employee saved = employeeService.saveEmployee(employee);
		redirectAttributes.addFlashAttribute("msg", "Employee Saved Successfully with id " + saved.empId);

		return "redirect:./register";
	}

	// Fetch state by countryId and send back to UI as json
	@ResponseBody
	@GetMapping("/getStateByCountryId")
	public List<State> getStateByCountryId(@RequestParam Integer countryId) {
		List<State> stateList = stateService.getAllState(countryId);
		return stateList;
	}

	// Fetch District by stateId and send back to UI as json
	@ResponseBody
	@GetMapping("/getDistrictByStateId")
	public List<District> getDistrictByStateId(@RequestParam Integer stateId) {
		List<District> districtList = districtService.getAllDistricts(stateId);
		return districtList;
	}

	// Edit Employee Data
	@GetMapping("/edit")
	public String edit(@RequestParam String empId, RedirectAttributes redirectAttributes) {
		Employee employee = employeeService.getEmployeeById(empId);

		redirectAttributes.addAttribute("employee", employee);

		return "redirect:./register";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam String empId, RedirectAttributes redirectAttributes) {
//        employeeService.deleteEmpById(empId);
		employeeService.softDelete(empId);
		redirectAttributes.addFlashAttribute("deleteMsg", "Deleted");
		return "redirect:./view";
	}

}
