
/**  
* @文件名: PerformanceServicelmp.java 
* @包名 ppms.serviceimpl 
* @描述: TODO 
* @修改人：
* @修改时间：2015-8-7 下午4:57:24 
* @修改内容：

* @version V1.0  
*/ 
package ppms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ppms.daoimpl.MonthPerformanceDaolmp;
import ppms.domain.OrganizationNj;
import ppms.domain.TbEmployee;
import ppms.domain.TbPerformance;
import ppms.service.PerformanceService;

/**   
 *    
 * 项目名称：PPMS   
 * 类名称：MonthPerformanceServicelmp   
 * 类描述：   
 * 创建人：SuperPcf
 * 创建时间：2015-8-7 下午4:57:24   
 * 修改人：（修改人的名字） 
 * 修改时间：2015-8-10 上午8:05:25   
  * 修改备注：   
* @version    
*    
*/ 
@Service
public class MonthPerformanceServicelmp implements PerformanceService {

	/** 
	
	* @字段：dao : 月度绩效表Dao 
	
	*/ 
	@Autowired
	private MonthPerformanceDaolmp dao;
	
	
	/**
	 * 
	 */
	public MonthPerformanceServicelmp() {
		super();
		System.out.println("create MonthPerformanceServicelmp");
		
	}

	

	/* 
     *
	 * 
	 */
	@Override
	public List<TbPerformance> getPerformances() {
		// TODO Auto-generated method stub
		return dao.getpPerformances();
	}





	/* (non-Javadoc)
	 * @see ppms.service.PerformanceService#getOrganizationNjs()
	 */
	@Override
	public List<OrganizationNj> getOrganizationNjs() {
		// TODO Auto-generated method stub
		return dao.getOrganizationNjs();
	}



	/* (non-Javadoc)
	 * @see ppms.service.PerformanceService#getEmployees()
	 */
	@Override
	public List<TbEmployee> getEmployees() {
		// TODO Auto-generated method stub
		return dao.getEmployees();
	}



	/* (non-Javadoc)
	 * @see ppms.service.PerformanceService#addPerformance(ppms.domain.TbPerformance)
	 */
	@Override
	public boolean addPerformance(TbPerformance performance) {
		if(dao.saveObject(performance)){
			return true;
		}
		return false;
	}

	
	
}
