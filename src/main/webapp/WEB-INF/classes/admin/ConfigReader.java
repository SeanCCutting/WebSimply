package admin;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConfigReader {
	
	private List<String> list = new ArrayList<String>();
	
	public void loadConfig() {
		String configFile = "E:\\Home\\WebSimply\\src\\main\\webapp\\WEB-INF\\config.cfg";
		try(Stream<String> stream = Files.lines(Paths.get(configFile))) {
			
			list = stream.collect(Collectors.toList());
			
			Field[] fields = Constants.class.getDeclaredFields();
			for(int configIndex = 0; configIndex < list.size(); configIndex++) {
				for(int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++) {
					//System.out.println(fields[fieldIndex].getType().getSimpleName().equalsIgnoreCase("String"));
					if(list.get(configIndex).startsWith(fields[fieldIndex].getName().toString()) && fields[fieldIndex].getType().getSimpleName().equalsIgnoreCase("String")) {
						fields[fieldIndex].set(this, list.get(configIndex).substring(list.get(configIndex).indexOf("=") +1));
					}
					
					if(list.get(configIndex).startsWith(fields[fieldIndex].getName().toString()) && fields[fieldIndex].getType().getSimpleName().equalsIgnoreCase("int")) {
						fields[fieldIndex].set(this, Integer.parseInt(list.get(configIndex).substring(list.get(configIndex).indexOf("=") +1)));
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
