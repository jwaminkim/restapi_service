package restapi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chunjae.restapi.model.TestModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping(path = "/api")
	public String GetList(
		@RequestParam(name="param1", defaultValue="true") String param1,
		@RequestParam(name="param2", defaultValue="false") String param2
		) {

		return "param1: "+param1+", param2: ";
	}
	
	@GetMapping(path = "/list")
	public String GetList() {
		System.out.println("list");
		String testval = "list";
		
		return testval;
	}
	
	@GetMapping(path = "/view")
	public String GetView() {
		System.out.println("view");
		String testval = "view";
		
		return testval;
	}
	
	//@RequestMapping(value = "/list", method = RequestMethod.GET)
	//@RequestMapping("/restapi")
	@GetMapping("/list/v1")
	@ResponseBody
    public String GetListV1() 
	{
		try 
		{
			/*
			String jsonValue = "{\"id\" : \"jwaminkim\", \"value\" : \"1\" }";
	        var jsonobj = new JSONObject(jsonValue);
	        
	        String resultVal = jsonobj.toString();
			return resultVal;
			*/
			
			//List<TestModel> resultMapList = new ArrayList<TestModel>();
			TestModel resultMap = new TestModel();
    		/*        
	        resultMap.Id = "1";
	        resultMap.Name = "jwaminkim";
	        resultMap.Nick = "kjm";
	        
	        resultMapList.add(resultMap);
	        
	        resultMap = new TestModel();
	        //resultMap.clear();
	        
	        resultMap.Id = "2";
	        resultMap.Name = "chunjae";
	        resultMap.Nick = "cj"; 
	        
	        resultMapList.add(resultMap);
	        */
	        String resultVal = mapToJson(resultMap);
			//Map<String, Object> deResultMap = jsonToMap(resultVal);    
			return resultVal;
		}
		catch (Exception ex)
		{
			return ex.getMessage();
		}
		
	}	
	
	@GetMapping(path = "/view/v1")
	public String GetViewV1() {
		System.out.println("view/v1");
		String testval = "view/v1";
		
		return testval;
	}
	
	@GetMapping(path = "/view/v2")
	public String GetViewV2() {
		System.out.println("view/v2");
		String testval = "view";
		
		return testval;
	}
	
	public String mapToJson(TestModel resultMap) throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        
        return mapper.writeValueAsString(resultMap);
    }
	
	public Map<String, Object> jsonToMap(String json) throws Exception
	{
	    ObjectMapper objectMapper = new ObjectMapper();
	    TypeReference<Map<String, Object>> typeReference = new TypeReference<Map<String,Object>>() {};
	    
	    return objectMapper.readValue(json, typeReference);
	}

}
