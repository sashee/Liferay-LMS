package hu.advancedweb.lms.evaluation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.collect.Maps;

@SuppressWarnings("unchecked")
public class ExamTest {
	/**
	 * Oldal->kerdes -> [tipus, szoveg, inputok nevei, inputokhoz tartozo szovegek]<br>
	 * Az utolso csak CHECKBOX es RADIO esetben<br>
	 * Az inputok nevei vesszovel vannak elvalasztva(TEXT esetben csak 1 van)
	 * */
//	public Map<String, ? extends Map<String, ? extends List<String>>>	tests	= Maps.newLinkedHashMap();// TODO
	public Map<String, Map<String, List<String>>>	tests	= Maps.newLinkedHashMap(); 
	
	
	/**
	 * Create empty Exam Test.
	 */
	public ExamTest() {
		// Do nothing.
	}
	
	/**
	 * Create Exam Test from JSON config.
	 */
	@SuppressWarnings("rawtypes")
	public ExamTest(String config) {
//		tests = (JSONObject) JSONValue.parse(config);
		
		try {
			tests = (Map) new JSONParser().parse(config, new ContainerFactory() {
			    
			        
					@Override
			        public Map createObjectContainer() {
			                return new LinkedHashMap();
			        }
			        
			        @Override
			        public List creatArrayContainer() {
			                return new ArrayList();
			        }
			});
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
}
