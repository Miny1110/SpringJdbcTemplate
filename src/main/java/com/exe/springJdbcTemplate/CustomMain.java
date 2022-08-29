package com.exe.springJdbcTemplate;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {

		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("app-context.xml");
		
		CustomDAO2 dao = (CustomDAO2)context.getBean("customDAO2");

		CustomDTO dto;
		
		//insert
		
		dto = new CustomDTO();
		dto.setId(666);
		dto.setName("ȫ�浿");
		dto.setAge(41);
		
		dao.insertData(dto);
		System.out.println("insert �Ϸ�");
		
		//update
		dto = new CustomDTO();
		dto.setId(555);
		dto.setName("�谨��");
		dto.setAge(24);
		
		dao.updateData(dto);
		System.out.println("update �Ϸ�");
		
		//delete
		dao.deleteData(111);
		
		//OneSelect
		dto = dao.getReadData(111);
		if(dto!=null) {
			System.out.printf("%d %s %d\n",
					dto.getId(),dto.getName(),dto.getAge());
		}
		System.out.println("OneSelect �Ϸ�");
	
		//list
		List<CustomDTO> lists = dao.getList();
		for(CustomDTO dto1 : lists) {
			System.out.printf("%d %s %d\n",
					dto1.getId(),dto1.getName(),dto1.getAge());
		}
		System.out.println("select �Ϸ�");
	}

}