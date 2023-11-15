package tech.csm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@GetMapping("/")
	public String welcome(Model model) {

		model.addAttribute("empList", employeeService.getAllEmp());
		model.addAttribute("deptList", departmentService.getAllDepartments());
		model.addAttribute("countryList", countryService.getAllCountry());

		return "View";
	}

	@ResponseBody
	@GetMapping("/getStateByCountryId")
	public List<State> getStateByCountryId(@RequestParam("countryId") Integer countryId) {
		List<State> stateList = stateService.getAllState(countryId);
		return stateList;
	}

	@ResponseBody
	@GetMapping("/getDistrictByStateId")
	public List<District> getDistrictByStateId(@RequestParam("stateId") Integer stateId) {
		List<District> districtList = districtService.getAllDistricts(stateId);
		return districtList;
	}

	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee employee, @RequestParam("photo") MultipartFile photo,
			RedirectAttributes redirectAttributes) {

		// Set photo path
		if (photo == null || photo.isEmpty()) {
			Employee e = employeeService.getEmployeeById(employee.getEmpId());
			employee.setPhotoPath(e.getPhotoPath());
		} else {
			employee.setPhotoPath(FileUpload.uploadFile(photo));
		}
		Employee e = employeeService.saveEmployee(employee);
		redirectAttributes.addFlashAttribute("msg", "Register Successfully with id " + e.getEmpId());
		return "redirect:/";
	}

	@GetMapping("/deleteEmp")
	public String deleteEmp(@RequestParam("empId") String empId, RedirectAttributes redirectAttributes) {
		System.out.println(empId);
		employeeService.deleteEmpById(empId);
		redirectAttributes.addFlashAttribute("deleteMsg", "Deleted");
		return "redirect:./";
	}

	@GetMapping("/editEmp")
	public String editEmp(@RequestParam("empId") String empId, @RequestParam("countryId") Integer countryId,
			@RequestParam("stateId") Integer stateId, Model model) {
		Employee employee = employeeService.getEmployeeById(empId);

		model.addAttribute("e", employee);
		model.addAttribute("empList", employeeService.getAllEmp());
		model.addAttribute("deptList", departmentService.getAllDepartments());
		model.addAttribute("countryList", countryService.getAllCountry());
		model.addAttribute("stateList", stateService.getAllState(countryId));
		model.addAttribute("districtList", districtService.getAllDistricts(stateId));
		return "demo";
	}

	@GetMapping("/test")
	public String test(@RequestParam String demo) {
		System.out.println(demo);
		return "demo";
	}
}
