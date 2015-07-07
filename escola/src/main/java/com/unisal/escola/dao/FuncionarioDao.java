package com.unisal.escola.dao;

import java.beans.Expression;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.unisal.escola.modelo.Funcionario;

public class FuncionarioDao {

public List<Funcionario> buscaFuncionario(String nome, String telefone, Date dataMin, Date dataMax, float precoMin, float precoMax, String funcao, String especialidade) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Funcionario.class);
		if(nome!=null){
			criteria.add(Restrictions.like("nome","%"+nome+"%"));
		}
		if(telefone!=null){
			criteria.add(Restrictions.like("telefoneResidencial","%"+telefone+"%"));
		}
		if(dataMin!=null){
			criteria.add(Restrictions.ge("dataNasc",dataMin));
		}
		if(dataMax!=null){
			criteria.add(Restrictions.le("dataNasc",dataMax));
		}
		if(precoMin > 0 ){
			criteria.add(Restrictions.ge("precoDaHora",precoMin));
		}
		if(precoMax > 0){
			criteria.add(Restrictions.le("precoDaHora",precoMax));
		}
		if(funcao!=null){
			criteria.add(Restrictions.like("funcao","%"+funcao+"%"));
		}
		if(especialidade!=null){		   
			        criteria.createAlias("Funcionario_Especialidade", "fe");            
			        criteria.createAlias("fe.Especialidade", "e");
			        criteria.add(Restrictions.like("e.nome", "%"+especialidade+"%"));
		}
		List<Funcionario> listaFuncionarios = criteria.list();

		session.close(); 
		sessionFactory.close();
		
		List<Object[]> list = criteria.list();
        for(Object[] arr : list){
            System.out.println(Arrays.toString(arr));
        }
		
		return null; 
	}
	
	public void cadastraFuncionario(Funcionario funcionario) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		session.save(funcionario);
		
		session.getTransaction().commit();
		
		session.close(); 
		sessionFactory.close();
		
		return; 
	}

	
	public void deletaFuncionario(long cpf) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Funcionario usuario = (Funcionario) session.get(Funcionario.class, cpf);
		
		session.delete(usuario);
		
		session.getTransaction().commit();
		session.close(); 
		sessionFactory.close();
		
		return; 
	}

	
	public void editaFuncionario(Funcionario funcionario) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Funcionario funcionario2 = (Funcionario) session.get(Funcionario.class, funcionario.getCpf());
		
		funcionario2 = funcionario;
		
		session.getTransaction().commit();
		session.close(); 
		sessionFactory.close();
		
		return; 
	}

	public Funcionario buscaFuncionarioCpf(long cpf) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Funcionario funcionario = (Funcionario) session.get(Funcionario.class, cpf);
		
		session.close(); 
		sessionFactory.close();

		
		return funcionario;
	}

	
	
}
