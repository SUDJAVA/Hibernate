package com.om.hib.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.om.hib.dto.ComputerDTO;
import com.om.hib.dto.OSDTO;
import com.om.hib.util.HibernateUtil;

public class ComputerDAO {
	SessionFactory factory = HibernateUtil.getSessionFactory();

	public ComputerDAO() {
		System.out.println(this.getClass().getSimpleName() + " created.");
	}

	// save operation
	public void save(ComputerDTO dto) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(dto);
		tx.commit();
		System.out.println("data saved");
		session.close();

	}

	// fetch operation
	public void fetch(int pk) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			ComputerDTO computerDTO = session.get(ComputerDTO.class, pk);
			System.out.println(computerDTO.getBrand());
			OSDTO osdto = computerDTO.getOsdto();
			System.out.println(osdto.getName());
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}

	}

	// delete operation
	public void delete(int pk) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			ComputerDTO computerDTO = session.load(ComputerDTO.class, pk);
			//OSDTO osdto=computerDTO.getOsdto();
			if (computerDTO != null)
				session.delete(computerDTO);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}	
		
	//update operation
	public void update(String name,int pk){
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			ComputerDTO computerDTO=session.get(ComputerDTO.class, pk);
			OSDTO osdto=computerDTO.getOsdto();
			if(osdto!=null)
				osdto.setName(name);
				

			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		
	}
		
		
		
		
		
		
		
		
		
		
		
	

}
