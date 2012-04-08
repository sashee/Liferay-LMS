package hu.advancedweb.lms.evaluation;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.google.common.collect.Maps;

public class ExamTest {
	/**
	 * Oldal->kerdes -> [tipus, szoveg, inputok nevei, inputokhoz tartozo szovegek]<br>
	 * Az utolso csak CHECKBOX es RADIO esetben<br>
	 * Az inputok nevei vesszovel vannak elvalasztva(TEXT esetben csak 1 van)
	 * */
	public Map<String, ? extends Map<String, ? extends List<String>>>	tests	= Maps.newLinkedHashMap();
	
	@SuppressWarnings("unchecked")
	public ExamTest(String config) {
		tests = (JSONObject) JSONValue.parse(config);
	}
	/*
	 * hmm, lehet megse lesz rendezett
a JSONObject egy Hashmap
siman, nem linked
aham
megvan
ContainerFactory
a parsolasnal at lehet adni egy olyet
es akkor meg lehet adni neki, hogy LinkedHashMap legyen es ne jsonobject
	 */
}
