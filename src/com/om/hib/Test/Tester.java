package com.om.hib.Test;

import com.om.hib.dao.ComputerDAO;
import com.om.hib.dto.ComputerDTO;
import com.om.hib.dto.OSDTO;

public class Tester {

	public static void main(String[] args) {

		ComputerDTO compaq = new ComputerDTO();
		compaq.setBrand("HP");
		compaq.setColor("red");
		compaq.setType("ultra");

		OSDTO windows = new OSDTO();
		windows.setName("windows 10");
		windows.setVersion(10);
		windows.setBits(32);

		compaq.setOsdto(windows);
		windows.setComdto(compaq);

		ComputerDAO cdao = new ComputerDAO();
		//cdao.save(compaq);
		
		//cdao.fetch(23);
		cdao.delete(42);
		//cdao.update("wind-sud",42);
		

	}

}
