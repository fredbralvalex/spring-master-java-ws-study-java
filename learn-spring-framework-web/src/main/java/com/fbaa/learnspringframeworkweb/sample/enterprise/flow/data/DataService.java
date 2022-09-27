
package com.fbaa.learnspringframeworkweb.sample.enterprise.flow.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

// Getting data
@Component
public class DataService {
	
	public List<Integer> retrieveData(){
		return Arrays.asList(12,34,56,78,90);
	}
	
}